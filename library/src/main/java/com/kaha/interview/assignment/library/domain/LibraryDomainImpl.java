package com.kaha.interview.assignment.library.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.kaha.interview.assignment.library.dto.Author;
import com.kaha.interview.assignment.library.dto.Book;
import com.kaha.interview.assignment.library.dto.DataResponse;
import com.kaha.interview.assignment.library.dto.RequestBodyDto;
import com.kaha.interview.assignment.library.dto.ResponseDto;
import com.kaha.interview.assignment.library.dto.SearchRequest;
import com.kaha.interview.assignment.library.exception.CustomException;
import com.kaha.interview.assignment.library.repository.AuthorRepository;
import com.kaha.interview.assignment.library.repository.BookRepository;

@Component
public class LibraryDomainImpl implements LibraryDomain {

	private static final Logger logger = LoggerFactory.getLogger(LibraryDomainImpl.class);
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	
	public ResponseDto addAuthor(Author author) throws CustomException {
		this.logger.info("In addAuthor Domain");
		ResponseDto response = new ResponseDto();
		Date currentDate = new Date();
		author.setCreatedDate(currentDate);
		author.setLastUpdatedDate(currentDate);
		Author savedAuthor;
		try {
		savedAuthor = this.authorRepository.findByAuthorName(author.getAuthorTitle());
		}catch(Exception e) {
			throw new CustomException("Db Error");
		}
		if(savedAuthor != null) {
			throw new CustomException("Exists");
		}
		Author newAuthor = this.authorRepository.save(author);
		
		if(newAuthor != null) {
			List<Object> authorList = new ArrayList<Object>();
			authorList.add(newAuthor);			
			DataResponse data = new DataResponse();
			data.setItems(authorList);
			
			response.setData(data);
			response.status = "Success";
			response.message = "Successfully saved data!";
		}else {
			throw new CustomException("");
		}
		return response;
	}
	
	public ResponseDto addBook( RequestBodyDto request) throws CustomException {
		this.logger.info("In addBook Domain");
		Date currentDate = new Date();
		request.author.setCreatedDate(currentDate);
		request.author.setLastUpdatedDate(currentDate);
		request.book.setCreatedDate(currentDate);
		request.book.setLastUpdatedDate(currentDate);
		Author savedAuthor;
		try {
		savedAuthor = this.authorRepository.findByAuthorName(request.author.getAuthorTitle());
		}catch(Exception e) {
			throw new CustomException("Db Error");
		}
		
		List<Book> savedBooks;
		Book newBook;
		try {
			savedBooks = this.bookRepository.findByBookName(request.book.getBookTitle());
		}catch(Exception e) {
			throw new CustomException("Db Error");
		}
		if(savedBooks.size()> 0) {
			throw new CustomException("Exists");
		}else {
			Author newAuthor;
			if(savedAuthor == null) {
				newAuthor = this.authorRepository.save(request.author);
				request.getBook().setAuthor(newAuthor);
			}else {
				request.getBook().setAuthor(savedAuthor);
			}
		newBook = this.bookRepository.save(request.getBook());
		}
		
		ResponseDto response = new ResponseDto();
		if(newBook != null) {
			List<Object> bookList = new ArrayList<Object>();
			bookList.add(newBook);			
			DataResponse data = new DataResponse();
			data.setItems(bookList);
			response.setData(data);
			response.status = "Success";
			response.message = "Successfully saved data!";
		}else {
			throw new CustomException("Error while saving data!");
		}
		return response;
	}
	
	public ResponseDto fetchAllBook( int page, int rowCount, String sort) throws CustomException{
		this.logger.info("In fetchAllBook Domain");
		ResponseDto response = new ResponseDto();
		System.out.println(sort);
		Pageable pageable = PageRequest.of(page, rowCount, Sort.by(sort));
		List<Book> bookList = this.bookRepository.findAllBook(pageable);
		
		if(bookList.size() <= 0) {
			throw new CustomException("No Data Found in DB!");
		}
		
		DataResponse data = new DataResponse();
		data.setItems(new ArrayList<Object>(bookList));
		response.setData(data);
		response.status = "Success";
		response.message = "Successfully saved data!";
		return response;
		}
	
	public ResponseDto searchBooks( SearchRequest searchRequest) throws CustomException {
		this.logger.info("In searchBooks Domain");
		ResponseDto response = new ResponseDto();
		List<Book> bookList = new ArrayList<Book>();
		if(searchRequest.getAuthorName()!= null) {
			bookList = this.bookRepository.findByAuthorName(searchRequest.getAuthorName());
		}else if(searchRequest.getBookTitle() != null) {
			bookList = this.bookRepository.findByBookName(searchRequest.getBookTitle());
		}else if(searchRequest.getBookCategory() != null) {
			bookList = this.bookRepository.findByBookCategory(searchRequest.getBookCategory());
		}
		if(bookList.size() <= 0) {
			throw new CustomException("No Data Found in DB!");
		}
		DataResponse data = new DataResponse();
		data.setItems(new ArrayList<Object>(bookList));
		response.setData(data);
		response.status = "Success";
		response.message = "Successfully fetched data!";
		return response;
		}
}

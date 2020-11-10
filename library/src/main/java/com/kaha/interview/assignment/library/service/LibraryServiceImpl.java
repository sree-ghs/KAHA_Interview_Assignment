package com.kaha.interview.assignment.library.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaha.interview.assignment.library.domain.LibraryDomain;
import com.kaha.interview.assignment.library.dto.Author;
import com.kaha.interview.assignment.library.dto.RequestBodyDto;
import com.kaha.interview.assignment.library.dto.ResponseDto;
import com.kaha.interview.assignment.library.dto.SearchRequest;
import com.kaha.interview.assignment.library.exception.CustomException;

@Service
public class LibraryServiceImpl implements LibraryService{

	private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	@Autowired
	LibraryDomain libraryDomain;
	
	
	public ResponseDto addAuthor(Author author) throws CustomException {
		this.logger.info("In addAuthor Service");
		ResponseDto response = this.libraryDomain.addAuthor(author);
		return response;
	} 
	
	public ResponseDto addBook( RequestBodyDto request) throws CustomException {
		this.logger.info("In addBook Service");
		ResponseDto response = this.libraryDomain.addBook(request);
		return response;
	}
	
	public ResponseDto fetchAllBook( int page, int rowCount, String sort) throws CustomException {
		this.logger.info("In fetchAllBook Service");
		ResponseDto response = this.libraryDomain.fetchAllBook(page, rowCount, sort);
		return response;
		
	}
	public ResponseDto searchBooks( SearchRequest searchRequest) throws CustomException {
		this.logger.info("In searchBooks Service");
		ResponseDto response = this.libraryDomain.searchBooks(searchRequest);
		return response;
	
	}
}

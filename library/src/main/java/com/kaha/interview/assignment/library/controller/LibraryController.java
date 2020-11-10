package com.kaha.interview.assignment.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaha.interview.assignment.library.dto.Author;
import com.kaha.interview.assignment.library.dto.RequestBodyDto;
import com.kaha.interview.assignment.library.dto.ResponseDto;
import com.kaha.interview.assignment.library.dto.SearchRequest;
import com.kaha.interview.assignment.library.exception.CustomException;
import com.kaha.interview.assignment.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	LibraryService libraryService;

	@CrossOrigin
	@PostMapping("/add/author")
	public ResponseEntity<ResponseDto> addAuthor(@RequestBody Author author) throws CustomException {
		this.logger.info("In addAuthor Controller");
		ResponseDto response = this.libraryService.addAuthor(author);
		
		if(response.getData() == null) {
			throw new CustomException("");
		}
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/add/book/")
	public ResponseEntity<ResponseDto> addBook(@RequestBody RequestBodyDto request) throws CustomException {
		this.logger.info("In addBook Controller");
		ResponseDto response = this.libraryService.addBook(request);
		if(response.getData() == null) {
			throw new CustomException("");
		}
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/books")
	public ResponseEntity<ResponseDto> fetchAllBook(@RequestParam int page, @RequestParam int rowCount, @RequestParam String sort) throws CustomException {
		this.logger.info("In fetchAllBook Controller");
		System.out.println("page - " + page);
		System.out.println("sort - " + sort);
		ResponseDto response = this.libraryService.fetchAllBook(page, rowCount, sort);
		if(response.getData() == null) {
			throw new CustomException("");
		}
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/book/search")
	public ResponseEntity<ResponseDto> searchBooks(@RequestBody SearchRequest searchRequest) throws CustomException {
		LibraryController.logger.info("In searchBook Controller");
		ResponseDto response = this.libraryService.searchBooks(searchRequest);
		if(response.getData() == null) {
			throw new CustomException("");
		}
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
}

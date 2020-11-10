package com.kaha.interview.assignment.library.service;

import com.kaha.interview.assignment.library.dto.Author;
import com.kaha.interview.assignment.library.dto.RequestBodyDto;
import com.kaha.interview.assignment.library.dto.ResponseDto;
import com.kaha.interview.assignment.library.dto.SearchRequest;
import com.kaha.interview.assignment.library.exception.CustomException;

public interface LibraryService {

	public ResponseDto addAuthor(Author author) throws CustomException ;
	
	public ResponseDto addBook( RequestBodyDto request) throws CustomException;
	
	public ResponseDto fetchAllBook( int page, int rowCount, String sort) throws CustomException;
	
	public ResponseDto searchBooks( SearchRequest searchRequest) throws CustomException ;

}

package com.kaha.interview.assignment.library.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaha.interview.assignment.library.dto.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long>  {
	
	@Query("Select b from Book b ")
	public List<Book> findAllBook(Pageable pageable);
	
	@Query("Select book from Book as book join book.author as author where author.authorTitle = :authorName")
	public List<Book> findByAuthorName(String authorName);	
	
	@Query("Select book from Book as book where book.bookTitle = :bookName")
	public List<Book> findByBookName(String bookName);	
	
	@Query("Select book from Book as book where book.bookCategory = :bookCategory")
	public List<Book> findByBookCategory(String bookCategory);	

}

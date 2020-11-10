package com.kaha.interview.assignment.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaha.interview.assignment.library.dto.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>  {

	@Query("Select author from Author author where author.authorTitle = :authorName")
	public Author findByAuthorName(String authorName);
}

package com.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entities.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

	public  List<Books> findByAuthor(String author);

}

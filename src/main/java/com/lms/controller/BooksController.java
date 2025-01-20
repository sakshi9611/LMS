package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.BooksDto;
import com.lms.service.BooksServices;

@RestController
@RequestMapping("/lms")
@CrossOrigin("*")
public class BooksController {

	@Autowired
	private BooksServices booksServices;

	
	@GetMapping("/")
	public String home() {
		return "Welcome to library management system...!!!";
	}

	@PostMapping("/addBook")
	public BooksDto addBook(@RequestBody BooksDto bookDto) {

		return booksServices.addBook(bookDto);

	}

	@GetMapping("/getBook/{ISBN}")
	public ResponseEntity<BooksDto> getBook(@PathVariable Long ISBN) {
		BooksDto book = booksServices.getBook(ISBN);
		if (book.isAvailable()) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getBookByAuthor/{author}")
	public ResponseEntity<List<BooksDto>> getBookByAuthorName(@PathVariable String author) {
		List<BooksDto> books = booksServices.getBookByAuthorName(author);
		if (books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@PutMapping("/updateBook")
	public BooksDto updateBook(@RequestBody BooksDto book) {

		return booksServices.updateBook(book);
	}

	@DeleteMapping("/deleteBook/{ISBN}")
	public ResponseEntity<String> deleteBook(@PathVariable Long ISBN) {

		try {
			booksServices.deleteBook(ISBN);
			return new ResponseEntity<>("Book deleted successfully!!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Book not found..!!", HttpStatus.NOT_FOUND);
		}
	}
	

}

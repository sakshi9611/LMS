package com.lms.service;

import java.util.List;
import com.lms.dto.BooksDto;

public interface BooksServices {

	public BooksDto addBook(BooksDto bookDto);
	public BooksDto getBook(Long ISBN);
	public BooksDto updateBook(BooksDto book);
	public BooksDto deleteBook(Long ISBN);
	public List<BooksDto> getBookByAuthorName(String author);
	
}

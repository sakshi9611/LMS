package com.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.BooksDto;
import com.lms.entities.Books;
import com.lms.exception.ResourceNotFoundException;
import com.lms.repository.BooksRepository;

@Service
public class BooksServicesImpl implements BooksServices {

	@Autowired
	private BooksRepository booksRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public BooksDto addBook(BooksDto bookDto) {

		Books books = dtoToEntity(bookDto);

		Books book = booksRepo.save(books);

		return entityToDto(book);
	}

	@Override
	public BooksDto getBook(Long ISBN) {

		Books book = booksRepo.findById(ISBN).orElseThrow(() -> new ResourceNotFoundException("Book not found!!"));

		return entityToDto(book);
	}
	
	@Override
	public List<BooksDto> getBookByAuthorName(String author) {
		// TODO Auto-generated method stub
		
		List<Books> books=booksRepo.findByAuthor(author);
		
		return books.stream()
                .map(this::entityToDto) // Use the entityToDto method for conversion
                .collect(Collectors.toList());
	}

	@Override
	public BooksDto updateBook(BooksDto book) {
		
		Optional<Books> b= booksRepo.findById(book.getISBN());
		Books bk=b.get();
		//bk.setAuthor(book.getAuthor());
		bk.setAvailable(false);
		bk.setAvailableQuantity(book.getAvailableQuantity());
		bk.setPublicationDate(book.getPublicationDate());
		bk.setTitle(book.getTitle());
		bk.setTotalQuantity(bk.getTotalQuantity());
		Books b2=booksRepo.save(bk);
		return entityToDto(b2);
	}

	@Override
	public BooksDto deleteBook(Long ISBN) {
		//booksRepo.deleteById(bookId);
		Optional<Books> b= booksRepo.findById(ISBN);
		Books bk=b.get();
		bk.setAvailable(false);
		Books b2=booksRepo.save(bk);
		return entityToDto(b2);
	}

	

	private BooksDto entityToDto(Books books) {
		return modelMapper.map(books, BooksDto.class);
	}

	private Books dtoToEntity(BooksDto booksDto) {
		return modelMapper.map(booksDto, Books.class);
	}

}

package com.caiubi.primavera.rest;

import java.util.List;

import com.caiubi.primavera.books.Author;
import com.caiubi.primavera.books.Book;

public interface BookService {
	public Book getBookByIsbn(String isbn);
	public List<Book> getBooksByAuthor(String authorId);
	public List<Book> getAllBooks();
	public List<Author> getAllAuthors();
	public Author getAuthorById(String authorId);
}

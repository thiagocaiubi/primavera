package com.caiubi.primavera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.caiubi.primavera.books.Address;
import com.caiubi.primavera.books.Author;
import com.caiubi.primavera.books.Book;
import com.caiubi.primavera.books.Publisher;
import com.caiubi.primavera.repository.BookRepository;

@Controller
public class BookServiceController {
 
	@Autowired
	BookService bookService;
	
	@Autowired
	BookRepository bookRepository;
 
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public ModelAndView postBook() {
		Author author = new Author();
		author.setAuthorId("qwertyuiop");
		author.setEmail("thiago.caiubi@gmail.com");
		author.setName("Thiago Caiubi");
		
		Address address = new Address();
		address.setAddress("Rua Funchal, 129");
		address.setCity("São Paulo");
		address.setState("SP");
		address.setZip("04525-023");
		
		Publisher publisher = new Publisher();
		publisher.setName("Thiago Caiubi");
		publisher.setAddress(address);
		
		Book book = new Book();
		book.addAuthors(author);
		book.setEdition(1234);
		book.setIsbn("caiubi");
		book.setPages(98);
		book.setPublished("yeah");
		book.setPublisher(publisher);
		book.setTitle("Renan rocks!");
		
		bookRepository.save(book);
		
		return new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "book", book);
	}
	
	@RequestMapping(value = "/books")
	public ModelAndView getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		ModelAndView mav = new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "books", books);
		return mav;
	}
 
	@RequestMapping(value = "/books/{isbn}")
	public ModelAndView getBookByIsbn(@PathVariable String isbn) {
		Book book = bookService.getBookByIsbn(isbn);
		ModelAndView mav = new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "book", book);
		return mav;
	}
 
	@RequestMapping(value = "/authors")
	public ModelAndView getAllAuthors() {
		List<Author> authors = bookService.getAllAuthors();
		ModelAndView mav = new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "authors", authors);
		return mav;
	}
 
	@RequestMapping(value = "/authors/{authorId}")
	public ModelAndView getAuthorById(@PathVariable String authorId) {
		Author author = bookService.getAuthorById(authorId);
		ModelAndView mav = new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "author", author);
		return mav;
	}
 
	@RequestMapping(value = "/authors/{authorId}/books")
	public ModelAndView getBooksByAuthor(@PathVariable String authorId) {
		List<Book> books = bookService.getBooksByAuthor(authorId);
		ModelAndView mav = new ModelAndView("viewResolver", BindingResult.MODEL_KEY_PREFIX + "books", books);
		return mav;
	}
}
package com.caiubi.primavera.books;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Document
@XStreamAlias("book")
public class Book {

	@Id
	private String id;
	private String isbn;
	private String title;
	private int edition;
	private int pages;
	private String published;
	private List<Author> authors = new LinkedList<Author>();
	private Publisher publisher;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = new LinkedList<Author>(authors);
	}
	public List<Author> getAuthors() {
		return new LinkedList<Author>(authors);
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getEdition() {
		return edition;
	}
	public void addAuthors(Author... authors) {
		Assert.notNull(authors, "At least one author must be assigned to a book");
		for (Author author : authors) {
			this.authors.add(author);
		}
	}
}

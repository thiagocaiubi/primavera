package com.caiubi.primavera.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.caiubi.primavera.books.Book;

@Repository
public class BookRepository {

		@Autowired
		MongoTemplate mongo;
		
		public void save(Book book) {
			mongo.save(book, "book");
		}
}
package com.hascode.tutorial.cucumber.book;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(final Book book) {
		store.add(book);
	}
 
	public List<Book> findBooks(final Date from, final Date to) {
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);
                
                List<Book> booksBetweenDates = new ArrayList<>();
                
                for(Book book : store){
                    if(book.getPublished().after(from) && book.getPublished().before(to)){
                        booksBetweenDates.add(book);
                    }
                }
                
                Collections.sort(booksBetweenDates);
                
                return booksBetweenDates;
	}
}

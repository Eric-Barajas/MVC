package com.ericbarajas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ericbarajas.mvc.models.Book;
import com.ericbarajas.mvc.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	return bookRepository.findById(id).orElse(null);
    	
    	//        Optional<Book> optionalBook = bookRepository.findById(id);
        //        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
    }
//    updates one book
//    get book
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
//    	putting whatever book by id into the variable newBook
    	Book newBook = findBook(id);
//    	setting/updating the newBooks title...(parameters)
    	newBook.setTitle(title);
    	newBook.setDescription(desc);
    	newBook.setLanguage(lang);
    	newBook.setNumberOfPages(numOfPages);
//    	return new updated book
    	return bookRepository.save(newBook);
    }
    
    
//    deletes one book
//    grabbing a book by its id
    public void deleteBook(Long id) {
//    	deletes the entity(a particular book) with the given id
    	bookRepository.deleteById(id);
    }
}

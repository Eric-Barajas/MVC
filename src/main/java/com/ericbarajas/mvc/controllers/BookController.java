package com.ericbarajas.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericbarajas.mvc.models.Book;
import com.ericbarajas.mvc.services.BookService;

@Controller
public class BookController {
//	IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	BookService bookServ;
	
//-----------------------------CREATE-----------------------------//
//    CREATE A BOOK
//    @GetMapping("/books/new")
//    public String newBook() {
//        return "new.jsp";
//    } 
//    @PostMapping("/books")
//    public String create(
//        @RequestParam("title") String title,
//        @RequestParam("description") String description,
//        @RequestParam("language") String language,
//        @RequestParam("pages") Integer pages) 
//    {
//        // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//        Book book = new Book(title, description, language, pages);
//        bookServ.createBook(book);
//        return "redirect:/books";
//    }
    
//    CREATE A BOOK WITH DATABINDING & @ModelAttribute
//    gets the form
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("aBook") Book emptyBookObj) {
        return "new.jsp";
    }
//    processes the form
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("aBook") Book filledBookObj, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookServ.createBook(filledBookObj);
            return "redirect:/books";
        }
    }
//-----------------------------CREATE-----------------------------//
    
//-----------------------------READ-----------------------------//
//	READ ONE USER show one books title description etc.
	@GetMapping("/books/{id}") 
	public String showOne(
		@PathVariable("id") Long id,
		Model model
	) {
//		RETRIEVE ONE BOOK FROM DB
		Book oneBook = bookServ.findBook(id);
		
//		PASS THE INFORMATION TO THE JSP
		model.addAttribute("book", oneBook);
		return "show.jsp";
	}
//	READ ALL show all the books with title description etc.
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookServ.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
//-----------------------------READ-----------------------------//
	
//-----------------------------UPDATE-----------------------------//
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookServ.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookServ.updateBook(book);
            return "redirect:/books";
        }
    }
//-----------------------------UPDATE-----------------------------//
    
//-----------------------------DELETE-----------------------------//
    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
//    public String destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
//    OR
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookServ.deleteBook(id);
        return "redirect:/books";
    }
    
//-----------------------------DELETE-----------------------------//
}

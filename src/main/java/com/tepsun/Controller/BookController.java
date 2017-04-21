package com.tepsun.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tepsun.model.Book;
import com.tepsun.model.BookRepository;



@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/booklist")
	public String books(Model model){
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> studentListRest(){
		return(List<Book>)bookRepository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id")Long bookId){
		return bookRepository.findOne(bookId);
	}
		
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }
	
	@RequestMapping(value="/login")
	  public String login() {
	    return "login";
	  }
	
	@RequestMapping(value="/")
    public String redirect(){
		return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }   
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.delete(bookId);
        return "redirect:../booklist";
    } 
}

package com.book.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.Service.BookService;
import com.book.demo.model.*;

@RestController
public class BookController {
	@Autowired
	private BookService bs;

	@GetMapping("/books")
	public List<Books> getbooks()
 {
		return this.bs.getbooks();
	}
	
	@GetMapping("books/{bookId}")
	public Books getbook(@PathVariable String BookId) {
		return this.bs.getbook(Long.parseLong(BookId));
		
	}
  @PostMapping("books")
  public Books addbook(@RequestBody Books book) {
	  return this.bs.addbook(book);
  }
  
  @PutMapping("/books")
  public Books updatebooks(@RequestBody Books book) {
	  return this.bs.updatebook(book);
  }
  
  @DeleteMapping("/books/{bookId}")
  public ResponseEntity<HttpStatus> deletebook(@PathVariable String bookId){
	  try {
		  this.bs.deletebook(Long.parseLong(bookId));
		  return new ResponseEntity<>(HttpStatus.OK);
	  }
	  catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
}

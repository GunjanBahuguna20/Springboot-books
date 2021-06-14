package com.book.demo.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.book.demo.model.Books;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

	List<Books> list;
	public BookServiceImpl() {
		list=new ArrayList<>();
		list.add(new Books(1,"The Kite Runner","Khaled Hosseini"));
		list.add(new Books(2,"The Suitable Boy","Vikram Seth"));
		list.add(new Books(3,"Norwegian Wood","Murakami"));
		list.add(new Books(4,"Norwegian Wood","Murakami"));
				
		
	}
	
	
	@Override
	public List<Books> getbooks() {
		return list;
	}

	@Override
	public Books getbook(long bookId) {
		Books b=null;
		for(Books book:list)
		{
			if(book.getBookId()==bookId) {
				b=book;
				break;
			}
		}
		return b;
	}

	@Override
	public Books addbook(Books book) {
   list.add(book);
		return book;
	}

	@Override
	public Books updatebook(Books book) {
		list.forEach(e->{
			if(e.getBookId()==book.getBookId()) {
				e.setTitle(book.getTitle());
		        e.setAuthor(book.getAuthor());
			}
		});
		return book;
	}


	@Override
	public void deletebook(long parseLong) {
		list=this.list.stream().filter(e->e.getBookId()!=parseLong).collect(Collectors.toList());
			}

}

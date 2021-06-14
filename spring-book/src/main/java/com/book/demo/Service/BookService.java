package com.book.demo.Service;
import java.util.*;

import com.book.demo.model.Books;
public interface BookService {
	public List<Books> getbooks();
	public Books getbook(long bookId);
	public Books addbook(Books book);

	public Books updatebook(Books book);
	public void deletebook(long parseLong);

}

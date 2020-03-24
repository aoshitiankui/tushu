package com.dao;
/***
*图书
*/
import com.util.*;
import java.util.*;

import org.springframework.stereotype.Repository;
import com.model.*;
public interface BooksMapper  {
	public int addBooks(BooksModel model);
	public int delBooks(BooksModel model);
	public int updBooks(BooksModel model);
	public Map findBooksById(BooksModel model);
	public List<Map<String,Object>> findBooksByCondition(BooksModel model);
	public int findBooksByConditionCount(BooksModel model);
	public List<Map<String,Object>> findBooksGuess(BooksModel model);
	public int findBooksGuessCount(BooksModel model);
	public String queryLatestBuy(BooksModel model);
	
}
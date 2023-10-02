package in.book.service;

import java.util.List;

import in.book.entity.Book;

public interface BookService {
	public String upsertBook(Book book);
	public List<Book> getAllBooks();
	public String deleteBook(Integer bookId);
}

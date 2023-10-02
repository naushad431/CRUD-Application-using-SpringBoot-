package in.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.book.entity.Book;
import in.book.repository.BookRepository;
@Service
public class BookServiceImplementation implements BookService {

	private BookRepository bookrepository;
	
	public BookServiceImplementation(BookRepository bookrepository ){
		this.bookrepository=bookrepository;
	}
	@Override
	public String upsertBook(Book book) {
		// TODO Auto-generated method stub
		Integer bookId=book.getBookId();
		bookrepository.save(book);
		if(bookId==null) {
			return "Book is inserted";
		}
		else{
			return "book is updated";
		}
		
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepository.findAll();
	}

	@Override
	public String deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		bookrepository.deleteById(bookId);
		return "Book Deleted";
	}

}

package in.book.rest;

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

import in.book.entity.Book;
import in.book.service.BookService;

@RestController
public class BookController {
 
	@Autowired
	private BookService bookService;
	 
	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody Book book){
		String msg=bookService.upsertBook(book);
		System.out.println(msg);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List> getAllBooks(){
		List<Book> allBooks=bookService.getAllBooks();
		return new ResponseEntity<List>(allBooks,HttpStatus.OK);
	}
	
	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		String msg=bookService.upsertBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		String msg= bookService.deleteBook(bookId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}

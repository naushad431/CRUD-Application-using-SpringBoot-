package in.book.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import in.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable> {
	
	 

}

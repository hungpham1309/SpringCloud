package com.example.bookservice.repository;

import com.example.bookservice.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query(
			value = "SELECT * FROM Book ",
			nativeQuery = true
	)
	List<Book> getAllBook();

	Book findById(int id);

	void deleteById(int id);

}

package com.cts.spring.boot.webrest.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.spring.boot.webrest.demo.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity,Long> {

	//@Query("SELECT b FROM BookEntity b WHERE b.title like '%:titleStub%' ")
	@Query("SELECT b FROM BookEntity b WHERE b.title =:titleStub ")
	List<BookEntity> getAllThatHasTitle(String titleStub);
}

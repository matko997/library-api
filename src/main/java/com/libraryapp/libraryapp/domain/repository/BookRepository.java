package com.libraryapp.libraryapp.domain.repository;

import com.libraryapp.libraryapp.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT bo FROM Book bo LEFT JOIN FETCH bo.author WHERE bo.isAvailable=:isAvailable")
    List<Book> findBookByAvailable(@Param("isAvailable") Boolean isAvailable);

    Optional<Book> findBookById(Long id);

}

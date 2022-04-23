package com.libraryapp.libraryapp.domain.repository;

import com.libraryapp.libraryapp.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}


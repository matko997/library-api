package com.libraryapp.libraryapp.service;

import com.libraryapp.libraryapp.api.exception.custom.ResourceNotFoundException;
import com.libraryapp.libraryapp.domain.model.Author;
import com.libraryapp.libraryapp.domain.model.Book;
import com.libraryapp.libraryapp.domain.repository.AuthorRepository;
import com.libraryapp.libraryapp.domain.repository.BookRepository;
import com.libraryapp.libraryapp.presentation.model.request.RequestBookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private static final String BOOK_NOT_FOUND_MESSAGE="Oops, seems like there is no book with id ";
    private static final String AUTHOR_NOT_FOUND_MESSAGE="Oops, seems like there is no author with id ";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findBookById(id).orElseThrow(()->new ResourceNotFoundException(BOOK_NOT_FOUND_MESSAGE + id));
    }

    public List<Book> findAllAvailableBooks() {
        return bookRepository.findBookByAvailable(true);
    }

    public Book createBook(RequestBookModel bookModel) {
        Author bookAuthor = authorRepository.findById(bookModel.getAuthorId()).orElseThrow(()->new ResourceNotFoundException(
                AUTHOR_NOT_FOUND_MESSAGE + bookModel.getAuthorId()));

        Book book = new Book(
                bookModel.getName(),
                bookModel.getIsAvailable(),
                bookAuthor
        );
        bookRepository.save(book);

        return book;
    }

    public Book deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                BOOK_NOT_FOUND_MESSAGE + id));

        bookRepository.delete(book);

        return book;

    }

    public Book updateBook(Long id,RequestBookModel requestBookModel) {

        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                BOOK_NOT_FOUND_MESSAGE + id));

        Author newAuthor = authorRepository.findById(requestBookModel.getAuthorId()).orElseThrow(()->
                new ResourceNotFoundException(AUTHOR_NOT_FOUND_MESSAGE + requestBookModel.getAuthorId()));


        book.setName(requestBookModel.getName());
        book.setIsAvailable(requestBookModel.getIsAvailable());
        book.setAuthor(newAuthor);

        bookRepository.save(book);

        return book;

    }

}

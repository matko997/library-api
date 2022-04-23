package com.libraryapp.libraryapp.api.controller;

import com.libraryapp.libraryapp.domain.model.Book;
import com.libraryapp.libraryapp.presentation.model.request.RequestBookModel;
import com.libraryapp.libraryapp.presentation.model.response.ResponseBookModel;
import com.libraryapp.libraryapp.presentation.service.PresentationBookService;
import com.libraryapp.libraryapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final PresentationBookService presentationBookService;

    @GetMapping()
    public ResponseEntity<List<ResponseBookModel>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();

        return new ResponseEntity<>(presentationBookService.buildAll(books), HttpStatus.OK);

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseBookModel> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);

        return new ResponseEntity<>(presentationBookService.buildSingle(book), HttpStatus.OK);

    }

    @GetMapping(path = "/available")
    public ResponseEntity<List<ResponseBookModel>> getAllAvailableBooks() {
        List<Book> book = bookService.findAllAvailableBooks();

        return new ResponseEntity<>(presentationBookService.buildAll(book), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<ResponseBookModel> createBook(@RequestBody @Valid RequestBookModel bookModel) {
        Book book = bookService.createBook(bookModel);

        return new ResponseEntity<>(presentationBookService.buildSingle(book), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<ResponseBookModel> removeBook(@PathVariable Long id) {
        Book book = bookService.deleteBookById(id);

        return new ResponseEntity<>(presentationBookService.buildSingle(book),HttpStatus.OK);

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ResponseBookModel> updateBook(@PathVariable Long id,
                                                        @RequestBody @Valid RequestBookModel requestBookModel) {
        Book book = bookService.updateBook(id,requestBookModel);

        return new ResponseEntity<>(presentationBookService.buildSingle(book),HttpStatus.OK);

    }

}
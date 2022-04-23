package com.libraryapp.libraryapp.api.controller;


import com.libraryapp.libraryapp.domain.model.Author;
import com.libraryapp.libraryapp.presentation.model.request.RequestAuthorModel;
import com.libraryapp.libraryapp.presentation.model.response.ResponseAuthorModel;
import com.libraryapp.libraryapp.presentation.service.PresentationAuthorService;
import com.libraryapp.libraryapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final PresentationAuthorService presentationAuthorService;


    @GetMapping()
    public ResponseEntity<List<ResponseAuthorModel>> getAllAuthors() {
        List<Author> authors = authorService.authors();

        return new ResponseEntity<>(presentationAuthorService.buildAll(authors),HttpStatus.OK);

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseAuthorModel> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);

        return new ResponseEntity<>(presentationAuthorService.buildSingle(author),HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<ResponseAuthorModel> createNewAuthor(@RequestBody @Valid RequestAuthorModel newAuthor) {
        Author author = authorService.createAuthor(newAuthor);

        return new ResponseEntity<>(presentationAuthorService.buildSingle(author),HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<ResponseAuthorModel> deleteAuthor(@PathVariable Long id) {

        Author author = authorService.removeAuthor(id);

        return new ResponseEntity<>(presentationAuthorService.buildSingle(author),HttpStatus.OK);

    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ResponseAuthorModel> updateAuthor(@PathVariable Long id,
                                                            @RequestBody @Valid RequestAuthorModel authorModel) {
        Author author = authorService.updateAuthor(id,authorModel);

        return new ResponseEntity<>(presentationAuthorService.buildSingle(author),HttpStatus.OK);

    }

}


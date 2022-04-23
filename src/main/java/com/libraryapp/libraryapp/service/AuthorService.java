package com.libraryapp.libraryapp.service;

import com.libraryapp.libraryapp.api.exception.custom.ResourceNotFoundException;
import com.libraryapp.libraryapp.domain.model.Author;
import com.libraryapp.libraryapp.domain.repository.AuthorRepository;
import com.libraryapp.libraryapp.presentation.model.request.RequestAuthorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    private static final String AUTHOR_NOT_FOUND_MESSAGE="Oops, seems like there is no author with id ";


    public List<Author> authors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(RequestAuthorModel newAuthor) {
        Author author = new Author(
                newAuthor.getFirstName(),
                newAuthor.getLastName()
        );

        authorRepository.save(author);

        return author;

    }

    public Author removeAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                AUTHOR_NOT_FOUND_MESSAGE + id));

        authorRepository.delete(author);
        return author;

    }

    public Author getAuthorById(Long id) {

        return authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AUTHOR_NOT_FOUND_MESSAGE + id));

    }

    public Author updateAuthor(Long id, RequestAuthorModel newAuthor) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                AUTHOR_NOT_FOUND_MESSAGE + id));

        author.setFirstName(newAuthor.getFirstName());
        author.setLastName(newAuthor.getLastName());
        authorRepository.save(author);

        return author;

    }

}

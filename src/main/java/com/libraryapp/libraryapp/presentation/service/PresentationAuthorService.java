package com.libraryapp.libraryapp.presentation.service;

import com.libraryapp.libraryapp.domain.model.Author;
import com.libraryapp.libraryapp.presentation.model.response.ResponseAuthorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PresentationAuthorService {

    public ResponseAuthorModel buildSingle(Author author) {
        return new ResponseAuthorModel(
                author.getId(),
                author.getFirstName(),
                author.getLastName()
        );

    }

    public List<ResponseAuthorModel> buildAll(List<Author> authors) {

        List<ResponseAuthorModel> responseAuthorModelsList = new ArrayList<>();
        authors.forEach(author -> responseAuthorModelsList.add(this.buildSingle(author)));

        return responseAuthorModelsList;

    }
}
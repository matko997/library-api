package com.libraryapp.libraryapp.presentation.service;

import com.libraryapp.libraryapp.domain.model.Book;
import com.libraryapp.libraryapp.presentation.model.response.ResponseBookModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PresentationBookService {

    public ResponseBookModel buildSingle(Book book) {
        return new ResponseBookModel(
                book.getId(),
                book.getName(),
                book.getIsAvailable(),
                book.getAuthor()
        );

    }

    public List<ResponseBookModel> buildAll(List<Book> books) {

        List<ResponseBookModel> responseBookModelList = new ArrayList<>();
        books.forEach(book -> responseBookModelList.add(this.buildSingle(book)));

        return responseBookModelList;

    }

}

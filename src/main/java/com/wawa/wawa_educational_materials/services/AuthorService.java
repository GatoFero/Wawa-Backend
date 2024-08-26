package com.wawa.wawa_educational_materials.services;

import com.wawa.wawa_educational_materials.entities.Author;
import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorById(String id);
}

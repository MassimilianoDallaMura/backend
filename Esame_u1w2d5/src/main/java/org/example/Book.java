package org.example;

import java.io.Serializable;

public class Book extends CatalogItem {
    private final String author;
    private final String genre;

    public Book(String isbn, String title, int publicationYear, int numPages, String author, String genre) {
        super(isbn, title, publicationYear, numPages);
        this.author = author;
        this.genre = genre;
    }

    // Metodi getters
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}

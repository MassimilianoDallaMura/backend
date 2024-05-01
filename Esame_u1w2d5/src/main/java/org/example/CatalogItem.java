package org.example;

import java.io.Serializable;

// Classe astratta per gli elementi del catalogo
abstract class CatalogItem implements Serializable {
    private final String isbn;
    private final String title;
    private final int publicationYear;
    private final int numPages;

    public CatalogItem(String isbn, String title, int publicationYear, int numPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numPages = numPages;
    }

    // Metodi getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getNumPages() {
        return numPages;
    }
}

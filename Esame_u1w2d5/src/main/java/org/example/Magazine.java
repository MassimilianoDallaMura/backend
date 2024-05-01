package org.example;

import java.io.Serializable;

public class Magazine extends CatalogItem {
    private final Periodicity periodicity;

    public Magazine(String isbn, String title, int publicationYear, int numPages, Periodicity periodicity) {
        super(isbn, title, publicationYear, numPages);
        this.periodicity = periodicity;
    }

    // Metodo getter
    public Periodicity getPeriodicity() {
        return periodicity;
    }
}

package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Classe per gestire il catalogo della biblioteca
public class LibraryCatalog {
    private List<CatalogItem> catalog;

    public LibraryCatalog() {
        catalog = new ArrayList<>();
    }

    // Aggiunta di un elemento al catalogo
    public void addItem(CatalogItem item) {
        catalog.add(item);
    }

    // Rimozione di un elemento dato un codice ISBN
    public void removeItem(String isbn) {
        catalog.removeIf(item -> item.getIsbn().equals(isbn));
    }

    // Ricerca per ISBN
    public CatalogItem findByIsbn(String isbn) {
        return catalog.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // Ricerca per anno di pubblicazione
    public List<CatalogItem> findByPublicationYear(int year) {
        return catalog.stream()
                .filter(item -> item.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Ricerca per autore
    public List<Book> findByAuthor(String author) {
        return catalog.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    // Salvataggio su disco dell'archivio
    public void saveCatalog(String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(catalog);
        }
    }

    // Caricamento dal disco dell'archivio in una nuova lista
    public void loadCatalog(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            catalog = (List<CatalogItem>) inputStream.readObject();
        }
    }
}

package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Percorso del file .txt da creare
        String filePath = "nuovo_file.txt";

        try {
            // per creare un oggetto FileWriter per scrivere nel file
            FileWriter writer = new FileWriter(filePath);

            // Scrivi il contenuto nel file
            writer.write("nuovo file .txt");

            // Chiudi il FileWriter
            writer.close();

            System.out.println("file creato");
        } catch (IOException e) {
            // Gestione delle eccezioni in caso di errore di I/O
            e.printStackTrace();
        }

        LibraryCatalog libraryCatalog = getLibraryCatalog();

        // Ricerca per autore
        List<Book> booksByAuthor = libraryCatalog.findByAuthor("Robert C. Martin");
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }

        // Salvataggio su disco
        try {
            libraryCatalog.saveCatalog("catalog.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Caricamento da disco
        LibraryCatalog newLibraryCatalog = new LibraryCatalog();
        try {
            newLibraryCatalog.loadCatalog("catalog.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Ricerca per ISBN dopo il caricamento
        CatalogItem item = newLibraryCatalog.findByIsbn("123456789");
        if (item != null) {
            System.out.println("Found: " + item.getTitle());
        } else {
            System.out.println("Item not found.");
        }
    }

    private static LibraryCatalog getLibraryCatalog() {
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        Book book1 = new Book("9780132350884", "Clean Code", 2008, 464, "Robert C. Martin", "Software Development");
        Book book2 = new Book("9781449355736", "Java Concurrency in Practice", 2006, 432, "Brian Goetz", "Java Programming");
        Magazine magazine1 = new Magazine("123456789", "National Geographic", 2021, 100, Periodicity.MONTHLY);

        libraryCatalog.addItem(book1);
        libraryCatalog.addItem(book2);
        libraryCatalog.addItem(magazine1);
        return libraryCatalog;
    }
}


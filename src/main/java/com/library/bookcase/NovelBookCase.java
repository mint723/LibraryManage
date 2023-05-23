package main.java.com.library.bookcase;

import main.java.com.library.book.NovelBook;

public class NovelBookCase extends BookCase {

    public void thisType() {
        System.out.printf("%15s%n", "*소설*");
    }

    public void addBook(String bookName) { this.bookCase.add(new NovelBook(bookName, "소설"));

    }
}
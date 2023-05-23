package main.java.com.library.bookcase;

import main.java.com.library.book.ComicBook;

public class ComicBookCase extends BookCase {

    public void thisType() {
        System.out.printf("%15s%n","*만화책*");
    }
    public void addBook(String bookName){
        this.bookCase.add(new ComicBook(bookName,"만화책"));
    }

}

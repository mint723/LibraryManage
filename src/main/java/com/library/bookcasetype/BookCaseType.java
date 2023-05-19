package main.java.com.library.bookcasetype;

import main.java.com.library.Book;

import java.util.ArrayList;

public interface BookCaseType {
    void thisType();
    Book getBook(int i);
    void addBook(String bookName);
    void deleteBook(int index);
    ArrayList<Book> getBookCase();
    String getBookName(int i);
    int getBookNo(int i);
    boolean getCanRental(int i);
    boolean setCanRental(int i);
    String getBookType(int i);
    void setBookType(int i, String bookType);
    void addBookObject(Book book);
}

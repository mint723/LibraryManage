package main.java.com.library.bookcase;

import main.java.com.library.book.NoneBook;

import java.util.ArrayList;
public class NoneBookCase extends BookCase {
    public void thisType() {
        System.out.printf("%17s%n","*분류 없음*");
    }
    public void addBook(String bookName){
        this.bookCase.add(new NoneBook(bookName,"분류 없음"));
    }

}

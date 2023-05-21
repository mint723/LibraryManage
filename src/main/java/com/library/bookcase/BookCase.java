package main.java.com.library.bookcase;

import main.java.com.library.book.Book;
import main.java.com.library.book.NoneBook;

import java.util.ArrayList;

abstract public class BookCase {
    private ArrayList<Book> bookCase = new ArrayList<>();

//    public void thisType() {
//        System.out.printf("%17s%n","*분류 없음*");
//    }
    abstract public void thisType();

    public Book getBook(int i){ return this.bookCase.get(i); }

    public void addBook(String bookName){
        this.bookCase.add(new NoneBook(bookName,"분류 없음"));
    }

    public void addBookObject(Book book){
        this.bookCase.add(book);
    }


    public void deleteBook(int index) {
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((index)==this.getBookNo(i)) {
                System.out.printf("'%s'에서 %d번 책 (%s)이 삭제되었습니다.%n","분류 없음",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    }

    public ArrayList<Book> getBookCase() {
        return this.bookCase;
    }

    public String getBookName(int i){
        return this.getBookCase().get(i).getBookName();
    }

    public int getBookNo(int i){ return this.getBookCase().get(i).getBookNo(); }

    public boolean getCanRental(int i){
        return this.getBookCase().get(i).getCanRental();
    }

    public boolean setCanRental(int i){ return this.getBookCase().get(i).setCanRental(); }

    public String getBookType(int i){ return this.getBookCase().get(i).getBookType(); }

    public void setBookType(int i, String bookName){ this.getBookCase().get(i).setBookType(bookName); }

}
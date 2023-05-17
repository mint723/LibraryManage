package main.java.com.library;

public class Book {
    static int count;
    int bookNo;
    String bookName;
    Boolean canRental;

    public Book(String name){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getBookNo() {
        return bookNo;
    }
    public Boolean getCanRental() {
        return canRental;
    }
    public void setCanRental(Boolean canRental) {
        this.canRental = canRental;
    }

}

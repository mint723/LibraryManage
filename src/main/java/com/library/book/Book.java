package main.java.com.library.book;

abstract public class Book {
    static int count;
    //접근제한자
    private int bookNo;
    private String bookName;
    private Boolean canRental;
    private String bookType;

    public Book(String BookName, String bookType){
        this.bookNo = ++count;
        this.bookName = BookName;
        this.canRental = true;
        this.bookType = bookType;
    }

    public abstract void bookInfo();

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookNo(int bookNo){ this.bookNo = bookNo; }

    public int getBookNo() {
        return bookNo;
    }

    public Boolean setCanRental() {
        return this.canRental = this.canRental==true?false:true;
    }

    public Boolean getCanRental() {
        return canRental;
    }

    public String getBookType() { return this.bookType; }

    public void setBookType(String bookType) { this.bookType = bookType; }
}

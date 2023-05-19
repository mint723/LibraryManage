package main.java.com.library;

import main.java.com.library.bookcasetype.BookCaseType;

public class Book {
    static int count;
    //접근제한자
    private int bookNo;
    private String bookName;
    private Boolean canRental;
    private String bookType;
    public Book(String name){
        this(name,"분류 없음");
    }

    public Book(String name, String bookType){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
        this.bookType = bookType;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookNo(int bookNo){
        this.bookNo = bookNo;
    }
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

    public static void bookList(BookCaseType bookCase) {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < bookCase.getBookCase().size()+1; i++) {
            bookInfo(i,bookCase);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }

    public static void bookInfo(int i, BookCaseType bookCase) {
        System.out.println("책 이름 : "+bookCase.getBookName(i-1));
        System.out.println("책 번호 : "+bookCase.getBookNo(i-1));
        System.out.printf("책 대출 가능 여부 : %s%n",bookCase.getCanRental(i-1)==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+bookCase.getBookType(i-1));
    }
}

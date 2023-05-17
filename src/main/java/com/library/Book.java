package main.java.com.library;

import java.util.Scanner;

public class Book {
    static int count;
    //접근제한자
    private int bookNo;
    private String bookName;
    private Boolean canRental;
    String bookAttribute;

    public Book(String name){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
//        this.bookAttribute = bookAttribute;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookName() {
        return bookName;
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

    public static void bookList(BookCase bookCase) {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < bookCase.getBookCase().size()+1; i++) {
            bookInfo(i,bookCase);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }

    public static void bookInfo(int i, BookCase bookCase) {
        System.out.println("책 이름 : "+bookCase.getBookName(i-1));
        System.out.println("책 번호 : "+bookCase.getBookNo(i-1));
        System.out.println("책 대출 가능 여부 : "+bookCase.getCanRental(i-1));
    }
}

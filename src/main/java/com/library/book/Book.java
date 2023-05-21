package main.java.com.library.book;

import main.java.com.library.bookcase.BookCaseType;

abstract public class Book {
    static int count;
    //접근제한자
    private int bookNo;
    private String bookName;
    private Boolean canRental;
    private String bookType;

    public Book(String name, String bookType){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
        this.bookType = bookType;
    }
//    public static void bookList(BookCaseType bookCase) {
//        System.out.printf("%n------Book List------%n");
//        for (int i = 1; i < bookCase.getBookCase().size() + 1; i++) {
//            Book.bookInfo(i,bookCase);
//            System.out.println("---------------------");
//        }
//        System.out.println("---------------------");
//    }
    public void bookList(BookCaseType bookCase) {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < bookCase.getBookCase().size() + 1; i++) {
            bookCase.getBook(0).bookInfo(i,bookCase);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }


//    public static void bookInfo(int index, BookCaseType bookCase) {
//        System.out.println("책 이름 : "+bookCase.getBookName(index - 1));
//        System.out.println("책 번호 : "+bookCase.getBookNo(index - 1));
//        System.out.printf("책 대출 가능 여부 : %s%n",bookCase.getCanRental(index - 1)==true?"대출 가능":"대여중");
//        System.out.println("책 종류 : "+bookCase.getBookType(index - 1));
//    }
    public void bookInfo(int index, BookCaseType bookCase) {
        System.out.println("책 이름 : "+bookCase.getBookName(index - 1));
        System.out.println("책 번호 : "+bookCase.getBookNo(index - 1));
        System.out.printf("책 대출 가능 여부 : %s%n",bookCase.getCanRental(index - 1)==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+bookCase.getBookType(index - 1));
    }


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

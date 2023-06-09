package main.java.com.library.book;


public class NoneBook extends Book {
    public NoneBook(String BookName) {
        super(BookName,"분류 없음");
    }

    public void bookInfo() {
        System.out.println("책 이름 : "+getBookName());
        System.out.println("책 번호 : "+getBookNo());
        System.out.printf("책 대출 가능 여부 : %s%n",getCanRental()==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+getBookType());
    }
}

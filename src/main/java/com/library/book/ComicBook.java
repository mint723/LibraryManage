package main.java.com.library.book;

import main.java.com.library.bookcase.BookCaseType;

public class ComicBook extends Book{
    public ComicBook(String name, String bookType) {
        super(name, bookType);
    }

    public void bookInfo(int index, BookCaseType bookCase) {
        System.out.println("책 이름 : "+bookCase.getBookName(index - 1));
        System.out.println("책 번호 : "+bookCase.getBookNo(index - 1));
        System.out.printf("책 대출 가능 여부 : %s%n",bookCase.getCanRental(index - 1)==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+bookCase.getBookType(index - 1));
        System.out.println("최소 연령 : 12세");
    }
}

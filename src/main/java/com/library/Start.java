package main.java.com.library;

import java.util.ArrayList;
import java.util.Scanner;
import static main.java.com.library.Book.*;
import static main.java.com.library.Search.search;
import static main.java.com.library.RentalAndReturn.rentalAndReturn;
import static main.java.com.library.ChangeInfo.changeInfo;
public class Start {
//    static ArrayList<Book> bookCase = new ArrayList<>();
    BookCase bookCase = new BookCase();
    static Scanner sc = new Scanner(System.in);
    public void start() {
        while(true) {
            System.out.println("******************************");
            System.out.printf("%17s%n","*1.도서 등록*");
            System.out.printf("%17s%n","*2.도서 삭제*");
            System.out.printf("%17s%n","*3.도서 검색*");
            System.out.printf("%17s%n","*4.도서 목록*");
            System.out.printf("%17s%n","*5.도서 대여 및 반납*");
            System.out.printf("%17s%n","*6.도서 정보 변경*");
            System.out.printf("%17s%n","*7.책장 추가*");
            System.out.printf("%17s%n","*8.종료*");
            System.out.println("******************************");
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("등록할 책의 제목을 입력해주세요");
                    String bookName=sc.nextLine();
                    this.bookCase.addBook(bookName);
                    break;
                case 2:
                    System.out.println("삭제하실 책의 번호를 입력해주세요");
                    sc.nextLine();
                    bookCase.deleteBook(sc.nextInt());
                    break;
                case 3:
                    search(bookCase);
                    break;
                case 4:
                    bookList(bookCase);
                    break;
                case 5:
                    rentalAndReturn(bookCase);
                    break;
                case 6:
                    changeInfo(bookCase);
                    break;
                case 7:
                    BookCase bookCase = new BookCase();
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("제대로 된 값을 입력해주세요.");
                    break;
            }
        }
    }
}

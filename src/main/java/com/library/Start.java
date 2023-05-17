package main.java.com.library;

import java.util.Scanner;
import static main.java.com.library.BooksArrays.*;
import static main.java.com.library.Search.search;
import static main.java.com.library.RentalAndReturn.rentalAndRetrun;
public class Start {
    static Scanner sc = new Scanner(System.in);
    static int select=0;
    static String book = "";
    static public void start() {
        while(select != 6) {
            System.out.println("******************************");
            System.out.printf("%17s%n","*1.도서 등록*");
            System.out.printf("%17s%n","*2.도서 삭제*");
            System.out.printf("%17s%n","*3.도서 검색*");
            System.out.printf("%17s%n","*4.도서 목록*");
            System.out.printf("%17s%n","*5.도서 대여 및 반납*");
            System.out.printf("%17s%n","*6.종료*");
            System.out.println("******************************");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    bookList();
                    break;
                case 5:
                    rentalAndRetrun();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("제대로 된 값을 입력해주세요.");
                    break;
            }
        }
        select = 0;
    }
}

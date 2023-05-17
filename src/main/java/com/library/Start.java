package main.java.com.library;

import java.util.ArrayList;
import java.util.Scanner;
import static main.java.com.library.Book.*;
import static main.java.com.library.Search.search;
import static main.java.com.library.RentalAndReturn.rentalAndRetrun;
import static main.java.com.library.ChangeInfo.changeInfo;
public class Start {
    public static ArrayList<Book> bookCase = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int select=0;
    static public void start() {
        while(select != 7) {
            System.out.println("******************************");
            System.out.printf("%17s%n","*1.도서 등록*");
            System.out.printf("%17s%n","*2.도서 삭제*");
            System.out.printf("%17s%n","*3.도서 검색*");
            System.out.printf("%17s%n","*4.도서 목록*");
            System.out.printf("%17s%n","*5.도서 대여 및 반납*");
            System.out.printf("%17s%n","*6.도서 정보 변경*");
            System.out.printf("%17s%n","*7.종료*");
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
                    changeInfo();
                    break;
                case 7:
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

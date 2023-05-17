package main.java.com.library;

import java.util.ArrayList;
import java.util.Scanner;

public class BooksArrays{

    public static ArrayList<Book> bookCase = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void bookList() {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < bookCase.size()+1; i++) {
            bookInfo(i);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }

    public static void bookInfo(int index) {
        System.out.println("책 이름 : "+bookCase.get(index-1).getBookName());
        System.out.println("책 번호 : "+bookCase.get(index-1).getBookNo());
        System.out.println("책 대출 가능 여부 : "+bookCase.get(index-1).getCanRental());
    }

    public static void addBook() {
        System.out.println("등록하실 책의 이름을 입력해주세요");
        String book = sc.nextLine();
        bookCase.add(new Book(book));
    }

    public static void deleteBook() {
        System.out.println("삭제하실 책의 번호를 입력해주세요");
        int index = sc.nextInt();
        for (int i = 0; i < bookCase.size(); i++) {
            if((index)==bookCase.get(i).bookNo) {
                System.out.printf("%d번 책 (%s)이 삭제되었습니다.%n",bookCase.get(i).bookNo,bookCase.get(i).bookName);
                bookCase.remove(i);
                return;
            }
        }
    }

}

package main.java.com.library;

import java.util.Scanner;

public class Book {
    static int count;
    int bookNo;
    String bookName;
    Boolean canRental;
    static Scanner sc = new Scanner(System.in);

    public Book(String name){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setBookNo(int bookNo){
        this.bookNo = bookNo;
    }
    public int getBookNo() {
        return bookNo;
    }
    public Boolean getCanRental() {
        return canRental;
    }
    public void setCanRental(Boolean canRental) {
        this.canRental = canRental;
    }

    public static void bookList() {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < Start.bookCase.size()+1; i++) {
            bookInfo(i);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }

    public static void bookInfo(int index) {
        System.out.println("책 이름 : "+Start.bookCase.get(index-1).getBookName());
        System.out.println("책 번호 : "+Start.bookCase.get(index-1).getBookNo());
        System.out.println("책 대출 가능 여부 : "+Start.bookCase.get(index-1).getCanRental());
    }

    public static void addBook() {
        System.out.println("등록하실 책의 이름을 입력해주세요");
        String book = sc.nextLine();
        Start.bookCase.add(new Book(book));
    }

    public static void deleteBook() {
        System.out.println("삭제하실 책의 번호를 입력해주세요");
        int index = sc.nextInt();
        for (int i = 0; i < Start.bookCase.size(); i++) {
            if((index)==Start.bookCase.get(i).bookNo) {
                System.out.printf("%d번 책 (%s)이 삭제되었습니다.%n",Start.bookCase.get(i).bookNo,Start.bookCase.get(i).bookName);
                Start.bookCase.remove(i);
                return;
            }
        }
    }

}

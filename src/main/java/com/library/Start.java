package main.java.com.library;
import main.java.com.library.bookcase.*;
import java.util.Scanner;

import static main.java.com.library.Search.search;
import static main.java.com.library.RentalAndReturn.rentalAndReturn;
public class Start {
    ChangeInfo changeInfo = new ChangeInfo();
    static Scanner SC = new Scanner(System.in);

    public void start() {
        BookCaseManagement.getInstance().addBookCase(new NoneBookCase());
        BookCaseManagement.getInstance().addBookCase(new ComicBookCase());
        BookCaseManagement.getInstance().addBookCase(new NovelBookCase());
        while(true) {
            System.out.println("관리할 책장을 선택해주세요");
            System.out.println("******************************");
            System.out.printf("%17s%n","*1.분류 없음*");
            System.out.printf("%17s%n","*2.만화책*");
            System.out.printf("%17s%n","*3.소설*");
            System.out.printf("%17s%n","*4.종료*");
            System.out.println("******************************");
            switch (SC.nextInt()){
                case 1:
                    startMethod(BookCaseManagement.getInstance().getBookCase(1));
                break;
                case 2:
                    startMethod(BookCaseManagement.getInstance().getBookCase(2));
                break;
                case 3:
                    startMethod(BookCaseManagement.getInstance().getBookCase(3));
                break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    private void startMethod(BookCase bookCase){
        while(true){
                bookCase.thisType();
                System.out.println("******************************");
                System.out.printf("%17s%n","*1.도서 등록*");
                System.out.printf("%17s%n","*2.도서 삭제*");
                System.out.printf("%17s%n","*3.도서 검색*");
                System.out.printf("%17s%n","*4.도서 목록*");
                System.out.printf("%17s%n","*5.도서 대여 및 반납*");
                System.out.printf("%17s%n","*6.도서 정보 변경*");
                System.out.printf("%17s%n","*7.나가기*");
                System.out.println("******************************");
                switch (SC.nextInt()) {
                    case 1:
                        bookCase.thisType();
                        SC.nextLine();
                        System.out.println("등록할 책의 제목을 입력해주세요");
                        String bookName= SC.nextLine();
                        bookCase.addBook(bookName);
                        break;
                    case 2:
                        bookCase.thisType();
                        System.out.println("삭제하실 책의 번호를 입력해주세요");
                        SC.nextLine();
                        bookCase.deleteBook(SC.nextInt());
                        break;
                    case 3:
                        bookCase.thisType();
                        search(bookCase);
                        break;
                    case 4:
                        bookCase.thisType();
                        if (bookCase.getBookCase().size()!=0){
                            bookCase.bookList();
                        }
                        else{
                            System.out.printf("%n%n%n%17s%n%n%n%n","등록된 책이 없습니다.");
                        }
                        break;
                    case 5:
                        bookCase.thisType();
                        rentalAndReturn(bookCase);
                        break;
                    case 6:
                        bookCase.thisType();
                        this.changeInfo.changeInfo(bookCase);
                        break;
                    case 7:
                        System.out.println("책장 선택 화면으로 이동합니다.");
                        return;
                    default:
                        System.out.println("제대로 된 값을 입력해주세요.");
                        break;
                }
            }
    }
}

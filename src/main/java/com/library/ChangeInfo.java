package main.java.com.library;

import main.java.com.library.book.Book;
import main.java.com.library.bookcase.BookCaseType;

public class ChangeInfo {
    public static void changeInfo(BookCaseType bookCase, BookCaseType none, BookCaseType comic, BookCaseType novel){
//        Book.bookList(bookCase);
        bookCase.getBook(0).bookList(bookCase);
        System.out.println("어떤 책의 정보를 변경하시겠습니까? 책의 번호를 입력해주세요 : ");
        int select = Start.SC.nextInt();
        for (int i = 0; i < bookCase.getBookCase().size(); i++) {
            if ((select) == bookCase.getBookNo(i)) {
                System.out.printf("정보를 변경할 책의 제목은 (%s)입니다.%n1.제목 변경%n2.번호 변경%n3.종류 변경%n",bookCase.getBookName(i));
                int num = Start.SC.nextInt();
                switch (num){
                    case 1:
                        changeBookName(bookCase,i);
                        break;
                    case 2:
                        changeBookNo(bookCase, i);
                        break;
                    case 3:
//                        bookCase.getClass().getTypeName(); 이거 사용했대 대구사는 어떤 십새끼가 체인지타입에서 썼다고 말 바꾸는 개 씨발련
                        changeType(bookCase,i,none,comic,novel);
                        break;
                    default:
                        System.out.println("제대로 된 값을 입력해주세요");
                        break;
                }
            }
        }
    }

    private static void changeBookName(BookCaseType bookCase, int i){
        System.out.println("변경할 책의 제목을 입력해주세요.");
        Start.SC.nextLine();
        String bookName=Start.SC.nextLine();
        System.out.printf("책의 제목이 (%s)에서 (%s)으로 정상적으로 변경되었습니다.%n",bookCase.getBookName(i),bookName);
        bookCase.getBookCase().get(i).setBookName(bookName);
    }

    private static void changeBookNo(BookCaseType bookCase, int i){
        System.out.printf("책의 번호를 %d에서 몇으로 변경하시겠습니까?.",bookCase.getBookNo(i));
        int bookNum=Start.SC.nextInt();
        System.out.printf("책의 번호가 %d에서 %d로 변경되었습니다.%n",bookCase.getBookNo(i),bookNum);
        bookCase.getBookCase().get(i).setBookNo(bookNum);
    }
    private static void changeType(BookCaseType bookCase, int i, BookCaseType none, BookCaseType comic, BookCaseType novel){
        System.out.printf("책의 종류를 %s에서 무엇로 변경하시겠습니까?%n번호로 입력해주세요.%n1.분류 없음%n2.만화책%n3.소설%n",bookCase.getBookType(i));
        String previous = bookCase.getBookType(i);
        int select = Start.SC.nextInt();
        switch (select){
            case 1:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"분류 없음");//모듈화
                bookCase.setBookType(i,"분류 없음");
                break;
            case 2:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"만화책");
                bookCase.setBookType(i,"만화책");
                break;
            case 3:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"소설");
                bookCase.setBookType(i,"소설");
                break;
        }
        ChangeBookCase.changeBookCase(none,comic,novel, i, select, previous);
    }

}

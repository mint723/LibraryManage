package main.java.com.library;

import main.java.com.library.bookcase.*;
public class ChangeInfo {
    public void changeInfo(BookCase bookCase){
        bookCase.bookList();
        System.out.println("어떤 책의 정보를 변경하시겠습니까? 책의 번호를 입력해주세요 : ");
        int select = Start.SC.nextInt();
        for (int index = 0; index < bookCase.getBookCase().size(); index++) {
            if ((select) == bookCase.getBookNo(index)) {
                System.out.printf("정보를 변경할 책의 제목은 (%s)입니다.%n1.제목 변경%n2.번호 변경%n3.종류 변경%n",bookCase.getBookName(index));
                int num = Start.SC.nextInt();
                switch (num){
                    case 1:
                        changeBookName(bookCase,index);
                        break;
                    case 2:
                        changeBookNo(bookCase, index);
                        break;
                    case 3:
                        changeType(bookCase,index);
                        break;
                    default:
                        System.out.println("제대로 된 값을 입력해주세요");
                        break;
                }
            }
        }
    }

    private void changeBookName(BookCase bookCase, int index){
        System.out.println("변경할 책의 제목을 입력해주세요.");
        Start.SC.nextLine();
        String bookName=Start.SC.nextLine();
        System.out.printf("책의 제목이 (%s)에서 (%s)으로 정상적으로 변경되었습니다.%n",bookCase.getBookName(index),bookName);
        bookCase.getBookCase().get(index).setBookName(bookName);
    }

    private void changeBookNo(BookCase bookCase, int index){
        System.out.printf("책의 번호를 %d에서 몇으로 변경하시겠습니까?.",bookCase.getBookNo(index));
        int bookNum=Start.SC.nextInt();
        System.out.printf("책의 번호가 %d에서 %d로 변경되었습니다.%n",bookCase.getBookNo(index),bookNum);
        bookCase.getBookCase().get(index).setBookNo(bookNum);
    }

    private void changeType(BookCase bookCase, int bookIndex){
        System.out.printf("책의 종류를 %s에서 무엇로 변경하시겠습니까?%n번호로 입력해주세요.%n1.분류 없음%n2.만화책%n3.소설%n",bookCase.getBookType(bookIndex));
        String previous = bookCase.getBookType(bookIndex);
        int select = Start.SC.nextInt();
        switch (select){
            case 1:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"분류 없음");
                bookCase.setBookType(bookIndex,"분류 없음");
                BookCaseManagement.getInstance().changeBookCase("NoneBookCase",bookCase,bookIndex);
                break;
            case 2:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"만화책");
                bookCase.setBookType(bookIndex,"만화책");
                BookCaseManagement.getInstance().changeBookCase("ComicBookCase",bookCase,bookIndex);
                break;
            case 3:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"소설");
                bookCase.setBookType(bookIndex,"소설");
                BookCaseManagement.getInstance().changeBookCase("NovelBookCase",bookCase,bookIndex);
                break;
        }
    }
}

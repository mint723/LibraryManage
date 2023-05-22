package main.java.com.library;

import main.java.com.library.bookcase.*;
//bookCase.getClass().getTypeName();
//main.java.com.library.bookcase.ComicBookCase
public class ChangeInfo {
    //매개변수를 북케이스매니지먼트로 받으면 책장들을 스태틱으로 선언하지 않아도 사용할 수 있을것으로 예상
    //but 곽트는 이미 bookCase로 진행함
    public void changeInfo(BookCase bookCase, BookCase none, BookCase comic, BookCase novel){
        String a = bookCase.getClass().getTypeName();
        System.out.println(a);
        bookCase.bookList();
        System.out.println("어떤 책의 정보를 변경하시겠습니까? 책의 번호를 입력해주세요 : ");
        System.out.println(bookCase.getClass().getTypeName());
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
//                        bookCase.getClass().getTypeName(); 이거 사용했대 대구사는 어떤 십새끼가 체인지타입에서 썼다고 말 바꾸는 개 씨발련
                        changeType(bookCase,index,none,comic,novel);
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
    private void changeType(BookCase bookCase, int bookIndex, BookCase none, BookCase comic, BookCase novel){
        System.out.printf("책의 종류를 %s에서 무엇로 변경하시겠습니까?%n번호로 입력해주세요.%n1.분류 없음%n2.만화책%n3.소설%n",bookCase.getBookType(bookIndex));
        String previous = bookCase.getBookType(bookIndex);
        int select = Start.SC.nextInt();
        switch (select){
            case 1:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"분류 없음");//모듈화
                bookCase.setBookType(bookIndex,"분류 없음");
                break;
            case 2:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"만화책");
                bookCase.setBookType(bookIndex,"만화책");
                break;
            case 3:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(bookIndex),"소설");
                bookCase.setBookType(bookIndex,"소설");
                break;
        }
        changeBookCase(none,comic,novel, bookIndex, select, previous);
    }

private void changeBookCase(BookCase none, BookCase comic, BookCase novel, int i, int select, String previous){
    switch (select){
        case 1:
            if (previous.equals("분류 없음")){
                none.addBookObject(none.getBook(i));
                none.deleteBook(none.getBookNo(i));
            }
            else if(previous.equals("만화책")){
                none.addBookObject(comic.getBook(i));
                comic.deleteBook(comic.getBookNo(i));
            }
            else if(previous.equals("소설")){
                none.addBookObject(novel.getBook(i));
                novel.deleteBook(novel.getBookNo(i));
            }

            break;
        case 2:
            if (previous.equals("분류 없음")){
                comic.addBookObject(none.getBook(i));
                none.deleteBook(none.getBookNo(i));
            }
            else if(previous.equals("만화책")){
                comic.addBookObject(comic.getBook(i));
                comic.deleteBook(comic.getBookNo(i));
            }
            else if(previous.equals("소설")){
                comic.addBookObject(novel.getBook(i));
                novel.deleteBook(novel.getBookNo(i));
            }
            break;
        case 3:
            if (previous.equals("분류 없음")){
                novel.addBookObject(none.getBook(i));
                none.deleteBook(none.getBookNo(i));
            }
            else if(previous.equals("만화책")){
                novel.addBookObject(comic.getBook(i));
                comic.deleteBook(comic.getBookNo(i));
            }
            else if(previous.equals("소설")){
                novel.addBookObject(novel.getBook(i));
                novel.deleteBook(novel.getBookNo(i));
            }
            break;
    }
}
}

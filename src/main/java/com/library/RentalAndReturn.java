package main.java.com.library;

import main.java.com.library.bookcase.*;

public class RentalAndReturn {
    RentalAndReturn(BookCase bookCase){
        bookCase.bookList();
    }

    public static void rentalAndReturn(BookCase bookCase) {
        System.out.printf("번호를 입력해주세요%n1.대여%n2.반납%n");
        int choose = Start.SC.nextInt();
        int index;
        switch (choose) {
            case 1:
                System.out.println("대여할 책의 번호를 입력해주세요");
                index = Start.SC.nextInt();
                rentalBook(bookCase,index);
                break;
            case 2:
                System.out.println("반납할 책의 번호를 입력해주세요");
                index = Start.SC.nextInt();
                returnBook(bookCase,index);
            default:
                System.out.println("제대로 된 값을 입력해주세요.");
                break;
        }
    }

    private static void rentalBook(BookCase bookCase, int index){
        for (int i = 0; i < bookCase.getBookCase().size(); i++) {
            if((index)==bookCase.getBookNo(i)) {
                if(bookCase.getCanRental(i)) {
                    System.out.printf("%d번 책 (%s)을 대여처리 했습니다.%n",bookCase.getBookNo(i),bookCase.getBookName(i));
                    bookCase.setCanRental(i);
                    return;
                }
                else {
                    System.out.println("이미 대여상태인 책입니다.");
                }
            }
        }
    }

    private static void returnBook(BookCase bookCase, int index){
        for (int i = 0; i < bookCase.getBookCase().size(); i++) {
            if((index)==bookCase.getBookNo(i)) {
                if(!bookCase.getCanRental(i)) {
                    System.out.printf("%d번 책 (%s)을 반납처리 했습니다.%n",bookCase.getBookNo(i),bookCase.getBookName(i));
                    bookCase.setCanRental(i);
                    return;
                }
                else {
                    System.out.println("이미 반납상태인 책입니다.");
                    break;
                }
            }
        }
    }
}

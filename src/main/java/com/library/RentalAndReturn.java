package main.java.com.library;
import java.util.Scanner;
public class RentalAndReturn {
    static Scanner sc = new Scanner(System.in);
    RentalAndReturn(){
        BooksArrays.bookList();
    }
    public static void rentalAndRetrun() {
        System.out.printf("번호를 입력해주세요%n1.대여%n2.반납%n");
        int choose = sc.nextInt();
        int index;
        switch (choose) {
            case 1:
                System.out.println("대여할 책의 번호를 입력해주세요");
                index = sc.nextInt();
                for (int i = 0; i < BooksArrays.bookCase.size(); i++) {
                    if((index)==BooksArrays.bookCase.get(i).bookNo) {
                        if(BooksArrays.bookCase.get(i).canRental==true) {
                            System.out.printf("%d번 책 (%s)을 대여처리 했습니다.%n",BooksArrays.bookCase.get(i).bookNo,BooksArrays.bookCase.get(i).bookName);
                            BooksArrays.bookCase.get(i).canRental=false;
                            return;
                        }
                        else {
                            System.out.println("이미 대여상태인 책입니다.");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("반납할 책의 번호를 입력해주세요");
                index = sc.nextInt();
                for (int i = 0; i < BooksArrays.bookCase.size(); i++) {
                    if((index)==BooksArrays.bookCase.get(i).bookNo) {
                        if(BooksArrays.bookCase.get(i).canRental==false) {
                            System.out.printf("%d번 책 (%s)을 반납처리 했습니다.%n",BooksArrays.bookCase.get(i).bookNo,BooksArrays.bookCase.get(i).bookName);
                            BooksArrays.bookCase.get(i).canRental=true;
                            return;
                        }
                        else {
                            System.out.println("이미 반납상태인 책입니다.");
                        }
                    }
                }
                break;
            default:
                System.out.println("제대로 된 값을 입력해주세요.");
                break;
        }
    }
}

package main.java.com.library;
public class RentalAndReturn {
    RentalAndReturn(){
        Book.bookList();
    }
    public static void rentalAndRetrun() {
        System.out.printf("번호를 입력해주세요%n1.대여%n2.반납%n");
        int choose = Start.sc.nextInt();
        int index;
        switch (choose) {
            case 1:
                System.out.println("대여할 책의 번호를 입력해주세요");
                index = Start.sc.nextInt();
                for (int i = 0; i < Start.bookCase.size(); i++) {
                    if((index)==Start.bookCase.get(i).bookNo) {
                        if(Start.bookCase.get(i).canRental) {
                            System.out.printf("%d번 책 (%s)을 대여처리 했습니다.%n",Start.bookCase.get(i).bookNo,Start.bookCase.get(i).bookName);
                            Start.bookCase.get(i).canRental=false;
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
                index = Start.sc.nextInt();
                for (int i = 0; i < Start.bookCase.size(); i++) {
                    if((index)==Start.bookCase.get(i).bookNo) {
                        if(!Start.bookCase.get(i).canRental) {
                            System.out.printf("%d번 책 (%s)을 반납처리 했습니다.%n",Start.bookCase.get(i).bookNo,Start.bookCase.get(i).bookName);
                            Start.bookCase.get(i).canRental=true;
                            return;
                        }
                        else {
                            System.out.println("이미 반납상태인 책입니다.");
                            break;
                        }
                    }
                }
            default:
                System.out.println("제대로 된 값을 입력해주세요.");
                break;
        }
    }
}

package main.java.com.library;

public class ChangeInfo {
    public static void changeInfo(){
        Book.bookList();
        System.out.println("어떤 책의 정보를 변경하시겠습니까? 책의 번호를 입력해주세요 : ");
        int select = Start.sc.nextInt();
        for (int i = 0; i < Start.bookCase.size(); i++) {
            if ((select) == Start.bookCase.get(i).bookNo) {
                System.out.printf("정보를 변경할 책의 제목은 (%s)입니다.%n1.제목 변경%n2.번호 변경%n",Start.bookCase.get(i).bookName);
                int num = Start.sc.nextInt();
                switch (num){
                    case 1:
                        System.out.println("변경할 책의 제목을 입력해주세요.");
                        Start.sc.nextLine();
                        String bookName=Start.sc.nextLine();
                        System.out.printf("책의 제목이 (%s)에서 (%s)으로 정상적으로 변경되었습니다.%n",Start.bookCase.get(i).getBookName(),bookName);
                        Start.bookCase.get(i).setBookName(bookName);
                        break;
                    case 2:
                        System.out.printf("책의 번호를 %d에서 몇으로 변경하시겠습니까?.",Start.bookCase.get(i).getBookNo());
                        int bookNum=Start.sc.nextInt();
                        System.out.printf("책의 번호가 %d에서 %d로 변경되었습니다.%n",Start.bookCase.get(i).getBookNo(),bookNum);
                        Start.bookCase.get(i).setBookNo(bookNum);
                        break;
                    default:
                        System.out.println("제대로 된 값을 입력해주세요");
                        break;
                }
            }
        }
    }
}

package main.java.com.library;

import java.util.ArrayList;

public class BookCase {
    ArrayList<Book> bookCase = new ArrayList<>();
    void addBook(String bookName){
        this.bookCase.add(new Book(bookName));
    }
    public void deleteBook(int index) {
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((index)==this.getBookNo(i)) {
                System.out.printf("%d번 책 (%s)이 삭제되었습니다.%n",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    }
    public ArrayList<Book> getBookCase() {
        return bookCase;
    }
    String getBookName(int i){
        return this.getBookCase().get(i).getBookName();
    }
    int getBookNo(int i){
        return this.getBookCase().get(i).getBookNo();
    }
    boolean getCanRental(int i){
        return this.getBookCase().get(i).getCanRental();
    }
    boolean setCanRental(int i){
        return this.getBookCase().get(i).setCanRental();
    }

}

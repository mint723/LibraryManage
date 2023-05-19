package main.java.com.library.bookcasetype;

import main.java.com.library.Book;

import java.util.ArrayList;

public class Comic implements BookCaseType {
    private ArrayList<Book> comic = new ArrayList<>();
    public void thisType() {
        System.out.printf("%15s%n","*만화책*");
    }
    public Book getBook(int i){ return this.comic.get(i); }

    public void addBook(String bookName){
        this.comic.add(new Book(bookName,"만화책"));
    }
    public void addBookObject(Book book){
        this.comic.add(book);
    }
    public void deleteBook(int index){
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((index)==this.getBookNo(i)) {
                System.out.printf("'%s'에서 %d번 책 (%s)이 삭제되었습니다.%n","만화책",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    };
    public ArrayList<Book> getBookCase() {
        return this.comic;
    };
    public String getBookName(int i){
        return this.getBookCase().get(i).getBookName();
    }
    public int getBookNo(int i){ return this.getBookCase().get(i).getBookNo(); }
    public boolean getCanRental(int i){
        return this.getBookCase().get(i).getCanRental();
    }
    public boolean setCanRental(int i){
        return this.getBookCase().get(i).setCanRental();
    }
    public String getBookType(int i){ return this.getBookCase().get(i).getBookType(); }
    public void setBookType(int i, String bookName){ this.getBookCase().get(i).setBookType(bookName); }
}

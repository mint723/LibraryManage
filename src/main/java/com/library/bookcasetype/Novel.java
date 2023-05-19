package main.java.com.library.bookcasetype;

import main.java.com.library.Book;

import java.util.ArrayList;

public class Novel implements BookCaseType {
    private ArrayList<Book> novel = new ArrayList<>();
    public void thisType() {
        System.out.printf("%15s%n","*소설*");
    }
    public Book getBook(int i){ return this.novel.get(i); }
    public void addBook(String bookName){
        this.novel.add(new Book(bookName,"소설"));
    }
    public void addBookObject(Book book){
        this.novel.add(book);
    }
    public void deleteBook(int index){
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((index)==this.getBookNo(i)) {
                System.out.printf("'%s'에서 %d번 책 (%s)이 삭제되었습니다.%n","소설",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    };
    public ArrayList<Book> getBookCase() {
        return this.novel;
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

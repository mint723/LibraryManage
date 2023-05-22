package main.java.com.library.bookcase;

import main.java.com.library.book.Book;
import main.java.com.library.book.NoneBook;

import java.util.ArrayList;

abstract public class BookCase {

    protected ArrayList<Book> bookCase = new ArrayList<>();

    BookCase(String bookCaseType){
        this.bookCaseType = bookCaseType;
    }

    BookCase(){
        this("분류 없음");
    }
    private String bookCaseType = ""; // 추후 책장 추가 시 생성자를 통해 책장 종류 받음
    //이후 북을 생성할 때 bookCaseType 통해 Book 객체를 추가할 때 Book 타입을 추가함


    abstract public void thisType();

    public void bookList(){
        for (int bookNo = 1; bookNo < bookCase.size()+1; bookNo++) {
            this.bookCase.get(bookNo-1).bookInfo();
        }
    }






    public Book getBook(int index){ return this.bookCase.get(index); }

    abstract public void addBook(String bookName);

    public void addBookObject(Book book){
        this.bookCase.add(book);
    }

    public void deleteBook(int index) {
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((index)==this.getBookNo(i)) {
                System.out.printf("'%s'에서 %d번 책 (%s)이 삭제되었습니다.%n","분류 없음",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    }

    public ArrayList<Book> getBookCase() {
        return this.bookCase;
    }

    public String getBookCaseType(){ return this.bookCaseType; }
    public String getBookName(int index){
        return this.getBookCase().get(index).getBookName();
    }

    public int getBookNo(int index){ return this.getBookCase().get(index).getBookNo(); }

    public boolean getCanRental(int index){
        return this.getBookCase().get(index).getCanRental();
    }

    public boolean setCanRental(int index){ return this.getBookCase().get(index).setCanRental(); }

    public String getBookType(int index){ return this.getBookCase().get(index).getBookType(); }

    public void setBookType(int index, String bookName){ this.getBookCase().get(index).setBookType(bookName); }

}

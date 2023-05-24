package main.java.com.library.bookcase;

import main.java.com.library.book.Book;

import java.util.ArrayList;

abstract public class BookCase {

    protected ArrayList<Book> bookCase = new ArrayList<>();

    BookCase(String bookCaseType){
        this.bookCaseType = bookCaseType;
    }

    BookCase(){
        this("분류 없음");
    }

    private String bookCaseType = "";

    abstract public void thisType();

    public void bookList(){
        for (int bookNo = 1; bookNo < bookCase.size()+1; bookNo++) {
            this.bookCase.get(bookNo-1).bookInfo();
        }
    }


    abstract public void addBook(String bookName);

    public void deleteBook(int bookNo) {
        for (int i = 0; i < this.getBookCase().size(); i++) {
            if((bookNo)==this.getBookNo(i)) {
                System.out.printf("'%s'에서 %d번 책 (%s)이 삭제되었습니다.%n","분류 없음",this.getBookNo(i),this.getBookName(i));
                this.getBookCase().remove(i);
                return;
            }
        }
    }
    //추상메서드 지정 후 각 카테고리별로 다르게 나오게 만들기





    public Book getBook(int index){ return this.bookCase.get(index); }

    public void addBookObject(Book book){
        this.bookCase.add(book);
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

    public String getBookCaseTypeName(){
        return this.getClass().getTypeName().substring(this.getClass().getTypeName().lastIndexOf(".")+1);
    }

}

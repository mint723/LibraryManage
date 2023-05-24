package main.java.com.library.bookcase;

import java.util.ArrayList;

public class BookCaseManagement {
    private BookCaseManagement(){}

    private static BookCaseManagement bookCaseManagement = new BookCaseManagement();

    public static BookCaseManagement getInstance(){
        return bookCaseManagement;
    }
    //싱글톤 패턴
    private static ArrayList<BookCase> bookCaseCollection = new ArrayList<>();

    public void addBookCase(BookCase bookCase){
        bookCaseCollection.add(bookCase);
    }

    public void deleteBookCase(int bookCaseNo){
        bookCaseCollection.remove(bookCaseNo-1);
    }

    public void BookCaseList(){
        for (int bookNo = 1; bookNo < bookCaseCollection.size()+1; bookNo++) {
            BookCaseInfo(bookNo);
        }
    }
    public void BookCaseInfo(int bookCaseNo){
        System.out.printf("%d번 책장 : %s",bookCaseNo,getBookCase(bookCaseNo));
    }

    public BookCase getBookCase(int bookCaseNo){
        return this.bookCaseCollection.get(bookCaseNo-1);
    }

    public void changeBookCase(String bookCaseType,BookCase bookCase, int bookIndex){
        for (int i = 0; i < bookCaseCollection.size(); i++) {
            if(bookCaseCollection.get(i).getBookCaseTypeName().equals(bookCaseType)){
                bookCaseCollection.get(i).addBookObject(bookCase.getBook(bookIndex));
                bookCase.deleteBook(bookCase.getBook(bookIndex).getBookNo());
            }
        }
    }
}

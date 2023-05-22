package main.java.com.library.bookcase;

import java.util.ArrayList;

public class BookCaseManagement {

    NoneBookCase noneBookCase = new NoneBookCase();
    ComicBookCase comicBookCase = new ComicBookCase();
    NovelBookCase novelBookCase = new NovelBookCase();

    private ArrayList<BookCase> bookCaseCollection = new ArrayList<>();

    void addBookCase(BookCase bookCase){
        bookCaseCollection.add(bookCase);
    }

    void deleteBookCase(BookCase bookCase, int bookCaseNo){
        bookCaseCollection.remove(bookCaseNo-1);
    }

    void BookCaseList(){
        for (int bookNo = 1; bookNo < bookCaseCollection.size()+1; bookNo++) {
            BookCaseInfo(bookNo);
        }
    }
    void BookCaseInfo(int bookCaseNo){
        System.out.printf("%d번 책장 : %s",bookCaseNo,getBookCase(bookCaseNo));
    }

    BookCase getBookCase(int BookCaseNo){
        return this.bookCaseCollection.get(BookCaseNo-1);
    }


}

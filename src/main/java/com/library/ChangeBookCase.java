package main.java.com.library;

import main.java.com.library.bookcase.BookCaseType;

public class ChangeBookCase {
    public static void changeBookCase(BookCaseType none, BookCaseType comic, BookCaseType novel, int i, int select, String previous){
        switch (select){
            case 1:
                if (previous.equals("분류 없음")){
                    none.addBookObject(none.getBook(i));
                    none.deleteBook(none.getBookNo(i));
                }
                else if(previous.equals("만화책")){
                    none.addBookObject(comic.getBook(i));
                    comic.deleteBook(comic.getBookNo(i));
                }
                else if(previous.equals("소설")){
                    none.addBookObject(novel.getBook(i));
                    novel.deleteBook(novel.getBookNo(i));
                }

                break;
            case 2:
                if (previous.equals("분류 없음")){
                    comic.addBookObject(none.getBook(i));
                    none.deleteBook(none.getBookNo(i));
                }
                else if(previous.equals("만화책")){
                    comic.addBookObject(comic.getBook(i));
                    comic.deleteBook(comic.getBookNo(i));
                }
                else if(previous.equals("소설")){
                    comic.addBookObject(novel.getBook(i));
                    novel.deleteBook(novel.getBookNo(i));
                }
                break;
            case 3:
                if (previous.equals("분류 없음")){
                    novel.addBookObject(none.getBook(i));
                    none.deleteBook(none.getBookNo(i));
                }
                else if(previous.equals("만화책")){
                    novel.addBookObject(comic.getBook(i));
                    comic.deleteBook(comic.getBookNo(i));
                }
                else if(previous.equals("소설")){
                    novel.addBookObject(novel.getBook(i));
                    novel.deleteBook(novel.getBookNo(i));
                }
                break;
        }
    }
}

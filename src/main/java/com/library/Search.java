package main.java.com.library;

import main.java.com.library.bookcase.*;

public class Search {
    public static void search(BookCase bookCase){
        int count = 0;
        System.out.printf("찾으시는 책을 검색해주세요%n검색 : ");
        Start.SC.nextLine();
        String searchWord = Start.SC.nextLine();
        searchWord = searchWord.replaceAll("\\s", "");
        for (int i = 0; i < bookCase.getBookCase().size(); i++) {
            String book = bookCase.getBookName(i);
            book = book.replaceAll("\\s", "");
            if (!searchWord.equals("")) {
                for (int j = 0; j < book.length()-searchWord.length()+1; j++) {
                    if(book.substring(j, searchWord.length()+j).equals(searchWord)) {
                        bookCase.getBook(i).bookInfo();
                        count++;
                        break;
                    }
                }
            }
        }
        if (count==0) {
            System.out.println("검색하신 책은 존재하지 않습니다.");
        }
    }
}

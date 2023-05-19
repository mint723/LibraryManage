package main.java.com.library;

import main.java.com.library.bookcasetype.BookCaseType;

public class Search {
    public static void search(BookCaseType bookCase){
        int count = 0;
        System.out.printf("찾으시는 책을 검색해주세요%n검색 : ");
        Start.sc.nextLine();
        String searchWord = Start.sc.nextLine();
        searchWord = searchWord.replaceAll("\\s", "");
        for (int i = 0; i < bookCase.getBookCase().size(); i++) {
            String book = bookCase.getBookName(i);
            book = book.replaceAll("\\s", "");
            if (!searchWord.equals("")) {
                for (int j = 0; j < book.length()-searchWord.length()+1; j++) {
                    if(book.substring(j, searchWord.length()+j).equals(searchWord)) {
                        Book.bookInfo(i+1,bookCase);
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

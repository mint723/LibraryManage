package main.java.com.library;

import java.util.Scanner;

public class Search {
    static Scanner sc = new Scanner(System.in);

    public static void search(){
        int count = 0;
        System.out.printf("찾으시는 책을 검색해주세요%n검색 : ");
        String searchWord = sc.nextLine();
        searchWord = searchWord.replaceAll("\\s", "");
        for (int i = 0; i < BooksArrays.bookCase.size(); i++) {
            String book = BooksArrays.bookCase.get(i).bookName;
            book = book.replaceAll("\\s", "");
            if (searchWord.equals("")) {}
            else {
                for (int j = 0; j < book.length()-searchWord.length()+1; j++) {
                    if(book.substring(j, searchWord.length()+j).equals(searchWord)) {
                        BooksArrays.bookInfo(i+1);
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

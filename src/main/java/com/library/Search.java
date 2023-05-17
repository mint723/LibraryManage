package main.java.com.library;

public class Search {

    public static void search(){
        int count = 0;
        System.out.printf("찾으시는 책을 검색해주세요%n검색 : ");
        Start.sc.nextLine();
        String searchWord = Start.sc.nextLine();
        searchWord = searchWord.replaceAll("\\s", "");
        for (int i = 0; i < Start.bookCase.size(); i++) {
            String book = Start.bookCase.get(i).bookName;
            book = book.replaceAll("\\s", "");
            if (searchWord.equals("")) {}
            else {
                for (int j = 0; j < book.length()-searchWord.length()+1; j++) {
                    if(book.substring(j, searchWord.length()+j).equals(searchWord)) {
                        Book.bookInfo(i+1);
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

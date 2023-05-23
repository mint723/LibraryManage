# 3차 FIX(2023. 05. 23)
book패키지 생성 후 기존의 Book class를 추상클래스로 변경 후 각 종류의 책들이 BookClass를 상속받도록 함,

이어서 2차 픽스 당시 오버로딩 했던 생성자를 제거 후 상속받은 class에서 super로 생성자를 받아와 각 클래스에서 bookType을 지정할 수 있도록 변경

<img src="https://velog.velcdn.com/images/mint723/post/6a8288b1-0f6f-4e32-bbd4-38663d1b4706/image.png">

BookCaseType interface는 해당 interface를 상속하는 class들과 메서드 개수가 동일하게 존재했으며, 이는 BookCaseType을 interface로 구성하는 것보다 상속으로 구성하는 것이 적합할 것이라고 판단함,

기존 BookCaseType 삭제 새롭게 생성한 추상 클래스 BookCase 그 역할을 대신 하며, ComicBookCase, NoneBookCase, NovelBookCase 클래스는 BookCase를 extends함

<img src="https://velog.velcdn.com/images/mint723/post/7d7311d1-cbdd-4d9d-83ea-4c7b00e77a1b/image.png">

기존 BookCaseType 인스턴스를 사용하던 관련 로직들 수정
___ 
   
기존 bookList 메서드는 Book class 안에 존재했으며, 지금의 BookCase class 역할을 하는 
BookCaseType 인스턴스를  매개변수로 받았음,

Book객체를 모아놓은 BookCase의 목록을 출력하기 위해 다시 Book클래스로 이동하는 과정이
적합하지 못하다고 판단함 따라서 해당 메서드를 BookCase클래스에 위치하고 작동하도록 관련 코드 수정, 

### 2차fix bookList method
 ```ruby
 public void bookList(BookCaseType bookCase) {
        System.out.printf("%n------Book List------%n");
        for (int i = 1; i < bookCase.getBookCase().size() + 1; i++) {
            bookCase.getBook(0).bookInfo(i,bookCase);
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
    }
    
```

### 3차fix bookList method
```ruby
public void bookList(){
        for (int bookNo = 1; bookNo < bookCase.size()+1; bookNo++) {
            this.bookCase.get(bookNo-1).bookInfo();
        }
    }
```

또한 bookInfo 메서드에서도 매개변수로 BookCaseType으로 받음, 해당 메서드는 book에 
그대로 위치하되 매개변수로 BookCase 인스턴스를 받지 않도록 관련 코드 수정
### 2차fix bookInfo method

```ruby
public void bookInfo(int index, BookCaseType bookCase) {
        System.out.println("책 이름 : "+bookCase.getBookName(index - 1));
        System.out.println("책 번호 : "+bookCase.getBookNo(index - 1));
        System.out.printf("책 대출 가능 여부 : %s%n",bookCase.getCanRental(index - 1)==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+bookCase.getBookType(index - 1));
    }
```
### 3차fix bookInfo method
```ruby
public void bookInfo() {
        System.out.println("책 이름 : "+getBookName());
        System.out.println("책 번호 : "+getBookNo());
        System.out.printf("책 대출 가능 여부 : %s%n",getCanRental()==true?"대출 가능":"대여중");
        System.out.println("책 종류 : "+getBookType());
    }
```
bookList, bookInfo 메서드를 사용하던 메서드들의 로직 정리
___    

향후 BookCase 객체들을 관리하기 위한 BookCaseManagement class를 싱글톤 패턴으로 디자인 함
```ruby
public class BookCaseManagement {
    private BookCaseManagement(){}

    private static BookCaseManagement bookCaseManagement = new BookCaseManagement();

    public static BookCaseManagement getInstance(){
        return bookCaseManagement;
    }
    ...
```


기존에는 Start class에 인스턴스 변수로 ComicBookCase, NoneBookCase, NovelBookCase를 생성해서 해당 인스턴스를 관리했지만, 현재는

start method가 선언됨과 동시에 BookCaseManagement의 클래스 변수 bookCaseCollection에 BookCase를 추가하고 관리할 수 있도록 변경
### 2차fix start method
```ruby
public class Start {
    BookCaseManagement bookCaseManagement = new BookCaseManagement();
    ChangeInfo changeInfo = new ChangeInfo();
    static Scanner SC = new Scanner(System.in);
    NoneBookCase noneBookCase = new NoneBookCase();
    ComicBookCase comicBookCase = new ComicBookCase();
    NovelBookCase novelBookCase = new NovelBookCase();
    public void start() {
        while(true) {
        ...
```
### 3차fix start method
```ruby
public class Start {
    ChangeInfo changeInfo = new ChangeInfo();
    static Scanner SC = new Scanner(System.in);
    public void start() {
        BookCaseManagement.getInstance().addBookCase(new NoneBookCase());
        BookCaseManagement.getInstance().addBookCase(new ComicBookCase());
        BookCaseManagement.getInstance().addBookCase(new NovelBookCase());
        while(true) {
        ...
```

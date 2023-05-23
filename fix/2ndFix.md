# 2차 FIX(2023. 05. 19)
자바의 객체지향 개념을 학습하며 인터페이스를 통해 책장 클래스를 관리하는 것이 유지보수에 용이할 것으로 판단되어 BookCaseType interface를 생성 후 관련 추상메서드를 선언함 

또한 이에 맞춰 BookClass에 멤버변수 bookType을 추가하여 bookType에 따라 알맞는 BookCase에 들어가는 그림을 구상했으며 이에 따라 Book class의 생성자를 수정 및 오버로딩하여 책이 생성됨과 동시에 알맞은 속성을 갖을 수 있도록 함
### 1차fix Book class 생성자
```ruby
public Book(String name){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
    }
```
### 2차fix Book class 생성자
```ruby
public Book(String name){
        this(name,"분류 없음");
    }

public Book(String name, String bookType){
        this.bookNo = ++count;
        this.bookName = name;
        this.canRental = true;
        this.bookType = bookType;
    }
```
기존에 존재하던 BookCase class를 'Book.bookType = "분류 없음"' 인 책을 보관하는 None class로 재구성하며 BookCaseType interface를 구현하도록 함, 이후 Comic, Novel class 또한 생성하여 BookCaseType interface를 구현하는 class로 생성 후 해당 클래스들을 새로 생성한 bookcasetype package로 이동함

<img src="https://media.discordapp.net/attachments/439043226423263232/1109125407673962546/image.png">

BookCaseType interface를 생성함으로써 기존 ChangeInfo, RentalAndReturn, Search 등과 같은 class에서 method의 매개변수를 선언할 때

기존에는 BookCase의 instance를 매개변수로 선언받았지만, 매개변수의 타입을 BookCaseType으로 변경하여 

BookCaseType interface를 구현한 class의 instance를 매개변수로 사용할 수 있도록 함
### 1차fix search method 매개변수
```ruby
public static void search(BookCase bookCase){ ... }
```
### 2차fix search method 매개변수
```ruby
public static void search(BookCaseType bookCase){ ... }
```

### ChangeBookCase.java
ChangeBookCase class추가, 다른 책장으로 해당 책을 옮길 수 있도록 하는 method 구현
```ruby
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
                ...
```

### ChangeInfo.java
changeType method 추가, 선택한 책의 종류를 수정할 수 있도록 구성함, 이후 바로 changeBookCase method를 불러와 수정한 책에 종류에 맞는 책장에 책을 보관함
```ruby
 private static void changeType(BookCaseType bookCase, int i, BookCaseType none, BookCaseType comic, BookCaseType novel){
        System.out.printf("책의 종류를 %s에서 무엇로 변경하시겠습니까?%n번호로 입력해주세요.%n1.분류 없음%n2.만화책%n3.소설%n",bookCase.getBookType(i));
        String previous = bookCase.getBookType(i);
        int select = Start.sc.nextInt();
        switch (select){
            case 1:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"분류 없음");
                bookCase.setBookType(i,"분류 없음");
                break;
            case 2:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"만화책");
                bookCase.setBookType(i,"만화책");
                break;
            case 3:
                System.out.printf("책의 종류가 %s에서 %s로 변경되었습니다%n",bookCase.getBookType(i),"소설");
                bookCase.setBookType(i,"소설");
                break;
        }
        ChangeBookCase.changeBookCase(none,comic,novel, i, select, previous);
    }
    
```


마지막으로 전체적으로 메서드의 모듈화를 진행하여 코드의 가독성을 높일 수 있도록 노력함

예시)
### Start.java - start method
```ruby
...
 switch (sc.nextInt()){
                case 1:
                    startMethod(this.none);
                break;
                case 2:
                    startMethod(this.comic);
                break;
                case 3:
                    startMethod(this.novel);
                break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
            ...
```

### ChangeInfo.java - changeInfo method
```ruby
...
switch (num){
                    case 1:
                        changeBookName(bookCase,i);
                        break;
                    case 2:
                        changeBookNo(bookCase, i);
                        break;
                    case 3:
                        changeType(bookCase,i,none,comic,novel);
                        break;
                    default:
                        System.out.println("제대로 된 값을 입력해주세요");
                        break;
                }
                ...
```

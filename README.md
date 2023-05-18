# LibraryManage
## 1차 FIX(2023. 05. 17)
### Book
기존 Book class 멤버변수의 접근 제한자는 public으로 패키지와 클래스에서 Book Class의 값을 조회하거나 변경할 수 있었기에, 접근 제한자를 private으로 바꾸어 캡슐화를 진행함      
또한 기존 addBook, deleteBook 메서드는 메서드를 호출시킴과 동시에 scanner를 통해서 사용자에게 값을 입력받았지만,   
   
 1. 입력 값을 받아옴 -> 2. 해당 입력 값을 통해 정보를 추가하거나 삭제함   
   
한 메서드 안에서 위와 같이 두 가지 책임을 지니는 것이 적절하지 못하다고 판단하여 Start클래스의 start메서드에서 사용자에게 값을 입력 받도록 수정하고 이에 따라 addBook, deleteBook 메서드는 각각의 기능만을 수행함
### BookCase
추후 책의 속성에 따라 책장별로 구분하여 알맞은 속성의 책을 BookCase에 할당하도록 하기 위해 BookCase 클래스를 생성함   
기존 Book class에 정의 된 addBook, deleteBook 메서드의 위치가 Book class보다 BookCase class에 적합할 것으로 판단하여 해당 메서드를 BookCase 클래스의 메서드로 이전시킴   
또한 편의 메서드를 정의함으로 기존 코드를 간소화 하도록 함   
#### [RentalAndReturn.java](https://github.com/mint723/LibraryManage/blob/master/src/main/java/com/library/RentalAndReturn.java)
```ruby
if((index)==bookCase.getBookNo(i)) {
   if(bookCase.getCanRental(i)) {
      System.out.printf("%d번 책 (%s)을 대여처리 했습니다.%n",bookCase.getBookNo(i),bookCase.getBookName(i));
      bookCase.setCanRental(i);
      return;
   }
}
```
#### [BookCase.java](https://github.com/mint723/LibraryManage/blob/master/src/main/java/com/library/BookCase.java)
```ruby
    String getBookName(int i){
        return this.getBookCase().get(i).getBookName();
    }
    int getBookNo(int i){
        return this.getBookCase().get(i).getBookNo();
    }
    boolean getCanRental(int i){
        return this.getBookCase().get(i).getCanRental();
    }
    boolean setCanRental(int i){
        return this.getBookCase().get(i).setCanRental();
    }
```


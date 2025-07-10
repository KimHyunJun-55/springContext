@Component 을 사용해서도 빈을 등록할수있다
- 이름을 등록해주고싶다면 @Component(value="name")

같은 객체라도 이름을 달리하면 스프링 컨테이너가 각각 싱글톤으로 관리를 해준다

빈에 매개변수가 필요하다면 
```declarative
@Bean
public BookService service(Book book){
    return new BookService(book);

}
```
하게되면 Book bean을 먼저생성한다.

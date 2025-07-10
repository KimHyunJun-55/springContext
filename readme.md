@Component 을 사용해서도 빈을 등록할수있다
- 이름을 등록해주고싶다면 @Component(value="name")

같은 객체라도 이름을 달리하면 스프링 컨테이너가 각각 싱글톤으로 관리를 해준다

빈에 매개변수가 필요하다면 

```java
@Bean
public BookService service(Book book){
    return new BookService(book);

}
```

하게되면 Book bean을 먼저생성한다.

---

# Servlet

### Web Application Server(WAS)

### Java EE Platfom

- javax.servlet 을 구현하고 있는것이 tomcat
- java EE 에서 jakarta EE 로 전환됨(java 8 이후버전)
  - https://www.samsungsds.com/kr/insights/java_jakarta.html
- 이클립스 재단으로 이관이 되며 자카르타 EE로 변경이됐다.
- javax.* -> jakarta.*

---

### Java 웹 프로그래밍

- Java언어로 웹 어플리케이션을 만든다
- 자바 웹 어플리케이션이 실행될 수있는 WAS가 필요함.
- Servlet/JSP 르 실행할수 있는 환경(Servlet 컨테이너라고함)
    - Jsp도 알고보면 Servlet기술로 만들어짐
    - Servlet 컨테이너는 WAS안에 있다.
    - Was는 여러개의 웹 어플리케이션을 실행시킬 수 있다.
    - 대표적인 WAS는 **Tomcat**
   


### Tomcat

- https://tomcat.apache.org

### Tomcat 을 이요한 어플리케이션을 만ㄷ든다는건
    - webapps/Root 의 내용을 내가 만든 내용으로 바꾼다.
    -Tomcat서버에 내가 만든 웹 어플리케이션을 deploy한다.


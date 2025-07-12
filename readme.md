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

- Jav a언어로 웹 어플리케이션을 만든다
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

###  스프링 웹 프로그래밍
-  가장 핵심이 되는 클래스
-  DispatcherServlet

### 서블릿에서 서블릿인스턴스를 생성하는것은?

- Tomcat 이라는 WAS가 인스턴스를 생성
- /hello 요청을 받으면, 해당 PATH를 처리하는 서블릿이 메모리에 있는지 검사를한다.
- 없다면 init()메서드를 실행해서 만든다.
- 있다면 hello.service(request,response);를 실행한다.
- service 메서드를 오버라이드 하지않으면 자신이가지고있는 this.doGet,doPost, httpMethod를 실행시킨다.
- 한마디로 서블릿은 톰캣이 관리해주는 객체다.


---

## Spring Framework 에서 Bean은?
- Spring Container 가 관리하는 객체(인스턴스)

---

## Spring으로 WebApplication을 만든다는것은

war파일 ---> Tomcat 서버로 배포해야한다

<pre> 
``` 
프로젝트 루트 
├── WEB-INF 
│ ├── classes
│ │ └── 개발자가 만든 package, class 들 
│ ├── lib 
│ │ └── spring 과 관련된 각종 jar 파일 
│ └── web.xml 
├── 각종 이미지, JSP 파일 등 
└── 기타 리소스 
``` 
</pre>

## 스프링 설정 파일을 작성한다.

- 스프링 컨테이너를 읽어드리는것은 ApplicationContext
```java
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig()");
    }
}

```
- web --> Java Config
    - Tomcat이 읽어들이는 Java Config에서 스프링 설정을 읽어들이도록 한다.
    - ApplicationContext 가 읽어들이도록 한다.
    - 스프링이 제공하는 WebApplicationInitializer 인터페이스를 구현한다.
    - onStartup() 를 오버라이딩하면, Tomcat이 실행되면서 자동으로 실행한다.
    - Tomcat이 실행될때 자동으로 읽어들이는 파일들은 스프링 jar파일에서 제공한다.
        - 자동으로 제공하는 클래스가 WebApplicationInitializer 를 
package star.springexam.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import star.springexam.exam.Book;

//java config 설정
@Configuration
public class ApplicationConfig {

    public ApplicationConfig(){
        System.out.println("ApplicationConfig()");
    }

    // xml 의 방식을 자바 개발자에게 어려움이많아
    // <bean id="book1" class"exam.Book"></bean>
    // 메소드 이름 : id
    @Bean
    public Book book1(){
        return new Book();
    }


    //setter 를 통하여 값을넣어주는것이 .xml 의 아래처럼하는것과 같은 결과를 보여준다.
    /*
    <bean id ="book2" class="exam.Book">
        <property name = "title" value="타이틀2"></property>
        <property name = "price" value="2000"></property>
    </beans>
     */
    @Bean
    public Book book2(){
        Book book = new Book();
        book.setTitle("타이틀2");
        book.setPrice(2000);
        return book;
    }
}

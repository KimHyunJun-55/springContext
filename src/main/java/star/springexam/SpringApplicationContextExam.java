package star.springexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import star.springexam.exam.Book;

public class SpringApplicationContextExam {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("star.springexam");
        Book book1 = context.getBean("book1", Book.class);
        book1.setTitle("타이틀");
        book1.setPrice(5000);


        System.out.println(book1.getTitle());
        System.out.println(book1.getPrice());

        System.out.println("------------------------");

        Book book2 = context.getBean("book1", Book.class);


        System.out.println(book2.getTitle());
        System.out.println(book2.getPrice());
    }
}

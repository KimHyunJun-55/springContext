package star.springexam.exam;

public class ApplicationContextMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new ApplicationContext();

        Book book1 = (Book)applicationContext.getBean("book1");
        book1.setTitle("타이틀");
        book1.setPrice(5000);
        System.out.println(book1.getTitle());
        System.out.println(book1.getPrice());

        System.out.println("=================================");



        Book book2 = (Book)applicationContext.getBean("book1");
        System.out.println(book2.getTitle());
        System.out.println(book2.getPrice());
    }
}

package org.example.uni.springdata;

import org.example.uni.springdata.entity.AuthorEntity;
import org.example.uni.springdata.repository.AuthorRepository;
import org.example.uni.springdata.service.AuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    private final AuthorService authors;

    public Application(AuthorService authors) {
        this.authors = authors;
    }

    public void run () {
        System.out.println("*************************************************");
        System.out.println("******************* Start ***********************");
        System.out.println("*************************************************");

        example1Read();
        example2Create();

        System.out.println("*************************************************");
        System.out.println("******************** End ************************");
        System.out.println("*************************************************");
    }

    private void example1Read() {
        System.out.println("******************** One ************************");
        System.out.println(authors.get(1));
        System.out.println("******************** List ***********************");
        authors.all().forEach(System.out::println);
        System.out.println("******************** Name ***********************");
        System.out.println(authors.find("Andersen Hans Christian"));
        System.out.println("**************** Name Matching ******************");
        authors.findByName("E").forEach(System.out::println);
        System.out.println("**************** Name Matching ******************");
        authors.findByBookName("Книга 1").forEach(System.out::println);
    }

    private void example2Create() {
        System.out.println("******************** Create ************************");
        AuthorEntity author = authors.create("Сергей Есенин", "Краткая информация по автору");
        System.out.println(author);
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        new Application(context.getBean(AuthorService.class)).run();
    }
}

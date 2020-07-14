package guru.springframework.spring5webapp.process;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunProcess implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public RunProcess(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Andy", "Chen");
        Book book = new Book("I'm the king of word", "1231234");
        Book book2 = new Book("Loss weight! This is good time!", "23424234");
        author.getBooks().add(book);
        author.getBooks().add(book2);
        book.getAuthors().add(author);
        book2.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);
        bookRepository.save(book2);

        long count = authorRepository.count();
        System.out.println("Author count: " + count);

        long count1 = bookRepository.count();
        System.out.println("Book count: " + count1);

        System.out.println("Author: " + author);
        System.out.println("Book: " + book);
        System.out.println("Book2: " + book2);


    }
}

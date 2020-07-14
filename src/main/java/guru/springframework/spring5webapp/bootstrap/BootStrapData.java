package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Author author1 = new Author("Bella", "Wu");
        author1.getBooks().add(book);
        book.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book);

        long count = authorRepository.count();
        System.out.println("Author count: " + count);

        long count1 = bookRepository.count();
        System.out.println("Book count: " + count1);

        System.out.println("Author: " + author);
        System.out.println("Book: " + book);
        System.out.println("Book2: " + book2);

        Publisher publisher = new Publisher("BigBooks", "NewTaipei No1", "NewTaipei", "Taiwan", "704" );
        publisher.getBooks().add(book);
        publisher.getBooks().add(book2);

        book.setPublisher(publisher);
        book2.setPublisher(publisher);

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count());

    }
}

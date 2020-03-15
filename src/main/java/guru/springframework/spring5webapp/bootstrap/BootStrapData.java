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

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Publishing One");
        publisher.setCity("City One");
        publisher.setState("STATE ONE");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author authorone = new Author("One", "One");
        Book bookone = new Book("Book One", "123123");
        authorone.getBooks().add(bookone);
        bookone.getAuthors().add(authorone);

        bookone.setPublisher(publisher);
        publisher.getBooks().add(bookone);

        authorRepository.save(authorone);
        bookRepository.save(bookone);
        publisherRepository.save(publisher);

        Author authortwo = new Author("Two", "Two");
        Book booktwo = new Book("Book Two", "312321");
        authortwo.getBooks().add(booktwo);
        booktwo.getAuthors().add(authortwo);

        booktwo.setPublisher(publisher);
        publisher.getBooks().add(booktwo);

        authorRepository.save(authortwo);
        bookRepository.save(booktwo);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }

}

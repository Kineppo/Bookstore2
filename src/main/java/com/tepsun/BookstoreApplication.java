package com.tepsun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tepsun.model.Book;
import com.tepsun.model.BookRepository;
import com.tepsun.model.User;
import com.tepsun.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, UserRepository urepository){
		return (args) ->{
			repository.save(new Book(1, "Harry Potter ja puoliverinen prinssi", "J.K. Rowling", 2006, "9789513135072", 20.90));
			repository.save(new Book(2, "Muumipappa ja meri", "Tove Jansson", 1965, "9789510405741", 8.40));
			
			User user1 = new User("user", "$2a$10$.Y9SiXv1Bt5OdXamgkChq.CeYXYoDzNU/hYF8dL4nMEyAM.6046fq", "user@mail.com" ,"USER");
			User user2 = new User("admin", "$2a$10$SqTP9.UilKHBjXs6pUztke8PRTNaaRmAdofROfF07iOCZf4jGNbDS", "admin@mail.com" ,"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}	
}

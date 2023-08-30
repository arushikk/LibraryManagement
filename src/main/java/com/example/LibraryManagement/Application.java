package com.example.LibraryManagement;

import com.example.LibraryManagement.Model.Author;
import com.example.LibraryManagement.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Autowired
	AuthorRepository authorRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("in run");
		List<Author> authorlist = authorRepository.findByAgeGreaterThanAndCountry(22, "India");
		//System.out.println(authorlist);

		authorlist.stream().map(author-> author.getBookList()).forEach(x->System.out.println(x.size()));

	}


}

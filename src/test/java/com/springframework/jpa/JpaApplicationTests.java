package com.springframework.jpa;

import com.springframework.jpa.repositories.BookRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository() {
		long count = bookRepository.count();

		AssertionsForClassTypes.assertThat(count).isGreaterThan(0);
	}
	@Test
	void contextLoads() {
	}

}

package com.springframework.jpa;

import com.springframework.jpa.domain.Book;
import com.springframework.jpa.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.AssertionsForClassTypes;

@DataJpaTest
public class SpringBootJpaSliceTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("My Book", "1235555", "Self"));

        long countAfter = bookRepository.count();

        AssertionsForClassTypes.assertThat(countBefore).isLessThan(countAfter);
    }
}

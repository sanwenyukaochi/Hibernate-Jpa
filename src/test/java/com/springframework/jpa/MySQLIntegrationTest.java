package com.springframework.jpa;

import com.springframework.jpa.repositories.BookRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.springframework.jpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        AssertionsForClassTypes.assertThat(countBefore).isEqualTo(2);

    }

}
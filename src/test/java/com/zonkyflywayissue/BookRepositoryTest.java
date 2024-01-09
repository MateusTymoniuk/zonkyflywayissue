package com.zonkyflywayissue;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest(
        properties = (
                "zonky.test.database.postgres.docker.image=postgres:13.8-alpine"
        )
)
@FlywayTest(locationsForMigrate = "testdata")
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldContainOneBook() {
        Book book = bookRepository.findById(1L).orElseThrow();
        Long expectedId = 1L;
        assertEquals(expectedId, book.getId());
    }
}
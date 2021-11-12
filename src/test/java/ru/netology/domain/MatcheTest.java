package ru.netology.domain;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatcheTest {
    Book grace = new Book(1, "java", 100, "grace");
    Smartphone apple = new Smartphone(2, "MIA2", 1000, "apple");


    @Test
    public void matcheTestName() {


        boolean actual = grace.matches("java");

        assertTrue(actual);
    }

    @Test
    public void matcheTestNameFalse() {


        boolean actual = grace.matches("arr");

        assertFalse(actual);
    }

    @Test
    public void matcheTestAuthor() {


        boolean actual = grace.matches("grace");

        assertTrue(actual);
    }

    @Test
    public void matcheTestAuthorFalse() {


        boolean actual = grace.matches("gracer");

        assertFalse(actual);
    }

    @Test
    public void matcheTestManufacturer() {


        boolean actual = apple.matches("apple");

        assertTrue(actual);
    }

    @Test
    public void matcheTestManufacturerFalse() {


        boolean actual = apple.matches("Samsung");

        assertFalse(actual);
    }

}

package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private ProductRepository repo = new ProductRepository();
    Manager man = new Manager(repo);
    Book grace = new Book(1, "java", 100, "grace");
    Smartphone apple = new Smartphone(2, "MIA2", 1000, "apple");
    Book gracer = new Book(3, "java", 100, "grace");
    Product radio = new Product();
    Book HP1 = new Book(4, "HP1", 100, "JR");
    Book HP2 = new Book(5, "HP2", 100, "JR");
    Smartphone samsung = new Smartphone(6, "smart", 1000, "samsung");
    Smartphone nokia = new Smartphone(7, "MI6", 1000, "apple");

    @BeforeEach
    public void setUp() {
        repo.save(grace);
        repo.save(apple);
        man.add(gracer);
        repo.save(radio);
        repo.save(HP1);
        repo.save(HP2);
        repo.save(samsung);
        repo.save(nokia);
    }


    @Test
    public void managerTestNameBook() {

        Product[] actual = man.searchBy("java");
        Product[] expected = {grace, gracer};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerTestAuthor() {

        Product[] actual = man.searchBy("JR");
        Product[] expected = {HP1, HP2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerTestNameSmartphone() {

        Product[] actual = man.searchBy("smart");
        Product[] expected = {samsung};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerTestManufacturerSmartphone() {

        Product[] actual = man.searchBy("apple");
        Product[] expected = {apple, nokia};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerTestNull() {

        Product[] actual = man.searchBy("nokia");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}


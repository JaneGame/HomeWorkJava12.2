package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

  private ProductRepository repo = new ProductRepository();
 // private Book Java = new Book();


  @Test
  public void ManagerTest(){
    Manager man = new Manager(repo);
    Book grace = new Book(1, "java", 100, "grace");
    Smartphone apple = new Smartphone(2, "java", 1000, "apple");
    Book gracer = new Book(3, "java", 100, "grace");
    Product radio = new Product();
    Book HP1 = new Book(4, "HP1", 100, "java");
    Book HP2 = new Book(5, "HP2", 100, "grace");
    Smartphone samsung = new Smartphone(6, "smart", 1000, "java");
    Smartphone nokia = new Smartphone(7, "MI6", 1000, "apple");


    repo.save(grace);
    repo.save(apple);
    man.add(gracer);
    repo.save(radio);
    repo.save(HP1);
    repo.save(HP2);
    repo.save(samsung);
    repo.save(nokia);

    apple.setManufacturer("samsung");
    gracer.setAuthor("JR");
    samsung.setPrice(500);

    repo.removeById(3);

    Product[] actual = man.searchBy("java");
    Product[] expected = {grace, apple, HP1, samsung};

    assertArrayEquals(expected, actual);
  }}


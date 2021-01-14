package day01;

import org.junit.jupiter.api.*;

public class BeforeAfterInJunit5 {


    @BeforeAll
    public static void setUp(){
        System.out.println("This run before All");
    }
    @BeforeEach
    public  void beforeEachTest(){
        System.out.println("This run before the test");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("This run all the way at the end");
    }
    @AfterEach
    public  void afterEachTest(){
        System.out.println("Running after each test");
    }
    @Test
    public void test1(){
        System.out.println("Test1 is running");
    }
    @Test
    public void test2(){
        System.out.println("Test2 is running");
    }
}

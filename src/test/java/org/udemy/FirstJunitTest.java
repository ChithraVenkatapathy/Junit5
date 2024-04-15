package org.udemy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*

 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstJunitTest {
    FirstJunit firstJunit;
    @BeforeAll
    static void beforeAll(){
        System.out.println("method signature must be static " +
                "executes only one time before method starts execute");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("method signature must be static, executes only one time after" +
                " all the method execution done");
    }
    @BeforeEach
     void setUp(){
        System.out.println("executes every time before method");
        firstJunit=new FirstJunit();
    }

    @AfterEach
    void tearDown(){
        System.out.println("executes after method done executing");
        firstJunit=null;
    }
    @Test
    @DisplayName("Adding Two Integer")
    @Order(1)
    void add(){
        //given
        int a=8, b=8;
        //when

        int sum=firstJunit.add(8,8);
       //then
        assertEquals(Integer.sum(a,b),sum);

    }
    @Test
    @DisplayName("Subtracting two integers")
    @Order(2)
    void subtract(){
        //given
        int a=9,b=4;
        //when

       int res= firstJunit.subtract(a,b);
        //then
        assertEquals(5,res);
    }

    @Test
    @Order(3)
    @DisplayName("dividing integer a with integer b")
    void divid(){
        //given
        int a=6, b=2;
        //when

        int ret=firstJunit.divid(a,b);
        //then
        Assertions.assertEquals(3,ret);
    }

    @Test
    @DisplayName("divided throws exception when a or b is zero")
    @Order(4)
    void dividthrowsexceptionwhenaorbiszero() throws ArithmeticException{
        //given
        int a=0,b=9;
        //when

        Executable executable=()->firstJunit.divid(a,b);

        Assertions.assertThrows(ArithmeticException.class,executable);
    }

    @Test
    @DisplayName("dividing with corect numbers")
    @Order(5)
    void dividedbynumbers() throws ArithmeticException{
        int a=6, b=2;

        //when & then
        int rez=firstJunit.divid(a,b);
        Assertions.assertEquals(3,rez);
    }

    @Test
    @DisplayName("second Number should be not zero ")
    @Order(8)
    void bShouldNotBeZero(){
        int a=4,b=5;
        Assertions.assertNotNull(firstJunit.divid(a,b));
    }

    @Test
            @Order(9)
            @DisplayName("what if b is zero")
    void whatIfBIsZero(){
        int a=6,b=0;
        Assertions.assertNull(firstJunit.divid(a,b));
    }

    @ParameterizedTest(name ="X={0},y={1}" )
    @CsvSource(value = {"2,7","6,3","3,6","4,5","5,4","7,2","1,8","8,1"})
    @Order(10)
    void parameterisedTest(int a,int b){
        Assertions.assertEquals(a+b,firstJunit.add(a,b));
    }
    @Order(11)
    @ParameterizedTest(name = "{0}")
    @DisplayName(value = "value source")
    @ValueSource(ints={2,4,5,8,10})
    void asd(int num){
    Assertions.assertTrue(()->firstJunit.evenOrOdd(num));
    }


    @Test
    @Order(6)
    @Disabled
    @DisplayName("AssertTrue testcase")
    void truebool(){

       Assertions.assertTrue(firstJunit.evenOrOdd(6));
     //  Assertions.assertTrue(firstJunit.evenOrOdd(7));
       Assertions.assertTrue(firstJunit.evenOrOdd(8));
    }

    @Test
    void failing(){
        fail("wrote method to failed",
                assertThrows(ArithmeticException.class,()->firstJunit.divid(0,5)));
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/record.csv",numLinesToSkip = 1)
    void addfromcsv(int x,int y){
        Assertions.assertEquals(x+y,firstJunit.add(x,y));
    }

    @Test
    @Order(7)
    @Disabled
    @DisplayName("AssertFalse testcase")
    void falsebool(){
        Assertions.assertFalse(firstJunit.evenOrOdd(7));
     //   Assertions.assertFalse(firstJunit.evenOrOdd(4));
        Assertions.assertFalse(firstJunit.evenOrOdd(5));
        Assertions.assertAll(()->Assertions.assertFalse(firstJunit.evenOrOdd(5)));
        Assertions.assertAll(()->Assertions.assertTrue(firstJunit.evenOrOdd(4)));
//        Assertions.assertAll(()->Assertions.assertFalse(firstJunit.evenOrOdd(8)));
    }
    @RepeatedTest(10)
    @DisplayName("generating random number")
    void generatingRandomNumber() throws InterruptedException {
        int limit=10;
        Assertions.assertTrue(firstJunit.generateRandomNumber(limit) < limit);
    }

    @Test
    void assertTimeOut(){
        Assertions.assertTimeout(Duration.ofMillis(600),()->firstJunit.generateRandomNumber(10));
    }

    @Test
    @DisplayName("Array equals")
    void assertArrayEquals(){
        int[] arr={1,2,3,4,5};
        Assertions.assertArrayEquals(new int[] {2,4,6,8,10},
                firstJunit.arraymultiple(arr));
    }

    @Test
    @DisplayName("Assert List Iteratable")
    void git status
    listIterable(){
        List<Integer> lter=new ArrayList<>(List.of(1,3,6,2,4));
        Assertions.assertIterableEquals(List.of(3,9,18,6,12),firstJunit.listIterate(lter));
    }
}

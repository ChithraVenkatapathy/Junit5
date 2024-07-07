package org.udemy.test;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.udemy.src.*;

import javax.sound.sampled.EnumControl;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.fail;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AssertionLearning {
    public static final String ENABLE_ENV="DEV";
    public static final String DISABLE_ENV="UAT";
    static int number=0;
    @BeforeEach
    void setUp(){
        ++number;
    }
    @AfterEach
    void tearDown(){
        System.out.println(number--);
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println(number);
    }
    @AfterAll
    static void afterAll(){
        System.out.println(number);
    }
    @Order(2)
    @Test
    @DisplayName("AssumeThat")
    public void workingWithAnnotation(){
        Assumptions.assumingThat(true,()-> BMICalculator.isDietRecommended(12,12));
    }

    @Test
    @DisplayName("AssertTimeout")
    void Should_execute_method_given_time(){
        for(int i=0;i<=1000;i++){
           Instant start= Instant.now();
           Thread th=new Thread("6");
           th.start();
           Instant end=Instant.now();
            Duration mili=Duration.between(start,end);
            System.out.println(mili.getSeconds());
        }
        Assertions.assertTimeout(Duration.ofMillis(1),()->ExceriseDetails.calculate(5,6));
    }

    @Test
    @DisplayName("assertionTimeoutPreemptively")
    void assertTimeoutPreemptively(){
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1),()->ExceriseDetails.calculate(5,6));
    }

    @Test
    @DisplayName("assertThrowsExactly")
    void assertThrowsExactly(){
        Assertions.assertThrowsExactly(ArithmeticException.class,()->ExceriseDetails.calculate(-1,0));
    }

    @Test
    @DisplayName("assertDoesNotThrowException")
    void assertDoesNotThrowException(){
        Assertions.assertDoesNotThrow(ExceriseDetails::writingMethodForAssertDoesNotThrown);
    }

    @Test
    @DisplayName("AssertThrows")
    void assertThrows(){
        Assertions.assertThrows(RuntimeException.class,()->ExceriseDetails.calculate(-1,0));
    }

    @Test
    @DisplayName("assertAll")
    void assertAll(){
        Coder code=new Coder(13,12,12,Gender.MALE);
        Coder code1=new Coder(13,12,12,Gender.MALE);
        Assertions.assertAll(()->
                Assertions.assertEquals(code.getHeight(),code1.getHeight()),
                ()->Assertions.assertEquals(code.getWeight(),code1.getWeight()),
                ()->Assertions.assertEquals(code.getAge(),code1.getAge()),
                ()->Assertions.assertEquals(code.getGender(),code1.getGender()));
    }



    @Order(1)
    @Test
    @DisplayName("AssertInstanceOf")
    public void workingWithOrder(){
        Assumptions.assumeTrue(true);
        Assertions.assertInstanceOf(BMICalculator.class,new BMICalculator(),"BMICalculator");
        Assertions.assertInstanceOf(Integer.class,23);
        Assertions.assertInstanceOf(Double.class,23.9);
        Assertions.assertInstanceOf(String.class,"sfsf");
        Assumptions.assumeFalse(true);
        Assertions.assertInstanceOf(Math.class,"sdf");
    }

    @Test
    @DisplayName("AssertArrayEquals")
    void WritingTestCaseToAssertArrayEquals(){
        int[] arr1=new int[]{1,2,3,3,4,5};
        int[] arr2={1,2,3,3,4,5};
      Assertions.assertArrayEquals(arr1,arr2);
      double[] darr=new double[]{12.5,6.7,7.8,66,89.0};
      double[] darr2={12.5,6.7,7.8,66,89};
      Assertions.assertArrayEquals(darr,darr2);
    }

    @Test
    @DisplayName("fail")
    @EnabledIf(AssertionLearning.ENABLE_ENV)
    void WritingTestCaseToFailWithDisable(){
        fail("implementing method to fail whatever is happened");
    }

    @Test
    @DisplayName("AssertIterableEquals")
     void assertIterableEquals(){
        List<Integer> AL= new ArrayList(List.of(12,13,14,15,16));
        List<Integer> LL=new LinkedList<>(List.of(12,13,14,15,16));
       LinkedHashSet<Integer> setLH= new LinkedHashSet<>(List.of(12,13,14,15,16));
       Assertions.assertIterableEquals(AL,LL);
       Assertions.assertIterableEquals(LL,AL);
       Assertions.assertIterableEquals(AL,setLH);
       Assertions.assertIterableEquals(LL,setLH);
    }



    @Nested
    @DisplayName("class one displayed second based on order")
    @Order(2)
    class one{
        @BeforeAll
        static void beforeAll(){
            System.out.println("beforeall in nested class");
        }
        @AfterAll
        static void afterAll(){
            System.out.println("afterall in nested class");
        }
        @BeforeEach
        void setUp(){
            System.out.println("before each in nested class");
        }
        @AfterEach
        void tearDown(){
            System.out.println("after each in nested class");
        }
        @Test
        @DisplayName("assertTrue")
        @Order(2)
        void assertTrue(){
            String name="rose";
            boolean test=name.equals("rose");
            Assertions.assertTrue(test);
        }

        @Test
        @DisplayName("assertFalse")
        @Order(1)
        void assertFalse(){
            Assertions.assertFalse(false,"assertion false");
        }

    }

    @RepeatedTest(7)
    @DisplayName(RepeatedTest.SHORT_DISPLAY_NAME)
    void repeatedTest(){
        Assertions.assertDoesNotThrow(()->ExceriseDetails.writingMethodForAssertDoesNotThrown());
    }

    @Test
    @DisplayName("assertLineMatches")
    void assertLineMatches(){
        List<String> l1=new LinkedList<>(List.of("asd","2","<<<"));
        List<String> ll1=new LinkedList<>(List.of("asd","2",">>>"));
        Assertions.assertLinesMatch(l1,ll1);
    }

    @Nested
    @DisplayName("Nested class 2")
   // @DisabledIf(DISABLE_ENV)
    @Order(1)
     class NestedTwo{
        @Test
        @DisplayName("AssertEquals")
        @Order(2)
        void assertEqual(){
            int a=1;
            double b=0.0;
            float c=2343243f;
            long d=3214431242423525L;
            String val="data";
            Assertions.assertEquals(1,a);
            Assertions.assertEquals(0.0,b);
            Assertions.assertEquals(2343243f,c);
            Assertions.assertEquals(3214431242423525L,d);
            Assertions.assertEquals("data",val);
        }

        @Test
        @DisplayName("AssertNotEquals")
        @Order(1)
        void AssertNotEquals(){
            byte b=123;
            short sh=2324;
            var name="name";
            Assertions.assertNotEquals(b,1234);
            Assertions.assertNotEquals(23,sh);
            Assertions.assertNotEquals("rose",name);
        }
        @Test
        @DisplayName("Assert Null and Non Null")
        void AssertNullAndNonNull(){
            String res=null;
            String nonNullValue="Ans";
            Assertions.assertNull(res);
            Assertions.assertNotNull(nonNullValue,"string is null");
        }

        @Test
        void AssertSameAndNotSame(){
            int a=5;
            double c=65.0;
            String name="name";
            Float num=23423424f;
            long numLong=2342232534l;
            Assertions.assertSame(a,5);
           // Assertions.assertSame(65.0,c);
            Assertions.assertSame(name,"name");
            String reName=new String("name");
            int anew =7;
            double cNew=65.0;
            Assertions.assertNotSame(anew,a);
            Assertions.assertNotSame(cNew,c);
            Assertions.assertNotSame(name,reName);

        }

    }


}
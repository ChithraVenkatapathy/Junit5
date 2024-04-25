package org.udemy.test;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.udemy.src.BMICalculator;
import org.udemy.src.Coder;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BMICalculatorTest {

    private String environment="prod";
    @BeforeAll
    public static void beforeAll(){
        System.out.println("executing before all the methods");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("will be executing after all the methods");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("will be executing each time before methods gets invoked");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("will be executed each time after method execution done");
    }

    @Nested
    class isdietrecommended {

        //@Test
        @ParameterizedTest(name = "weight {0}, height {1}")
        @ValueSource(doubles = {89.0, 88.6, 85.0, 84.4})
        public void should_returntrue_when_diet_isrecommended(double weightval) {
            //given
            double weight = weightval;
            double height = 1.76;
            //then
            boolean isDietRequired = BMICalculator.isDietRecommended(weight, height);
            //when
            Assertions.assertTrue(isDietRequired);
        }

        @Test
        public void should_throw_Exception_when_height_equals_Zero() throws ArithmeticException {
            //given
            double height = 0.0;
            double weight = 8.0;
            //then
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
            //when
            Assertions.assertThrows(Exception.class, executable);
        }

        @Test

        public void isDietRecommendedexceptioncovering() throws ArithmeticException {
            //given
            double height = 0.0;
            //when
            Executable exe = () -> BMICalculator.isDietRecommended(23.00, height);
            //then
            Assertions.assertThrows(ArithmeticException.class, exe);
        }

        //@Test
        @ParameterizedTest(name = "weight {0} and height {1}")
        @CsvFileSource(resources = "/dietplanrecommended.csv", numLinesToSkip = 1)
        public void isDietRecommendedCoveringLine13(double formalweight, double formalheight) {
            //given
            double height = formalheight;
            double weight = formalweight;
            //when
            boolean returnfalse = BMICalculator.isDietRecommended(height, weight);
            //then
            Assertions.assertFalse(returnfalse);
        }

        @Test
        @DisplayName("Assumptions.assumetrue")
        public void isDietRecommendedCoveringLine14() {
            Assumptions.assumeTrue(BMICalculatorTest.this.environment.equals("dev"));
            //given
            double height = 1.76;
            double weight = 89.0;
            //when
            boolean returntrue = BMICalculator.isDietRecommended(weight, height);
            //then
            Assertions.assertTrue(returntrue);
        }
    }

    @Nested
    class returncoderwithworstBMI{
        @Test
        public void shouldreturncoderwithworstBMI(){
            //given
            List<Coder> coder= new LinkedList<>();
            coder.add(new Coder(1.2,34));
            coder.add(new Coder(1.6,34.78));
            coder.add(new Coder(3.4,34.65));
            coder.add(new Coder(5.6,345.0));
            //when
            Coder code=BMICalculator.findCoderWithWorstBMI(coder);
            //then
            Assertions.assertAll(
                    ()->Assertions.assertEquals(1.2,code.getHeight()),
                    ()->Assertions.assertEquals(34.0,code.getWeight()));

        }

        @Test
        public void shouldreturnnullwhenthecodelistempty(){
            //given
            List<Coder> coders=new LinkedList<>();
            //when
            Coder code=BMICalculator.findCoderWithWorstBMI(coders);
            //then
            Assertions.assertNull(code);
        }

        @Test
        @DisplayName("Assertion timeout")
        public void timeoutassertions(){
            //given
            List<Coder> coder=new LinkedList<>();
            for (int i=0;i<=1000;i++){
                coder.add(new Coder(1.0+i,10+i));
            }
            //when
            Executable executable=()->BMICalculator.findCoderWithWorstBMI(coder);
            //then
            Assertions.assertTimeout(Duration.ofMillis(2),executable);
        }
    }

   @Nested
   class calculateBMI{
       //@Test
       @ParameterizedTest(name = "weight {1} ,height {0}")
       @CsvSource(value = {"1.5,26.0","1.6,26.5","1.4,24.6","1.8,29.6"})
       public void shouldcalulateBMI(double formalheight,double formalweight) {
           //given
           double height=formalheight;
           double weight=formalweight;
           Coder code=new Coder(height,weight);
           //when
           double BMI=BMICalculator.calculateBMI(code);
           //then

           Assertions.assertEquals(Math.round(weight / (height * height) * 100) / 100.0,BMI);
       }

       @Test
       public void shouldthrowexceptionwhenheightiszero() throws ArithmeticException{
           //given
           Coder code=new Coder(0.0,24.0);
           //when
           Executable executable=()->BMICalculator.calculateBMI(code);
           //then
           Assertions.assertThrows(ArithmeticException.class,executable);
       }
       @Test
       public void coveringshouldcalculateBMI() throws ArithmeticException{
           //given
           double height=0.0;
           double weight=23.0;
           Coder code=new Coder(height,weight);

           //when
//        if(height==0.0){
           Executable ex=()->BMICalculator.calculateBMI(code);
           Assertions.assertThrows(ArithmeticException.class,ex);
//        }else{
//            Assertions.assertEquals(val,BMICalculator.calculateBMI(code));
//        }
           //then

       }

   }

   @Nested
   class getBMIScores{
       @Test
       @DisplayName("Assumptions.assumeTrue")
       public void getBMIScores(){
           Assumptions.assumeTrue(BMICalculatorTest.this.environment.equals("prod"));
           //given
           List<Coder> coders=new LinkedList<>();
           coders.add(new Coder(1.2,23));
           coders.add(new Coder(1.4,29));
           coders.add(new Coder(1.3,26));
           coders.add(new Coder(1.5,28));

           //when
           double[] bmiscore=BMICalculator.getBMIScores(coders);

           //then
           Assertions.assertArrayEquals(new double[]{15.97,14.8,15.38,12.44},bmiscore);
       }
       @RepeatedTest(value = 5,name = RepeatedTest.SHORT_DISPLAY_NAME)
       public void repeatedTest() throws InterruptedException {
           int limit =10;
           int rNumber= BMICalculator.generateRandomNumbers(10);
           Assertions.assertTrue(rNumber<limit);
       }
   }








}

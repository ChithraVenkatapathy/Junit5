package org.udemy.src;

public class info {
    /*
	dependency in pom.xml is <org.junit.jupiter> artifact id is <junit-jupiter> ,
	scope is test and version 5.10.2

	Types of test
	1)@Test -> to test with empty parameter
	@Test
	public void testing(){ }
	2)@ParameterisedTest -> to test the method with parameterised value
	@ParameterisedTest
	public void parameterisedTest(int a ,int b){ }
	3)@RepeatedTest (value=5)-> method will be executed repeatedly 5 times
	4)@Nested -> by defining nested keyword inside it can add any number of test cases.
	-> by mean group of similar test will be added .
	5)DisplayName("") -> whatever given inside display name will be displayed as test name
	when the test is executed
	6)@Disabled -> when the test is written for particular time no need the test to run. but after
	sometimes we know definitely need the test. by giving @disabled test no longer executes
	7)@fail -> this will fail the test case-> there are some scenario when we definietly need
	to fail the test coverage
	8)Assumptions.AssumeTrue -> when the assume true is true then only lines written after
	the AssumeTrue will be executed.
	9)Assumptions.AssumeFalse -> when the assumeFalse is false then only lines written
	after the AssumeFalse will be executed
	10)Order(1) -> this will execute the test cases in order
	11) Assertions.AssertTrue(boolean expected) -> expected must return true so that test case will
	pass
	12) Assertions.AssertFalse(boolean expected) -> expected must be false sp the test case will
	pass
	13)Assertions.AssertEquals(Expected,actual) ->this works for int,double,long,short,string
	all kind of data types. expected and actual value must be same so that test case will
	pass
	14)Assertions.AssertArrayEqual(expected(new array{1,2,3}),actual(new array{1,2,3}))
	->to test all the values in array assert array equals is used
	15)Assertions.AssertIterateEquals(Expected (new List{1,2,3}),actual(List.of(1,2,3)))
	-> to check the values in the List AssertIterateEquals is used
	16)AssertAll() -> by using assert all we can use any number of assertions test inside
	by using () -> Assertions.AssertEquals(expected,actual);()->Assertions.AssertTrue(Boolean expression)
	this is how we can use the assertAll. The major advantage is if any test case failed the next
	following test case will be executed.
	usually without using assertAll() with multiple assertions written in a code if any assertions
	fail none of following will be executed
	17) @ValueSource(doubles={1.3,2.5,5.6})
	whatever data type we giving should give with 's'.
	ex : for int -> ints, double->doubles, string->strings
	public void data(double value){ }
	18)@CSVSource(value={"12.4,23.5","1.3,4.6","2.4,5.6","2.4,5.6"})
	public void data(double val1,double val2){ }-> CSV is Comma separated file
	19) @CSVFileSource(resources="file.csv",numOfLinesToSkip=1)
	public void data(int x,int y){ }
	->file must be inside test/resources
	@BeforeAll ->
	this method will execute only once before all the method invoking happened . this is class level
	@AfterAll -> this method will execute only once after all the methods execution
	done.

	@BeforeEach() -> this method will execute each and every time before method invoking about
	to happen
	public void setUp(){ }
	@AfterEach() -> this method will execute after each and every time method invoking
	done happening
	public void tearDown(){ }
	Assertions.AssertThrow(Exception.class,Executable object) ->
	Executable executable=()->className.methodName(val1);
	this is covering exception for throw new Exception class

	@TestMethodOrder(MethodOrderer.OrderAnnotation.class) -> this will order the methods
	that's available in class based on Order(1)
	@Assertion.AssertNull-> test checks for expected values must be null
	@Assertion.AssertNonNull -> test checks for the expected values must be non-null
	@Assertion.AssertTimeOut -> test checks performance duration of the method execution.
	Assertion.AssertTimeOut(Duration.ofMiliSeconds(1),Executable executable);
 */
}

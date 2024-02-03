package junitProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestInstance(Lifecycle.PER_CLASS)
class JavaProject1ApplicationTests {

	
	  // @AfterEach void afterEach() { System.out.println("After Each"); }
	 
	 // @BeforeEach void beforeEach() { System.out.println("Before Each"); }
	 
	
	@BeforeAll
	static void  beforeAll() {
		System.out.println("Before ALLLLLLLL");
	}
	
	@AfterAll
	 static void  afterAll() {
		System.out.println("After ALLLLLLLL");
	}
	
	
	//@Nested
	//class RegularTest {
	@Test
    @DisplayName("Custom test name containing spaces")
	@DisabledOnOs(value=OS.MAC, disabledReason = "Only solaris enabled")
	void context1Loads() {
		assertEquals(3, 3);
	}

	
	@Test
	@DisplayName("😱")
	@RepeatedTest(value=5, name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
	void contextLoads() {
		assertEquals(3, 3);
	}
	//}
	
	//@Nested
	//class ParameterizedTests {
	
	@Test
    @DisplayName("Value source")
	@ParameterizedTest
	@ValueSource(longs = {1,2,3,3,5})
	void context2Loads(long Number) {
		assertEquals(Number, 3);
		System.out.println("Hello welcomr to all");
	}
	
	@Test
    @DisplayName("Method source")
	@ParameterizedTest
	@MethodSource(value = "getValues")
	void context3Loads(String value) {
		assertEquals(value, "JP");
		System.out.println("This is method source");
	}
	
	private static List<String> getValues() {
		return Arrays.asList("Nithya","JP");
	}
	

	@Test
    @DisplayName("CSV source from internal file")
	@ParameterizedTest
	@CsvSource({"0123456789", "JP","JP"})
	void context4Loads(String value) {
		assertEquals(value, "JP");
		System.out.println("This is CSV internal source");
	}
	
	@Test
    @DisplayName("CSV source from external file")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv")
	void context5Loads(String value) {
		assertEquals(value, "JP");
		System.out.println("This is CSV external source");
	}

	//}
	
}

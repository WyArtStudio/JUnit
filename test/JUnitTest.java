import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JUnitTest {
    int taskDone = 0;
    private final JUnit jUnit = new JUnit();

    /*
    Denotes that the annotated method should be executed before all @Test, @RepeatedTest,
    @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4’s @BeforeClass.
    Such methods are inherited (unless they are hidden or overridden) and must be static
    (unless the "per-class" test instance lifecycle is used).
     */
    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Test ready to launch...");
    }

    /*
    Denotes that the annotated method should be executed before each @Test, @RepeatedTest, @ParameterizedTest,
    or @TestFactory method in the current class; analogous to JUnit 4’s @Before. Such methods are inherited
    unless they are overridden.
     */
    @BeforeEach
    void beforeTest() {
        int beforeTask = taskDone+1;
        System.out.println("\nLaunch Test " + beforeTask);
    }

    /*
    Denotes that a method is a test method. Unlike JUnit 4’s @Test annotation, this annotation does not
    declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated
    annotations. Such methods are inherited unless they are overridden.
     */
    @Test
    void sum() {
        int expected = 5;
        int actual = jUnit.sum(2, 3);
        assertEquals(expected, actual);
        assertTrue(expected != actual, "Value expected equals to value actual!");
    }

    @Test
    void minus() {
        int expected = 23;
        int actual = jUnit.minus(27, 3);
        assertNotEquals(expected, actual);
        assertFalse(expected == actual, "Value expected is not equals to value actual!");
    }

    @Test
    void multiply() {
        int expected = 40200;
        int actual = jUnit.multiply(201, 200);
        assertNotEquals(expected, actual);
        assertSame(expected, actual);
    }

    @Test
    void divide() {
        double expected = 0.5;
        double actual = jUnit.divide(2, 3);
        assertEquals(expected, actual);
        assertNull(actual, "Value actual is not null!");
    }

    /*
    Denotes that the annotated method should be executed after each @Test, @RepeatedTest, @ParameterizedTest,
    or @TestFactory method in the current class; analogous to JUnit 4’s @After. Such methods are inherited
    unless they are overridden.
     */
    @AfterEach
    void afterTest() {
        taskDone++;
        System.out.println("\nTest " + taskDone + " done.");
    }

    /*
    Denotes that the annotated method should be executed after all @Test, @RepeatedTest, @ParameterizedTest,
    and @TestFactory methods in the current class; analogous to JUnit 4’s @AfterClass. Such methods are
    inherited (unless they are hidden or overridden) and must be static (unless the "per-class" test
    instance lifecycle is used).
     */
    @AfterAll
    static void afterAllTest() {
        System.out.println("\nAll test scenario has been tested!");
    }
}
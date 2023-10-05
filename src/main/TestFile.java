
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestFile {

    public void testMethod1() {
        assertTrue(true);
        assertEquals(1, 1);
    }

    private void helperMethod() {
        // This is a helper method and doesn't contain assertions
        int x = 5;
        int y = 10;
        int sum = x + y;
    }

    public void testMethod2() {
        assertFalse(false);
        assertNotNull(new Object());
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    public static void someStaticMethod() {
        // Note: The tassert program should still catch this even though it's a static method
        assertNull(null);
    }

    public void multipleAssertionsInOneLine() {
        assertTrue(true); assertEquals(2, 2);  // Two assertions on one line
    }

    public void testMethod3() {
        assertNotSame(new Object(), new Object());
        assertThat(5, is(5));
    }

    public void exceptionTest() {
        assertThrows(RuntimeException.class, () -> { throw new RuntimeException(); });
    }
}
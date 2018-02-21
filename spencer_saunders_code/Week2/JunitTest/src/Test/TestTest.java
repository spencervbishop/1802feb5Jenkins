package Test;

import static org.junit.Assert.*;

public class TestTest {

    @org.junit.Test
    public void testConcatenate() {
        Test test = new Test();
        String result = test.concatenate("one", "two");
        assertEquals("onetwo", result);
    }

    @org.junit.Test
    public void testMultiply() {
        Test test = new Test();
        int result = test.multiply(-2,10);
        assertEquals(-20, result);
    }
}
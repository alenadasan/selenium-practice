package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {

    @Test
    public void testAddTwoNumbers() {
        int sum = 2 + 3;

        assertEquals(sum, 5);
        assertTrue(sum > 0);
    }
}

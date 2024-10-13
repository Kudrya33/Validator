package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string().required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("valid string"));
    }

    @Test
    void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(5);

        assertFalse(schema.isValid("1234"));
        assertTrue(schema.isValid("Hexlet"));
    }

    @Test
    void testContains() {
        Validator v = new Validator();
        StringSchema schema = v.string().contains("wh");

        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("fox say"));
    }

    @Test
    void testLastCalledMethodWins() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(10).minLength(4);

        assertTrue(schema.isValid("Hexlet"));
    }
}

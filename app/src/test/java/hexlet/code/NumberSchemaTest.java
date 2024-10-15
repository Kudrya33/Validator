package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    @Test
    void testRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number().required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }

    @Test
    void testPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number().positive();

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(10));
    }

    @Test
    void testRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number().range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void testLastCalledMethodWins() {
        Validator v = new Validator();
        NumberSchema schema = v.number().range(5, 10).range(11, 16);

        assertTrue(schema.isValid(13));
    }
}

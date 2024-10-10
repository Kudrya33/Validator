package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void soutPrintTest() {
        String expected = "Hello World!";
        var result = App.soutPrint();
        assertEquals(expected, result);
    }
}

package edu.csc214.dishstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {
    @Test
    void appMainRunsWithoutThrowingException() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}

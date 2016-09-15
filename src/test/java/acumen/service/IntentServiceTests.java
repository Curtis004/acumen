package acumen.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Parameterized.class)
@SpringBootTest
public class IntentServiceTests {
    private IntentService intentService;

    private String validCommandString;

    private String invalidCommandString;

    public IntentServiceTests(String validCommandString, String invalidCommandString) {
        this.validCommandString = validCommandString;
        this.invalidCommandString = invalidCommandString;
    }

    @Before
    public void setUp() {
        this.intentService = new IntentService();
    }

    @Test
    public void testDetermineIntentWithValidRooms() {
        intentService.determineIntent("living room", this.validCommandString);
    }

    @Parameterized.Parameters
    public static String[][] determineIntentProvider() {
        return new String[][] {
                {"a", "b"},
                {"c", "d"}
        };
    }
}

package acumen.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoiceCommandSyntaxExceptionTests {
    @Test
    public void testException() {
        try {
            throw new VoiceCommandSyntaxException("Test Message");
        } catch (VoiceCommandSyntaxException e) {
            assertThat(e.getMessage(), is("Test Message"));
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }
}

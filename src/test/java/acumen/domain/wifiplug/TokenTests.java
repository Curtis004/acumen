package acumen.domain.wifiplug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenTests {
    @Test
    public void testTokenDomainConstructors() {
        Token token = new Token("000");

        assertThat(token.toString(), is("000"));
    }
}

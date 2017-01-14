package acumen.domain.acumen;

import acumen.data.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateTests {
    @Test
    public void testStateDomainConstructors() {
        State state = new State(States.ON);

        assertThat(state.getName(), is("ON"));
    }

    @Test
    public void testToBooleanReturnsCorrectBoolean() {
        State onState = new State(States.ON);
        State offState = new State(States.OFF);

        assertThat(onState.toBoolean(), is(true));
        assertThat(offState.toBoolean(), is(false));
    }
}

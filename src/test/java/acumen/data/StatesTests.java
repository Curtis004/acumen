package acumen.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesTests {
    @Test
    public void testPossibleStatesNotNull() {
        assertThat(States.ON, is(notNullValue()));
        assertThat(States.OFF, is(notNullValue()));
    }

    @Test
    public void testGetRoomReturnsRoomsString() {
        assertThat(States.ON.getState(), is("on"));
        assertThat(States.OFF.getState(), is("off"));
    }

    @Test
    public void testInverseOfReturnsCorrectInvers() {
        assertThat(States.inverseOf(States.ON), is(States.OFF));
        assertThat(States.inverseOf(States.OFF), is(States.ON));

//        For when we have a state that doesn't have a corresponding inversion.
//        assertThat(States.inverseOf(States.WITHOUT_INVERSION), is(States.WITHOUT_INVERSION));
    }
}

package acumen.domain.acumen;

import acumen.data.Devices;
import acumen.data.Rooms;
import acumen.data.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntentTests {
    @Test
    public void testIntentDomainConstructors() {
        Room room = new Room(Rooms.LIVING_ROOM);
        Device device = new Device("000", Devices.LIGHTS);
        State state = new State(States.ON);

        Intent intent = new Intent(room, device, state);

        assertThat(intent.getRoom(), is(room));
        assertThat(intent.getDevice(), is(device));
        assertThat(intent.getState(), is(state));
    }
}

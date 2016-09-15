package acumen.domain.acumen;

import acumen.data.Rooms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTests {
    @Test
    public void testRoomDomainConstructors() {
        Room room = new Room(Rooms.LIVING_ROOM);

        assertThat(room.getName(), is("living room"));
    }
}

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
public class RoomsTests {
    @Test
    public void testPossibleRoomsNotNull() {
        assertThat(Rooms.BEDROOM, is(notNullValue()));
        assertThat(Rooms.KITCHEN, is(notNullValue()));
        assertThat(Rooms.LIVING_ROOM, is(notNullValue()));
    }

    @Test
    public void testGetRoomReturnsRoomsString() {
        assertThat(Rooms.BEDROOM.getRoom(), is("bedroom"));
        assertThat(Rooms.KITCHEN.getRoom(), is("kitchen"));
        assertThat(Rooms.LIVING_ROOM.getRoom(), is("living room"));
    }

    @Test
    public void testValueOfWithParsingReturnsCorrectFormat() {
        assertThat(Rooms.valueOfWithParsing("living room"), is(Rooms.LIVING_ROOM));
    }
}

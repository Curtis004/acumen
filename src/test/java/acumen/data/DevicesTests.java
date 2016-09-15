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
public class DevicesTests {
    @Test
    public void testPossibleDevicesNotNull() {
        assertThat(Devices.LAMP, is(notNullValue()));
        assertThat(Devices.LIGHTS, is(notNullValue()));
        assertThat(Devices.TV, is(notNullValue()));
    }

    @Test
    public void testGetDeviceReturnsDeviceString() {
        assertThat(Devices.LAMP.getDevice(), is("lamp"));
        assertThat(Devices.LIGHTS.getDevice(), is("lights"));
        assertThat(Devices.TV.getDevice(), is("TV"));
    }
}

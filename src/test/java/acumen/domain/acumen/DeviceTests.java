package acumen.domain.acumen;

import acumen.data.Devices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceTests {
    @Test
    public void testDeviceDomainConstructors() {
        Device device = new Device("000", Devices.LIGHTS);

        assertThat(device.getDeviceId(), is("000"));
        assertThat(device.getName(), is("lights"));
    }
}

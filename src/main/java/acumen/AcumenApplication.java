package acumen;

import acumen.data.Devices;
import acumen.data.Rooms;
import acumen.data.States;
import acumen.domain.acumen.Device;
import acumen.domain.acumen.Room;
import acumen.domain.acumen.State;
import acumen.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AcumenApplication extends SpringBootServletInitializer {
    @Autowired
    private Environment environment;

	@Autowired
	private StateService stateService;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

    public AcumenApplication(Environment environment) {
        this.environment = environment;
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AcumenApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AcumenApplication.class, args);
	}

	@PostConstruct
	public void loadDefaults() {
		Map<Device, State> livingRoomDefaults = new HashMap<>();
		livingRoomDefaults.put(
		        new Device(
		                environment.getProperty("wifiplug.mac.livingroom.lamp"),
                        Devices.LAMP
                ), new State(States.OFF)
        );
        livingRoomDefaults.put(
                new Device(
                        environment.getProperty("wifiplug.mac.livingroom.tv"),
                        Devices.TV
                ), new State(States.OFF)
        );

		Map<Device, State> bedRoomDefaults = new HashMap<>();
		bedRoomDefaults.put(
		        new Device(
                        environment.getProperty("wifiplug.mac.bedroom.lamp"),
                        Devices.LAMP
                ), new State(States.OFF)
        );

		stateService.createRoom(new Room(Rooms.LIVING_ROOM), livingRoomDefaults);
		stateService.createRoom(new Room(Rooms.BEDROOM), bedRoomDefaults);
	}
}

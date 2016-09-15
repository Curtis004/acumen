package acumen.state;

import acumen.data.Devices;
import acumen.data.Rooms;
import acumen.domain.acumen.Device;
import acumen.domain.acumen.Room;
import acumen.domain.acumen.State;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RoomDeviceState {
    private Map<Room, Map<Device, State>> applicationState = new HashMap<>();

    public void update(Room room, Device device, State state) {
        try {
            applicationState.get(room).replace(device, state);
        } catch (NullPointerException e) {
            throw new RuntimeException(
                    "You cannot change a device state with out it first being registered as a default. See StateService.loadDefaults()"
            );
        }
    }

    public void putRoom(Room room, Map<Device, State> deviceState) {
        applicationState.put(room, deviceState);
    }

    public Map.Entry<Room, Map<Device,State>> getApplicationStateRoom(Rooms room) {
        return applicationState.entrySet().stream().filter(
                roomMapEntry -> roomMapEntry.getKey().getName().equals(room.getRoom())
        ).findFirst().orElseThrow(
                () -> new RuntimeException("Room not initialised, check your defaults.")
        );
    }

    public Map.Entry<Device, State> getApplicationStateRoomDevice(Devices device, Room room) {
        return applicationState.get(room).entrySet().stream().filter(
                deviceStateEntry -> deviceStateEntry.getKey().getName().equals(device.getDevice())
        ).findFirst().orElseThrow(
                () -> new RuntimeException("Device not initialised, check your defaults.")
        );
    }

    public State getApplicationStateRoomDeviceState(Device device, Room room) {
        return applicationState.get(room).get(device);
    }
}

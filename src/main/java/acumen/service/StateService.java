package acumen.service;

import acumen.data.Devices;
import acumen.data.Rooms;
import acumen.domain.acumen.Device;
import acumen.domain.acumen.Intent;
import acumen.domain.acumen.Room;
import acumen.domain.acumen.State;
import acumen.state.RoomDeviceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StateService {
    @Autowired
    private RoomDeviceState roomDeviceState;

    public void update(Intent intent) {
        roomDeviceState.update(
                intent.getRoom(),
                intent.getDevice(),
                intent.getState()
        );
    }

    public void createRoom(Room room, Map<Device, State> deviceStates) {
        roomDeviceState.putRoom(room, deviceStates);
    }

    Room getRoom(Rooms room) {
        return roomDeviceState.getApplicationStateRoom(room).getKey();
    }

    Device getRoomDevice(Room room, Devices device) {
        return roomDeviceState.getApplicationStateRoomDevice(
                device, room
        ).getKey();
    }

    State getRoomDeviceState(Room room, Device device) {
        return roomDeviceState.getApplicationStateRoomDeviceState(
                device, room
        );
    }
}

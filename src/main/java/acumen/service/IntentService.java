package acumen.service;

import acumen.data.Devices;
import acumen.data.Rooms;
import acumen.data.States;
import acumen.domain.VoiceCommandSyntaxException;
import acumen.domain.acumen.Device;
import acumen.domain.acumen.Intent;
import acumen.domain.acumen.Room;
import acumen.domain.acumen.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class IntentService {
    @Autowired
    private StateService stateService;

    public Intent determineIntent(String defaultRoom, String said) {
        Room room = findRoomFromSaid(defaultRoom, said);
        Device device = findDeviceFromSaidAndRoom(said, room);
        State state = findDeviceStateFromSaidAndRoomAndDevice(said, room, device);

        return new Intent(room, device, state);
    }

    private Room findRoomFromSaid(String defaultRoom, String said) {
        try {
            return stateService.getRoom(
                Stream.of(Rooms.values()).filter(
                        rooms -> said.contains(rooms.getRoom())
                ).findFirst().orElseThrow(
                        () -> new VoiceCommandSyntaxException("Unable to find a registered room in what was said.")
                )
            );
        } catch(VoiceCommandSyntaxException e) {
            if (!defaultRoom.isEmpty()) {
                return stateService.getRoom(Rooms.valueOfWithParsing(defaultRoom));
            }

            throw e;
        }
    }

    private Device findDeviceFromSaidAndRoom(String said, Room room) {
        return stateService.getRoomDevice(
                room,
                Stream.of(Devices.values()).filter(
                        devices -> said.contains(devices.getDevice())
                ).findFirst().orElseThrow(
                        () -> new VoiceCommandSyntaxException("Unable to find that device in room.")
                )
        );
    }

    private State findDeviceStateFromSaidAndRoomAndDevice(String said, Room room, Device device) {
        try {
            return new State(
                    Stream.of(States.values()).filter(
                            states -> said.contains(states.getState())
                    ).findFirst().orElseThrow(
                            () -> new VoiceCommandSyntaxException("Unable to find a desired device state.")
                    )
            );
        } catch (VoiceCommandSyntaxException e) {
            return new State(
                    States.inverseOf(
                        States.valueOf(
                                stateService.getRoomDeviceState(room, device).getName()
                        )
                    )
            );
        }
    }
}

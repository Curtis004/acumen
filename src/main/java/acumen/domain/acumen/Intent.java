package acumen.domain.acumen;

public class Intent {
    private Room room;

    private Device device;

    private State state;

    public Intent(Room room, Device device, State state) {
        this.room = room;
        this.device = device;
        this.state = state;
    }

    public Room getRoom() {
        return room;
    }

    public Device getDevice() {
        return device;
    }

    public State getState() {
        return state;
    }
}

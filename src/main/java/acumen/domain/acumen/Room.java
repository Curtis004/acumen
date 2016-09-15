package acumen.domain.acumen;

import acumen.data.Rooms;

public class Room {
    private String name;

    public Room(Rooms rooms) {
        this.name = rooms.getRoom();
    }

    public String getName() {
        return name;
    }
}

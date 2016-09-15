package acumen.data;

public enum Rooms {
    LIVING_ROOM("living room"),
    KITCHEN("kitchen"),
    BEDROOM("bedroom");

    private String room;

    Rooms(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public static Rooms valueOfWithParsing(String room) {
        return valueOf(room.replace(" ", "_").toUpperCase());
    }
}

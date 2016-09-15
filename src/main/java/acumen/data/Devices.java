package acumen.data;

public enum Devices {
    LIGHTS("lights"),
    LAMP("lamp"),
    TV("TV");

    private String device;

    Devices(String device) {
        this.device = device;
    }

    public String getDevice() {
        return device;
    }
}

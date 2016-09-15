package acumen.domain.acumen;

import acumen.data.Devices;

public class Device {
    private String name;

    private String deviceId;

    public Device(String deviceId, Devices devices) {
        this.deviceId = deviceId;
        this.name = devices.getDevice();
    }

    public String getName() {
        return name;
    }

    public String getDeviceId() {
        return deviceId;
    }
}

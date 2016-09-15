package acumen.data;

public enum States {
    ON("on"),
    OFF("off");

    private String state;

    States(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public static States inverseOf(States state) {
        switch(state) {
            case OFF:
                return States.ON;
            case ON:
                return States.OFF;
            default:
                return state;
        }
    }
}

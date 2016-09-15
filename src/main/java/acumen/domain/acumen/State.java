package acumen.domain.acumen;

import acumen.data.States;

public class State {
    private String name;

    public State(States states) {
        this.name = states.getState();
    }

    public String getName() {
        return name;
    }

    public boolean toBoolean() {
        States desiredState = States.valueOf(name.toUpperCase());

        switch(desiredState) {
            case ON:
                return true;
            case OFF:
                return false;
            default:
                return false;
        }
    }
}

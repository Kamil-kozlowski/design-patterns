public class StateApp {
    public static void main(String[] args) {
        TV tv = new TV(); // turned off

        tv.nextChannel(); //error
        tv.previousChannel(); //error
        tv.turnOff(); // error

        tv.turnOn(); // turning on
        tv.previousChannel(); //error
        tv.nextChannel(); //changing channel - 2
        tv.nextChannel(); //changing channel - 3
        tv.nextChannel(); //changing channel - 4
        tv.turnOff(); // turning off
    }
}

class TV {
    State state;

    public TV() {
        this.state = new TurnedOffState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    void turnOn() {
        state.turnOn();
    }
    void turnOff() {
        state.turnOff();
    }
    void nextChannel() {
        state.nextChannel();
    }
    void previousChannel() {
        state.previousChannel();
    }
}

abstract class State {
    TV tv;

    public State(TV tv) {
        this.tv = tv;
    }

    abstract void turnOn();
    abstract void turnOff();
    abstract void nextChannel();
    abstract void previousChannel();
}

class TurnedOnState extends State {

    static int channel = 1;

    public TurnedOnState(TV tv) {
        super(tv);
    }

    @Override
    void turnOn() {
        System.out.println("Error - TV is turned on.");
    }

    @Override
    void turnOff() {
        System.out.println("Turning off.");
        tv.setState(new TurnedOffState(tv));
    }

    @Override
    void nextChannel() {
        System.out.println("Changing channel to: " + ++channel);
    }

    @Override
    void previousChannel() {
        if (channel > 1) {
            System.out.println("Changing channel to: " + --channel);
        } else {
            System.out.println("This is the first channel.");
        }
    }
}

class TurnedOffState extends State {

    public TurnedOffState(TV tv) {
        super(tv);
    }

    @Override
    void turnOn() {
        System.out.println("Turning on.");
        tv.setState(new TurnedOnState(tv));
    }

    @Override
    void turnOff() {
        System.out.println("Error - TV is turned off.");
    }

    @Override
    void nextChannel() {
        System.out.println("Error - TV is turned off.");
    }

    @Override
    void previousChannel() {
        System.out.println("Error - TV is turned off.");
    }
}
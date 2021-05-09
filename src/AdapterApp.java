public class AdapterApp {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        String stringHolderResult = new StringHolder("original string").prepareForReceiver();
        String numberHolderAdapterResult = new NumberHolderAdapter(new NumberHolder(2.5)).prepareForReceiver();
        receiver.receive(stringHolderResult);
        receiver.receive(numberHolderAdapterResult);
    }
}

// Receiver class that only accepts strings
class Receiver {
    void receive(String string) {
        System.out.println("Received: " + string);
    }
}

class StringHolder {
    private final String string;

    public StringHolder(String string) {
        this.string = string;
    }

    public String prepareForReceiver() {
        return string;
    }
}

class NumberHolder {
    private final Double number;

    public NumberHolder(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }
}

// Adapter for handling number type holder
class NumberHolderAdapter extends StringHolder {
    public NumberHolderAdapter(NumberHolder numberHolder) {
        super(String.valueOf(numberHolder.getNumber()));
    }
}

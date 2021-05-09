public class FacadeApp {
    public static void main(String[] args) {
        String result = new Facade().performOperations("3");
        System.out.println(result);
    }
}

// Facade expecting String and returning String, internally calling all subsystems
class Facade {
    String performOperations(String s) {
        double d = new StringToNumberConverter().convert(s);
        double d2 = new ByTwoMultiplier().multiplyByTwo(d);
        double d3 = new ByThreeDivider().divideByThree(d2);
        return new NumberToStringConverter().convert(d3);
    }
}

class StringToNumberConverter {
    double convert(String s) {
        System.out.println("StringToNumberConverter subsystem called");
        return Double.parseDouble(s);
    }
}

class NumberToStringConverter {
    String convert(double d) {
        System.out.println("NumberToStringConverter subsystem called");
        return String.valueOf(d);
    }
}

class ByTwoMultiplier {
    double multiplyByTwo(double d) {
        System.out.println("ByTwoMultiplier subsystem called");
        return d*2.0d;
    }
}

class ByThreeDivider {
    double divideByThree(double d) {
        System.out.println("ByThreeDivider subsystem called");
        return d/3.0d;
    }
}

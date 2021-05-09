public class AbstractFactoryApp {

    public static void main(String[] args) {
        new Game(new ModernFactory()).printGameDetails();
        new Game(new MedievalFactory()).printGameDetails();
    }
}

class Game {
    private final Factory factory;

    public Game(Factory factory) {
        this.factory = factory;
    }

    void printGameDetails() {
        this.factory.createRoad().printDetails();
        this.factory.createBuilding().printDetails();
    }
}

// Type interfaces
interface Building {
    void printDetails();
}

interface Road {
    void printDetails();
}

// Type implementations
class MedievalBuilding implements Building {

    @Override
    public void printDetails() {
        System.out.println("Medieval building");
    }
}

class MedievalRoad implements Road {

    @Override
    public void printDetails() {
        System.out.println("Medieval road");
    }
}

class ModernBuilding implements Building {

    @Override
    public void printDetails() {
        System.out.println("Modern building");
    }
}

class ModernRoad implements Road {

    @Override
    public void printDetails() {
        System.out.println("Modern road");
    }
}

// Factory
interface Factory {
    Building createBuilding();
    Road createRoad();
}

// Factory implementations
class MedievalFactory implements Factory {

    @Override
    public Building createBuilding() {
        return new MedievalBuilding();
    }

    @Override
    public Road createRoad() {
        return new MedievalRoad();
    }
}

class ModernFactory implements Factory {

    @Override
    public Building createBuilding() {
        return new ModernBuilding();
    }

    @Override
    public Road createRoad() {
        return new ModernRoad();
    }
}




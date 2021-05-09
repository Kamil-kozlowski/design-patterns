public class FactoryApp {

    public static void main(String[] args) {
        GameObject object1 = SuperGame.createObject(new SoldierCreator());
        GameObject object2 = SuperGame.createObject(new WorkerCreator());
    }
}

class SuperGame {
    static GameObject createObject(ObjectCreator creator) {
        return creator.create();
    }
}

// Game object interface
interface GameObject {
    void printDetails();
}

// Concrete game objects
class Soldier implements GameObject {
    @Override
    public void printDetails() {
        System.out.println("Soldier");
    }
}

class Worker implements GameObject {
    @Override
    public void printDetails() {
        System.out.println("Worker");
    }
}

// Factory
abstract class ObjectCreator {
    GameObject create() {
        System.out.println("Creating an object: ");
        GameObject object = getObject();
        object.printDetails();
        return object;
    }

    abstract GameObject getObject();
}

// Factory suppliers
class SoldierCreator extends ObjectCreator {

    @Override
    GameObject getObject() {
        return new Soldier();
    }
}

class WorkerCreator extends ObjectCreator {

    @Override
    GameObject getObject() {
        return new Worker();
    }
}



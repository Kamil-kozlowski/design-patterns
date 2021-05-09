public class PrototypeApp {
    public static void main(String[] args) {
        Human human = new Human(180d, 70d);
        Human humanClone = human.clone();
        System.out.println(humanClone);

        Animal animal = new Animal(100, 4);
        Animal animalClone = animal.clone();
        System.out.println(animalClone);
    }
}

interface Prototype<T> {
    T clone();
}

class Human implements Prototype<Human> {
    private final double height;
    private final double weight;

    public Human(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public Human clone() {
        return new Human(height, weight);
    }

    @Override
    public String toString() {
        return "Human{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class Animal implements Prototype<Animal> {
    private final double height;
    private final int numberOfLegs;

    public Animal(double height, int numberOfLegs) {
        this.height = height;
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public Animal clone() {
        return new Animal(height, numberOfLegs);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "height=" + height +
                ", numberOfLegs=" + numberOfLegs +
                '}';
    }

}
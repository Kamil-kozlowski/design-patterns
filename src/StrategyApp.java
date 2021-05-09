public class StrategyApp {
    public static void main(String[] args) {
        new Move().perform(new OffensiveStrategy());
        new Move().perform(new OffensiveStrategy());
        new Move().perform(new WaitingStrategy());
        new Move().perform(new DefensiveStrategy());
    }
}

class Move {
    public void perform(MoveStrategy strategy) {
        strategy.performOperation();
    }
}

interface MoveStrategy {
    void performOperation();
}

class OffensiveStrategy implements MoveStrategy {

    @Override
    public void performOperation() {
        System.out.println("Attack!");
    }
}

class DefensiveStrategy implements MoveStrategy {

    @Override
    public void performOperation() {
        System.out.println("Stay back!");
    }
}

class WaitingStrategy implements MoveStrategy {

    @Override
    public void performOperation() {
        System.out.println("Let's see what the enemy is going to do!");
    }
}


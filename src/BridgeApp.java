public class BridgeApp {
    public static void main(String[] args) {
        Unit navy = new Navy();
        Unit infantry = new Infantry();

        new PlayerMoveImpl(navy).moveDown();
        new PlayerMoveImpl(navy).moveLeft();
        new PlayerMoveImpl(navy).moveUp();
        new PlayerMoveImpl(navy).moveRight();

        new PlayerMoveImpl(infantry).moveUp();
        new PlayerMoveImpl(infantry).moveDown();
        new PlayerMoveImpl(infantry).moveLeft();
        new PlayerMoveImpl(infantry).moveRight();
    }
}

// PlayerMove ----bridge---- Unit

interface PlayerMove {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
}

class PlayerMoveImpl implements PlayerMove {
    private final Unit unit;

    public PlayerMoveImpl(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void moveUp() {
        unit.moveUp();
    }

    @Override
    public void moveDown() {
        unit.moveDown();
    }

    @Override
    public void moveLeft() {
        unit.moveLeft();
    }

    @Override
    public void moveRight() {
        unit.moveRight();
    }
}

interface Unit {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    void reportPosition();
}

class Navy implements Unit {
    private static final int UNIT_MOVE_RANGE = 1;

    private int x = 0;
    private int y = 0;

    @Override
    public void moveUp() {
        x = x + UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void moveDown() {
        x = x - UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void moveLeft() {
        y = y - UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void moveRight() {
        y = y + UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void reportPosition() {
        System.out.printf("Current position of unit %s is [%s, %s]%n", this.getClass().getName(), x, y);
    }
}

class Infantry implements Unit {
    private static final int UNIT_MOVE_RANGE = 2;

    private int x = 0;
    private int y = 0;

    @Override
    public void moveUp() {
        x = x + UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void moveDown() {
        System.out.println("Infantry cannot move down.");
        reportPosition();
    }

    @Override
    public void moveLeft() {
        y = y - UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void moveRight() {
        y = y + UNIT_MOVE_RANGE;
        reportPosition();
    }

    @Override
    public void reportPosition() {
        System.out.printf("Current position of unit %s is [%s, %s]%n", this.getClass().getName(), x, y);
    }
}

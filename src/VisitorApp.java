public class VisitorApp {
    public static void main(String[] args) {
        Museum museum = new Museum();
        Theatre theatre = new Theatre();
        Cinema cinema = new Cinema();

        Visitor visitor = new PeopleCounterVisitor();
        visitor.visitCinema(cinema);
        visitor.visitCinema(cinema);
        visitor.visitMuseum(museum);
        visitor.visitTheatre(theatre);
        visitor.visitTheatre(theatre);
        visitor.visitTheatre(theatre);
    }
}

interface Place {
    void accept(Visitor visitor);
}

class Museum implements Place {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMuseum(this);
    }
}

class Theatre implements Place {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTheatre(this);
    }
}

class Cinema implements Place {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCinema(this);
    }
}

interface Visitor {
    void visitMuseum(Museum museum);

    void visitTheatre(Theatre theatre);

    void visitCinema(Cinema cinema);
}

class PeopleCounterVisitor implements Visitor {

    private static int museumCounter = 0;
    private static int theatreCounter = 0;
    private static int cinemaCounter = 0;

    @Override
    public void visitMuseum(Museum museum) {
        System.out.println(++museumCounter + ". museum visit");
    }

    @Override
    public void visitTheatre(Theatre theatre) {
        System.out.println(++theatreCounter + ". theatre visit");
    }

    @Override
    public void visitCinema(Cinema cinema) {
        System.out.println(++cinemaCounter + ". cinema visit");
    }
}
package byog.Core;

public class Door {
    public Position hole;
    boolean isVert;

    public Door(Position p, boolean isVert) {
        hole = new Position(p);
        this.isVert = isVert;
    }
}
package byog.Core;

public class Position{
    public int xOffSet;
    public int yOffSet;
    public Position(int x, int y) {
        xOffSet = x;
        yOffSet = y;
    }

    public Position(Position p) {
        this(p.xOffSet, p.yOffSet);
    }
    public void setPosition(int x, int y) {
        xOffSet = x;
        yOffSet = y;
    }
}
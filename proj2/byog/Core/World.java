package byog.Core;

import byog.TileEngine.Tileset;
import byog.TileEngine.TETile;

import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.DelayQueue;

public class World{
    private int height;
    private int width;
    private TETile[][] tiles;
    private static final TETile wall = Tileset.WALL;
    private static final TETile door = Tileset.LOCKED_DOOR;
    private static final TETile uDoor = Tileset.UNLOCKED_DOOR;
    private static final TETile outside = Tileset.FLOOR;
    private static final TETile inside = Tileset.FLOWER;
    private Random random;
    private Deque<Door> doors = new ArrayDeque<>();
    public World(int w, int h, int seed) {
        height = h;
        width = w;
        tiles = new TETile[width][height];
        for (int x=0; x<width; x+=1) {
            for(int y=0; y<height; y+=1) {
                tiles[x][y] = outside;
            }
        }
        makeHorHallway(new Position(15, 4), 5);
        makeVertHallway(new Position(60, 4), 5);
        doors.addFirst(new Door(new Position(15, 6), false));
        makeRoom(new Position(8,3), 7, 7);
    }

    public TETile[][] getTETiles() {
        return tiles;
    }

    /** Make a horizontal pipe, given its width, height and position
    * Unit of measurement is the inside tile count not the wall tile count
    */
    public void makeHorPipe(Position p, int width, int height) {
        for(int w = 0; w<width; w+=1){
            tiles[p.xOffSet + w][p.yOffSet] = wall;
            tiles[p.xOffSet + w][p.yOffSet + height + 1] = wall;
        }
    }

    /**Make a vertical pipe, given its width, height, and position
     * Unit of measurement is the inside tile count not the wall tile count
     */
    public void makeVertPipe(Position p, int width, int height) {
        for(int h = 0; h<height; h+=1){
            tiles[p.xOffSet][p.yOffSet + h] = wall;
            tiles[p.xOffSet + width + 1][p.yOffSet + h] = wall;
        }
    }

    /** Make a horizontal hallway of height 1, given its width and position
    *Unit of measurement is the inside tile count not the wall tile count
    */
    public void makeHorHallway(Position pos, int width){
        makeHorPipe(pos, width, 1);
    }

    /**Make a  vertical hallway of width 1, given its height and position
    *Unit of measurement is the inside tile count not the wall tile count
    */
    public void makeVertHallway(Position pos, int height){
        makeVertPipe(pos, 1, height);
    }

    public void makeRoom(Position pos, int width, int height) {
        //makeVertPipe(pos, width, height);
        makeHorPipe(pos, width, height);
        for(int i=0; i<doors.size(); i+=1){
            Position hole = doors.get(i).hole;
            tiles[hole.xOffSet][hole.yOffSet] = outside;
            doors.removeFirst();
        }
    }


}
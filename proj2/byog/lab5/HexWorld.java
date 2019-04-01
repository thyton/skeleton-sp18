package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int GAP = 3;

    private static void addHexagon(TETile[][] world, int s, int xOffSet, int yOffSet, TETile tile){
        int maxOffSet = s - 1;
        addUpperHexagonPart(world, s, xOffSet, yOffSet, maxOffSet, tile);
        addLowerHexagonPart(world, s, xOffSet, yOffSet + s, maxOffSet, tile);
    }

    private static void addUpperHexagonPart(TETile[][] world, int s, int xOffSet, int yOffSet, int maxOffSet, TETile tile) {
        int addedFills = 0;
        for(int y = yOffSet; y < yOffSet + s; y+=1) {
            addLine(world, s + addedFills*2, xOffSet + maxOffSet, y, tile);
            --maxOffSet;
            ++addedFills;
        }
    }

    private static void addLowerHexagonPart(TETile[][] world, int s, int xOffSet, int yOffSet, int maxOffSet, TETile tile){
        int addedFills = 0;
        for(int y = yOffSet + s - 1; y >= yOffSet; y-=1) {
            addLine(world, s + addedFills*2, xOffSet + maxOffSet, y, tile);
            --maxOffSet;
            ++addedFills;
        }
    }

    private static void addLine(TETile[][] world, int size, int xOffSet, int yOffSet, TETile tile){
        for(int x = xOffSet; x < xOffSet + size; x += 1) {
            world[x][yOffSet] = tile;
        }
    }
    private static void addRowOfHexagons(TETile[][] world, int s, int xOffSet, int yOffSet, int count) {
        int maxOffSet = s - 1; // maximum of OffSet of the shortest row
                            // maxOffSet*2 + s is the longest row
        TETile[] set = {Tileset.WALL, Tileset.FLOWER, Tileset.GRASS, Tileset.WATER};
        Random rm = new Random();
        for(int cnt = 0; cnt < count; cnt+=1) {
            addHexagon(world, s ,xOffSet + cnt*(maxOffSet*2 + s*2), yOffSet, set[rm.nextInt(4)]);
        }
    }
    public static void main(String args[]){
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        int bottomXOffSet = 11;
        int bottomYOffSet = 1;
        int s = 3;
        addRowOfHexagons(world,3, bottomXOffSet, bottomYOffSet, 1);
        // 3 rows of 3 hexagons
        int startXOffSet = 1;
        int startYOffSet = bottomYOffSet + s*2;
        for(int cnt = 0; cnt < 3; cnt+=1){
            addRowOfHexagons(world, s, startXOffSet , startYOffSet + cnt*s*2, 3);
        }

        // 4 rows of 2 hexagons
        startXOffSet = 6;
        startYOffSet = s + 1;
        for(int cnt = 0; cnt < 4; cnt+=1){
            addRowOfHexagons(world, s, startXOffSet , startYOffSet + cnt*s*2, 2);
        }
        addRowOfHexagons(world, 3, bottomXOffSet, bottomYOffSet + 8*s, 1);

        ter.renderFrame(world);
    }
}

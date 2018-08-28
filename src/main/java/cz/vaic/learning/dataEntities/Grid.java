package cz.vaic.learning.dataEntities;

public class Grid {
    private final int[][] grid;

    public Grid(int[][] grid) {
        this.grid = grid;
    }

    public int getNumberFromGrid(int width,int height) {
        return grid[width][height];
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }
}

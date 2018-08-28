package cz.vaic.learning.helpers;

import cz.vaic.learning.dataEntities.Grid;

import java.util.ArrayList;

public class GridHelper {

    public static Grid parseGridBySpaces(String input) {
        String[] lines = input.split("\n");
        int[][] digits = new int[lines.length][];
        for (int i = 0; i <lines.length ; i++) {
            String digitLine[] = lines[i].split(" ");
            digits[i] = new int[digitLine.length];
            for(int j = 0; j< digitLine.length; j++) {
                digits[i][j] = Integer.parseInt(digitLine[j]);
            }
        }
        return new Grid(digits);
    }

    public static long findHighestMultipleInAllPossibleDirections(int row, int column, Grid grid, int length) {
        ArrayList<Long> multiples = new ArrayList<>();
        multiples.add(findMultipleInDirection(true,true,grid,row,column,length));
        multiples.add(findMultipleInDirection(true,false,grid,row,column,length));
        multiples.add(findMultipleInDirection(false,true,grid,row,column,length));
        multiples.add(findMultipleInDirection(false,false,grid,row,column,length));

        return StreamHelpers.findHighestNumberInList(multiples);
    }

    private static long findMultipleInDirection(boolean down, boolean right, Grid grid, int row, int column, int length) {
        ArrayList<Integer> digits = new ArrayList<>();
        if(down && right) {
            if(row <= grid.getHeight() - length && column <= grid.getWidth() - length) {
                for (int i = 0; i < length; i++) {
                    digits.add(grid.getNumberFromGrid(row+i,column+i));
                }
            }
        } else if(right) {
            if(column <= grid.getWidth() - length) {
                for (int i = 0; i < length; i++) {
                    digits.add(grid.getNumberFromGrid(row,column+i));
                }
            }
        }else if(down) {
            if(row <= grid.getHeight() - length) {
                for (int i = 0; i < length; i++) {
                    digits.add(grid.getNumberFromGrid(row+i,column));
                }
            }
        } else {
            if(row <= grid.getHeight() - length && column > length) {
                for (int i = 0; i < length; i++) {
                    digits.add(grid.getNumberFromGrid(row+i,column-i));
                }
            }
        }
        return digits.stream().reduce(1,(a,b) -> a*b);
    }


}

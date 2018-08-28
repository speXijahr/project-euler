package cz.vaic.learning.solvers;

import cz.vaic.learning.IO.FileHelper;
import cz.vaic.learning.dataEntities.Grid;
import cz.vaic.learning.helpers.GridHelper;
import cz.vaic.learning.helpers.StreamHelpers;

import java.util.ArrayList;

public class Problems11to20 {



    public static long problem11() {
        ArrayList<Long> highestMultiplesForTiles = new ArrayList<>();

        String filePath = "src/main/resources/problem11input.txt";
        String input = FileHelper.readFileAsString(filePath);
        Grid grid  = GridHelper.parseGridBySpaces(input);
        for (int i = 0; i < grid.getHeight();i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                highestMultiplesForTiles.add(GridHelper.findHighestMultipleInAllPossibleDirections(i,j,grid,4));
            }
        }

        return StreamHelpers.findHighestNumberInList(highestMultiplesForTiles);
    }




}



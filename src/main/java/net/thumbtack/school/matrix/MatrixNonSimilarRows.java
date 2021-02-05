package net.thumbtack.school.matrix;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixNonSimilarRows {
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix){
        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows(){
        List<int[]> nonSimilarRows = new ArrayList<>();
        Map<Set<Integer>,int[]> nonSimilarSetRowsMap = new HashMap<>();
        for (int[] row : matrix){
            Set<Integer> setRow = IntStream.of(row).boxed().collect(Collectors.toSet());
            nonSimilarSetRowsMap.put(setRow,row);
        }
        nonSimilarRows.addAll(nonSimilarSetRowsMap.values());
        return nonSimilarRows;
    }
}

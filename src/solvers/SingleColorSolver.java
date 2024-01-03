package solvers;

import components.Board;
import components.CellSequence;
import components.CellType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SingleColorSolver {

    public static boolean solve(final List<List<Integer>> rows, final List<List<Integer>> cols, final int width) {
        List<List<List<CellType>>> rowsCombinations = findlinesCombos(rows, width);
        printResult(rowsCombinations);
        return false;
    }

    private static List<List<List<CellType>>> findlinesCombos(final List<List<Integer>> rows, final int width) {
        List<List<List<CellType>>> rowsCombos = new ArrayList<>();
        GenericLineSolver<CellSequence> lineSolver = new GenericLineSolver<>();
        for (List<Integer> row : rows) {
            CellSequence[] blacks = row.stream().map(length -> new CellSequence(length, CellType.BLACK)).toArray(CellSequence[] :: new);
            CellSequence[] whites = Arrays.stream(new CellSequence[width - row.stream().mapToInt(a -> a).sum()])
                    .map(cellSequence -> new CellSequence(1, CellType.WHITE))
                    .toArray(CellSequence[]::new);
            rowsCombos.add(SingleCellLineSplitter.isolateCells(lineSolver.allCombinations(blacks, whites)));
        }
        return rowsCombos;
    }

    private static void printResult(final List<List<List<CellType>>> rowsCombinations) {
        for (int i = 0 ; i < rowsCombinations.size() ; ++i) {
            System.out.println("Line " + i + " combinations:");
            for (List<CellType> combo : rowsCombinations.get(i)) {
                System.out.println(combo);
            }
        }
    }
}

package solvers;

import components.CellSequence;
import components.CellType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SingleColorSolver {

    public static void solve(final List<List<Integer>> rows, final List<List<Integer>> cols, final int width) {
        List<List<List<CellType>>> rowsCombinations = findlinesCombos(rows, width);
        printResult(rowsCombinations);
    }

    private static List<List<List<CellType>>> findlinesCombos(final List<List<Integer>> rows, final int width) {
        List<List<List<CellType>>> rowsCombos = new ArrayList<>();
        GenericLineSolver<CellSequence> lineSolver = new GenericLineSolver<>();
        for (List<Integer> row : rows) {
            CellSequence[] blacks = row.stream().map(length -> new CellSequence(length, CellType.BLACK)).toArray(CellSequence[] :: new);
            CellSequence[] whites = Arrays.stream(new CellSequence[width - row.stream().mapToInt(a -> a).sum()])
                    .map(cellSequence -> new CellSequence(1, CellType.WHITE))
                    .toArray(CellSequence[]::new);
            rowsCombos.add(isolateCells(lineSolver.allCombinations(blacks, whites)));
        }
        return rowsCombos;
    }

    private static List<List<CellType>> isolateCells(final List<List<CellSequence>> combinations) {
        filterSameColorFollowings(combinations);
        final List<List<CellType>> isolatedCellCombinations = new ArrayList<>(combinations.size());
        for (List<CellSequence> combination : combinations) {
            List<CellType> currentCombination = new ArrayList<>(combination.size());
            for (CellSequence cells : combination) {
                for (int i = 0 ; i < cells.length() ; ++i) {
                    currentCombination.add(cells.color());
                }
            }
            isolatedCellCombinations.add(currentCombination);
        }
        return isolatedCellCombinations;
    }

    private static void filterSameColorFollowings(final List<List<CellSequence>> combinations) {
        Iterator<List<CellSequence>> iterator = combinations.iterator();
        while (iterator.hasNext()) {
            final List<CellSequence> combination = iterator.next();
            if (combination.size() > 1) {
                for (int i = 1 ; i < combination.size() ; ++i) {
                    if (combination.get(i - 1).color().equals(CellType.BLACK) && combination.get(i).color().equals(CellType.BLACK)) {
                        iterator.remove();
                        break;
                    }
                }
            }
        }
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
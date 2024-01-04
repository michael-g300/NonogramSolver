package solvers;

import components.CellSequence;
import components.CellType;

import java.util.*;

public class SingleColorSolver {

    public static void solve(final List<List<Integer>> rows, final List<List<Integer>> cols, final int width, final int height) {
        List<List<List<CellType>>> rowsCombinations = findlinesCombos(rows, width);
        List<List<CellType>> finalCombo = findCorrectCombo(rowsCombinations, cols, width, height);
        printResult(finalCombo);
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

    private static List<List<CellType>> findCorrectCombo(final List<List<List<CellType>>> rowsCombinations, final List<List<Integer>> cols,
                                                         final int width, final int height) {
        List<List<CellType>> finalCombo = new ArrayList<>(rowsCombinations.size());
        List<ListIterator<List<CellType>>> rowCombosIterators = new ArrayList<>(rowsCombinations.size());
        for (List<List<CellType>> rowsCombination : rowsCombinations) {
            rowCombosIterators.add(rowsCombination.listIterator());
        }
        ListIterator<List<List<CellType>>> rowsIterator = rowsCombinations.listIterator();
        ColumnSolver columnConfirm = new ColumnSolver();
        while (rowsIterator.hasNext()) {
            final int currentRowNum = rowsIterator.nextIndex();
            System.out.println("Checking row number " + currentRowNum);
            if (!rowCombosIterators.get(currentRowNum).hasNext()) {
                System.out.println("No more combinations, going back again");
                rowCombosIterators.set(currentRowNum, rowsCombinations.get(currentRowNum).listIterator());
                if (finalCombo.isEmpty()) {
                    break;
                }
                finalCombo.remove(finalCombo.size() - 1);
                if (!rowsIterator.hasPrevious()) {
                    break;
                }
                rowsIterator.previous();
                continue;
            }
            while (rowCombosIterators.get(currentRowNum).hasNext()) {
                //System.out.println("Checking combination number " + rowCombosIterators.get(currentRowNum).nextIndex());
                finalCombo.add(rowCombosIterators.get(currentRowNum).next());
                if (columnConfirm.confirmCombinations(finalCombo, cols, width, height)) {
                    rowsIterator.next();
                    break;
                }
                else {
                    finalCombo.remove(finalCombo.size() - 1);
                }
            }
        }
        return finalCombo;
    }

    private static void printResult(final List<List<CellType>> rowsCombinations) {
        if (rowsCombinations.isEmpty()) {
            System.out.println("No solution :(");
            return;
        }
        for (List<CellType> rowsCombination : rowsCombinations) {
            StringBuilder builder = new StringBuilder();
            for (CellType cellType : rowsCombination) {
                builder.append(cellType.equals(CellType.BLACK) ? " X " : " - ");
            }
            System.out.println(builder);
        }
    }
}
package solvers;

import components.CellSequence;
import components.CellType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleCellLineSplitter {
    public static List<List<CellType>> isolateCells(final List<List<CellSequence>> combinations) {
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
}

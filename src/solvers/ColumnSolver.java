package solvers;

import components.CellType;

import java.util.ArrayList;
import java.util.List;

public class ColumnSolver {
    public boolean confirmCombinations(final List<List<CellType>> rows, final List<List<Integer>> cols, final int width, final int height) {
        for (int i = 0 ; i < width ; ++i) {
            final List<Integer> currentCol = new ArrayList<>(cols.get(i).size());
            currentCol.addAll(cols.get(i));
            int currentSequence = 0;
            for (int j = 0 ; j < rows.size() ; ++j) {
                if (rows.get(j).get(i).equals(CellType.BLACK)) {
                    ++currentSequence;
                }
                else {
                    if (currentSequence > 0) {
                        if (!currentCol.isEmpty() && currentCol.get(0).compareTo(currentSequence) == 0) {
                            currentSequence = 0;
                            currentCol.remove(0);
                        }
                        else {
                            return false;
                        }
                    }
                }
                if (j == height - 1) {
                    if (!confirmEnd(currentSequence, currentCol)) {
                        return false;
                    }
                }
            }
//            if(!checkRemainingVacancy(currentSequence, height - rows.size(), currentCol)) {
//                return false;
//            }
        }
        return true;
    }

    private boolean confirmEnd(final int currentSequence, final List<Integer> currentCol) {
        if (currentCol.size() > 1) {
            return false;
        }
        if (currentCol.isEmpty()) {
            return currentSequence == 0;
        }
        return currentCol.get(0) == currentSequence;
    }

    private boolean checkRemainingVacancy(final int currentSequence, final int remainingHeight, final List<Integer> remainingCol) {
        if (currentSequence > 0) {
            if (remainingCol.isEmpty()) {
                return false;
            }
            remainingCol.set(0, remainingCol.get(0) - currentSequence);
        }
        int remainingSequences = 0;
        for (int sequence : remainingCol) {
            remainingSequences += sequence;
            ++remainingSequences;
        }
        return (remainingSequences - 1) <= remainingHeight;
    }
}

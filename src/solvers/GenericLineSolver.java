package solvers;

import java.util.ArrayList;
import java.util.List;

public class GenericLineSolver<T> {
    public List<List<T>> allCombinations(final T[] blacks, final T[] whites) {
        List<List<T>> result = new ArrayList<>();
        List<T> currentCombination = new ArrayList<>();
        generateCombinations(blacks, whites, 0, 0, currentCombination, result);
        return result;
    }

    private void generateCombinations(final T[] blacks, final T[] whites, int index1, int index2,
                                             final List<T> currentCombination, final List<List<T>> result) {

        if (index1 == blacks.length && index2 == whites.length) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (index1 < blacks.length) {
            currentCombination.add(blacks[index1]);
            generateCombinations(blacks, whites, index1 + 1, index2, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }

        if (index2 < whites.length) {
            currentCombination.add(whites[index2]);
            generateCombinations(blacks, whites, index1, index2 + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

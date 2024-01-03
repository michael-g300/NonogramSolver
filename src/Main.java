import components.CellSequence;
import components.CellType;
import solvers.GenericLineSolver;
import solvers.SingleCellLineSplitter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CellSequence[] array1 = {new CellSequence(1, CellType.BLACK), new CellSequence(2, CellType.BLACK), new CellSequence(3, CellType.BLACK)};
        CellSequence[] array2 = {new CellSequence(4, CellType.WHITE), new CellSequence(5, CellType.WHITE), new CellSequence(1, CellType.WHITE)};

        GenericLineSolver<CellSequence> integerLineSolver = new GenericLineSolver<>();
        List<List<CellSequence>> combinations = integerLineSolver.allCombinations(array1, array2);
        List<List<CellType>> isolatedCellCombinations = SingleCellLineSplitter.isolateCells(combinations);

        System.out.println("Combinations:");
        for (List<CellType> combination : isolatedCellCombinations) {
            System.out.println(combination);
        }
    }
}
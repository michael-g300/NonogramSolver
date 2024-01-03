import components.CellSequence;
import components.CellType;
import solvers.GenericLineSolver;
import solvers.SingleCellLineSplitter;
import solvers.SingleColorSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> row2 = Arrays.asList(1, 3, 6);
        List<Integer> row3 = Arrays.asList(2, 3, 1);
        List<Integer> row4 = Arrays.asList(7);

        SingleColorSolver.solve(Arrays.asList(row1, row2, row3, row4), new ArrayList<List<Integer>>(), 13);

//        CellSequence[] array1 = {new CellSequence(1, CellType.BLACK), new CellSequence(2, CellType.BLACK), new CellSequence(3, CellType.BLACK)};
//        CellSequence[] array2 = {new CellSequence(4, CellType.WHITE), new CellSequence(5, CellType.WHITE), new CellSequence(1, CellType.WHITE)};
//
//        GenericLineSolver<CellSequence> integerLineSolver = new GenericLineSolver<>();
//        List<List<CellSequence>> combinations = integerLineSolver.allCombinations(array1, array2);
//        List<List<CellType>> isolatedCellCombinations = SingleCellLineSplitter.isolateCells(combinations);
//
//        System.out.println("Combinations:");
//        for (List<CellType> combination : isolatedCellCombinations) {
//            System.out.println(combination);
//        }
    }
}
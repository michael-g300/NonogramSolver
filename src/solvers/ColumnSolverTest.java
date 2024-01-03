package solvers;

import components.CellType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColumnSolverTest {

    @Test
    void confirmCombinations() {
        List<CellType> row1 = Arrays.asList(CellType.WHITE, CellType.BLACK, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.BLACK,
                CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE,
                CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE,
                CellType.BLACK, CellType.WHITE);
        List<CellType> row2 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.WHITE,
                CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE,
                CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.WHITE,  CellType.WHITE,
                CellType.BLACK, CellType.WHITE, CellType.BLACK);

        List<Integer> col1 = List.of(12);
        List<Integer> col2 = List.of(0);
        List<Integer> col3 = Arrays.asList(2, 3, 2, 1);
        List<Integer> col4 = Arrays.asList(4, 5, 2);
        List<Integer> col5 = Arrays.asList(1, 1, 2, 2);
        List<Integer> col6 = Arrays.asList(2, 1, 2, 1);
        List<Integer> col7 = Arrays.asList(4, 1, 2, 2, 2);
        List<Integer> col8 = Arrays.asList(1, 3, 2, 1);
        List<Integer> col9 = Arrays.asList(5, 2, 1);
        List<Integer> col10 = Arrays.asList(3, 1, 2);
        List<Integer> col11 = Arrays.asList(4, 3);
        List<Integer> col12 = Arrays.asList(2, 1);
        List<Integer> col13 = Arrays.asList(1, 2, 2);
        List<Integer> col14 = Arrays.asList(1, 1, 2, 2);
        List<Integer> col15 = Arrays.asList(1, 3, 2, 1);
        List<Integer> col16 = Arrays.asList(2, 1, 3, 5);
        List<Integer> col17 = Arrays.asList(1, 7, 1);
        List<Integer> col18 = Arrays.asList(1, 2, 1, 5, 2);
        List<Integer> col19 = Arrays.asList(1, 1, 11, 1);
        List<Integer> col20 = Arrays.asList(1, 11);

        List<List<Integer>> cols = Arrays.asList(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20);
        List<List<CellType>> rows = Arrays.asList(row1, row2);

        ColumnSolver solver = new ColumnSolver();
        assertFalse(solver.confirmCombinations(rows, cols, 20, 20));
    }
}
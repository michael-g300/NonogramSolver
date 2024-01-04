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
        List<CellType> row1 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE);
        List<CellType> row2 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.WHITE);
        List<CellType> row3 = Arrays.asList(CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.WHITE);
        List<CellType> row4 = Arrays.asList(CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.WHITE);
        List<CellType> row5 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE, CellType.WHITE);
        List<CellType> row6 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE);
        List<CellType> row7 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.BLACK, CellType.WHITE, CellType.WHITE);
        List<CellType> row8 = Arrays.asList(CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.WHITE, CellType.WHITE, CellType.BLACK, CellType.WHITE, CellType.WHITE);

        List<Integer> col1 = List.of(0);
        List<Integer> col2 = List.of(2);
        List<Integer> col3 = List.of(2, 3);
        List<Integer> col4 = List.of(3);
        List<Integer> col5 = List.of(3);
        List<Integer> col6 = List.of(2, 3);
        List<Integer> col7 = List.of(2);
        List<Integer> col8 = List.of(0);

        List<List<Integer>> cols = Arrays.asList(col1, col2, col3, col4, col5, col6, col7, col8);
        List<List<CellType>> rows = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8);

        ColumnSolver solver = new ColumnSolver();
        assertTrue(solver.confirmCombinations(rows, cols, 8, 8));
    }
}
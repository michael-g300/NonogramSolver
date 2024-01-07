package solvers;

import components.Board;
import components.CellType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedSCLTest {

    @Test
    void solve() {
        final AdvancedSCL solver = new AdvancedSCL(List.of(List.of(2, 2, 3)), List.of(List.of(0),List.of(0),List.of(0),List.of(0),List.of(0),List.of(0),List.of(0),List.of(0),List.of(0),List.of(0)));
        solver.solve();
        final Board solvedBoard = solver.getBoard();

        assertEquals(solvedBoard.getCell(0, 1), CellType.BLACK);
        assertEquals(solvedBoard.getCell(0, 4), CellType.BLACK);
        assertEquals(solvedBoard.getCell(0, 7), CellType.BLACK);
        assertEquals(solvedBoard.getCell(0, 8), CellType.BLACK);
        assertNull(solvedBoard.getCell(0, 2));

        assertEquals(solver.getWaitingList(), List.of(2,5,8,9));
    }
}
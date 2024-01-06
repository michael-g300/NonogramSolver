package solvers;

import components.Board;
import components.CellType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedSCLTest {

    @Test
    void solve() {
        final AdvancedSCL solver = new AdvancedSCL(List.of(List.of(1, 2, 3)), List.of(List.of(1),List.of(1),List.of(1),List.of(1),List.of(1),List.of(1),List.of(1),List.of(1),List.of(1),List.of(1)));
        solver.solve();
        final Board solvedBoard = solver.getBoard();
        assertEquals(solvedBoard.getCell(0, 7), CellType.BLACK);
        assertEquals(solvedBoard.getCell(0, 6), null);
    }
}
package solvers;

import components.Board;
import components.CellType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AdvancedSCL {
    private final Board m_board;
    private final List<List<Integer>> m_rows;
    private final List<List<Integer>> m_cols;
    private final List<Integer> m_linesQueue;

    public AdvancedSCL(final List<List<Integer>> rows, final List<List<Integer>> cols) {
        m_board = new Board(rows.size(), cols.size());
        m_rows = rows;
        m_cols = cols;
        m_linesQueue = new LinkedList<>();
    }

    public void solve() {
        checkForOverlap();
    }

    public Board getBoard() {return m_board;}

    private void checkForOverlap () {
        for (int i = 0 ; i < (m_board.getRows() + m_board.getCols()) ; ++i) {
            if (i < m_board.getRows()) {
                checkLineForOverlap(i, m_rows.get(i));
            }
//            else {
//                checkLineForOverlap(i, m_cols.get(i - m_board.getRows()));
//            }
        }
    }
    private void checkLineForOverlap(final int lineNum, final List<Integer> line) {
        final int lineLength = lineNum < m_board.getRows() ? m_board.getCols() : m_board.getRows();
        final int spareCells = lineLength - (line.stream().mapToInt(Integer::intValue).sum() + line.size() - 1);
        if (spareCells < Collections.max(line)) {
            colorInOverlap(lineNum, line, spareCells);
        }
    }

    private void colorInOverlap(final int lineNum, final List<Integer> line, final int spareCells) {
        int currentCell = 0;
        for (int num : line) {
            if (num <= spareCells) {
                currentCell += num;
            }
            else {
                currentCell += spareCells;
                for (int i = 0 ; i < (num - spareCells) ; ++i) {
                    if (lineNum < m_board.getRows()) {
                        m_board.colorCell(lineNum, currentCell, CellType.BLACK);
                    }
                    else {
                        m_board.colorCell(currentCell, lineNum, CellType.BLACK);
                    }
                    ++currentCell;
                }
            }
            ++currentCell;
        }
    }
}

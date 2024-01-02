package solvers;

import components.Board;
import components.CellType;

import java.util.List;

public class SingleColorSolver {

    public static boolean solve(final List<List<Integer>> rows, final List<List<Integer>> cols, final Board board) {
        checkForOverlap(board, rows, cols);
        fillWithConstraints(board, rows, cols);

        return false;
    }

    private static void checkForOverlap(final Board board, final List<List<Integer>> rows, final List<List<Integer>> cols) {
        final int rowsNum = board.getRows();
        final int colsNum = board.getCols();
        for (int i = 0 ; i < rowsNum ; ++i) {
            final List<Integer> row = rows.get(i);
            int coloredCellsNum = countColoredCellsInLine(row);
            if (row.stream().anyMatch(x -> x > (board.getCols() - coloredCellsNum))) {
                fillInOverlap(board, i, row, true, board.getCols() - coloredCellsNum);
            }
        }
        for (int i = 0 ; i < colsNum ; ++i) {
            final List<Integer> col = cols.get(i);
            int coloredCellsNum = countColoredCellsInLine(col);
            if (col.stream().anyMatch(x -> x > (board.getCols() - coloredCellsNum))) {
                fillInOverlap(board, i, col, false, board.getCols() - coloredCellsNum);
            }
        }
    }

    private static void fillInOverlap(final Board board, final int lineNum, final List<Integer> line, final boolean isRow, final int dif) {
        int startingPosition = 0;
        for (int num : line) {
            if (num < dif) {
                for (int i = startingPosition + dif ; i < num ; ++i) {
                    board.colorCell(isRow ? lineNum : i, isRow ? i : lineNum, CellType.BLACK);
                }
            }
            startingPosition += (num + 1);
        }
    }

    private static int countColoredCellsInLine(final List<Integer> line) {
        int coloredCellsNum = 0;
        for (int num : line) {
            coloredCellsNum += (num + 1);
        }
        return coloredCellsNum - 1;
    }

    private static void fillWithConstraints(final Board board, final List<List<Integer>> rows, final List<List<Integer>> cols) {
        for (int i = 0 ; i < board.getRows() ; ++i) {
            for (int j = 0 ; j < board.getCols() ; ++j) {
                if (board.getCell(i, j) == CellType.BLACK) {
                    checkFromTop(board, cols.get(j), j, i);
                    checkFromBottom(board, cols.get(j), i);
                }
            }
        }
    }

    private static void checkFromTop(final Board board, final List<Integer> col, final int colNum, final int startingPoint) {
        int freeCells = 0;
        int coloredAdjacentCells = 0;
        int completedBlocks = 0;
        for (int i = 0 ; i < startingPoint ; ++i) {
            if (board.getCell(i, colNum) == CellType.BLACK) {
                while (board.getCell(i, colNum) == CellType.BLACK && i < startingPoint) {
                    ++coloredAdjacentCells;
                    ++i;
                }
                if (i < startingPoint && board.getCell(i, colNum) == CellType.WHITE) {
                    ++completedBlocks;
                    coloredAdjacentCells = 0;
                    freeCells = 0;
                }
            }
            else if (board.getCell(i, colNum) == CellType.WHITE) {
                if (freeCells != 0) {
                    return;
                }
            }
            else {
                ++freeCells;
            }
        }
        final int currentBlock = col.get(completedBlocks);
        if (board.getCell(startingPoint, colNum) == CellType.BLACK) {
            final int remainder = currentBlock - coloredAdjacentCells - freeCells;
            if (remainder == 0 && startingPoint < (board.getRows() - 1)) {
                board.colorCell(startingPoint + 1, colNum, CellType.WHITE);
            }
            for (int i = 0 ; remainder > 0 && i < remainder ; ++i) {
                board.colorCell(startingPoint + i + 1, colNum, CellType.BLACK);
            }
        }
    }

    private static void checkFromBottom(final Board board, final List<Integer> col, final int startingPoint) {

    }
}

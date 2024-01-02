import components.Board;
import solvers.SingleColorSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<List<Integer>> rows = new ArrayList<>();
        final List<List<Integer>> cols = new ArrayList<>();
        Board board;

        rows.add(List.of(3));
        rows.add(Arrays.asList(2,2));
        rows.add(Arrays.asList(1,1));

        cols.add(List.of(1));
        cols.add(List.of(2));
        cols.add(Arrays.asList(1,1));
        cols.add(List.of(2));
        cols.add(List.of(2));

        board = new Board(rows.size(), cols.size());

        SingleColorSolver.solve(rows, cols, board);
        board.printBoard();
    }
}
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

        SingleColorSolver.solve(Arrays.asList(row1, row2, row3, row4), new ArrayList<>(), 13);
    }
}
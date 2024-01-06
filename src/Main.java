import solvers.SingleColorSolver;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> row1 = List.of(7);
        List<Integer> row2 = List.of(12);
        List<Integer> row3 = List.of(16);
        List<Integer> row4 = List.of(18);
        List<Integer> row5 = List.of(19);
        List<Integer> row6 = List.of(8, 3);
        List<Integer> row7 = List.of(6, 8, 2);
        List<Integer> row8 = List.of(5, 11, 1);
        List<Integer> row9 = List.of(4, 15);
        List<Integer> row10 = List.of(3, 6, 6);
        List<Integer> row11 = List.of(2, 6, 4);
        List<Integer> row12 = List.of(1, 6, 1);
        List<Integer> row13 = List.of(5, 1, 1, 4);
        List<Integer> row14 = List.of(1, 1, 7);
        List<Integer> row15 = List.of(1, 5, 3);
        List<Integer> row16 = List.of(1,7,3);
        List<Integer> row17 = List.of(1,7,2);
        List<Integer> row18 = List.of(1,6,2);
        List<Integer> row19 = List.of(1,1,6);
        List<Integer> row20 = List.of(2,2,4);
        List<Integer> row21 = List.of(1,1,1,1);
        List<Integer> row22 = List.of(3,1,1,1,2,1,1);
        List<Integer> row23 = List.of(4,1,1,1,1,1);
        List<Integer> row24 = List.of(3,2,1,1,2,1);
        List<Integer> row25 = List.of(2,2,2,1,1,1);
        List<Integer> row26 = List.of(3,3,2,4,1,2);
        List<Integer> row27 = List.of(5,2,6,4);
        List<Integer> row28 = List.of(2,3,2,3,3,1,4);
        List<Integer> row29 = List.of(1,2,2,7,7);
        List<Integer> row30 = List.of(3,13,3);

        List<Integer> col1 = List.of(4,1,3);
        List<Integer> col2 = List.of(6,2,3);
        List<Integer> col3 = List.of(6,1,2,2);
        List<Integer> col4 = List.of(6,2,1,3);
        List<Integer> col5 = List.of(6,3,4,4);
        List<Integer> col6 = List.of(5,4,3,3);
        List<Integer> col7 = List.of(6,5,8,1);
        List<Integer> col8 = List.of(5,4,5,4);
        List<Integer> col9 = List.of(5,8,3);
        List<Integer> col10 = List.of(6,4,4,1);
        List<Integer> col11 = List.of(5,4,7);
        List<Integer> col12 = List.of(5,3,5);
        List<Integer> col13 = List.of(5,3,4);
        List<Integer> col14 = List.of(5,3,3,2);
        List<Integer> col15 = List.of(5,8,2,9);
        List<Integer> col16 = List.of(5,5,3,3,5);
        List<Integer> col17 = List.of(4,5,7,2,3);
        List<Integer> col18 = List.of(4,5,5,1,1);
        List<Integer> col19 = List.of(3,3,6,3);
        List<Integer> col20 = List.of(4,2,7,2);
        List<Integer> col21 = List.of(4,1,2,9,4);
        List<Integer> col22 = List.of(3,3,3,6);
        List<Integer> col23 = List.of(3,2,4);
        List<Integer> col24 = List.of(6,1,5);
        List<Integer> col25 = List.of(4,4,2);

        List<List<Integer>> rows = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13, row14, row15, row16, row17, row18, row19, row20, row21, row22, row23, row24, row25, row26, row27, row28, row29, row30);
        List<List<Integer>> cols = Arrays.asList(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17, col18, col19, col20, col21, col22, col23, col24, col25);

        SingleColorSolver.solve(rows, cols, 25, 30);
    }
}
package components;

public class Board {
    private final CellType [][] m_cells;
    public Board(final int rows, final int cols) {
        m_cells = new CellType[rows][cols];
    }

    public CellType getCell(final int row, final int col) {
        return m_cells[row][col];
    }

    public int getRows() {
        return m_cells.length;
    }

    public int getCols() {
        return m_cells[0].length;
    }

    public void colorCell(final int row, final int col, final CellType color) {
        m_cells[row][col] = color;
    }

    public void printBoard() {
        final StringBuilder output = new StringBuilder();
        for (CellType[] mCell : m_cells) {
            for (int j = 0; j < m_cells[0].length; ++j) {
                output.append(mCell[j] == CellType.BLACK ? "0 " : "  ");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
    }
}

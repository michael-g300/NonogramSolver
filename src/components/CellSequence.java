package components;

public record CellSequence(int length, CellType color) {
    @Override
    public String toString() {
        return length +
                " (" +
                color.toString() +
                ")";
    }
}

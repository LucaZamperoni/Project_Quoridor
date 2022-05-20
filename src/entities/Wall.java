package entities;

public class Wall {
    private Integer row;
    private Integer col;
    private String orientation;

    public Wall() {
    }

    public Wall(Integer row, Integer col, String orientation) {
        this.row = row;
        this.col = col;
        this.orientation = orientation;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Wall [" + "Row: " + row + "| Col: " + col + "| Orientation: " + orientation + ']';
    }
}

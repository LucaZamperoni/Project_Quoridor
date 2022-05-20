package entities;

public class Pawn {

    private String id;
    private Integer row;
    private Integer col;
    private Integer benefit;
    private Boolean moveFront;
    private Boolean moveRight;
    private Boolean moveLeft;
    private Boolean moveBack;

    public Pawn() {
    }

    public Pawn(String id, Integer row, Integer col, Integer benefit, Boolean moveFront, Boolean moveRight, Boolean moveLeft, Boolean moveBack) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.benefit = benefit;
        this.moveFront = moveFront;
        this.moveRight = moveRight;
        this.moveLeft = moveLeft;
        this.moveBack = moveBack;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getBenefit() {
        return benefit;
    }

    public void setBenefit(Integer benefit) {
        this.benefit = benefit;
    }

    public Boolean getMoveFront() {
        return moveFront;
    }

    public void setMoveFront(Boolean moveFront) {
        this.moveFront = moveFront;
    }

    public Boolean getMoveRight() {
        return moveRight;
    }

    public void setMoveRight(Boolean moveRight) {
        this.moveRight = moveRight;
    }

    public Boolean getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(Boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public Boolean getMoveBack() {
        return moveBack;
    }

    public void setMoveBack(Boolean moveBack) {
        this.moveBack = moveBack;
    }    

    @Override
    public String toString() {
        return "Pawn [" + "ID:" + id + " | Row: " + row + " | Col: " + col + " | Benefit: " + benefit + " | moveFront: " + moveFront + " | moveRight: " + moveRight + " | moveLeft: " + moveLeft + " | moveBack: " + moveBack + ']';
    }
}
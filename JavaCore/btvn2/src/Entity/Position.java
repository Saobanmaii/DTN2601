package Entity;

public class Position {
    private int positionID;
    private PositionName positionName;

    public Position(int positionID, PositionName positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }
    public PositionName getPositionName() { return positionName; }
}

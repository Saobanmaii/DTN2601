package Entity;
import Enum.PositionName;
public class Position {
    private int positionID;
    private PositionName positionName;

    public Position() {}
    public Position(int positionID, PositionName positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }
    public PositionName getPositionName() { return positionName; }
}

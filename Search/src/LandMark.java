import java.util.ArrayList;

abstract public class LandMark {
    private String ID;
    private String LandMarkName;
    private int location;
    private String fromEdge;
    private String toEdge;
    ArrayList<Edge> edges;

    public String getID() {
        return ID;
    }

    public String getLandMarkName() {
        return LandMarkName;
    }

    public int getLocation() {
        return location;
    }

    LandMark(String fromEdge, String ToEdge, String ID, String name, String location){
        this.fromEdge = fromEdge;
        this.toEdge = ToEdge;
        this.ID = ID;
        this.LandMarkName = name;
        this.location = Integer.parseInt(location);
        this.edges = new ArrayList<Edge>();
    }

    public String getFromEdge() {
        return fromEdge;
    }

    public String getToEdge() {
        return toEdge;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    abstract void printL();
}

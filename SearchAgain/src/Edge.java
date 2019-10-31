abstract public class Edge {
    private String fromEdge;
    private String ToEdge;
    private String EdgeType;
    private String EdgeName;
    private int Length;
    private int Speed;
    private double cost;
    private double Veff;
    public double VeffNew;
    public double CostNew;
    double distance;
    Edge parent;
    int vis;

//    public void CalcCostNew(){
//
//    }


    public double getVeff() {
        return Veff;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setVeff(double veff) {
        this.Veff = veff;
    }

    Edge(String fromEdge, String ToEdge, String EdgeType, String EdgeName, String Length, String Speed){
        this.fromEdge = fromEdge;
        this.ToEdge = ToEdge;
        this.EdgeType = EdgeType;
        this.EdgeName = EdgeName;
        this.Length = Integer.parseInt(Length) ;
        this.Speed = Integer.parseInt(Speed);
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
        this.vis = 0;

//        this.CalculateVeff();
//        this.CalculateCost();
    }

    public String getFromEdge() {
        return fromEdge;
    }

    public String getToEdge() {
        return ToEdge;
    }

    public String getEdgeType() {
        return EdgeType;
    }

    public String getEdgeName() {
        return EdgeName;
    }

    public int getLength() {
        return Length;
    }

    public int getSpeed() {
        return Speed;
    }


    public double getCost() {
        return cost;
    }

    public void CalculateCost(){
        this.cost = ((double)(Length*1.000)/VeffNew);
        this.CostNew = this.cost;
    }

    abstract public void CalculateVeff();

    abstract public void printEdge();

}

public class Motorway extends Edge{
    private int TollPrice;
    private int LaneNO;
    private int MaintenanceLevel;
    private int occupancy;
    public Motorway(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String TollPrice,String LaneNo, String MaintenanceLevel,String occupancy){
        super(fromEdge,ToEdge,EdgeType, EdgeName, Length, Speed);
        this.LaneNO = Integer.parseInt(LaneNo);
        this.MaintenanceLevel = Integer.parseInt(MaintenanceLevel);
        this.occupancy = Integer.parseInt(occupancy);
        this.TollPrice = Integer.parseInt(TollPrice);
        this.CalculateVeff();
        super.CalculateCost();
    }
    public void CalculateVeff(){
        double temp = (double)super.getSpeed() * (Math.abs((double) 1 - (occupancy/(double)(100*LaneNO))));
        super.setVeff(temp);
    }

    public int getTollPrice() {
        return TollPrice;
    }

    public int getLaneNO() {
        return LaneNO;
    }

    public int getMaintenanceLevel() {
        return MaintenanceLevel;
    }

    public int getOccupancy() {
        return occupancy;
    }


    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+TollPrice+" "+ LaneNO +" "+ MaintenanceLevel+" "+ occupancy);//+ " " + super.getCost());
    }
}

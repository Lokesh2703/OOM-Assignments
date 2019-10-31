public class pedestrianRoad extends Edge {
    private int width;
    private int Scenicvalue;
    private int occupancy;
    pedestrianRoad(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String width,String Scenicvalue,String occupancy){
        super(fromEdge,ToEdge, EdgeType, EdgeName, Length, Speed);
        this.width=Integer.parseInt(width);
        this.occupancy = Integer.parseInt(occupancy);
        this.Scenicvalue = Integer.parseInt(Scenicvalue);
//        this.CalculateVeff();
//        super.CalculateCost();
    }

    public int getWidth() {
        return width;
    }

    public int getScenicvalue() {
        return Scenicvalue;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void CalculateVeff(){
        double temp = (double)super.getSpeed()*(double) ((double)1-(occupancy/(double)1500));
        super.setVeff(temp);
    }

    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+width+" "+ Scenicvalue +" "+ occupancy);//+ " " + super.CostNew + " " + super.getCost()+ " " + super.getVeff()+ " " + super.VeffNew);
    }
}
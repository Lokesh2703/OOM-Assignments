public class cyclistRoad extends Edge {
    private int curvature;
    cyclistRoad(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String curvature){
        super(fromEdge,ToEdge,EdgeType,EdgeName, Length, Speed);
        this.curvature = Integer.parseInt(curvature);
        this.CalculateVeff();
        super.CalculateCost();
    }

    public int getCurvature() {
        return curvature;
    }

    public void CalculateVeff(){
        double temp = (double) super.getSpeed() / (double)curvature;
//        System.out.println("Veff:"+" "+temp);
        super.setVeff(temp);
    }


    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+curvature);//+ " " + distance);//+ " " + super.CostNew + " " + super.getCost()+ " " + super.getVeff()+ " " + super.VeffNew);
    }
}

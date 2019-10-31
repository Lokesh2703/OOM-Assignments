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
        super.setVeff(temp);
    }


    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+curvature);//+ " " + super.getCost());
    }

    public static boolean edgeValidator(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String curvature){
        if(Edge.edgeValidator(fromEdge,ToEdge,EdgeType,EdgeName, Length, Speed)){
            if(Integer.parseInt(curvature)>0)
                return true;
            else {
                System.out.println("invalid cyclistRoad edge");
                return false;
            }
        }
        else {
            System.out.println("invalid edge");
            return false;
        }
    }
}

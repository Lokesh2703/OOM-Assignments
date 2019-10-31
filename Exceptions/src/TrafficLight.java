public class TrafficLight extends LandMark{
    private int avgTimeRed;

    TrafficLight(String fromEdge,String ToEdge,String ID,String name,String location,String avgTimeRed){
        super(fromEdge,ToEdge,ID,name,location);
        this.avgTimeRed = Integer.parseInt(avgTimeRed);
    }

    public int getAvgTimeRed() {
        return avgTimeRed;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.avgTimeRed);
    }

    public static boolean LandMarkValidator(String fromEdge,String ToEdge,String ID,String name,String location,String avgTimeRed, Edge edg[],int k){
        if(LandMark.LandMarkValidator(fromEdge,ToEdge,ID,name,location)){
            if(Integer.parseInt(avgTimeRed)>0 && Integer.parseInt(avgTimeRed)<=100){
                if(LandMark.FromToValidator(fromEdge,ToEdge,edg,k)){
                    return true;
                }
                return false;
            }
            else{
                System.out.println("invalid trafficLight landmark");
                return false;
            }
        }
        return false;
    }

}

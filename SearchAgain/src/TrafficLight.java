public class TrafficLight extends LandMark {
    private int avgTimeRed;

    TrafficLight(String fromEdge, String ToEdge, String ID, String name, String location, String avgTimeRed,String LType){
        super(fromEdge,ToEdge,ID,name,location,LType);
        this.avgTimeRed = Integer.parseInt(avgTimeRed);
    }

    public int getAvgTimeRed() {
        return avgTimeRed;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.avgTimeRed);
    }
}

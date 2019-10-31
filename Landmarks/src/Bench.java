public class Bench extends LandMark{
    private int capacity;
    private String donatedBy;

    Bench(String fromEdge, String ToEdge, String ID, String name, String location,String capacity,String donatedBy){
        super(fromEdge,ToEdge,ID,name,location);
        this.capacity = Integer.parseInt(capacity);
        this.donatedBy = donatedBy;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.capacity + " " + this.donatedBy);
    }
}

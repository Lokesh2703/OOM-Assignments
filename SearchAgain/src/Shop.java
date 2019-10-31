public class Shop extends LandMark {
    private String Time;

    private int rating;
    private int explevel;

    Shop(String fromEdge, String ToEdge, String ID, String name, String location, String Time, String type, String rating, String explevel,String Ltype){
        super(fromEdge,ToEdge,ID,name,location,Ltype);
        this.Time = Time;
        super.setType(type);
        this.rating = Integer.parseInt(rating);
        this.explevel = Integer.parseInt(explevel);
    }

    public String getTime() {
        return Time;
    }

//    public String getType() {
//        return type;
//    }

    public int getRating() {
        return rating;
    }

    public int getExplevel() {
        return explevel;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.Time + " " + super.getType() + " " + this.rating + " " +this.explevel);
    }
}

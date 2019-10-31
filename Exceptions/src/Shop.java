public class Shop extends LandMark{
    private String Time;
    private String type;
    private int rating;
    private int explevel;

    Shop(String fromEdge, String ToEdge, String ID, String name, String location, String Time,String type,String rating,String explevel){
        super(fromEdge,ToEdge,ID,name,location);
        this.Time = Time;
        this.type = type;
        this.rating = Integer.parseInt(rating);
        this.explevel = Integer.parseInt(explevel);
    }

    public String getTime() {
        return Time;
    }

    public String getType() {
        return type;
    }

    public int getRating() {
        return rating;
    }

    public int getExplevel() {
        return explevel;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.Time + " " + this.type + " " + this.rating + " " +this.explevel);
    }

    public static boolean LandMarkValidator(String fromEdge, String ToEdge, String ID, String name, String location, String Time,String type,String rating,String explevel, Edge edg[],int k){
        if(LandMark.LandMarkValidator(fromEdge,ToEdge,ID,name,location)){
            if(Integer.parseInt(rating)>=0 && Integer.parseInt(rating)<=10 && Integer.parseInt(explevel)>=0 && Integer.parseInt(explevel)<=10 &&
                    (type.equalsIgnoreCase("food") || type.equalsIgnoreCase("clothing") ||type.equalsIgnoreCase("store") ||type.equalsIgnoreCase("others"))){
                if(LandMark.FromToValidator(fromEdge,ToEdge,edg,k)){
                    return true;
                }
                return false;
            }
            else{
                System.out.println("invalid shop landmark");
                return false;
            }
        }
        return false;
    }
}

import java.util.ArrayList;

abstract public class LandMark{
    private String ID;
    private String LandMarkName;
    private int location;
    private String fromEdge;
    private String toEdge;
    ArrayList<Edge> edges;

    public String getID() {
        return ID;
    }

    public String getLandMarkName() {
        return LandMarkName;
    }

    public int getLocation() {
        return location;
    }

    LandMark(String fromEdge, String ToEdge, String ID, String name, String location){
        this.fromEdge = fromEdge;
        this.toEdge = ToEdge;
        this.ID = ID;
        this.LandMarkName = name;
        this.location = Integer.parseInt(location);
        this.edges = new ArrayList<Edge>();
    }

    public String getFromEdge() {
        return fromEdge;
    }

    public String getToEdge() {
        return toEdge;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    abstract void printL();

    public static boolean LandMarkValidator(String fromEdge, String ToEdge, String ID, String name, String location){
        if(ID.length()>3 && ID.length()<15 && name.length()<25 && name.length()>3){
            return true;
        }
        else if(ID.length()<=3 || ID.length()>=15 || name.length()>=25 || name.length()<=3){
            System.out.println("invalid landmark");
        }
//        else if(fromEdge.length()<=3 || fromEdge.length()>=25 || ToEdge.length()<=3 || ToEdge.length()>=25){
//            System.out.println("invalid road");
//        }
        return false;
    }

    public static boolean FromToValidator(String fromEdge, String ToEdge, Edge edg[],int k){
////        System.out.println(edg.length);
//        if(fromEdge.length()>3 && fromEdge.length()<25 && ToEdge.length()>3 && ToEdge.length()<25){
//            return true;
//        }
//        else {
//            System.out.println("invalid road");
//            return false;
//        }
        int flag1=0;
        int flag2=0;
        for(int i=0;i<k;i++){
            if((fromEdge.equalsIgnoreCase(edg[i].getFromEdge()))){
                flag1++;
            }
            if((ToEdge.equalsIgnoreCase(edg[i].getToEdge()))){
                flag2++;
            }
        }
        if(flag1>=1 && flag2>=1)
            return true;
        else {
            System.out.println("invalid road");
            return false;
        }
    }
}

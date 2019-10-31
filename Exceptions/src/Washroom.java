public class Washroom extends LandMark {
    private int CostPerUse;
    private int CleanLevel;

    Washroom(String fromEdge, String ToEdge, String ID, String name, String location,String CostPerUse,String CleanLevel){
        super(fromEdge,ToEdge,ID,name,location);
        this.CostPerUse = Integer.parseInt(CostPerUse);
        this.CleanLevel = Integer.parseInt(CleanLevel);
    }

    public int getCostPerUse() {
        return CostPerUse;
    }

    public int getCleanLevel() {
        return CleanLevel;
    }

    public void printL(){
        System.out.println(super.getID()+ " " + super.getLandMarkName() + " " + super.getLocation() + " " + this.CostPerUse + " " +this.CleanLevel);
    }

    public static boolean LandMarkValidator(String fromEdge, String ToEdge, String ID, String name, String location,String CostPerUse,String CleanLevel, Edge edg[],int k){
        if(LandMark.LandMarkValidator(fromEdge,ToEdge,ID,name,location)){
            if(Integer.parseInt(CleanLevel)>=0 && Integer.parseInt(CleanLevel)<=10){
                if(LandMark.FromToValidator(fromEdge,ToEdge,edg,k)){
                    return true;
                }
                return false;
            }
            else{
                System.out.println("invalid washroom landmark");
                return false;
            }
        }
        return false;
    }
}

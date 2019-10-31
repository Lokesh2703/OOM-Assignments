public class Washroom extends LandMark {
    private int CostPerUse;
    private int CleanLevel;

    Washroom(String fromEdge, String ToEdge, String ID, String name, String location, String CostPerUse, String CleanLevel,String Ltype){
        super(fromEdge,ToEdge,ID,name,location,Ltype);
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
}

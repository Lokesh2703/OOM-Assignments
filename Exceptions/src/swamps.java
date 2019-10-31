public class swamps extends Edge {
    private int difficulty;
    swamps(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String difficulty){
        super(fromEdge,ToEdge,EdgeType,EdgeName,Length, Speed);
        this.difficulty = Integer.parseInt(difficulty);
        this.CalculateVeff();
        super.CalculateCost();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void CalculateVeff(){
        double temp = (double) super.getSpeed()/(double)(difficulty*difficulty) ;
        super.setVeff(temp);
    }

    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+difficulty);//+ " " + super.getCost());
    }

    public static boolean edgeValidator(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String difficulty){
        if(Edge.edgeValidator(fromEdge,ToEdge,EdgeType,EdgeName, Length, Speed)){
            if(Integer.parseInt(difficulty)>=0 && Integer.parseInt(difficulty)<=5){
                return true;
            }
            else {
                System.out.println("invalid swamps edge");
                return false;
            }
        }
        else {
            System.out.println("invalid edge");
            return false;
        }
    }
}

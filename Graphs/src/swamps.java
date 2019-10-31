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
}

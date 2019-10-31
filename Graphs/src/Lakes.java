public class Lakes extends Edge{
    private int width;
    private int tidalLevel;
    private int depth;
    Lakes(String fromEdge,String ToEdge,String EdgeType, String EdgeName, String Length, String Speed,String width,String tidalLevel,String depth){
        super(fromEdge,ToEdge,EdgeType, EdgeName,Length, Speed);
        this.depth = Integer.parseInt(depth);
        this.tidalLevel = Integer.parseInt(tidalLevel);
        this.width = Integer.parseInt(width);
        this.CalculateVeff();
        super.CalculateCost();
    }

    public int getWidth() {
        return width;
    }

    public int getTidalLevel() {
        return tidalLevel;
    }

    public int getDepth() {
        return depth;
    }


    public void CalculateVeff(){
        double temp = (double) super.getSpeed();
        super.setVeff(temp);
    }

    public void printEdge(){
        System.out.println(super.getFromEdge()+" "+super.getToEdge()+" "+super.getEdgeName()+" "+super.getLength()+" "+super.getSpeed()+" "+width+" "+tidalLevel+" "+depth);//+ " " + super.getCost());
    }
}

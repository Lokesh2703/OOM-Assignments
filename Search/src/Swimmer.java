import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Swimmer extends Travellers{
    ArrayList<Edge> list;
    private int weightMotor = 3;
    private int weightPed = 2;
    private int weightCyclist = 2;
    private int weightSwamps = 3;
    private int weightLakes = 1;

    Swimmer(String name, String maxSpeed,ArrayList<Edge> list){
        super(name,maxSpeed);
        this.list = new ArrayList<Edge>(list);
    }

    public ArrayList<Edge> getList() {
        return list;
    }

    public void Calc(){
        for(Edge x: list){
            x.CalculateVeff();
            x.VeffNew=(Math.min(x.getVeff(),super.getMaxSpeed()));
            x.CalculateCost();
            if(x.getEdgeType().compareToIgnoreCase("motorway")==0) {
//                x.setCost(x.getCost()*(double)this.weightMotor);
                x.CostNew=(x.getCost()*(double)this.weightMotor);
            }
            else if(x.getEdgeType().compareToIgnoreCase("cyclistRoad")==0) {
//                x.setCost(x.getCost()*(double)this.weightCyclist);
                x.CostNew=(x.getCost()*(double)this.weightCyclist);
            }
            else if(x.getEdgeType().compareToIgnoreCase("pedestrianRoad")==0) {
//                x.setCost(x.getCost()*(double)this.weightPed);
                x.CostNew=(x.getCost()*(double)this.weightPed);
            }
            else if(x.getEdgeType().compareToIgnoreCase("swamps")==0) {
//                x.setCost(x.getCost()*(double)this.weightSwamps);
                x.CostNew=(x.getCost()*(double)this.weightSwamps);
            }
            else if(x.getEdgeType().compareToIgnoreCase("lakes")==0) {
//                x.setCost(x.getCost()*(double)this.weightLakes);
                x.CostNew=(x.getCost()*(double)this.weightLakes);
            }
        }
    }

    public TreeMap<String, ArrayList<Edge>> MapMaker(){
        TreeMap<String, ArrayList<Edge>> dj2= new TreeMap<String, ArrayList<Edge>>();
        for(Edge x:list){
            if(dj2.get(x.getFromEdge())==null){
                ArrayList<Edge> list3 = new ArrayList<Edge>();
                list3.add(x);
                dj2.put(x.getFromEdge(), list3);
            }
            else {
                ArrayList<Edge> list3 = dj2.get(x.getFromEdge());
                list3.add(x);
                dj2.put(x.getFromEdge(), list3);
            }
        }
        return dj2;
    }

    public void print(){
        Collections.sort(list,new FromEdgeCom().thenComparing(new CostComNew()).thenComparing(new NameCom()));
        for (Edge x: list){
            x.printEdge();
        }
    }
}

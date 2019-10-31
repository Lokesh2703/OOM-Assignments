import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class OldWalkers extends Travellers {
    ArrayList<Edge> list;
    int weightMotor = 5;
    int weightPed = 1;
//    int weightCyclist = 2;
//    int weightSwamps = 3;
//    int weightLakes = 1;

    OldWalkers(String name, String maxSpeed,ArrayList<Edge> list){
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
//                x.setCost(x.getCost()*(double)weightMotor);
                x.CostNew=(x.getCost()*(double)weightMotor);
            }
//            else if(x.getEdgeType().compareToIgnoreCase("cyclistRoad")==0) {
//                x.setCost(x.getCost()*weightCyclist);
//            }
            else if(x.getEdgeType().compareToIgnoreCase("pedestrianRoad")==0) {
//                x.setCost(x.getCost()*(double)weightPed);
                x.CostNew=(x.getCost()*(double)weightPed);
            }
//            else if(x.getEdgeType().compareToIgnoreCase("swamps")==0) {
//                x.setCost(x.getCost()*weightSwamps);
//            }
//            else if(x.getEdgeType().compareToIgnoreCase("lakes")==0) {
//                x.setCost(x.getCost()*weightLakes);
//            }
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

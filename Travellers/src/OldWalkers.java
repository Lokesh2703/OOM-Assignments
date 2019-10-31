import java.util.ArrayList;
import java.util.Collections;

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

    public void print(){
        Collections.sort(list,new FromEdgeCom().thenComparing(new CostComNew()).thenComparing(new NameCom()));
        for (Edge x: list){
            x.printEdge();
        }
    }
}

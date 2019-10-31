import java.util.ArrayList;
import java.util.Collections;

public class cyclist extends Travellers {
    ArrayList<Edge> list;
    int weightMotor = 2;
    int weightPed = 3;
    int weightCyclist = 1;

    cyclist(String name, String maxSpeed,ArrayList<Edge> list){
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
                x.CostNew=(x.getCost()*(double) weightMotor);
            }
            else if(x.getEdgeType().compareToIgnoreCase("cyclistRoad")==0) {
                x.CostNew=(x.getCost()*(double)weightCyclist);
            }
            else if(x.getEdgeType().compareToIgnoreCase("pedestrianRoad")==0) {
                x.CostNew=(x.getCost()*(double)weightPed);
            }
        }
    }

    public void print(){
        Collections.sort(list,new FromEdgeCom().thenComparing(new CostComNew()).thenComparing(new NameCom()));
        for (Edge x: list){
            x.printEdge();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FromEdgeCom implements Comparator<Edge> {
    @Override
    public int compare(Edge e1,Edge e2){
//        if(e1.getFromEdge().equals(e2.getFromEdge())){
//            if(Math.abs(e1.getCost()-e2.getCost())<0.0001){
//                return e1.getEdgeName().compareTo(e2.getEdgeName());
//            }
//            else {
//                if(e1.getCost()<e2.getCost())
//                    return -1;
//                return 1;
//            }
//        }
//        else {
        return e1.getFromEdge().compareTo(e2.getFromEdge());
//        }
    }
}

class CostCom implements Comparator<Edge>{
    //    @Override
//    public int compare(Edge e1,Edge e2){
//        return (Math.abs(e1.getCost() - e2.getCost()) < (double) 0.0001)?0:1;
//    }
    @Override
    public int compare(Edge e1,Edge e2){
        if(e1.getCost()>e2.getCost() && Math.abs(e2.getCost()-e1.getCost())>=0.0001)
            return -1;
        if(e1.getCost()<e2.getCost() && Math.abs(e2.getCost()-e1.getCost())>=0.0001)
            return 1;
        return 0;
    }
}

class CostComNew implements Comparator<Edge>{
    //    @Override
//    public int compare(Edge e1,Edge e2){
//        return (Math.abs(e1.getCost() - e2.getCost()) < (double) 0.0001)?0:1;
//    }
    @Override
    public int compare(Edge e1,Edge e2){
        if(e1.CostNew<e2.CostNew && Math.abs(e2.CostNew-e1.CostNew)>0.0001)
            return -1;
        else if(e1.CostNew>e2.CostNew && Math.abs(e2.CostNew-e1.CostNew)>0.0001)
            return 1;
        return 0;
    }
}

class NameCom implements Comparator<Edge>{
    @Override
    public int compare(Edge e1,Edge e2){
        return e1.getEdgeName().compareTo(e2.getEdgeName());
    }
}

public class TestClass {
    static void swap(Edge e1, Edge e2) {
        System.out.println("Swap of " + e1.getFromEdge() + " " + e1.getToEdge() + " " + e1.getCost() + " " + e2.getFromEdge() + " " + e2.getToEdge() + " " + e2.getCost());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inp2 = new BufferedReader(new InputStreamReader(System.in));
        String nS = inp2.readLine();
        int n = Integer.parseInt(nS);
        for(int z=0;z<n;z++){
            nS = inp2.readLine();
            int k = Integer.parseInt(nS);
            String s;
            Edge edg[] = new Edge[2 * k];
            ArrayList<Edge> listMotor = new ArrayList<Edge>();
            ArrayList<Edge> listSwim = new ArrayList<Edge>();
            ArrayList<Edge> listCyclist = new ArrayList<Edge>();
            ArrayList<Edge> listOld = new ArrayList<Edge>();
            ArrayList<Edge> listNew = new ArrayList<Edge>();

            for (int i = 0; i < 2 * k; i++) {
                s = inp2.readLine();
                String p[] = new String[0];
                p = s.split(" ");
                if (p[2].compareToIgnoreCase("motorway") == 0) {
                    edg[i] = new Motorway(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
                    listMotor.add(edg[i]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listOld.add(edg[i]);
                    listNew.add(edg[i]);
                    edg[++ i] = new Motorway(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
                    listMotor.add(edg[i]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listOld.add(edg[i]);
                    listNew.add(edg[i]);
                } else if (p[2].compareToIgnoreCase("pedestrianRoad") == 0) {
                    edg[i] = new pedestrianRoad(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listOld.add(edg[i]);
                    listNew.add(edg[i]);
                    edg[++ i] = new pedestrianRoad(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listOld.add(edg[i]);
                    listNew.add(edg[i]);
                } else if (p[2].compareToIgnoreCase("cyclistRoad") == 0) {
                    edg[i] = new cyclistRoad(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listNew.add(edg[i]);
                    edg[++ i] = new cyclistRoad(p[1], p[0], p[2], p[3], p[4], p[5], p[6]);
                    listSwim.add(edg[i]);
                    listCyclist.add(edg[i]);
                    listNew.add(edg[i]);
                } else if (p[2].compareToIgnoreCase("swamps") == 0) {
                    edg[i] = new swamps(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
                    listSwim.add(edg[i]);
                    listNew.add(edg[i]);
                    edg[++ i] = new swamps(p[1], p[0], p[2], p[3], p[4], p[5], p[6]);
                    listSwim.add(edg[i]);
                    listNew.add(edg[i]);
                } else if (p[2].compareToIgnoreCase("lakes") == 0) {
                    edg[i] = new Lakes(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    listSwim.add(edg[i]);
                    edg[++ i] = new Lakes(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    listSwim.add(edg[i]);
                }
            }
            nS = inp2.readLine();
            int q = Integer.parseInt(nS);
            Travellers trav[] = new Travellers[q];
            for(int i=0;i<q;i++){
                nS = inp2.readLine();
                String a[] = nS.split(" ");
                if(a[2].compareToIgnoreCase("motorist")==0){
                    trav[i] = new Motorist(a[0],a[1],listMotor);
                    trav[i].Calc();
                    trav[i].print();
                }
                else if(a[2].compareToIgnoreCase("swimmer")==0 || a[2].compareToIgnoreCase("swimmers")==0){
                    trav[i] = new Swimmer(a[0],a[1],listSwim);
                    trav[i].Calc();
                    trav[i].print();
                }
                else if(a[2].compareToIgnoreCase("cyclist")==0){
                    trav[i] = new cyclist(a[0],a[1],listCyclist);
                    trav[i].Calc();
                    trav[i].print();
                }
                else if(a[2].compareToIgnoreCase("oldwalker")==0){
                    trav[i] = new OldWalkers(a[0],a[1],listOld);
                    trav[i].Calc();
                    trav[i].print();
                }
                else if(a[2].compareToIgnoreCase("newwalker")==0 || a[2].compareToIgnoreCase("newwalkers")==0){
                    trav[i] = new NewWalkers(a[0],a[1],listNew);
                    trav[i].Calc();
                    trav[i].print();
                }
            }
        }

    }
}


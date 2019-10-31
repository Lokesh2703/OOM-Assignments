import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class FromEdgeCom implements Comparator<Edge>{
    @Override
    public int compare(Edge e1,Edge e2){
            return e1.getFromEdge().compareTo(e2.getFromEdge());
    }
}

class CostCom implements Comparator<Edge>{
    @Override
    public int compare(Edge e1,Edge e2){
        if(e1.getCost()<e2.getCost() && Math.abs(e2.getCost()-e1.getCost())>0.0001)
            return -1;
        if(e1.getCost()>e2.getCost() && Math.abs(e2.getCost()-e1.getCost())>0.0001)
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

class sort implements Comparator<LandMark>{
    @Override
    public int compare(LandMark e1,LandMark e2){
        return e1.getID().compareTo(e2.getID());
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
            String nS2[] = nS.split(" ");
            int k = Integer.parseInt(nS2[0]);
            int l = Integer.parseInt(nS2[1]);
            String s;
            Edge edg[] = new Edge[2 * k];
            for (int i = 0; i < 2 * k; i++) {
                s = inp2.readLine();
                String p[] = new String[0];
                p = s.split(" ");
                if (p[2].compareToIgnoreCase("motorway") == 0) {
                    edg[i] = new Motorway(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
                    edg[++ i] = new Motorway(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
                } else if (p[2].compareToIgnoreCase("pedestrianRoad") == 0) {
                    edg[i] = new pedestrianRoad(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    edg[++ i] = new pedestrianRoad(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                } else if (p[2].compareToIgnoreCase("cyclistRoad") == 0) {
                    edg[i] = new cyclistRoad(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
                    edg[++ i] = new cyclistRoad(p[1], p[0], p[2], p[3], p[4], p[5], p[6]);
                } else if (p[2].compareToIgnoreCase("swamps") == 0) {
                    edg[i] = new swamps(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
                    edg[++ i] = new swamps(p[1], p[0], p[2], p[3], p[4], p[5], p[6]);
                } else if (p[2].compareToIgnoreCase("lakes") == 0) {
                    edg[i] = new Lakes(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                    edg[++ i] = new Lakes(p[1], p[0], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
                }
            }
            LandMark lm[] = new LandMark[l];
            TreeMap<String,LandMark> tm = new TreeMap<String, LandMark>();
            for(int i=0;i<l;i++){
                s = inp2.readLine();
                String p[] = new String[0];
                p = s.split(" ");
                if (p[5].compareToIgnoreCase("trafficLight")== 0){
                    lm[i] = new TrafficLight(p[0],p[1],p[2],p[3],p[4],p[6]);
                }
                else if(p[5].compareToIgnoreCase("bench")==0) {
                    lm[i] = new Bench(p[0], p[1], p[2], p[3], p[4], p[6], p[7]);
                }
                else if(p[5].compareToIgnoreCase("shop")==0){
                    lm[i] = new Shop(p[0], p[1], p[2], p[3], p[4], p[6], p[7], p[8], p[9]);
                }
                else if(p[5].compareToIgnoreCase("washroom")==0){
                    lm[i] = new Washroom(p[0], p[1], p[2], p[3], p[4], p[6], p[7]);
                }
                tm.put(p[2],lm[i]);
            }

            for(int i=0;i<2*k;i++){
                for(int j=0;j<l;j++){
                    if(edg[i].getFromEdge().compareTo(lm[j].getFromEdge())==0 && edg[i].getToEdge().compareTo(lm[j].getToEdge())==0){
                        edg[i].lmarks.add(lm[j]);
                        lm[j].edges.add(edg[i]);
                    }
                }
            }

            nS = inp2.readLine();
            int nL= Integer.parseInt(nS);
            String IDs[] =new String[nL];
            for(int i=0;i<nL;i++){
                IDs[i] = inp2.readLine();
                LandMark lm2 = tm.get(IDs[i]);
                lm2.printL();
                Set<LandMark> set = new TreeSet<LandMark>(new sort());
                Collections.sort(lm2.edges,new FromEdgeCom().thenComparing(new CostCom()).thenComparing(new NameCom()));
                for(Edge j:lm2.edges){
                    j.printEdge();
                    for(LandMark x:j.lmarks){
                        set.add(x);
                    }
                }
//                System.out.println();
                for(LandMark x: set){
                    x.printL();
                }
            }
        }

    }
}


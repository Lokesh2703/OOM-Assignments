import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FromEdgeCom implements Comparator<Edge>{
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
            ArrayList<Edge> list = new ArrayList<Edge>(2*k);
            for(int i=0;i<2*k;i++){
                list.add(edg[i]);
            }
            Collections.sort(list,new FromEdgeCom().thenComparing(new CostCom()).thenComparing(new NameCom()));
//        for (int i = 0; i < 2 * k; i++) {
//            for (int j = i + 1; j < 2 * k; j++) {
//                if (edg[i].getFromEdge().compareTo(edg[j].getFromEdge()) > 0) {
//                    Edge temp = edg[i];
//                    edg[i] = edg[j];
//                    edg[j] = temp;
//                } else if (edg[i].getFromEdge().compareTo(edg[j].getFromEdge()) == 0) {
//                    if (Math.abs(edg[i].getCost() - edg[j].getCost()) >= (double) 0.0001 && edg[i].getCost() > edg[j].getCost()) {
//                        Edge temp = edg[i];
//                        edg[i] = edg[j];
//                        edg[j] = temp;
//                    } else if (Math.abs(edg[i].getCost() - edg[j].getCost()) < (double) 0.0001) {
//                        if (edg[i].getEdgeName().compareTo(edg[j].getEdgeName()) >= 0) {
//                            Edge temp = edg[i];
//                            edg[i] = edg[j];
//                            edg[j] = temp;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < 2 * k; i++) {
//            try {
//                edg[i].printEdge();
//            } catch (NullPointerException e) {
//                System.out.println(e);
//            }
//        }
            for(Edge i: list){
                i.printEdge();
            }
        }

    }
}


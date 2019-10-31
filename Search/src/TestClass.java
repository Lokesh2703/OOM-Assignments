import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class FromEdgeCom implements Comparator<Edge> {
    @Override
    public int compare(Edge e1,Edge e2){
        return e1.getFromEdge().compareTo(e2.getFromEdge());
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

    static void printLast(Edge ReqEdge, TreeMap<String, Edge> tm) {
        if (tm.get(ReqEdge.getToEdge()) != null)
            printLast(tm.get(ReqEdge.getToEdge()), tm);
        ReqEdge.printEdge();
    }

    static void PrintList(TreeMap<String, Edge> par,String RegTo){
        if(par.get(RegTo)==null){
            return;
        }
        else {
            PrintList(par,par.get(RegTo).getFromEdge());
            par.get(RegTo).printEdge();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inp2 = new BufferedReader(new InputStreamReader(System.in));
        String nS = inp2.readLine();
        int n = Integer.parseInt(nS);
        for (int z = 0; z < n; z++) {
            nS = inp2.readLine();
            String nS2[] = nS.split(" ");
            int k = Integer.parseInt(nS2[0]);
            int l = Integer.parseInt(nS2[1]);
            String s;
            Edge edg[] = new Edge[2 * k];
            ArrayList<Edge> listMotor = new ArrayList<Edge>();
            ArrayList<Edge> listSwim = new ArrayList<Edge>();
            ArrayList<Edge> listCyclist = new ArrayList<Edge>();
            ArrayList<Edge> listOld = new ArrayList<Edge>();
            ArrayList<Edge> listNew = new ArrayList<Edge>();

            TreeMap<String, ArrayList<Edge>> dj = new TreeMap<String, ArrayList<Edge>>();

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
//                System.out.println(dj.get(p[i]));
                if (dj.get(p[1]) == null) {
                    ArrayList<Edge> list3 = new ArrayList<Edge>();
                    list3.add(edg[i]);
                    dj.put(p[1], list3);
                    if (dj.get(p[0]) == null) {
                        list3 = new ArrayList<Edge>();
                        list3.add(edg[i - 1]);
                        dj.put(p[0], list3);
                    } else {
                        list3 = dj.get(p[0]);
                        list3.add(edg[i - 1]);
                        dj.put(p[0], list3);
                    }
                } else {
                    ArrayList<Edge> list3 = dj.get(p[1]);
                    list3.add(edg[i]);
                    dj.put(p[1], list3);
                    if (dj.get(p[0]) == null) {
                        list3 = new ArrayList<Edge>();
                        list3.add(edg[i - 1]);
                        dj.put(p[0], list3);
                    } else {
                        list3 = dj.get(p[0]);
                        list3.add(edg[i - 1]);
                        dj.put(p[0], list3);
                    }
                }
            }

            LandMark lm[] = new LandMark[l];
//            TreeMap<String,LandMark> tm = new TreeMap<String, LandMark>();
            for (int i = 0; i < l; i++) {
                s = inp2.readLine();
                String p[] = new String[0];
                p = s.split(" ");
                if (p[5].compareToIgnoreCase("trafficLight") == 0) {
                    lm[i] = new TrafficLight(p[0], p[1], p[2], p[3], p[4], p[6]);
                } else if (p[5].compareToIgnoreCase("bench") == 0) {
                    lm[i] = new Bench(p[0], p[1], p[2], p[3], p[4], p[6], p[7]);
                } else if (p[5].compareToIgnoreCase("shop") == 0) {
                    lm[i] = new Shop(p[0], p[1], p[2], p[3], p[4], p[6], p[7], p[8], p[9]);
                } else if (p[5].compareToIgnoreCase("washroom") == 0) {
                    lm[i] = new Washroom(p[0], p[1], p[2], p[3], p[4], p[6], p[7]);
                }
//                tm.put(p[2],lm[i]);
            }


            nS = inp2.readLine();
            int q = Integer.parseInt(nS);
            Travellers trav[] = new Travellers[q];
            for (int i = 0; i < q; i++) {
                nS = inp2.readLine();
                String a[] = nS.split(" ");
                String ReqFrom = new String();
                String ReqLand = new String();
                ReqFrom = a[0];
                ReqLand = a[1];


                if (a[4].compareToIgnoreCase("motorist") == 0) {
                    trav[i] = new Motorist(a[2], a[3], listMotor);
                    trav[i].Calc();
//                    trav[i].print();
                } else if (a[4].compareToIgnoreCase("swimmer") == 0 || a[4].compareToIgnoreCase("swimmers") == 0) {
                    trav[i] = new Swimmer(a[2], a[3], listSwim);
                    trav[i].Calc();
//                    trav[i].print();
                } else if (a[4].compareToIgnoreCase("cyclist") == 0) {
                    trav[i] = new cyclist(a[2], a[3], listCyclist);
                    trav[i].Calc();
//                    trav[i].print();
                } else if (a[4].compareToIgnoreCase("oldwalker") == 0) {
                    trav[i] = new OldWalkers(a[2], a[3], listOld);
                    trav[i].Calc();
//                    trav[i].print();
                } else if (a[4].compareToIgnoreCase("newwalker") == 0 || a[4].compareToIgnoreCase("newwalkers") == 0) {
                    trav[i] = new NewWalkers(a[2], a[3], listNew);
                    trav[i].Calc();
//                    trav[i].print();
                }

                // for (Map.Entry<String, ArrayList<Edge>> entry : dj.entrySet()) {
                //     System.out.println(entry.getKey());
                //     for (Edge x : entry.getValue()) {
                //         x.printEdge();
                //     }
                // }
                // TreeMap<String, ArrayList<Edge>> dj = new TreeMap<String, ArrayList<Edge>>();

                dj = trav[i].MapMaker();


                 for (Map.Entry<String, ArrayList<Edge>> entry : dj.entrySet()) {
                    System.out.println(entry.getKey());
                    for (Edge x : entry.getValue()) {
                        x.printEdge();
                    }
                 }

//                String ReqTo = new String();
//                int flag2=0;
//                for (LandMark x : lm) {
//                    if (x.getID().equals(ReqLand)) {
//                        ReqTo = x.getFromEdge();
//                        flag2=1;
//                        break;
//                    }
//                }
//                // if(flag2==0){
//                //     System.out.println("no path exists");
//                //     continue;
//                // }
////                System.out.println("\n\nReqFrom:" + ReqFrom + " " + "ReqLand:" + ReqLand);
////                System.out.println("ReqTo :" + ReqTo);
//                // int flag=0;
//                TreeMap<String, Integer> vis = new TreeMap<String, Integer>();
//                TreeMap<String, Edge> par = new TreeMap<String, Edge>();
//                TreeMap<String, Double> dis = new TreeMap<String, Double>();
//
//                for (String x : dj.keySet()) {
//                    vis.put(x, 0);
//                    dis.put(x,Double.MAX_VALUE);
//                    par.put(x,null);
//                }
//
//                ArrayList<Edge> que = new ArrayList<Edge>();
//                ArrayList<Edge> curr = dj.get(ReqFrom);
//                dis.put(ReqFrom,0.0000);
//                par.put(ReqFrom,null);
//                vis.put(ReqFrom,2);
//                if (curr == null) {
//                    // flag=1;
//                    System.out.println("no path exists");
//                    continue;
//                }
//                else{
////                    for(Edge x: curr){
//                    for(int f=0;f<curr.size();f++){
//                        Edge x = curr.get(f);
//                        if(vis.get(x.getToEdge())==0) {
//                            vis.put(x.getToEdge(), 1);
//                            dis.put(x.getToEdge(), x.CostNew);
////                            System.out.println("Setting parent of " + x.getToEdge() + " as " + x.getFromEdge());
//                            par.put(x.getToEdge(), x);
////                            System.out.print("Adding :");
////                            x.printEdge();
//                            que.add(x);
//                        }
//                        else if(vis.get(x.getToEdge())==1){
////                            for(Edge y:que){
//                            for(int g=0;g<que.size();g++){
//                                Edge y = que.get(g);
//                                if(y.getToEdge().equals(x.getToEdge())){
//                                    if(dis.get(x.getToEdge())> (dis.get(x.getFromEdge())+x.CostNew)){
//                                        dis.put(x.getToEdge(),(dis.get(x.getFromEdge())+x.CostNew));
//                                        par.put(x.getToEdge(),x);
////                                        System.out.println("Setting parent of " + x.getToEdge()+ " as " + x.getFromEdge());
////                                        System.out.print("Adding :");
////                                        x.printEdge();
//                                        que.add(x);
////                                        System.out.print("Removing :");
////                                        System.out.print(y);
////                                        y.printEdge();
//                                        que.remove(y);
//                                    }
//                                    else if(Math.abs(dis.get(x.getToEdge())- (dis.get(x.getFromEdge())+x.CostNew))<0.0001){
//                                        if(y.getEdgeName().compareTo(x.getEdgeName())>0){
//                                            dis.put(x.getToEdge(),(dis.get(x.getFromEdge())+x.CostNew));
//                                            par.put(x.getToEdge(),x);
////                                            System.out.println("Setting parent of " + x.getToEdge()+ " as " + x.getFromEdge());
//                                            que.add(x);
//                                            que.remove(y);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
////                    System.out.println("In queue");
////                    System.out.println("-----------\n------------");
////                    for(Edge x:que){
////                        x.printEdge();
////                    }
////                    System.out.println("-----------\n------------");
//
//                    while (!que.isEmpty()){
//                        Edge sel = que.get(0);
//                        for(Edge x: que){
//                            if (dis.get(x.getToEdge()) < dis.get(sel.getToEdge()) && Math.abs(dis.get(x.getToEdge()) - dis.get(sel.getToEdge())) >= 0.0001) {
//                                sel = x;
//                            } else if (Math.abs(dis.get(x.getToEdge()) - dis.get(sel.getToEdge())) < 0.0001) {
//                                if (sel.getEdgeName().compareTo(x.getEdgeName()) > 0) {
//                                    sel = x;
//                                }
//                            }
//                        }
////                        System.out.print("Selected : ");
////                        sel.printEdge();
//                        que.remove(sel);
//                        vis.put(sel.getToEdge(), 2);
//                        ArrayList<Edge> curr2 = dj.get(sel.getToEdge());
//                        if (curr2 == null) {
//                            // flag = 1;
//                            System.out.println("no path exists");
//                            break;
//                        }
//                        else {
//                            for(Edge x:curr2){
//                                if(vis.get(x.getToEdge())==0){
//                                    vis.put(x.getToEdge(),1);
//                                    dis.put(x.getToEdge(),(dis.get(x.getFromEdge())+x.CostNew));
////                                    System.out.println("Setting parent of " + x.getToEdge()+ " as " + x.getFromEdge());
//                                    par.put(x.getToEdge(),x);
////                                    System.out.print("Adding :");
////                                    System.out.print(x);
////                                    x.printEdge();
//                                    que.add(x);
//                                }
//                                else if(vis.get(x.getToEdge())==1){
////                                    for(Edge y:que){
////                                        if(y.getToEdge().equals(x.getToEdge()) && y.getFromEdge().equals(x.getFromEdge())){
//                                    if(dis.get(x.getToEdge())> (dis.get(x.getFromEdge())+x.CostNew)){
//                                        dis.put(x.getToEdge(),(dis.get(x.getFromEdge())+x.CostNew));
////                                                System.out.println("Setting parent of " + x.getToEdge()+ " as " + x.getFromEdge());
//                                        par.put(x.getToEdge(),x);
////                                                System.out.print("Adding :");
////                                                System.out.print(x);
////                                                x.printEdge();
//                                        que.add(x);
////                                                System.out.print("Removing :");
////                                                y.printEdge();
//                                        que.remove(par.get(x.getToEdge()));
//                                    }
//                                    else if(Math.abs(dis.get(x.getToEdge())- (dis.get(x.getFromEdge())+x.CostNew))<0.0001){
//                                        if(par.get(x.getToEdge()).getEdgeName().compareTo(x.getEdgeName())>0){
//                                            dis.put(x.getToEdge(),(dis.get(x.getFromEdge())+x.CostNew));
////                                                    System.out.println("Setting parent of " + x.getToEdge() +" as " + x.getFromEdge());
//                                            par.put(x.getToEdge(),x);
////                                                    System.out.print("Adding :");
////                                                    System.out.print(x);
////                                                    x.printEdge();
//                                            que.add(x);
//                                            que.remove(par.get(x.getToEdge()));
////                                                    que.remove(y);
//                                        }
//                                    }
////                                        }
////                                    }
//                                }
//                            }
//                        }
////                        for(var d: dis.entrySet()){
////                            System.out.println(d.getKey() + " ==>> " + d.getValue());
////                        }
//                    }
                }
//                for(var u: par.entrySet()){
//                    System.out.print(u.getKey() + "  ++++++++>>>  ");// + u.getValue().getFromEdge());
//                    if(u.getValue()==null) {
//                        System.out.println("Null");
//                    }
//                    else {
//                        System.out.print(u.getValue() + " ");
//                        System.out.println(u.getValue().getFromEdge());
//                    }
//                }
                // if(dis.get(ReqTo)==null){
                //     System.out.println("no path exists");
                // }
                // else

//                if(dis.get(ReqTo)==null){
//                    System.out.println("no path exists");
//                }
//                else if(dis.get(ReqTo).equals(0.000) || dis.get(ReqTo).equals("ReqFrom")){
//                    System.out.println("source on landmark");
//                }
//                else if(dis.get(ReqTo).equals(Double.MAX_VALUE)){
//                    System.out.println("no path exists");
//                }
//                else {
//                    PrintList(par, ReqTo);
//                }
//            }
        }
    }
}
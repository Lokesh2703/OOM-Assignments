class Beverage {
    String[] item = new String[100];
    int[] cost = new int[100];
    int[] no = new int[100];
    double total_amt;
    int num = 0;
    double CGST;
    double SGST;

    public void get_itemName(String name, int cost, int no) {
        ++num;
        item[num] = name;
        this.cost[num] = cost;
        this.no[num] = no;
    }

    public double calculate_amt() {
        int j = 1;
        double total = 0;
        for (int i = 1; i <= num; i++) {
            total = total + (cost[i] * no[j]);
            j++;
        }
        total_amt = total;
        return total;
    }

    double get_SGST() {
        return SGST;
    }

    double get_CGST() {
        return CGST;
    }
}
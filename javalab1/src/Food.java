class Food {
    String[] item = new String[100];
    int[] cost = new int[100];
    int[] no = new int[100];
    double total_amt;
    double CGST;
    double SGST;

    int num = 0;

    public void get_itemName(String name, int cost, int no) {
        ++num;
        item[num] = name;
        this.cost[num] = cost;
        this.no[num] = no;
    }

    double calculate_amt() {
        int j = 1;
        double total = 0;
        for (int i = 1; i <= num; i++) {
            total = total + (cost[i] * no[j]);
            j++;
        }
        total_amt = total;
        CGST = total_amt * 0.025;
        SGST = total_amt * 0.025;
        return total;
    }

    double get_SGST() {
        return SGST;
    }

    double get_CGST() {
        return CGST;
    }

}
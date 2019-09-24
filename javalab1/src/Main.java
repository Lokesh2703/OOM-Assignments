import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String C_name = inp.nextLine();
        String item_name = new String();
        Food food = new Food();
        Beverage beverage = new Beverage();
        item_name = inp.nextLine();
        // System.out.println(item_name);
        while (item_name.toLowerCase().compareTo("end")!=0){
            int l = item_name.lastIndexOf(" ");
            String cost = item_name.substring(l + 1);
            // System.out.println(cost);
            int num = Integer.parseInt(cost);
            // System.out.println(item_name);
            // int num =1;
            if (item_name.toLowerCase().contains("muffin")) {
                food.get_itemName(item_name, 85, num);
            } else if (item_name.toLowerCase().contains("cake")) {
                food.get_itemName(item_name, 400, num);
            } else if (item_name.toLowerCase().contains("pastry")) {
                food.get_itemName(item_name, 70, num);
            } else if (item_name.toLowerCase().contains("milk")) {
                beverage.get_itemName(item_name, 35, num);
            } else if (item_name.toLowerCase().contains("coffee")) {
                beverage.get_itemName(item_name, 30, num);
            } else if (item_name.toLowerCase().contains("pepsi") || item_name.toLowerCase().contains("sprite")
                    || item_name.toLowerCase().contains("maaza") || item_name.toLowerCase().contains("slice")) {
                beverage.get_itemName(item_name, 15, num);
            }
            item_name = inp.nextLine();
        }
        double amt = food.calculate_amt();
        double amt_b = beverage.calculate_amt();
        double SGST = food.SGST + beverage.SGST;
        double CGST = food.CGST + beverage.CGST;
        System.out.println("Customer name: " + C_name);
        System.out.println("Amount: Rs. " + (int)(amt + amt_b));
        System.out.println("SGST: Rs. " + (SGST));
        System.out.println("CGST: Rs. " + (CGST));
        System.out.println("Total: Rs. " + (amt + amt_b + SGST + CGST));
    }
}

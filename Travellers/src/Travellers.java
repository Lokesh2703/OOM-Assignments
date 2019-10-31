abstract public class Travellers {
    private String name;
    private int maxSpeed;

    Travellers(String name, String maxSpeed) {
        this.name = name;
        this.maxSpeed = Integer.parseInt(maxSpeed);
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    abstract public void Calc();
    abstract public void print();
}

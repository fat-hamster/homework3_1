public class Fruit {
    private double wight;

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return this.getClass().toString().replaceAll("class ", "") + " weight = " + this.getWight();
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Box extends Fruit {
    ArrayList<Fruit> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public Box(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
        for (Fruit fruit : fruits) {
            setWight(getWight() + fruit.getWight());
        }
    }

    public Box(Fruit[] fruits) {
        Collections.addAll(this.fruits, fruits);
        for (Fruit fruit : this.fruits) {
            setWight(getWight() + fruit.getWight());
        }
    }

    public void addFruit(Fruit fruit) {
        if(!this.fruits.isEmpty() && !isCompatible(fruit)) {
            System.out.println("Фрукты в коробке должны быть одного типа!");
            return;
        }
        this.fruits.add(fruit);
        this.setWight(this.getWight() + fruit.getWight());
    }

    public void addFruits(Box box) {
        if(!this.fruits.isEmpty() && !box.fruits.isEmpty() && !isCompatible(box.fruits.get(0))) {
            System.out.print("Добавить можно только");
            System.out.println(this.fruits.get(0).getClass().toString().replaceAll("class", ""));
            return;
        }
        this.fruits.addAll(box.fruits);
        box.removeAllFruits();
    }

    private boolean isCompatible(Fruit fruit) {
        if(this.fruits.isEmpty()) {
            return true; // не знаю как лучше :( наверное так.
                         // раз коробка пустая, то любые фрукты можно засыпать
        }
        return fruits.get(0).getClass().equals(fruit.getClass());
    }

    public void removeFruit() {
        if(this.fruits.size() > 0) {
            this.fruits.remove(this.fruits.size() - 1);
            setWight(getWight() - fruits.get(fruits.size() - 1).getWight());
        }
    }

    public void removeAllFruits() {
        if(this.fruits.size() > 0) {
            this.fruits.clear();
            setWight(0);
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }

    public boolean compare(Box box) {
        if (this.getWight() != box.getWight()) {
            return false;
        }
        return true;
    }
}

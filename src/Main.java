import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Integer[] source = new Integer[6];
        for (int i = 0; i < source.length; i++) {
            source[i] = new Random().nextInt(100);
        }
        Integer[] dest;

        dest = exchange(source, 5, 0);
        IntStream.range(0, dest.length).forEach(i -> {
            System.out.print(source[i]);
            System.out.print("\t" + dest[i]);
            System.out.println();
        });

        ArrayList<Integer> test = toArrayList(dest);

        System.out.println(test);


        Box box = new Box();
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        box.addFruit(new Apple());
        box.addFruit(new Apple());

        Box box1 = new Box();
        box1.addFruit(new Orange());
        box1.addFruit(new Orange());
        box1.addFruit(new Orange());
        box1.addFruit(new Orange());

        Box box2 = new Box();
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());

        System.out.println("Box1 " + box);
        System.out.println("Box2 " + box1);
        System.out.println("Box3 " + box2);
        System.out.println("Compare box with box1 - " + box2.compare(box1));

        box.addFruits(box1);
        box.addFruits(box2);

        System.out.println("Box1 " + box);
        System.out.println("Box2 " + box1);
        System.out.println("Box3 " + box2);
        System.out.println("Compare box with box1 - " + box2.compare(box1));
    }

    public static <T> T[] exchange(T[] objects, int source, int dest) {
        T[] tempObjects = objects.clone();

        if(dest >= objects.length || source >= objects.length) {
            return null;
        }

        tempObjects[dest] = objects[source];
        tempObjects[source] = objects[dest];
        return tempObjects;
    }

    public static <T> ArrayList<T> toArrayList(T[] elements) {
        ArrayList<T> arrayList = new ArrayList<>();

        Collections.addAll(arrayList, elements);
        return arrayList;
    }
}

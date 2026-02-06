import java.util.ListIterator;
import java.util.Scanner;

public class Exercise24_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();

        System.out.print("Enter five numbers: ");
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }

        ListIterator<Double> it = list.listIterator(2);
        it.next();
        it.set(10.55);

        ListIterator<Double> forward = list.listIterator();
        while (forward.hasNext()) {
            System.out.print(forward.next() + " ");
        }
        System.out.println();

        ListIterator<Double> backward = list.listIterator(list.size());
        while (backward.hasPrevious()) {
            System.out.print(backward.previous() + " ");
        }
        System.out.println();
    }
}

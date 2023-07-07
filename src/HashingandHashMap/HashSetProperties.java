package HashingandHashMap;
import java.util.HashSet;

public class HashSetProperties {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Find the elements that are common to both sets (Intersection)
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Find the elements that are in set1 but not in set2 (Set difference)
        HashSet<Integer> difference1 = new HashSet<>(set1);
        difference1.removeAll(set2);
        System.out.println("Set1 difference: " + difference1);

        // Find the elements that are in set2 but not in set1 (Set difference)
        HashSet<Integer> difference2 = new HashSet<>(set2);
        difference2.removeAll(set1);
        System.out.println("Set2 difference: " + difference2);
    }
}

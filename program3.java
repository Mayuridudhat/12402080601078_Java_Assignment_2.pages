import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        System.out.println("=== CRUD using ArrayList ===");
        List<String> list = new ArrayList<>();
        list.add("Apple"); list.add("Banana"); // Create
        System.out.println("Read List: " + list); // Read
        list.set(1, "Blueberry"); // Update
        list.remove("Apple"); // Delete
        System.out.println("After Update/Delete: " + list);

        System.out.println("\n=== CRUD using HashMap ===");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John"); map.put(2, "Jane"); // Create
        System.out.println("Read Map: " + map); // Read
        map.put(2, "Janet"); // Update
        map.remove(1); // Delete
        System.out.println("After Update/Delete: " + map);

        System.out.println("\n=== CRUD using TreeMap (Sorted Keys) ===");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 100); treeMap.put("Lion", 50); // Create
        System.out.println("Read TreeMap (Auto-sorted): " + treeMap); // Read
        treeMap.put("Lion", 60); // Update
        treeMap.remove("Zebra"); // Delete
        System.out.println("After Update/Delete: " + treeMap);
    }
}
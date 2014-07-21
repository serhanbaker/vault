/**
 * @serhanbaker, 21.Jul.2014.
 */
public class Test {
    public static void main(String[] args){
        HashTable<String, Integer> ht = new HashTable<String, Integer>();

        ht.put("banana", 165);
        ht.put("apple", 512);
        ht.put("pineapple", 423);
        ht.put("peanut", 789);

        System.out.println("apple: " + ht.get("apple"));
        System.out.println("banana: " + ht.get("banana"));

        System.out.println("invalid: " + ht.get("invalid")); // returns null

        ht.modify("banana", 1337);
        System.out.println("banana (modified): " + ht.get("banana"));

        ht.remove("apple");
        System.out.println("apple (deleted): " + ht.get("apple"));

        System.out.println("contains('soda'): " + ht.contains("soda"));
    }
}

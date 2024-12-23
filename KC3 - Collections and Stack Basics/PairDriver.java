public class PairDriver {
    public static void main(String[] args) {
        ArrayPair<String> stringPair = new ArrayPair<>("apple", "peach");

        System.out.println("First: " + stringPair.getFirst());
        System.out.println("Second: " + stringPair.getSecond());

        stringPair.setFirst("Blue");
        stringPair.setSecond("Orange");

        System.out.println("Modified 1: " + stringPair.getFirst());
        System.out.println("Modified 2: " + stringPair.getSecond());
    }
}

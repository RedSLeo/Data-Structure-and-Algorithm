
package ch07.trees;
import ch07.trees.BinarySearchTree;
import java.util.Random;

public class BSTDriver {
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); 

        minTest();
        heightTest();
        BSTExperiment();
    }

    static void minTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(15);
        bst.add(10);
        bst.add(8);
        bst.add(12);
        bst.add(20);
        bst.add(17);
        bst.add(25);

        System.out.println("Smallest element using min method: " + bst.min());
        System.out.println("Smallest element using min2 method: " + bst.min2());
    }

    static void heightTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        System.out.println("Recursive height of empty tree: " + bst.height());
        System.out.println("Iterative height of empty tree: " + bst.heightIterative());

        bst.add(75);
        System.out.println("After adding root (recursive height): " + bst.height());
        System.out.println("After adding root (iterative height): " + bst.heightIterative());

        bst.add(80);
        bst.add(25);
        bst.add(30);
        bst.add(98);
        bst.add(45);
        bst.add(17);
        bst.add(10);
        bst.add(55);

        System.out.println("Recursive height: " + bst.height());
        System.out.println("Iterative height: " + bst.heightIterative());
    }

    static void BSTExperiment() {
        Random random = new Random();
        int totalTrees = 10;
        int numNodes = 1000;
        int range = 3000;

        for (int i = 1; i <= totalTrees; i++) {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();

            for (int j = 0; j < numNodes; j++) {
                int randomValue = random.nextInt(range) + 1;
                bst.add(randomValue);
            }

            int height = bst.height();
            int minHeight = (int) Math.floor(Math.log(numNodes) / Math.log(2));
            double fRatio = bst.fRatio();

            System.out.printf("Tree %d:\n", i);
            System.out.printf("Height: %d\n", height);
            System.out.printf("Minimum height: %d\n", minHeight);
            System.out.printf("Fullness Ratio: %.2f\n", fRatio);
            System.out.println("-----------------------");
        }
    }

}

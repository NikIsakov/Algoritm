package Lesson6.HW6;

import Lesson6.Node;
import Lesson6.Tree;
import Lesson6.TreeImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HW {
    public static void main(String[] args) {
        int maxLevel = 6;
        int numberOfTrees = 20;
        int totalNode = (int) (Math.pow(2, maxLevel)-1);
        int min = -25;
        int max = 25;
        int balanceTree = 0;


        for (int i = 0; i<numberOfTrees;i++){
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevel);
            for (int j = 0; j < totalNode; j++){
                tree.add((int) (Math.random()*(max-min)+min));
            }
            if (tree.isBalanced()){
                balanceTree++;
            }
        }

        System.out.println("Процент несбалансированных деревьев: "+(numberOfTrees-balanceTree)/numberOfTrees*100+"%");
    }
}

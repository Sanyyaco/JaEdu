package com.edu.dataStructures.tree.mytree;

public class main {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
//        int[] array = {3,5,8,2,1,9,7,6,0,4};
//        for (int i : array){
//            tree.add(i);
//        }

        String[] array = {"c","e","d","a","l","b","k","n"};
        for (String i : array){
            tree.add(i);
        }

        tree.print();

        tree.delete("l");

        tree.print();
    }
}

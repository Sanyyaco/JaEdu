package com.edu.dataStructures.tree.treeset;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<String>();

        //add Comparator to constructor to define the order in which the elements get sorted
        Set<String> treeSetWithSortOrder = new TreeSet<>(Comparator.comparing(String::length));

        //TreeSet is not thread safe, synchronize it using wrapper:
        Set<String> syncTreeSet = Collections.synchronizedSet(treeSet);

        System.out.println("Element is added: " + treeSet.add("ABC"));
        System.out.println("Duplicate element is not added: " + !treeSet.add("ABC"));


    }
}

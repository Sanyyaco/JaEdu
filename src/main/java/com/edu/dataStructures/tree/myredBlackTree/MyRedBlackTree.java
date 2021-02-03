package com.edu.dataStructures.tree.myredBlackTree;

public class MyRedBlackTree {
    Node root;

    class Node{
        Object value;
        Node leftChild;
        Node rightChild;
        Node parent;
        boolean isRed = true;
        boolean isRoot = false;
    }

    public void addValues(Object... values){
        for (Object i : values){
            add(i);
        }
        rebalance();
    }

    public void add(Object value){
        if (root == null){
            root = new Node();
            root.value = value;
            root.isRoot = true;
            root.isRed = false;
        } else {
            add(root, value);
        }
    }

    private Node add(Node node, Object value){
        if (node.value.hashCode() < value.hashCode()){
            if (node.leftChild == null){
                node.leftChild = new Node();
                node.leftChild.value = value;
                node.leftChild.parent = node;
                return node.leftChild;
            } else {
                return add(node.leftChild, value);
            }
        } else {
            if (node.rightChild == null){
                node.rightChild = new Node();
                node.rightChild.value = value;
                node.rightChild.parent = node;
                return node.rightChild;
            } else {
                return add(node.rightChild, value);
            }
        }
    }

    private void rebalance(){
        rebalance(root);
    }

    private void rebalance(Node node){
        if(!node.isRoot && node.parent != null && node.parent.parent != null){
            if(node.isRed && node.parent.isRed && node.parent.rightChild == node && node.parent.parent.leftChild == node.parent){
                rotateLeft(node);
                rotateRight(node);
                swapColorWithRightChild(node);
            } else if (node.isRed && node.parent.isRed && node.parent.leftChild == node && node.parent.parent.leftChild == node.parent){
                rotateRight(node);
                swapColorWithRightChild(node);
            } else if (node.isRed && node.parent.isRed && node.parent.leftChild == node && node.parent.parent.rightChild == node.parent){
                rotateRight(node.parent);
                swapColorWithLeftChild(node.parent);
            } else if (node.isRed && node.parent.isRed && node.parent.leftChild == node && node.parent.parent.rightChild == node.parent){
                rotateRight(node);
                rotateLeft(node);
                swapColorWithLeftChild(node);
            }
        }
        if (node.leftChild != null) rebalance(node.leftChild);
        if (node.rightChild != null) rebalance(node.rightChild);
    }

    private void rotateLeft(Node node){
        Node grandParent = node.parent.parent;
        Node parent = node.parent;

        parent.rightChild = node.leftChild;
        grandParent.leftChild = node;
        node.leftChild = parent;

        parent.parent = node;
        node.parent = grandParent;
    }

    private void rotateRight(Node node){
        Node parent = node.parent;
        parent.leftChild = node.rightChild;
        node.rightChild = parent;
        node.parent = parent.parent;
        parent.parent = node;
    }

    private void swapColorWithRightChild(Node node){
        if(node.rightChild.isRed == false && node.isRed == true){
            node.rightChild.isRed = true;
            node.isRed = false;
        }
    }

    private void swapColorWithLeftChild(Node node){
        if(node.leftChild.isRed == false && node.isRed == true){
            node.rightChild.isRed = true;
            node.isRed = false;
        }
    }

    public void print(){
        print(root);
    }

    private void print(Node node){
        if (node.rightChild != null) print(node.rightChild);
        System.out.println("node.value " + node.value + ", node.isRed " + node.isRed + ", node.root " + node.isRoot);
        if (node.leftChild != null) print(node.leftChild);
    }

}

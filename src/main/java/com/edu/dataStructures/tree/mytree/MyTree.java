package com.edu.dataStructures.tree.mytree;

import java.util.ArrayList;
import java.util.List;

public class MyTree {
    private int size;
    Node root;
    class Node{
        private Object value;
        private Node rightChildren;
        private Node leftChildren;
    }

    public void add(Object value){
        if(root == null){
            root = new Node();
            root.value = value;
        } else {
            compareAndDirect(root, value);
        }
    }

    private void compareAndDirect(Node leafNode, Object newNodeValue){
        if(newNodeValue.hashCode() < leafNode.value.hashCode()){
            if (leafNode.leftChildren == null) {
                leafNode.leftChildren = new Node();
                leafNode.leftChildren.value = newNodeValue;
            } else {
                compareAndDirect(leafNode.leftChildren, newNodeValue);
            }
        } else {
            if (leafNode.rightChildren == null) {
                leafNode.rightChildren = new Node();
                leafNode.rightChildren.value = newNodeValue;
            } else {
                compareAndDirect(leafNode.rightChildren, newNodeValue);
            }
        }
    }

    public void print(){
        iterate(root, new PrintCommand());
        System.out.println();
    }

    private void iterate(Node root, Command command){

        if (root.leftChildren != null ){
            iterate(root.leftChildren, command);
        }

        command.execute(root.value);

        if (root.rightChildren != null ){
            iterate(root.rightChildren, command);
        }
    }

    List<Object> array;
    private void addToArray(Node root ){
        if (array == null){
            array = new ArrayList<Object>();
        }

        if (root.leftChildren != null ){
            addToArray(root.leftChildren);
        }

        array.add(root.value);

        if (root.rightChildren != null ){
            addToArray(root.rightChildren);
        }
    }

    public void delete (Object value){
        delete(value, root);
    }

    private void delete(Object deleteValue, Node root){
        if (root.value.hashCode() > deleteValue.hashCode()){
            delete (deleteValue, root.leftChildren);
        }
        if (root.value.hashCode() == deleteValue.hashCode()){
            addToArray(root.rightChildren);
            addToArray(root.leftChildren);
            root.value = array.get((array.size()-1)/2);
            array.remove((array.size()-1)/2);
            root.leftChildren = null;
            root.rightChildren = null;
            for (Object i: array){
                if(i != null){
                    add(i);
                }
            }
            return;
        }
        if (root.value.hashCode() < deleteValue.hashCode()){
            delete (deleteValue, root.rightChildren);
        }
    }

}

package com.edu.dataStructures.tree.mytree;

public class PrintCommand implements Command {
    public void execute(Object arg) {
        System.out.print(arg.toString() + " ");
    }
}

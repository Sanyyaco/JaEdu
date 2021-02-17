package com.edu.patterns.creational.prototype;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;


public class TreeTest {

    @Test
    public void copy() {
        Tree tree = new PlasticTree("a", "b", "c");
        Tree treeCopy = tree.copy();
        Assert.that(tree.getHeight()==treeCopy.getHeight(),"");
    }
}
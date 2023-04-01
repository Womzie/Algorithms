package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeTest {

    private GeneralTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new GeneralTree<>();
    }

    @Test
    void isInitiallyEmpty() {
        assertEquals("()", tree.toString());
    }

    @Test
    void setsRoot() {
        tree.setRoot(5);
        assertEquals("(5)", tree.toString());
    }

    @Test
    void addsFirstChild() {
        tree.setRoot(5);
        tree.addChild(5, 3);
        assertEquals("(5 (3))", tree.toString());
    }

    @Test
    void addsSecondChild() {
        tree.setRoot(5);
        tree.addChild(5, 3);
        tree.addChild(5, 2);
        assertEquals("(5 (3) (2))", tree.toString());
    }

    @Test
    void addsDeepChild() {
        tree.setRoot(4);
        tree.addChild(4, 7);
        tree.addChild(7, 2);
        assertEquals("(4 (7 (2)))", tree.toString());
    }

    @Test
    void producesStringForComplexTree() {
        tree.setRoot(1);
        tree.addChild(1, 2);
        tree.addChild(1, 3);
        tree.addChild(1, 4);
        tree.addChild(2, 5);
        tree.addChild(4, 6);
        tree.addChild(4, 7);
        tree.addChild(4, 8);
        assertEquals("(1 (2 (5)) (3) (4 (6) (7) (8)))", tree.toString());
    }

}
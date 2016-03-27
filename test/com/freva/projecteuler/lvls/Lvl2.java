package com.freva.projecteuler.lvls;

import com.freva.projecteuler.lvl2.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lvl2 {
    @Test
    public void testProblem051Solution() {
        assertEquals(new Problem051().solve(), 121313);
    }

    @Test
    public void testProblem052Solution() {
        assertEquals(new Problem052().solve(), 142857);
    }

    @Test
    public void testProblem053Solution() {
        assertEquals(new Problem053().solve(), 4075);
    }

    @Test
    public void testProblem054Solution() {
        assertEquals(new Problem054().solve(), 376);
    }

    @Test
    public void testProblem055Solution() {
        assertEquals(new Problem055().solve(), 249);
    }

    @Test
    public void testProblem056Solution() {
        assertEquals(new Problem056().solve(), 972);
    }

    @Test
    public void testProblem057Solution() {
        assertEquals(new Problem057().solve(), 153);
    }

    @Test
    public void testProblem058Solution() {
        assertEquals(new Problem058().solve(), 26241);
    }
}

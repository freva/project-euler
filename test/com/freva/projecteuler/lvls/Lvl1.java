package com.freva.projecteuler.lvls;

import com.freva.projecteuler.lvl1.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lvl1 {
    @Test
    public void testProblem026Solution() {
        assertEquals(new Problem026().solve(), 983);
    }

    @Test
    public void testProblem027Solution() {
        assertEquals(new Problem027().solve(), -59231);
    }

}

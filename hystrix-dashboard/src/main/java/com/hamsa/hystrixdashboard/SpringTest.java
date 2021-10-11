package com.hamsa.hystrixdashboard;


import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SpringTest {
    private Spring spring;

    @Before
    public void setUp() {
        spring = new Spring("ticker", TRUE, 12.45, 13.34, "srfgr");
    }

    private Spring successEqualsMock() {
        return new Spring("ticker", TRUE, 12.45, 13.34, "srfgr");
    }

    private Spring failureEqualsMock() {
        return new Spring("ticker12", TRUE, 12.45, 13.34, "srfgr");
    }

    private int successHashCodeMock() {
        return new Spring("ticker", TRUE, 12.45, 13.34, "srfgr").hashCode();
    }

    private int failureHashCodeMock() {
        return new Spring("ticker", TRUE, 12.45, 13.34, "srfgr").hashCode();
    }

    @Test
    public void testEqualsPositive() {
        Spring expectedSpring = successEqualsMock();
        assertEquals(spring, expectedSpring);
        assertEquals(expectedSpring.getAskPrice(), 13.34, 0.1);
    }

    @Test
    public void testEqualsNegative() {
        Spring expectedSpring = failureEqualsMock();
        assertNotEquals(spring, expectedSpring);
        assertNotEquals(expectedSpring.getTicker(), "ticker");
    }

    @Test
    public void testHashcodePositive() {
        Spring expectedSpring = successEqualsMock();
        assertEquals(spring.hashCode(), successHashCodeMock());
    }

    @Test
    public void testHashcodeNegative() {
        Spring expectedSpring = failureEqualsMock();
        assertNotEquals(spring.hashCode(), failureEqualsMock());
    }
}

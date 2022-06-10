package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.KeyStore;

import static org.junit.Assert.assertEquals;


public class rangetest {
    Range range = new Range(2, 15);


    @Test
    public void testCombine() {

        Range range1 = new Range(3, 8);
        Range range2 = new Range(2, 15);
        Range range4 = new Range(6, 20);

        Range range3 = new Range(5, 18);
        Range range5 = new Range(8, 28);
        Range range6 = new Range(2, 30);
        assertEquals(range, Range.combine(range1, range2));
        assertEquals(range, Range.combine(range3, range4));
        assertEquals(range, Range.combine(range5, range6));


    }


    @Test
    public void testConstrain() {

        Range range1 = new Range(8, 15);
        Range range2 = new Range(10, 20);


        assertEquals(8.3, range.constrain(8.3), 0);


    }


    @Test
    public void testContains() {

        Range range1 = new Range(8, 15);
        Range range2 = new Range(10, 20);

        //Assert.assertTrue(String.valueOf(true),range.contains(8.3));
        Assert.assertTrue(String.valueOf(true), range.contains(2));


    }


    @Test
    public void testgetlowerBound() {

        Range range1 = new Range(8, 15);


        double Rangge = 8;
        Assert.assertTrue(Rangge == range1.getLowerBound());


        //  Assert.assertTrue(2,range.getLowerBound());


    }


    @Test
    public void testgeupperBound() {

        Range range1 = new Range(8, 15);


        double Rangge = 15;
        Assert.assertTrue(Rangge == range1.getUpperBound());


        Range range2 = new Range(8, 15);


        double Range = 8;
        Assert.assertFalse(Rangge == range.getUpperBound());


    }


    @Test
    public void testGetLength() {
        Range range1 = new Range(10.0, 15.0);
        double R = 5.0;
        Assert.assertEquals(R, range1.getLength(), 0.0);
        Range range2 = new Range(-9.0, -3.0);
        double R2 = 6.0;
        Assert.assertEquals(R2, range2.getLength(), 0.0);
    }


    @Test
    public void testExpand() {
        Range range1 = new Range(2.0, 6.0);
        Range range2 = new Range(1.0, 8.0);
        Assert.assertEquals(range2, Range.expand(range1, 0.35, 0.57));
        Assert.assertThrows(InvalidParameterException.class, () ->
            Range.expand(null, 10,10));}



    @Test
    public void testExpandToInclude() {
        Range range = new Range(5.0, 11.0);
        Range range1 = new Range(5.0, 15.0);
        Assert.assertEquals(range1, Range.expandToInclude(range, 12.0));

        ///////////////////////////////////////////////////

        Range rrange2 = new Range(2.0, 6.0);
        Range Range2 = new Range(2.0, 8.0);
        Assert.assertEquals(Range2, Range.expandToInclude(rrange2, 5.0));
        ////////////////////////////////////////////
        Range R3 = new Range(200.0, 200.0);
        Assert.assertEquals(R3, Range.expandToInclude((Range) null, 200.0));
        Range r3 = new Range(5.0, 11.0);
        Range NR4 = new Range(5.0, 11.0);
        Assert.assertEquals(NR4, Range.expandToInclude(r3, 7.0));
    }

    @Test
    public void testGetCentralValue() {
        Range range1 = new Range(20.0, 20.0);
        double R = 20.0;
        Assert.assertTrue(R == range1.getCentralValue());
    }

    @Test
    public void testIntersects() {
        Range range1 = new Range(22.0, 27.0);
        Assert.assertTrue(range1.intersects(25.0, 26.0));
        Range range2 = new Range(9.0, 20.0);
        Assert.assertTrue(range2.intersects(15.0, 17.0));
        Range range3 = new Range(1.0, 10.0);
        Assert.assertFalse(range3.intersects(20.0, 30.0));
    }

    @Test
    public void testShift() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(4.0, 8.0);
        Assert.assertEquals(range2, Range.shift(range1, 3.0));
        Range range3 = new Range(2.0, 5.0);
        Range range4 = new Range(0.0, 3.0);
        Assert.assertEquals(range4, Range.shift(range3, -2.0));
        Range range5 = new Range(1.0, 5.0);
        Range range6 = new Range(6.0, 10.0);
        Assert.assertEquals(range6, Range.shift(range5, 5.0));
        Assert.assertThrows(InvalidParameterException.class, () -> {
            Range.shift((Range) null, 3);
        });
    }


    @Test
    public void testShift2() {
        Range range = new Range(-1.0, 5.0);
        Range Rangee = new Range(2.0, 9.0);
        Assert.assertEquals(Rangee, Range.shift(range, 4.0, true));
        Range range2 = new Range(-6.0, -3.0);
        Range R2 = new Range(-4.0, 0.0);
        Assert.assertEquals(R2, Range.shift(range2, 3.0, true));
        Range range3 = new Range(-8.0, -3.0);
        Range R3 = new Range(-10.0, -6.0);
        Assert.assertEquals(R3, Range.shift(range3, -3.0, true));



        Assert.assertThrows(InvalidParameterException.class, () -> {
            Range.shift((Range) null, -5.0);
        });

    }

    @Test
    public void ttestExpandToInclude() {
        Range r = new Range(5.0, 10.0);
        Range NR = new Range(5.0, 15.0);
        Assert.assertEquals(NR, Range.expandToInclude(r, 12.0));
        Range r2 = new Range(2.0, 6.0);
        Range NR2 = new Range(2.0, 8.0);
        Assert.assertEquals(NR2, Range.expandToInclude(r2, 5.0));
        Range NR3 = new Range(100.0, 100.0);
        Assert.assertEquals(NR3, Range.expandToInclude((Range)null, 100.0));
        Range r3 = new Range(5.0, 10.0);
        Range NR4 = new Range(5.0, 10.0);
        Assert.assertEquals(NR4, Range.expandToInclude(r3, 6.0));
    }


    @Test
    public void testEquals() {
        Range ra1 = new Range(7.0, 10.0);
        Range ra2 = new Range(7.0, 10.0);
        Assert.assertEquals(ra1, ra2);
        Assert.assertEquals(ra2, ra1);
        ra1 = new Range(3.0, 11.0);
        ra2 = new Range(1.0, 10.0);
        Assert.assertNotEquals(ra1, ra2);
        ra1 = new Range(0.2, 10.0);
        ra2 = new Range(8.0, 20.0);
        Assert.assertNotEquals(ra1, ra2);
        Assert.assertFalse(ra1.equals(0.0));
    }
}















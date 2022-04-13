package main;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static main.BeforeTest.calculator;

public class SubtractionTest {
    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {7, 3, 4},
                {-1, 2, -3},
                {4, -5, 9},
                {7.5, 3.4, 4.1}};
    }

    @Test(dataProvider = "provideNewData", groups = "AdditionSubtraction")
    public void testSubtraction(double a, double b, double result) {
        double sub = calculator.sub(a, b);
        Assert.assertEquals(result, sub);
    }
}
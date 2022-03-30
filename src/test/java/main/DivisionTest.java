package main;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {
    protected Calculator calculator;

    @BeforeMethod
    public void makeCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {1, 1, 1},
                {4, 2, 2},
                {3.14, 2.5, 1.256},
                {3, 2, 1.5}};
    }

    @DataProvider
    public Object[][] provideNewDataForNaN() {
        return new Object[][]{
                {1, 0, "Infinity"}};
    }

    @Test(dataProvider = "provideNewData")
    public void testDivision(double a, double b, double result) {
        double div = calculator.div(a, b);
        Assert.assertEquals(result, div);
    }

    @Test(dataProvider = "provideNewDataForNaN")
    public void testDivisionForNaN(double a, double b, String result) {
        String div = String.valueOf(calculator.div(a, b));
        Assert.assertEquals(result, div);
    }
}
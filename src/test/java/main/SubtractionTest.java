package main;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractionTest {
    protected Calculator calculator;

    @BeforeMethod
    public void makeCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {7, 3, 4},
                {-1, 2, -3},
                {4, -5, 9},
                {7.5, 3.4, 4.1}};
    }

    @Test(dataProvider = "provideNewData")
    public void testSubtraction(double a, double b, double result) {
        double sub = calculator.sub(a, b);
        Assert.assertEquals(result, sub);
    }
}
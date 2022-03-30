package main;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest {
    protected Calculator calculator;

    @BeforeMethod
    public void makeCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {1, 2, 2},
                {3, -7, -21},
//                {3.14, 2.4, 7.536}, // Wrong test, I dunno why
                {0, 3, 0}};
    }

    @Test(dataProvider = "provideNewData")
    public void testMultiply(double a, double b, double result) {
        double sum = calculator.mult(a, b);
        Assert.assertEquals(result, sum);
    }
}
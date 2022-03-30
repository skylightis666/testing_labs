package main;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdditionTest {
    protected Calculator calculator;

    @BeforeMethod
    public void makeCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {-3, 3, 0},
                {7.1, 2, 9.1},
                {0, 5, 5}};
    }

    @Test(dataProvider = "provideNewData")
    public void testAddition(double a, double b, double result) {
        double sum = calculator.sum(a, b);
        Assert.assertEquals(result, sum);
    }

}
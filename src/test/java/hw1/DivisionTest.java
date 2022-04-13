package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static hw1.BeforeTest.calculator;

public class DivisionTest {
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

    @Test(dataProvider = "provideNewData", groups = "MultiplyDivision")
    public void testDivision(double a, double b, double result) {
        double div = calculator.div(a, b);
        Assert.assertEquals(div, result);
    }

    @Test(dataProvider = "provideNewDataForNaN", groups = "MultiplyDivision")
    public void testDivisionForNaN(double a, double b, String result) {
        String div = String.valueOf(calculator.div(a, b));
        Assert.assertEquals(div, result);
    }
}
package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static hw1.BeforeTest.calculator;

public class AdditionTest {
    @DataProvider
    public Object[][] provideNewData() {
        return new Object[][]{
                {-3, 3, 0},
                {7.1, 2, 9.1},
                {0, 5, 5}};
    }

    @Test(dataProvider = "provideNewData", groups = "AdditionSubtraction")
    public void testAddition(double a, double b, double result) {
        double sum = calculator.sum(a, b);
        Assert.assertEquals(result, sum);
    }

}
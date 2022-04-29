package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeGroups;


public class BeforeTest {

    protected static Calculator calculator;

    @BeforeGroups(groups = {"AdditionSubtraction", "MultiplyDivision"})
    public void initCalculator() {
        calculator = new Calculator();
    }
}

package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorAddTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorAddTest.class);

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorAddTest.class");
        calculator = new Calculator();
    }

    @Test
    void addTestAsPositive() throws InterruptedException {
        LOGGER.info("Verify function add() as positive");

        int expectedResult = 5 + 6;
        Thread.sleep(2000);

        Assert.assertEquals(calculator.add(5,6), expectedResult, "Failed addTestAsPositive");
    }

    @Test(groups = "groupNegative")
    void addTestAsNegative() throws InterruptedException {
        LOGGER.info("Verify function add() as negative");

        int expectedResult = 5;
        Thread.sleep(3000);

        Assert.assertEquals(calculator.add(2,2), expectedResult, "Failed addTestAsNegative");
    }

    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorAddTest.class");
    }
}

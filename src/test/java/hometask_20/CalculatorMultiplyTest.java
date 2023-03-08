package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorMultiplyTest.class);

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorMultiplyTest.class");
        calculator = new Calculator();
    }

    @Test
    void multiplyTestAsPositive() throws InterruptedException {
        LOGGER.info("Verify function add() as positive");

        int expectedResult = 5 * 6;
        Thread.sleep(3000);

        Assert.assertEquals(calculator.multiply(5,6), expectedResult, "Failed multiplyTestAsPositive");
    }

    @Test(groups = "groupNegative")
    void multiplyTestAsNegative() throws InterruptedException {
        LOGGER.info("Verify function add() as negative");

        int expectedResult = 5 * 2;
        Thread.sleep(2000);

        Assert.assertEquals(calculator.multiply(3,2), expectedResult, "Failed multiplyTestAsNegative");
    }

    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorMultiplyTest.class");
    }
}

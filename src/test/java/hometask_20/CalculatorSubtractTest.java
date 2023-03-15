package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorSubtractTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorSubtractTest.class);

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorSubtractTest.class");
        calculator = new Calculator();
    }

    @Test
    void subtractTestAsPositive() throws InterruptedException {
        LOGGER.info("Verify function subtract() as positive");

        int expectedResult = 10 - 6;
        Thread.sleep(2000);

        Assert.assertEquals(calculator.subtract(10,6), expectedResult, "Failed subtractTestAsPositive");
    }

    @Test(groups = "groupNegative")
    void subtractTestAsNegative() throws InterruptedException {
        LOGGER.info("Verify function subtract() as negative");

        int expectedResult = 15 - 12;
        Thread.sleep(3000);

        Assert.assertEquals(calculator.subtract(10,6), expectedResult, "Failed subtractTestAsNegative");
    }

    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorSubtractTest.class");
    }
}

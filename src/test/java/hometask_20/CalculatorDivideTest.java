package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorDivideTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorDivideTest.class);

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorDivideTest.class");
        calculator = new Calculator();
    }

    @Test
    void divideTestAsPositive() throws InterruptedException {
        LOGGER.info("Verify function divide() as positive");

        double expectedResult = 20.5 / 4.5;
        Thread.sleep(2000);

        Assert.assertEquals(calculator.divide(20.5,4.5), expectedResult, "Failed divideTestAsPositive");
    }

    @Test(groups = "groupNegative")
    void divideTestAsNegative() throws InterruptedException {
        LOGGER.info("Verify function divide() as negative");

        double expectedResult = 20.5 / 8.5;
        Thread.sleep(3000);

        Assert.assertEquals(calculator.divide(20.5,5.5), expectedResult, "Failed divideTestAsNegative");
    }

    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorDivideTest.class");
    }
}

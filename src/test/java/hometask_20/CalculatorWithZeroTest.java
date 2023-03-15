package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorWithZeroTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorWithZeroTest.class);

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorWithZeroTest.class");
        calculator = new Calculator();
    }

    @Test
    @Parameters({ "number1" })
    void addWithZero(int number1) throws InterruptedException {
        LOGGER.info("Verify function add() with zero");

        int expectedResult = number1 + 0;
        Thread.sleep(2000);

        Assert.assertEquals(calculator.add(number1,0), expectedResult, "Failed addWithZero");
    }

    @Test
    @Parameters({ "number2" })
    void subtractWithZero(int number2) throws InterruptedException {
        LOGGER.info("Verify function subtract() with zero");

        int expectedResult = number2 - 0;
        Thread.sleep(3000);

        Assert.assertEquals(calculator.subtract(number2,0), expectedResult, "Failed subtractWithZero");
    }

    @Test
    @Parameters({ "number3" })
    void multiplyWithZero(int number3) throws InterruptedException {
        LOGGER.info("Verify function multiply() with zero");

        int expectedResult = number3 * 0;
        Thread.sleep(4000);

        Assert.assertEquals(calculator.multiply(number3,0), expectedResult, "Failed multiplyWithZero");
    }

    @Test(groups = "groupNegative")
    @Parameters({ "number4" })
    void divideWithZero(double number4) throws InterruptedException {
        LOGGER.info("Verify function divide() with zero");

        Double expectedResult = 0 / number4;
        Thread.sleep(5000);

        Assert.assertEquals(calculator.divide(number4,0), expectedResult, "Failed divideWithZero");
    }

    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorWithZeroTest.class");
    }
}

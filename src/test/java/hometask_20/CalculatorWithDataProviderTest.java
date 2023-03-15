package hometask_20;

import homework_20.Calculator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorWithDataProviderTest {

    private static final Logger LOGGER = Logger.getLogger(CalculatorWithDataProviderTest.class);

    private Calculator calculator;

    @BeforeMethod
    void setUp() {
        LOGGER.info("Launch method setUp() in CalculatorWithDataProviderTest.class");
        calculator = new Calculator();
    }

    @Test(dataProvider = "testData")
    void addWithDataProvider(Integer number1, Integer number2) throws InterruptedException {
        LOGGER.info("Verify function addWithDataProvider()");

        int expectedResult = number1 + number2;
        Thread.sleep(4000);

        Assert.assertEquals(calculator.add(number1,number2), expectedResult, "Failed addWithDataProvider");
    }

    @DataProvider(name = "testData")
    public static Object[] data() {
        return new Object[][]{ {1,3}, {4, 5}, {10,2}, {-6,-7}};
    }


    @AfterMethod
    void close() {
        LOGGER.info("Launch method close() in CalculatorWithDataProviderTest.class");
    }
}

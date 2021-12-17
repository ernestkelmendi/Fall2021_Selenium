package Class1;

import org.testng.annotations.Test;
import org.testng.Assert;

public class UseTestNg {
    /**
     * Use of TestNg:
     * 1. Helps to create Test Method
     * 2. Helps to assert the result
     *
     * Use of Selenium:
     * Helps to automate web testcases
     */


    // Test method (all Test method are executable
    @Test
    public void twoPlusTwoResult() {
        int result = 2 + 2;
        // result should be 4
        Assert.assertEquals(result, 5, "2 + 2 verification failed");
    }

    @Test
    public void threePlusThreeResult() {
        int result = 3 + 3;
        Assert.assertEquals(result, 6, "3 + 3 verification failed");
    }



}

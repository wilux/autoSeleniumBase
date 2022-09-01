package Tests;

import org.testng.annotations.Test;

/*
 *  Here Example Unit Test without Seleneium, just logical test code
 * */

public class UnitExampleTest {

    @Test(priority = 1)
    public void AloneCodeTest() {

        int n = 15;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");

            }

            if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("Fizz");
            }

            if (i % 5 == 0 && i % 3 != 0) {
                System.out.println("Buzz");
            }

            if (i % 3 != 0 || i % 5 != 0) {
                System.out.println(i);

            }
        }


    }


}


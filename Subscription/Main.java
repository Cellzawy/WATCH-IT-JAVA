import java.util.Calendar;

import static java.lang.Math.pow;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Calendar today= Calendar.getInstance();
        Subscription sub = new Subscription();
        sub.setPriceOfPlan(10);
        sub.CheckIfSubscriptionEnding(today);


    }
}
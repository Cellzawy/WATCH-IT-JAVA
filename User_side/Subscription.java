import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;

public class Subscription {
    Plan plan = new Plan();
    int PriceOfPlan ;
    static int countBasic=0;
    static int countStandard=0;
    static int countPremium=0;

    // Array[12] to calculate the revenue of each month
    int[] monthlyRevenue = new int[12];


    /**
     * Assign PriceOfPlan and set witch Subscription the user chose
     * @param priceOfPlan the amount of money the user chose */
    public void setPriceOfPlan(int priceOfPlan)
    {

        PriceOfPlan = priceOfPlan;
        setSubscription();
    }


    /**
     * This method compare the mount of money the user chose to witch type the money entered is sufficient for  */
    public void setSubscription()
    {
        if( PriceOfPlan ==  10)
        {
            plan.setTypeOfPlan("Basic");
            countBasic++;
        }
        else if(PriceOfPlan ==  15)
        {
            plan.setTypeOfPlan("Standard");
            countStandard++;
        }
        else if(PriceOfPlan ==  30)
        {
            plan.setTypeOfPlan("Premium");
            countPremium++;
        }
        else
        {
            plan.setTypeOfPlan("Unsubcribed");
        }
    }


    /**
     * Check if the user's subscription has ended
     * @param today to get the real life current time
     */
    public boolean CheckIfSubscriptionEnding(Calendar today)
    {
        try{
            int SECONDS_IN_A_DAY = 24 * 60 * 60;
            long diff =  today.getTimeInMillis() - plan.StartDate.getTimeInMillis();
            long diffSec = diff / 1000;
            long days = diffSec / SECONDS_IN_A_DAY;


            if( plan.numberOfMovies==0 || days == 0)
            {
                setPriceOfPlan(0);
                System.out.println("You have no movies or day left then your subscription has ended");
                return false;
            }
        }
        catch (NullPointerException nullPointerException)
        {
            System.out.println("You are  Unsubscribe");
            return false;
        }
        return true;
    }


    /**
     * If the remaining user's day or number of movies left is near the end
     * this method sends a warring
     * @param today to get the real life current time
     */
    public void Warring()
    {

        if(plan.numberOfMovies == 2 )
        {
            System.out.println("Be Alerted : You only have 2 movies left");
        }
    }

    /** Send current status of the user's subscription
     * @param today to get the real life current time
     */
    public void StatusSubscription(Calendar today)
    {
        try
        {
            System.out.println("Subscription: "+ plan.typeOfPlan+"     Number Of Movies left: "+plan.numberOfMovies);
            CalculateTime(today);
        }
        catch (NullPointerException nullPointerException)
        {
            System.out.println("Time left: No Time left");
        }
    }

    /** To calculate the days,the hours,the minutes and the seconds left
     * by using the different between the current time and the start date of the user's subscription
     * @param today to get the real life current time
     */
    public void CalculateTime(Calendar today)
    {
        int SECONDS_IN_A_DAY = 24 * 60 * 60;
        long diff =  today.getTimeInMillis() - plan.StartDate.getTimeInMillis();
        long diffSec = diff / 1000;
        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600); // % 24 not needed

        System.out.printf("Time left: %d days, %d hours, %d minutes and %d seconds\n", days, hours, minutes, seconds);
    }

    //Revenue from Subscription

    /**
     * @param planPrice
     */
    // When the user finally confirm the plan, then this function "insertToRevenue" shall be called
    public void insertToRevenue(int planPrice) {
        int currentMonth = LocalDate.now().getMonthValue();
        monthlyRevenue[currentMonth-1] += planPrice;
        //System.out.println(currentMonth);
    }

    /**
     * Obtaining the Highest monthly revenue of all 12 month
     * @return the Highest monthly revenue of all 12 month
     */
    // Obtaining the Highest monthly revenue of all
    public Month getHighestRevenue() {
        int [] arr = new int[12];
        arr = monthlyRevenue.clone();
        Arrays.sort(arr);
        return Month.of(arr[11]);
    }
}

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

public class Subscription {
    Plan plan = new Plan();
    int PriceOfPlan ; // basics = 10     standard = 15   premium = 30
    static int countBasic=0;
    static int countStandard=0;
    static int countPremium=0;

    // Array[12] to calculate the revenue of each month
    int[] monthlyRevenue = new int[12];


    public void setPriceOfPlan(int priceOfPlan)
    {
        PriceOfPlan = priceOfPlan;
        setSubcription();
    }

    public void setSubcription()
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

    public void CheckIfSubcriptionEnding(Calendar today)
    {
        int SECONDS_IN_A_DAY = 24 * 60 * 60;
        long diff =  today.getTimeInMillis() - plan.StartDate.getTimeInMillis();
        long diffSec = diff / 1000;
        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600); // % 24 not needed

        try{
            if( plan.numberOfMovies==0 || days == 0)
            {
                setPriceOfPlan(0);

            }
        }
        catch (NullPointerException nullPointerException)
        {
            System.out.println("Your current Subcription has ended");
        }
    }

    public void Warring(Calendar today)
    {
        int SECONDS_IN_A_DAY = 24 * 60 * 60;
        long diff =  today.getTimeInMillis() - plan.StartDate.getTimeInMillis();
        long diffSec = diff / 1000;
        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600); // % 24 not needed
        if(plan.numberOfMovies == 2 || days == 10)
        {
            System.out.println("Be Alerted : You only have 2 movies left");
        }
    }


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

    // When the user finally confirm the plan, then this function "insertToRevenue" shall be called
    public void insertToRevenue(int planPrice) {
        int currentMonth = LocalDate.now().getMonthValue();
        monthlyRevenue[currentMonth-1] += planPrice;
        //System.out.println(currentMonth);
    }

    // Obtaining the Highest monthly revenue of all
    public Month getHighestRevenue() {
        int [] arr = new int[12];
        arr = monthlyRevenue.clone();
        Arrays.sort(arr);
        return Month.of(arr[11]);
    }

}

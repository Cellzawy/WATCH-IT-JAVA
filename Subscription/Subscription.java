import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Subscription {
    Plan plan = new Plan();
    int PriceOfPlan ; // basics = 10     standard = 15   premium = 30
    LocalDate StartDate;

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
            StartDate = LocalDate.now();
            countBasic++;
        }
        else if(PriceOfPlan ==  15)
        {
            plan.setTypeOfPlan("Standard");
            StartDate = LocalDate.now();
            countStandard++;
        }
        else if(PriceOfPlan ==  30)
        {
            plan.setTypeOfPlan("Premium");
            StartDate = LocalDate.now();
            countPremium++;
        }
        else
        {
            plan.setTypeOfPlan("Unsubcribed");
            plan.days = 0;
            plan.numberOfMovies =0;
        }
    }


    public void SubcriptionEnding()
    {
        if( plan.numberOfMovies==0 || plan.days ==0)
        {
           setPriceOfPlan(0);
           System.out.println("Your current Subcription has ended");
        }
    }

    public void Warring(Plan plan)
    {
        if(plan.numberOfMovies == 2)
        {
            System.out.println("Be Alerted : You only have 2 movies left wi bsl ");
        }
    }
    public void StatusSubscription()
    {
        System.out.println("Subscription: "+ plan.typeOfPlan+"     Number Of Movies left: "+plan.numberOfMovies +"     Days left: "+plan.days);
    }


    //Revenue from Subscription

    /*
    public static int RevenueBasic ()
    {
        //27sb li kol shr

        return countBasic*10;
    }
    public static int RevenueStandard ()
    {
        //27sb li kol shr
        return countStandard*15;
    }
    public static int RevenuePremium ()
    {
        //27sb li kol shr
        return countPremium*30;
    }
    public static int TotalRevenue ()
    {
        return RevenueBasic() + RevenueStandard() + RevenuePremium();
    }
     */

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

import java.time.LocalDate;

public class Subscription {
    private Plan plan = new Plan() ;
    private  int PriceOfPlan ; // basics = 10     standard = 20    premium = 40

    int numberOfMovies;
    int days ;
    LocalDate StartDate;

    static int countBasic=0;
    static int countStandard=0;
    static int countPremium=0;


    public void checkSubcriptionValidity()
    {
        if(PriceOfPlan ==  10)
        {
            plan.setPlan("Basic");
            days = 30;
            StartDate = LocalDate.now();
            countBasic++;
        }
        else if(PriceOfPlan ==  20)
        {
            plan.setPlan("Standard");
            days = 30;
            StartDate = LocalDate.now();
            countStandard++;
        }
        else if(PriceOfPlan ==  40)
        {
            plan.setPlan("Premium");
            days = 30;
            StartDate = LocalDate.now();
            countPremium++;
        }
        else
        {
            plan.setPlan("Unknown");
            days = 0;
        }
    }

    public void setPriceOfPlan(int priceOfPlan)
    {
        PriceOfPlan = priceOfPlan;
        checkSubcriptionValidity();
    }

    public void SubcriptionEnding()
    {
        if( numberOfMovies==0 || days ==0)
        {
            plan.setPlan("Unkown");//change it to NULL
            System.out.println("Your current Subcription has ended");
        }
    }

    public  void Warring(Plan plan)
    {
        if(numberOfMovies == 2)
        {
            System.out.println("Be Alerted : You only have 2 movies left wi bsl ");
        }
    }
    public void SatuesSubscription()
    {
        System.out.println("Subscription: "+ plan.getPlan()+"     Number Of Movies left: "+numberOfMovies +"     Days left: "+days);
    }

    //Revenue from Subscription

    public static int RevenueBasic ()
    {
        //27sb li kol shr

        return countBasic*10;
    }
    public static int RevenueStandard ()
    {
        //27sb li kol shr
        return countStandard*20;
    }
    public static int RevenuePremium ()
    {
        //27sb li kol shr
        return countPremium*40;
    }
    public static int TotalRevenue ()
    {
        return RevenueBasic() + RevenueStandard() + RevenuePremium();
    }

}

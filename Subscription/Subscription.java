import java.time.LocalDate;

public class Subscription {
    private User user;
    private Plan plan ;
    private  int PriceOfPlan ; // basics = 10     standard = 20    premium = 40
    int numberOfMovies;
    int days ;
    LocalDate date;
    public void setPriceOfPlan(int priceOfPlan) {
        PriceOfPlan = priceOfPlan;
    }


    public void checkSubcriptionValidity(int user.ID)
    {
        if(PriceOfPlan ==  10)
        {
            plan.setPlan("Basic");
            days = 30;
            date = LocalDate.now();
        }
        else if(PriceOfPlan ==  20)
        {
            plan.setPlan("Standard");
            days = 30;
            date = LocalDate.now();
        }
        else if(PriceOfPlan ==  40)
        {
            plan.setPlan("Premium");
            days = 30;
            date = LocalDate.now();
        }
        else
        {
            plan.setPlan("Unknown");
            days = 0;
        }
    }

    public void SubcriptionEnding(int user.ID)
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
        System.out.println("Subscription: "+ plan.getPlan()+"\t"+"Number Of Movies left: "+numberOfMovies +"Days left: "+days);
    }
    
}

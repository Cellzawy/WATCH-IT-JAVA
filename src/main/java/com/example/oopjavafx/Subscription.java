package com.example.oopjavafx;

import java.time.LocalDate;

public class Subscription {

    private Plan plan = new Plan() ;
    private  int PriceOfPlan ; // basics = 10     standard = 20    premium = 30

    int numberOfMovies;
    int days ;
    LocalDate StartDate;

    static int countBasic=0;
    static int countStandard=0;
    static int countPremium=0;
    static int[] monthlyRevenue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};


    public Plan getPlan() {
        return plan;
    }
    public void checkSubscriptionValidity()
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
        else if(PriceOfPlan ==  30)
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
        checkSubscriptionValidity();
    }

    public void SubscriptionEnding()
    {
        if( numberOfMovies==0 || days ==0)
        {
            plan.setPlan("Unkown");//change it to NULL
            System.out.println("Your current Subcription has ended");
        }
    }

    public  void Warning(Plan plan)
    {
        if(numberOfMovies == 2)
        {
            System.out.println("Be Alerted : You only have 2 movies left wi bsl ");
        }
    }
    public void StatusSubscription()
    {
        System.out.println("Subscription: "+ plan.getPlan()+"     Number Of Movies left: "+numberOfMovies +"     Days left: "+days);
    }

    //Revenue from Subscription

    public void renewSubscription(User user) {
        days = 30;
        int currentMonth = LocalDate.now().getMonth().getValue();
        monthlyRevenue[currentMonth - 1] += PriceOfPlan;
    }

    public static int RevenueBasic ()
    {
        return countBasic*10;
    }
    public static int RevenueStandard ()
    {
        return countStandard*20;
    }
    public static int RevenuePremium ()
    {
        return countPremium*30;
    }
    public static int TotalRevenue ()
    {
        return RevenueBasic() + RevenueStandard() + RevenuePremium();
    }
}


public class Plan {

    /* Attributes */
    int numberOfMovies;        // Maximum Number of movies allowed to the user according to the plan type
    String typeOfPlan;               // The chosen plan
                    // Price of the plan
    int days;                  // hi3od i2l l7d wi hn3mlo m3a al GUI
    boolean is_subscribed;     // Determining if the user is still subscribed or not

    // A counter for each plan subscribed
    // will be accessed by the admin to see the most subscribed plan among


    /* End of Attributes*/


    public void setTypeOfPlan(String typeOfPlan)
    {
        this.typeOfPlan = typeOfPlan;
        checkPlanConstraints(this.typeOfPlan);
    }

     public void checkPlanConstraints(String plan)
     {
         if(plan.equals("Basic"))
         {
             days=30;
             numberOfMovies= 5;
         }
         else if(plan.equals("Standard"))
         {
             days=30;
             numberOfMovies= 10;
         }
         else if(plan.equals("Premium"))
         {
             days=30;
             numberOfMovies= 30;
         }
     }
}
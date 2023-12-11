import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;
public class Plan {

    /* Attributes */
    int numberOfMovies;        // Maximum Number of movies allowed to the user according to the plan type
    String typeOfPlan;               // The chosen plan
    Calendar StartDate;
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
             StartDate = Calendar.getInstance();
             numberOfMovies= 5;
         }
         else if(plan.equals("Standard"))
         {
             StartDate = Calendar.getInstance();
             numberOfMovies= 10;
         }
         else if(plan.equals("Premium"))
         {
             StartDate = Calendar.getInstance();
             numberOfMovies= 30;
         }
         else
         {
             StartDate = null;
             numberOfMovies =0;
         }
     }
}
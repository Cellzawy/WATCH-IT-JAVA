import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Admin user = new Admin();
        while(!user.loggedIn)  {
            System.out.println("Enter your email: ");
            user.setUser_email(in.next());
            System.out.println("Enter your password: ");
            user.setUser_password(in.next());
            user.loggedIn = true;
            System.out.println("Success, you logged in!");
            System.out.println("Most subbed plan : " + user.getMostSubbedPlan());
            System.out.println("Most revenue month : " + user.getMostRevMonth());

        }
    }
}

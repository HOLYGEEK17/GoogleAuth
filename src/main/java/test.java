import com.warrenstrange.googleauth.*;
import java.util.Scanner;

public class test {

    public static void main(String args[]) throws Exception {

        //  creates a new set of credentials for a user
        //  No user name is provided to the API and it is a responsibility of
        //  the caller to save it for later use during the authorisation phase.
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();

        String secretKey = key.getKey(); // the value of the shared secret

        System.out.println("key=" + secretKey);

        String url = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL("JobDiva", "JobDiva.com", key);
        System.out.println("url="+url);
        String authUrl = GoogleAuthenticatorQRGenerator.getOtpAuthURL("JobDiva", "JobDiva.com", key);
        System.out.println("url="+authUrl);

        int password = Integer.parseInt(getInput("Input 6-digit password"));
        boolean isCodeValid = gAuth.authorize(secretKey, password);
        System.out.println(isCodeValid);


//        System.out.println(gAuth.getTotpPassword(secretKey));
//        System.out.println(gAuth.getTotpPassword("6CGCFWFQ4F2F7PCJ"));

    }

    public static String getInput(String hint) {
        System.out.print(hint + ": ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}




















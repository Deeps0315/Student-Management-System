package SmartStudent;
import java.util.Scanner;

public class AdminService {
	private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean loginPrompt(Scanner sc) {
        System.out.println("=== Admin Login ===");

        System.out.print("Enter username: ");
        String inputUser = sc.nextLine();

        System.out.print("Enter password: ");
        String inputPass = sc.nextLine();

        return inputUser.equals(USERNAME) && inputPass.equals(PASSWORD);
}
}
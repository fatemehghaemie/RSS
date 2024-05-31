import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final String FILENAME = "fati.txt";
    private static ArrayList<String> rSS= new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);

        loadURLs();
        while(true) {
            System.out.println("click  number 1 for Adding a URL:");
            System.out.println("click  number 2 for Removing a URL:");
            System.out.println("click  number 3 for Showing  URLs;");
            System.out.println("click  number 4 for Exiting:");

            int choice = scanner1.nextInt();

            switch(choice) {
                case 1:
                    System.out.println(" please enter website URL to add:");
                    scanner1.nextLine();
                    String uRL = scanner1.nextLine();
                    if((!rSS.contains(uRL))) {
                        rSS.add(uRL);
                        saveURLs();
                        System.out.println("URL add");
                    } else {

                        System.out.println("URL is here.");
                    }
                    break;

                case 2:

                    System.out.println("Enter the URL name to remove:");
                    scanner1.nextLine();
                    String removeURL = scanner1.nextLine();
                    if(!(rSS.contains(removeURL))) {
                        rSS.remove(removeURL);
                        saveURLs();
                        System.out.println("URL removed ");
                    } else {

                        System.out.println("URL does not exist.");
                    }
                    break;

                case 3:
                    System.out.println("All  URLs  existing :");
                    for(String uRL1 : rSS) {
                        System.out.println(uRL1);
                    }
                    break;

                case 4:
                    System.out.println("Exit ");
                    scanner1.close();
                    System.exit(0);

                default:
                    System.out.println("error : our selected is not true.");
            }
        }
    }

    private static void saveURLs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {

            for (String uRL : rSS) {
                writer.println(uRL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadURLs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;

            while ((line = reader.readLine()) != null) {

                rSS.add(line);
            }
        } catch (IOException e) {

        }
    }
}

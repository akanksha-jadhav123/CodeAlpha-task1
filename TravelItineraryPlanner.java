import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    // A simple class to represent each destination
    static class Destination {
        String name;
        String date;
        String transportation;
        String accommodation;
        double budget;
        String weather;

        public Destination(String name, String date, String transportation, String accommodation, double budget, String weather) {
            this.name = name;
            this.date = date;
            this.transportation = transportation;
            this.accommodation = accommodation;
            this.budget = budget;
            this.weather = weather;
        }

        @Override
        public String toString() {
            return "\nDestination: " + name +
                    "\nDate: " + date +
                    "\nTransportation: " + transportation +
                    "\nAccommodation: " + accommodation +
                    "\nBudget: $" + budget +
                    "\nWeather: " + weather + "\n";
        }
    }

    // Main method for the itinerary planner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        double totalBudget = 0.0;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a destination to your itinerary");
            System.out.println("2. View your itinerary");
            System.out.println("3. Calculate total budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    addDestination(scanner, itinerary);
                    break;
                case 2:
                    viewItinerary(itinerary);
                    break;
                case 3:
                    calculateTotalBudget(itinerary);
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to add a destination to the itinerary
    public static void addDestination(Scanner scanner, ArrayList<Destination> itinerary) {
        System.out.print("Enter the destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the travel date (e.g., 2024-12-25): ");
        String date = scanner.nextLine();

        System.out.print("Enter transportation method (e.g., flight, car): ");
        String transportation = scanner.nextLine();

        System.out.print("Enter accommodation type (e.g., hotel, Airbnb): ");
        String accommodation = scanner.nextLine();

        System.out.print("Enter your estimated budget for this destination ($): ");
        double budget = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over

        // Simulate weather information (in a real app, you could fetch weather data from an API)
        System.out.print("Enter expected weather at this destination: ");
        String weather = scanner.nextLine();

        // Create a new Destination object and add it to the itinerary list
        Destination newDestination = new Destination(name, date, transportation, accommodation, budget, weather);
        itinerary.add(newDestination);

        System.out.println("Destination added to your itinerary!");
    }

    // Method to view the complete itinerary
    public static void viewItinerary(ArrayList<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty. Please add destinations first.");
        } else {
            System.out.println("\nYour Travel Itinerary:");
            for (Destination destination : itinerary) {
                System.out.println(destination);
            }
        }
    }

    // Method to calculate the total budget for all destinations in the itinerary
    public static void calculateTotalBudget(ArrayList<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty. Please add destinations first.");
        } else {
            double totalBudget = 0.0;
            for (Destination destination : itinerary) {
                totalBudget += destination.budget;
            }
            System.out.println("\nTotal Budget for your entire trip: $" + totalBudget);
        }
    }
}

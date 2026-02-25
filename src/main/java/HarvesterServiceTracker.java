import java.util.Scanner; // Import the Scanner class to read user input

public class HarvesterServiceTracker {

    public static void main(String[] args) {
        // Create a Scanner object to read from the keyboard
        Scanner input = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("W70 HARVESTER - DAILY ENTRY SYSTEM");
        System.out.println("=========================================\n");

        // 1. Collect Dynamic Data from the User
        System.out.print("Enter hours operated today: ");
        double hoursOperated = input.nextDouble();

        System.out.print("Enter rate charged per hour (Rs.): ");
        double ratePerHour = input.nextDouble();

        System.out.print("Enter diesel consumed today (Liters): ");
        double fuelConsumedLiters = input.nextDouble();

        System.out.print("Enter current diesel price per liter (Rs.): ");
        double dieselPricePerLiter = input.nextDouble();

        System.out.print("Enter current total engine hours: ");
        int totalEngineHours = input.nextInt();

        // 2. Process the Calculations
        int oilChangeInterval = 250; // This stays static as it's a fixed rule
        double grossRevenue = hoursOperated * ratePerHour;
        double totalFuelCost = fuelConsumedLiters * dieselPricePerLiter;
        double netProfit = grossRevenue - totalFuelCost;
        
        // Calculate hours until next service (assuming service every 250 hours)
        int hoursUntilService = oilChangeInterval - (totalEngineHours % oilChangeInterval);

        // 3. Output the Dynamic Report
        System.out.println("\n=========================================");
        System.out.println("FINANCIAL SUMMARY:");
        System.out.println("Gross Revenue:   Rs." + grossRevenue);
        System.out.println("Total Fuel Cost: Rs." + totalFuelCost);
        System.out.println("Net Profit:      Rs." + netProfit);
        System.out.println("\n MAINTENANCE STATUS:");
        
        if (hoursUntilService <= 10) {
            System.out.println("WARNING: Oil change due in " + hoursUntilService + " hours! Schedule maintenance immediately.");
        } else {
            System.out.println("Engine is healthy. Next service in: " + hoursUntilService + " hours.");
        }
        System.out.println("=========================================");

        // Close the scanner to prevent memory leaks
        input.close();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test1;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class CarbonFootprintCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to receive user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input relevant information
        System.out.println("Please enter the following information to calculate your carbon footprint:");

        // Energy usage
        System.out.print("Annual household energy consumption (kilowatt-hours): ");
        double energyUsage = scanner.nextDouble();

        // Mode of transportation
        System.out.print("Daily car mileage (kilometers): ");
        double carMileage = scanner.nextDouble();

        // Dietary habits
        System.out.print("Weekly consumption of beef and lamb (kilograms): ");
        double meatConsumption = scanner.nextDouble();

        // Shopping and lifestyle
        System.out.print("Number of times using plastic products per month: ");
        int plasticUsage = scanner.nextInt();

        // Waste management
        System.out.print("Weekly waste generation (kilograms): ");
        double weeklyWaste = scanner.nextDouble();

        // Tree planting and ecosystem protection
        System.out.print("Number of tree planting activities per year: ");
        int treePlanting = scanner.nextInt();

        // Calculate carbon footprint
        double carbonFootprint = calculateCarbonFootprint(energyUsage, carMileage, meatConsumption,
                plasticUsage, weeklyWaste, treePlanting);

        // Display the result
        System.out.println("\nYour annual carbon footprint is: " + carbonFootprint + " kgCO2e");

        // Close the Scanner
        scanner.close();
    }

    // Method to calculate the carbon footprint
    private static double calculateCarbonFootprint(double energyUsage, double carMileage,
            double meatConsumption, int plasticUsage, double weeklyWaste, int treePlanting) {
        // Calculate the carbon footprint based on the input data using appropriate formulas
        // This is just an example; actual calculations may require more complex models and data
        double carbonFootprint = energyUsage * 0.5 + carMileage * 0.1 + meatConsumption * 10
                + plasticUsage * 0.05 + weeklyWaste * 5 - treePlanting * 20;
        return carbonFootprint;
    }
}

class KeyFeature3 {
    public static void main(String[] args) {
    int UserInput;
    
    Scanner Input=new Scanner(System.in);
    System.out.println("CAT1: Transportation");
    System.out.println("CAT2: Agriculture");
    System.out.println("CAT3: Waste Management");
    System.out.println("CAT4: Food Production");
    System.out.println("CAT5: Water Usage");
    System.out.print("Please choose your Category: CAT");
    UserInput=Input.nextInt();
    System.out.println();
     
    switch (UserInput) {
        
        case 1: 
            String[] Transportation ={ 
                "Membership for RON97 petrol",
                "Monthly Pass for Public Transport",
                "Hybrid Car",
                "Electric Car/Bike",
                "Dynamo Powered Lights (bikes)",
                "Membership for regular service"};
            System.out.println("Suggested Purchase for Transportation: ");
            System.out.println();
            for (int i = 0; i < Transportation.length; i++) 
            {
                System.out.println((i+1)+". "+Transportation[i]);
            }
        break; 
        
        case 2: 
            String[] Agriculture = {
                "GPS-guided Tractors",
                "Drones & Satelites",
                "Cover Crop Mixtures",
                "Solar Panels & Wind Turbines",
                "Drip-irrigation water system",
                "Organic Fertilisers",
                "Biological Pest Control",
                "Soil Moisture Sensor",
                "No-Till Planters"
            };
            System.out.println("Suggested Investments for Agriculture: ");
            System.out.println();
            for (int i = 0; i < Agriculture.length; i++) 
            {
                System.out.println((i+1)+". "+Agriculture[i]);
            }
        break;
        
        case 3: 
            String[] WasteManagement = {
                "Reusable Bags",
                "Reusable Water Bottles",
                "Reusable Containers",
                "Compostable and Biodegradable Products",
                "Recycling Bins",
                "Eco-Friendly Cleaning Products",
                "Reusable cloth napkins",
                "Subscription Services for Sustainable Products",
                "Electronic Waste Recycling Services",
                "Home Composting Bins"};
            System.out.println("Suggested Products for Waste Management: ");
            System.out.println();
            for (int i = 0; i < WasteManagement.length; i++) 
            {
                System.out.println((i+1)+". "+WasteManagement[i]);
            }
        break;
        
        case 4: 
            String[] FoodProduction = {
                "Locally Sourced and Seasonal Foods",
                "Organic and Sustainable Products",
                "Choose Sustainable Seafood",
                "Support Eco-Friendly Packaging",
                "Consider Energy-Efficient Appliances"};
            System.out.println("Suggested Products for Food Management: ");
            System.out.println();
            for (int i = 0; i < FoodProduction.length; i++) 
            {
                System.out.println((i+1)+". "+FoodProduction[i]);
            }
        break;
        
        case 5: 
            String[] WaterUsage = {"Low-Flow Faucets and Aerators",
                "Water-Efficient Showerheads",
                "Smart Irrigation Systems",
                "Rain Barrels",
                "Water-Efficient Appliances",
                "Leak Detection Devices"};
            System.out.println("Suggested Products for Water Usage: ");
            System.out.println();
            for (int i = 0; i < WaterUsage.length; i++) 
            {
                System.out.println((i+1)+". "+WaterUsage[i]);
            }
        break;
    }
  }
}

class CarbonFootprintComparison {

    private final List<Double> platformData = new ArrayList<>();
    private final Map<String, List<Double>> userData = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public void startApp() {
        while (true) {
            System.out.println("1. Calculate and upload your carbon footprint data");
            System.out.println("2. Compare your data with others");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            int choice = getValidInput(1, 3);

            switch (choice) {
                case 1:
                    calculateAndUploadData();
                    break;
                case 2:
                    compareWithOthers();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
            }

            System.out.print("Do you want to continue? (Y/N): ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private int getValidInput(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }

    private void calculateAndUploadData() {
        System.out.print("Enter a name for your data: ");
        String dataName = scanner.next();

        System.out.print("Enter daily driving hours: ");
        double drivingHours = getValidDoubleInput();

        double carbonFootprint = calculateCarbonFootprint(drivingHours);

        System.out.println("Your daily carbon emission is: " + carbonFootprint + " units");

        // Upload the data
        uploadUserData(dataName, carbonFootprint);

        System.out.print("Do you want to upload another set of data? (Y/N): ");
        String uploadAnother = scanner.next();
        if (uploadAnother.equalsIgnoreCase("Y")) {
            calculateAndUploadData();
        }
    }

    private double getValidDoubleInput() {
        double value;
        while (true) {
            try {
                value = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return value;
    }

    private void uploadUserData(String dataName, double carbonFootprint) {
        if (!userData.containsKey(dataName)) {
            userData.put(dataName, new ArrayList<>());
        }

        userData.get(dataName).add(carbonFootprint);

        // Also add to the platform data for comparison
        platformData.add(carbonFootprint);

        System.out.println("Data '" + dataName + "' uploaded successfully!");
    }

    private void compareWithOthers() {
    if (platformData.isEmpty()) {
        System.out.println("No data available for comparison.");
        return;
    }

    System.out.println("Select the data to compare:");
    int index = 1;
    for (String dataName : userData.keySet()) {
        System.out.println(index + ". " + dataName);
        index++;
    }

    if (userData.isEmpty()) {
        System.out.println("No user data available. Please upload your data first.");
        return;
    }

    System.out.print("Enter the number of the data to be your temporary data for comparing: ");
    int selectedDataIndex = getValidInput(1, userData.size());

    List<String> dataNames = new ArrayList<>(userData.keySet());
    String selectedDataName = dataNames.get(selectedDataIndex - 1);
    List<Double> selectedUserData = userData.get(selectedDataName);

    int userRank = 1;
    for (List<Double> data : userData.values()) {
        if (Collections.max(selectedUserData) < Collections.max(data)) {
            userRank++;
        }
    }

    int totalUsers = userData.size();

    System.out.println("You are ranked " + userRank + " out of " + totalUsers + " users.");
}


    private double calculateCarbonFootprint(double drivingHours) {
        // This is just an example, assuming 2 units of carbon emission per hour of driving
        return drivingHours * 2;
    }
}

public class Test1 {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Test1() {
        // Initialize JFrame
        frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Add ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform user authentication (replace with your logic)
                if (authenticateUser(usernameField.getText(), new String(passwordField.getPassword()))) {
                    // If authentication is successful, show the main menu
                    showMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(3, 2)); // Use fully qualified name for GridLayout
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder
        panel.add(loginButton);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        // Replace this with your actual user authentication logic
        // For simplicity, let's assume a hardcoded username and password
        return "user".equals(username) && "password".equals(password);
    }

    private void showMainMenu() {
        // Remove the login GUI components
        frame.getContentPane().removeAll();

        // Create components for the main menu
        JButton calculatorButton = new JButton("Carbon Footprint Calculator");
        JButton suggestionsButton = new JButton("Suggestions");
        JButton comparisonButton = new JButton("Carbon Footprint Comparison");
        JButton backButton = new JButton("Back");
        JButton logoutButton = new JButton("Logout");

        // Add ActionListeners to the buttons
        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch CarbonFootprintCalculator
                CarbonFootprintCalculator.main(null);
            }
        });

        suggestionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch KeyFeature3 (Suggestions)
                KeyFeature3.main(null);
            }
        });

        comparisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Launch CarbonFootprintComparison
                CarbonFootprintComparison comparison = new CarbonFootprintComparison();
                comparison.startApp();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the login screen
                new Test1();
                // Dispose the current frame
                frame.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Log out and go back to the login screen
                new Test1();
                // Dispose the current frame
                frame.dispose();
            }
        });

        // Create a JPanel for the main menu
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new java.awt.GridLayout(5, 1)); // Use fully qualified name for GridLayout
        mainMenuPanel.add(calculatorButton);
        mainMenuPanel.add(suggestionsButton);
        mainMenuPanel.add(comparisonButton);
        mainMenuPanel.add(backButton);
        mainMenuPanel.add(logoutButton);

        // Add the main menu panel to the frame
        frame.getContentPane().add(mainMenuPanel);

        // Repaint the frame to show the main menu
        frame.revalidate();
        frame.repaint();
        
    }
    
        private void launchCalculator() {
        // Remove the main menu GUI components
        frame.getContentPane().removeAll();

        // Call the CarbonFootprintCalculator class
        CarbonFootprintCalculator.main(null);

        // Repaint the frame
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test1();
            }
        });
    }
}

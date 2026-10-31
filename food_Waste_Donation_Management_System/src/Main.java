import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.User;
import model.FoodDonation;
import model.DonationRequest;

import service.UserService;
import service.DonationService;
import service.RequestService;
import service.ReportService;
import ui.LoginApp;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        DonationService donationService = new DonationService();
        RequestService requestService = new RequestService();
        ReportService reportService = new ReportService();

        ArrayList<User> users = new ArrayList<>();
        ArrayList<FoodDonation> donations = new ArrayList<>();
        ArrayList<DonationRequest> requests = new ArrayList<>();

        int userId = 1;
        int donationId = 1;
        int requestId = 1;

        while (true) {

            System.out.println("\n===== FOOD WASTE DONATION MANAGEMENT SYSTEM =====");
            System.out.println("1. Donor");
            System.out.println("2. NGO / Volunteer");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                // =====================================================
                // DONOR SECTION
                // =====================================================

                case 1:

                    while (true) {

                        System.out.println("\n===== DONOR MENU =====");
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Back");

                        System.out.print("Enter your choice: ");
                        int donorChoice = scanner.nextInt();

                        switch (donorChoice) {

                            // ---------------- REGISTER ----------------

                            case 1:

                                scanner.nextLine();

                                System.out.print("Enter Name: ");
                                String name = scanner.nextLine();

                                System.out.print("Enter Email: ");
                                String email = scanner.nextLine();

                                System.out.print("Enter Phone: ");
                                String phone = scanner.nextLine();

                                System.out.print("Enter Password: ");
                                String password = scanner.nextLine();

                                User donor = new User(
                                        userId,
                                        name,
                                        email,
                                        phone,
                                        password,
                                        "DONOR"
                                );

                                userService.registerUser(donor);

                                users.add(donor);
                                userId++;

                                break;

                            // ---------------- LOGIN ----------------

                            case 2:

                                LoginApp.LoginResult loginResult =
                                        LoginApp.showLogin(userService);

                                User loggedInDonor = loginResult.getUser();

                                if (loggedInDonor != null &&
                                    loggedInDonor.getRole().equals("DONOR")) {

                                    System.out.println(
                                            "\nDonor login successful!"
                                    );

                                    System.out.println(
                                            "Welcome, " +
                                            loggedInDonor.getName() +
                                            "!"
                                    );

                                    // -------- DONOR DASHBOARD --------

                                    while (true) {

                                        System.out.println(
                                                "\n===== DONOR DASHBOARD ====="
                                        );

                                        System.out.println(
                                                "1. Post Food Donation"
                                        );

                                        System.out.println(
                                                "2. View My Donations"
                                        );

                                        System.out.println(
                                                "3. View Donation Status"
                                        );

                                        System.out.println(
                                                "4. Donation History"
                                        );

                                        System.out.println(
                                                "5. Logout"
                                        );

                                        System.out.print(
                                                "Enter your choice: "
                                        );

                                        int donorDashboardChoice =
                                                scanner.nextInt();

                                        switch (donorDashboardChoice) {

                                            // -------- POST FOOD --------

                                            case 1:

                                                scanner.nextLine();

                                                System.out.println(
                                                        "\n===== POST FOOD DONATION ====="
                                                );

                                                System.out.print(
                                                        "Enter Food Name: "
                                                );

                                                String foodName =
                                                        scanner.nextLine();

                                                System.out.print(
                                                        "Enter Food Type: "
                                                );

                                                String foodType =
                                                        scanner.nextLine();

                                                System.out.print(
                                                        "Enter Quantity: "
                                                );

                                                int quantity =
                                                        scanner.nextInt();

                                                scanner.nextLine();

                                                System.out.print(
                                                        "Enter Preparation Date (YYYY-MM-DD): "
                                                );

                                                LocalDate preparationDate =
                                                        LocalDate.parse(
                                                                scanner.nextLine()
                                                        );

                                                System.out.print(
                                                        "Enter Expiry Date (YYYY-MM-DD): "
                                                );

                                                LocalDate expiryDate =
                                                        LocalDate.parse(
                                                                scanner.nextLine()
                                                        );

                                                System.out.print(
                                                        "Enter Pickup Location: "
                                                );

                                                String pickupLocation =
                                                        scanner.nextLine();

                                                System.out.print(
                                                        "Enter Description: "
                                                );

                                                String description =
                                                        scanner.nextLine();

                                                FoodDonation donation =
                                                        new FoodDonation(
                                                                donationId,
                                                                loggedInDonor.getUserId(),
                                                                foodName,
                                                                foodType,
                                                                quantity,
                                                                preparationDate,
                                                                expiryDate,
                                                                pickupLocation,
                                                                description,
                                                                "AVAILABLE",
                                                                LocalDate.now()
                                                        );

                                                donationService.addDonation(
                                                        donation
                                                );

                                                donations.add(donation);

                                                donationId++;

                                                break;

                                            // -------- VIEW MY DONATIONS --------

                                            case 2:

                                                System.out.println(
                                                        "\n===== MY DONATIONS ====="
                                                );

                                                donationService.viewMyDonations(
                                                        loggedInDonor.getUserId()
                                                );

                                                break;

                                            // -------- STATUS --------

                                            case 3:

                                                System.out.println(
                                                        "\n===== DONATION STATUS ====="
                                                );

                                                donationService.viewMyDonations(
                                                        loggedInDonor.getUserId()
                                                );

                                                break;

                                            // -------- HISTORY --------

                                            case 4:

                                                System.out.println(
                                                        "\n===== DONATION HISTORY ====="
                                                );

                                                donationService.viewMyDonations(
                                                        loggedInDonor.getUserId()
                                                );

                                                break;

                                            // -------- LOGOUT --------

                                            case 5:

                                                System.out.println(
                                                        "Logged out successfully!"
                                                );

                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid choice."
                                                );
                                        }

                                        if (donorDashboardChoice == 5) {
                                            break;
                                        }
                                    }

                                } else {

                                    System.out.println(
                                            "Invalid email or password!"
                                    );
                                }

                                break;

                            // ---------------- BACK ----------------

                            case 3:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice."
                                );
                        }

                        if (donorChoice == 3) {
                            break;
                        }
                    }

                    break;


                // =====================================================
                // NGO SECTION
                // =====================================================

                case 2:

                    while (true) {

                        System.out.println(
                                "\n===== NGO / VOLUNTEER MENU ====="
                        );

                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Back");

                        System.out.print("Enter your choice: ");
                        int ngoChoice = scanner.nextInt();

                        switch (ngoChoice) {

                            // ---------------- REGISTER ----------------

                            case 1:

                                scanner.nextLine();

                                System.out.print("Enter Name: ");
                                String ngoName = scanner.nextLine();

                                System.out.print("Enter Email: ");
                                String ngoEmail = scanner.nextLine();

                                System.out.print("Enter Phone: ");
                                String ngoPhone = scanner.nextLine();

                                System.out.print("Enter Password: ");
                                String ngoPassword = scanner.nextLine();

                                User ngo = new User(
                                        userId,
                                        ngoName,
                                        ngoEmail,
                                        ngoPhone,
                                        ngoPassword,
                                        "NGO"
                                );

                                userService.registerUser(ngo);

                                users.add(ngo);
                                userId++;

                                break;

                            // ---------------- LOGIN ----------------

                            case 2:

                                LoginApp.LoginResult ngoLoginResult =
                                        LoginApp.showLogin(userService);

                                User loggedInNGO = ngoLoginResult.getUser();

                                if (loggedInNGO != null &&
                                    loggedInNGO.getRole().equals("NGO")) {

                                    System.out.println(
                                            "\nNGO login successful!"
                                    );

                                    System.out.println(
                                            "Welcome, " +
                                            loggedInNGO.getName() +
                                            "!"
                                    );

                                    // -------- NGO DASHBOARD --------

                                    while (true) {

                                        System.out.println(
                                                "\n===== NGO DASHBOARD ====="
                                        );

                                        System.out.println(
                                                "1. View Available Food"
                                        );

                                        System.out.println(
                                                "2. View Food Details"
                                        );

                                        System.out.println(
                                                "3. Request Food"
                                        );

                                        System.out.println(
                                                "4. View My Requests"
                                        );

                                        System.out.println(
                                                "5. Track Request Status"
                                        );

                                        System.out.println(
                                                "6. Logout"
                                        );

                                        System.out.print(
                                                "Enter your choice: "
                                        );

                                        int ngoDashboardChoice =
                                                scanner.nextInt();

                                        switch (ngoDashboardChoice) {

                                            // ------ AVAILABLE FOOD ------

                                            case 1:

                                                System.out.println(
                                                        "\n===== AVAILABLE FOOD ====="
                                                );

                                                donationService
                                                        .viewAvailableDonations();

                                                break;


                                            // ------ FOOD DETAILS ------

                                            case 2:

                                                System.out.print(
                                                        "Enter Donation ID: "
                                                );

                                                int detailsId =
                                                        scanner.nextInt();

                                                boolean detailsFound = false;

                                                for (FoodDonation d : donations) {

                                                    if (d.getDonationId() ==
                                                            detailsId) {

                                                        System.out.println(
                                                                "\n===== FOOD DETAILS ====="
                                                        );

                                                        System.out.println(
                                                                "Donation ID: " +
                                                                d.getDonationId()
                                                        );

                                                        System.out.println(
                                                                "Food Name: " +
                                                                d.getFoodName()
                                                        );

                                                        System.out.println(
                                                                "Food Type: " +
                                                                d.getFoodType()
                                                        );

                                                        System.out.println(
                                                                "Quantity: " +
                                                                d.getQuantity()
                                                        );

                                                        System.out.println(
                                                                "Preparation Date: " +
                                                                d.getPreparationDate()
                                                        );

                                                        System.out.println(
                                                                "Expiry Date: " +
                                                                d.getExpiryDate()
                                                        );

                                                        System.out.println(
                                                                "Pickup Location: " +
                                                                d.getPickupLocation()
                                                        );

                                                        System.out.println(
                                                                "Description: " +
                                                                d.getDescription()
                                                        );

                                                        System.out.println(
                                                                "Status: " +
                                                                d.getStatus()
                                                        );

                                                        detailsFound = true;
                                                        break;
                                                    }
                                                }

                                                if (!detailsFound) {

                                                    System.out.println(
                                                            "Donation not found!"
                                                    );
                                                }

                                                break;


                                            // ------ REQUEST FOOD ------

                                            case 3:

                                                System.out.print(
                                                        "Enter Donation ID: "
                                                );

                                                int requestedDonationId =
                                                        scanner.nextInt();

                                                boolean donationFound = false;

                                                for (FoodDonation d : donations) {

                                                    if (d.getDonationId() ==
                                                            requestedDonationId &&
                                                        d.getStatus()
                                                            .equals("AVAILABLE")) {

                                                        DonationRequest request =
                                                                new DonationRequest(
                                                                        requestId,
                                                                        requestedDonationId,
                                                                        loggedInNGO.getUserId(),
                                                                        LocalDate.now(),
                                                                        "PENDING"
                                                                );

                                                        requestService.addRequest(
                                                                request
                                                        );

                                                        requests.add(request);

                                                        d.setStatus("REQUESTED");

                                                        requestId++;

                                                        donationFound = true;

                                                        break;
                                                    }
                                                }

                                                if (!donationFound) {

                                                    System.out.println(
                                                            "Food donation not available!"
                                                    );
                                                }

                                                break;


                                            // ------ MY REQUESTS ------

                                            case 4:

                                                System.out.println(
                                                        "\n===== MY REQUESTS ====="
                                                );

                                                requestService.viewMyRequests(
                                                        loggedInNGO.getUserId()
                                                );

                                                break;


                                            // ------ TRACK STATUS ------

                                            case 5:

                                                System.out.print(
                                                        "Enter Request ID: "
                                                );

                                                int trackRequestId =
                                                        scanner.nextInt();

                                                requestService
                                                        .trackRequestStatus(
                                                                trackRequestId
                                                        );

                                                break;


                                            // ------ LOGOUT ------

                                            case 6:

                                                System.out.println(
                                                        "Logged out successfully!"
                                                );

                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid choice."
                                                );
                                        }

                                        if (ngoDashboardChoice == 6) {
                                            break;
                                        }
                                    }

                                } else {

                                    System.out.println(
                                            "Invalid email or password!"
                                    );
                                }

                                break;


                            // ---------------- BACK ----------------

                            case 3:

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice."
                                );
                        }

                        if (ngoChoice == 3) {
                            break;
                        }
                    }

                    break;


                // =====================================================
                // ADMIN SECTION
                // =====================================================

                case 3:

                    LoginApp.LoginResult adminLoginResult =
                            LoginApp.showLogin(userService);

                    if (adminLoginResult.isAdmin()) {

                        System.out.println(
                                "\nAdmin login successful!"
                        );

                        // -------- ADMIN DASHBOARD --------

                        while (true) {

                            System.out.println(
                                    "\n===== ADMIN DASHBOARD ====="
                            );

                            System.out.println("1. View All Users");
                            System.out.println("2. View All Donations");
                            System.out.println("3. View Food Requests");
                            System.out.println("4. Approve Request");
                            System.out.println("5. Reject Request");
                            System.out.println("6. Reports");
                            System.out.println("7. Logout");

                            System.out.print(
                                    "Enter your choice: "
                            );

                            int adminChoice =
                                    scanner.nextInt();

                            switch (adminChoice) {

                                // ------ USERS ------

                                case 1:

                                    System.out.println(
                                            "\n===== ALL USERS ====="
                                    );

                                    for (User u : users) {

                                        System.out.println(
                                                "User ID: " +
                                                u.getUserId()
                                        );

                                        System.out.println(
                                                "Name: " +
                                                u.getName()
                                        );

                                        System.out.println(
                                                "Email: " +
                                                u.getEmail()
                                        );

                                        System.out.println(
                                                "Phone: " +
                                                u.getPhone()
                                        );

                                        System.out.println(
                                                "Role: " +
                                                u.getRole()
                                        );

                                        System.out.println(
                                                "-----------------------------"
                                        );
                                    }

                                    break;


                                // ------ DONATIONS ------

                                case 2:

                                    System.out.println(
                                            "\n===== ALL DONATIONS ====="
                                    );

                                    for (FoodDonation d : donations) {

                                        System.out.println(
                                                "Donation ID: " +
                                                d.getDonationId()
                                        );

                                        System.out.println(
                                                "Food Name: " +
                                                d.getFoodName()
                                        );

                                        System.out.println(
                                                "Quantity: " +
                                                d.getQuantity()
                                        );

                                        System.out.println(
                                                "Status: " +
                                                d.getStatus()
                                        );

                                        System.out.println(
                                                "-----------------------------"
                                        );
                                    }

                                    break;


                                // ------ REQUESTS ------

                                case 3:

                                    System.out.println(
                                            "\n===== FOOD REQUESTS ====="
                                    );

                                    for (DonationRequest r : requests) {

                                        System.out.println(
                                                "Request ID: " +
                                                r.getRequestId()
                                        );

                                        System.out.println(
                                                "Donation ID: " +
                                                r.getDonationId()
                                        );

                                        System.out.println(
                                                "NGO ID: " +
                                                r.getNgoId()
                                        );

                                        System.out.println(
                                                "Request Date: " +
                                                r.getRequestDate()
                                        );

                                        System.out.println(
                                                "Status: " +
                                                r.getStatus()
                                        );

                                        System.out.println(
                                                "-----------------------------"
                                        );
                                    }

                                    break;


                                // ------ APPROVE ------

                                case 4:

                                    System.out.print(
                                            "Enter Request ID to approve: "
                                    );

                                    int approveId =
                                            scanner.nextInt();

                                    boolean approved = false;

                                    for (DonationRequest r : requests) {

                                        if (r.getRequestId() ==
                                                approveId) {

                                            r.setStatus("APPROVED");

                                            for (FoodDonation d : donations) {

                                                if (d.getDonationId() ==
                                                        r.getDonationId()) {

                                                    d.setStatus(
                                                            "APPROVED"
                                                    );

                                                    break;
                                                }
                                            }

                                            approved = true;

                                            System.out.println(
                                                    "Request approved successfully!"
                                            );

                                            break;
                                        }
                                    }

                                    if (!approved) {

                                        System.out.println(
                                                "Request not found!"
                                        );
                                    }

                                    break;


                                // ------ REJECT ------

                                case 5:

                                    System.out.print(
                                            "Enter Request ID to reject: "
                                    );

                                    int rejectId =
                                            scanner.nextInt();

                                    boolean rejected = false;

                                    for (DonationRequest r : requests) {

                                        if (r.getRequestId() ==
                                                rejectId) {

                                            r.setStatus("REJECTED");

                                            for (FoodDonation d : donations) {

                                                if (d.getDonationId() ==
                                                        r.getDonationId()) {

                                                    d.setStatus(
                                                            "AVAILABLE"
                                                    );

                                                    break;
                                                }
                                            }

                                            rejected = true;

                                            System.out.println(
                                                    "Request rejected successfully!"
                                            );

                                            break;
                                        }
                                    }

                                    if (!rejected) {

                                        System.out.println(
                                                "Request not found!"
                                        );
                                    }

                                    break;


                                // ------ REPORTS ------

                                case 6:

                                    System.out.println(
                                            "\n===== SYSTEM REPORTS ====="
                                    );

                                    reportService.showUserReport(users);

                                    System.out.println();

                                    reportService.showDonationReport(
                                            donations
                                    );

                                    System.out.println();

                                    reportService.showRequestReport(
                                            requests
                                    );

                                    break;


                                // ------ LOGOUT ------

                                case 7:

                                    System.out.println(
                                            "Logged out successfully!"
                                    );

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid choice."
                                    );
                            }

                            if (adminChoice == 7) {
                                break;
                            }
                        }

                    } else {

                        System.out.println(
                                "Invalid admin username or password!"
                        );
                    }

                    break;


                // =====================================================
                // EXIT
                // =====================================================

                case 4:

                    System.out.println(
                            "\nThank you for using the system!"
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }
}
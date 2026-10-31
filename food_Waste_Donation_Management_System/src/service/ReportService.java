package service;

import java.util.ArrayList;
import model.User;
import model.FoodDonation;
import model.DonationRequest;

public class ReportService {

    // Display total number of users
    public void showUserReport(ArrayList<User> users) {

        int totalUsers = users.size();

        int totalDonors = 0;
        int totalNGOs = 0;

        for (User user : users) {

            if (user.getRole().equals("DONOR")) {
                totalDonors++;
            }

            if (user.getRole().equals("NGO")) {
                totalNGOs++;
            }
        }

        System.out.println("===== USER REPORT =====");
        System.out.println("Total Users: " + totalUsers);
        System.out.println("Total Donors: " + totalDonors);
        System.out.println("Total NGOs: " + totalNGOs);
    }

    // Display food donation report
    public void showDonationReport(ArrayList<FoodDonation> donations) {

        int totalDonations = donations.size();
        int availableDonations = 0;
        int collectedDonations = 0;

        for (FoodDonation donation : donations) {

            if (donation.getStatus().equals("AVAILABLE")) {
                availableDonations++;
            }

            if (donation.getStatus().equals("COLLECTED")) {
                collectedDonations++;
            }
        }

        System.out.println("===== DONATION REPORT =====");
        System.out.println("Total Food Donations: " + totalDonations);
        System.out.println("Available Donations: " + availableDonations);
        System.out.println("Collected Donations: " + collectedDonations);
    }

    // Display request report
    public void showRequestReport(ArrayList<DonationRequest> requests) {

        int pendingRequests = 0;
        int approvedRequests = 0;
        int rejectedRequests = 0;

        for (DonationRequest request : requests) {

            if (request.getStatus().equals("PENDING")) {
                pendingRequests++;
            }

            if (request.getStatus().equals("APPROVED")) {
                approvedRequests++;
            }

            if (request.getStatus().equals("REJECTED")) {
                rejectedRequests++;
            }
        }

        System.out.println("===== REQUEST REPORT =====");
        System.out.println("Pending Requests: " + pendingRequests);
        System.out.println("Approved Requests: " + approvedRequests);
        System.out.println("Rejected Requests: " + rejectedRequests);
    }
}
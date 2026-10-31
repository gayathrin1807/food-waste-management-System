package service;

import java.util.ArrayList;
import model.FoodDonation;

public class DonationService {

    private ArrayList<FoodDonation> donations = new ArrayList<>();

    // Add a new food donation
    public void addDonation(FoodDonation donation) {
        donations.add(donation);
        System.out.println("Food donation added successfully!");
    }

    // View donations posted by a particular donor
    public void viewMyDonations(int donorId) {

        for (FoodDonation donation : donations) {

            if (donation.getDonorId() == donorId) {

                System.out.println("Donation ID: " + donation.getDonationId());
                System.out.println("Food Name: " + donation.getFoodName());
                System.out.println("Food Type: " + donation.getFoodType());
                System.out.println("Quantity: " + donation.getQuantity());
                System.out.println("Preparation Date: " + donation.getPreparationDate());
                System.out.println("Expiry Date: " + donation.getExpiryDate());
                System.out.println("Pickup Location: " + donation.getPickupLocation());
                System.out.println("Description: " + donation.getDescription());
                System.out.println("Status: " + donation.getStatus());
                System.out.println("-----------------------------");
            }
        }
    }

    // View all available food donations
    public void viewAvailableDonations() {

        for (FoodDonation donation : donations) {

            if (donation.getStatus().equals("AVAILABLE")) {

                System.out.println("Donation ID: " + donation.getDonationId());
                System.out.println("Food Name: " + donation.getFoodName());
                System.out.println("Food Type: " + donation.getFoodType());
                System.out.println("Quantity: " + donation.getQuantity());
                System.out.println("Pickup Location: " + donation.getPickupLocation());
                System.out.println("Expiry Date: " + donation.getExpiryDate());
                System.out.println("-----------------------------");
            }
        }
    }
}
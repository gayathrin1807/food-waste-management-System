package model;

import java.time.LocalDate;

public class FoodDonation {

    private int donationId;
    private int donorId;
    private String foodName;
    private String foodType;
    private int quantity;
    private LocalDate preparationDate;
    private LocalDate expiryDate;
    private String pickupLocation;
    private String description;
    private String status;
    private LocalDate createdAt;

    public FoodDonation(int donationId, int donorId, String foodName,
                        String foodType, int quantity,
                        LocalDate preparationDate, LocalDate expiryDate,
                        String pickupLocation, String description,
                        String status, LocalDate createdAt) {

        this.donationId = donationId;
        this.donorId = donorId;
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.preparationDate = preparationDate;
        this.expiryDate = expiryDate;
        this.pickupLocation = pickupLocation;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPreparationDate() {
        return preparationDate;
    }

    public void setPreparationDate(LocalDate preparationDate) {
        this.preparationDate = preparationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
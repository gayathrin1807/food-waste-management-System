package model;

public class Donor extends User {

    private String donorType;

    public Donor(int userId, String name, String email, String phone,
                 String password, String role, String donorType) {

        super(userId, name, email, phone, password, role);
        this.donorType = donorType;
    }

    public String getDonorType() {
        return donorType;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }
}
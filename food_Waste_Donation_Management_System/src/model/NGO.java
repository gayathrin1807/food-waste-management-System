package model;

public class NGO extends User {

    private String organizationName;

    public NGO(int userId, String name, String email, String phone,
               String password, String role, String organizationName) {

        super(userId, name, email, phone, password, role);
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
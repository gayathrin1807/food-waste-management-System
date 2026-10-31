package model;

import java.time.LocalDate;

public class DonationRequest {

    private int requestId;
    private int donationId;
    private int ngoId;
    private LocalDate requestDate;
    private String status;

    public DonationRequest(int requestId, int donationId, int ngoId,
                           LocalDate requestDate, String status) {

        this.requestId = requestId;
        this.donationId = donationId;
        this.ngoId = ngoId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getNgoId() {
        return ngoId;
    }

    public void setNgoId(int ngoId) {
        this.ngoId = ngoId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
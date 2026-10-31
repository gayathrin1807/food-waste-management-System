package service;

import java.util.ArrayList;
import model.DonationRequest;

public class RequestService {

    private ArrayList<DonationRequest> requests = new ArrayList<>();

    // Add a new food request
    public void addRequest(DonationRequest request) {
        requests.add(request);
        System.out.println("Food request submitted successfully!");
    }

    // View requests made by a particular NGO
    public void viewMyRequests(int ngoId) {

        for (DonationRequest request : requests) {

            if (request.getNgoId() == ngoId) {

                System.out.println("Request ID: " + request.getRequestId());
                System.out.println("Donation ID: " + request.getDonationId());
                System.out.println("Request Date: " + request.getRequestDate());
                System.out.println("Status: " + request.getStatus());
                System.out.println("-----------------------------");
            }
        }
    }

    // Track the status of a particular request
    public void trackRequestStatus(int requestId) {

        for (DonationRequest request : requests) {

            if (request.getRequestId() == requestId) {

                System.out.println("Request ID: " + request.getRequestId());
                System.out.println("Donation ID: " + request.getDonationId());
                System.out.println("Status: " + request.getStatus());
                return;
            }
        }

        System.out.println("Request not found!");
    }
}
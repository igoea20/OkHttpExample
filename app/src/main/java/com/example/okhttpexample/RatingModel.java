package com.example.okhttpexample;

public class RatingModel {

    private int RatingId;
    private String ClientEmail;
    private String SupplierEmail;
    private int RatingNumber;
    private String RatingComment;


    //constructors
    public RatingModel(int ratingId, String clientEmail,
                      String supplierEmail,  int ratingNumber,String ratingComment) {
        RatingId = ratingId;
        ClientEmail = clientEmail;
        SupplierEmail = supplierEmail;
        RatingNumber = ratingNumber;
        RatingComment = ratingComment;
    }

    //public SupplierModel() {
    //}

    //toString for printing data
    // @NotNull
    @Override
    public String toString() {
        return "RatingModel{" +
                ", RatingId='" + RatingId + '\'' +
                ", ClientEmail='" + ClientEmail + '\'' +
                ", SupplierEmail='" + SupplierEmail + '\'' +
                ", RatingNumber='" + RatingNumber + '\'' +
                ", RatingComment='" + RatingComment + '\'' +
                '}';
    }

    //getters and setters
    public int getOrderId() { return RatingId; }

    public void setOrderId(int orderId) {
        RatingId = orderId;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        SupplierEmail = supplierEmail;
    }


    public int getOrderHours() {
        return RatingNumber;
    }

    public void setOrderHours(int orderHours) {
        RatingNumber = orderHours;
    }


    public String getOrderLocation() {
        return RatingComment;
    }

    public void setOrderLocation(String orderLocation) {
        RatingComment = orderLocation;
    }
}

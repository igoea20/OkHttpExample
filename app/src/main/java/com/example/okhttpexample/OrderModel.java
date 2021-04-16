package com.example.okhttpexample;

public class OrderModel {

    private int OrderId;
    private String ClientEmail;
    private String SupplierEmail;
    private String SupplierService;
    private String OrderDate;
    private int OrderHours;
    private String OrderLocation;


    //constructors
    public OrderModel(int orderId, String clientEmail,
                         String supplierEmail,  String supplierService, String orderDate, int orderHours,String orderLocation) {
        OrderId = orderId;
        ClientEmail = clientEmail;
        SupplierEmail = supplierEmail;
        SupplierService = supplierService;
        OrderDate = orderDate;
        OrderHours = orderHours;
        OrderLocation = orderLocation;
    }

    //public SupplierModel() {
    //}

    //toString for printing data
    // @NotNull
    @Override
    public String toString() {
        return "OrderModel{" +
                ", OrderId='" + OrderId + '\'' +
                ", ClientEmail='" + ClientEmail + '\'' +
                ", SupplierEmail='" + SupplierEmail + '\'' +
                ", SupplierService='" + SupplierService + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", OrderHours='" + OrderHours + '\'' +
                ", OrderLocation='" + OrderLocation + '\'' +
                '}';
    }

    //getters and setters
    public int getOrderId() { return OrderId; }

    public void setOrderId(int orderId) {
        OrderId = orderId;
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

    public String getSupplierService() {
        return SupplierService;
    }

    public void setSupplierService(String supplierService) {
        SupplierService = supplierService;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getOrderHours() {
        return OrderHours;
    }

    public void setOrderHours(int orderHours) {
        OrderHours = orderHours;
    }


    public String getOrderLocation() {
        return OrderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        OrderLocation = orderLocation;
    }


}

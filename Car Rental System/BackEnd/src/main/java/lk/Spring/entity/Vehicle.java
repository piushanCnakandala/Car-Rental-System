package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private String registrationNum;
    private String vehicleTypeId;
    private String brand;
    private String transmissionType;
    private String noOfPassengers;
    private String colour;
    private String fuelType;
    private String runningKM;
    private String status;

    public Vehicle() {
    }

    public Vehicle(String registrationNum, String vehicleTypeId, String brand, String transmissionType, String noOfPassengers, String colour, String fuelType, String runningKM, String status) {
        this.registrationNum = registrationNum;
        this.vehicleTypeId = vehicleTypeId;
        this.brand = brand;
        this.transmissionType = transmissionType;
        this.noOfPassengers = noOfPassengers;
        this.colour = colour;
        this.fuelType = fuelType;
        this.runningKM = runningKM;
        this.status = status;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(String noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getRunningKM() {
        return runningKM;
    }

    public void setRunningKM(String runningKM) {
        this.runningKM = runningKM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

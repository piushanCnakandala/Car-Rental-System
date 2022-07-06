package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RegisteredCustomer {
    @Id
    private String cusId;
    private String cusName;
    private String address;
    private String email;
    private String nicNo;
    private String drivingLicense;
    private String password;

    public RegisteredCustomer() {
    }

    public RegisteredCustomer(String cusId, String cusName, String address, String email, String nicNo, String drivingLicense, String password) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.address = address;
        this.email = email;
        this.nicNo = nicNo;
        this.drivingLicense = drivingLicense;
        this.password = password;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

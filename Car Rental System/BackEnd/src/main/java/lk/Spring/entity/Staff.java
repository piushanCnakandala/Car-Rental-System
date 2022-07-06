package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Staff {
    @Id
    private String staffId;
    private String name;
    private String email;
    private String address;
    private String mobileNo;
    private String password;

    public Staff() {
    }

    public Staff(String staffId, String name, String email, String address, String mobileNo, String password) {
        this.staffId = staffId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

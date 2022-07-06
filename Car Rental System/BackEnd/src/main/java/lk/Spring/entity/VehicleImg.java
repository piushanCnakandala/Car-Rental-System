package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VehicleImg {
    @Id
    private String registrationNom;
    private String vehicleTypeId;
    private String imgId;

    public VehicleImg() {
    }

    public VehicleImg(String registrationNom, String vehicleTypeId, String imgId) {
        this.registrationNom = registrationNom;
        this.vehicleTypeId = vehicleTypeId;
        this.imgId = imgId;
    }

    public String getRegistrationNom() {
        return registrationNom;
    }

    public void setRegistrationNom(String registrationNom) {
        this.registrationNom = registrationNom;
    }

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}
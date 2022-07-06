package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VehicleType {
    @Id
    private String vehicleTypeId;
    private String vehicleType;
    private String losDamageWaiver;

    public VehicleType() {
    }

    public VehicleType(String vehicleTypeId, String vehicleType, String losDamageWaiver) {
        this.vehicleTypeId = vehicleTypeId;
        this.vehicleType = vehicleType;
        this.losDamageWaiver = losDamageWaiver;
    }

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLosDamageWaiver() {
        return losDamageWaiver;
    }

    public void setLosDamageWaiver(String losDamageWaiver) {
        this.losDamageWaiver = losDamageWaiver;
    }
}

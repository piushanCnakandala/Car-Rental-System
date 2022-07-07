package lk.Spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Vehicle {
  @Id
    private String registrationNum;
    private String vehicleTypeId;
    private String brand;
    private String transmissionType;
    private int noOfPassengers;
    private String colour;
    private String fuelType;
    private double runningKM;
    private String status;

}

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

public class RegisteredCustomer {
    @Id
    private String cusId;
    private String cusName;
    private String address;
    private String email;
    private String nicNo;
    private String drivingLicense;
    private String password;


}

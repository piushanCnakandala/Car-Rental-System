package lk.Spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriveSchedule_Pk implements Serializable {
    private String staffId;
    private String registrationNumber;
    private String rentId;
}

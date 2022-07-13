package lk.Spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.Spring.entity.Rent;
import lk.Spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDetailsDTO {

    private String rent_Id;
    private String registration_Number;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate rent_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate return_Date;
    private int kilometers;
    private double rental_Cost;
    private double damage_Cost;
    private String status;
    private Rent rent;
    private Vehicle vehicle;
}

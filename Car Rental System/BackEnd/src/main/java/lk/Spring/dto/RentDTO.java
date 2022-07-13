package lk.Spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.Spring.entity.Customer;
import lk.Spring.entity.Rent_Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDTO  {
    private String rent_Id;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate rent_Date;
    private String status;
    private String reason;
    private Customer customer;
    private List<Rent_Detail> rent_details;
}

package lk.Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver_ScheduleDTO {
    private String staff_Id;
    private String registration_Number;
    private String rent_Id;
    private LocalDate rent_Date;
    private LocalDate return_Date;

}

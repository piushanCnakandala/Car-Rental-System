package lk.Spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@IdClass(DriveSchedule_Pk.class)
public class DriveSchedule {
    @Id
    private String rentId;
    @Id
    private String staffId;
    @Id
    private String registrationNumber;
    private LocalDate rentDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", insertable = false, updatable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "registrationNumber", referencedColumnName = "registrationNumber", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", insertable = false, updatable = false)
    private Rent rent;

}

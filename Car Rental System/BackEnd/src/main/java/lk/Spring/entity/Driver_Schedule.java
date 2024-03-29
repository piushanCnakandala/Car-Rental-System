package lk.Spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@IdClass(Drive_Schedule_PK.class)
public class Driver_Schedule {
    @Id
    private String driver_Id;
    @Id
    private String registration_Number;
    @Id
    private String rent_Id;
    private LocalDate checking;
    private LocalDate return_Date;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "driver_Id",referencedColumnName = "driver_Id",nullable = false,insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "registration_Number",referencedColumnName = "registration_Number",nullable = false,insertable = false,updatable = false)
    private Vehicle vehicle;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "rent_Id",referencedColumnName = "rent_Id",nullable = false,insertable = false,updatable = false)
    private Rent rent;
}

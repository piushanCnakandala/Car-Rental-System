package lk.Spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Rent {
  @Id
    private String rentId;
    private String registrationNum;
    private String reason;
    private LocalDate date;
    private String status;
  @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
  @JoinColumn(name = "cusId", referencedColumnName = "cusId", nullable = false)
  private RegisteredCustomer cusId;
  @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
  private List<RentDetails> rentDetails;

}

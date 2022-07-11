package lk.Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Vehicle_ImgDTO {
    private String img_Id;
    private String description;
}

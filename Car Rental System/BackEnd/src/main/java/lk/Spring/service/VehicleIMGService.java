package lk.Spring.service;

import lk.Spring.dto.StaffDTO;
import lk.Spring.dto.Vehicle_ImgDTO;

import java.util.List;

public interface VehicleIMGService {
    void saveVehicleIMG(Vehicle_ImgDTO vehicle_imgDTO);
    void deleteVehicleIMG(String id);
    void updateVehicleIMG(Vehicle_ImgDTO vehicle_imgDTO);
    Vehicle_ImgDTO searchVehicleIMG(String id);
    List<Vehicle_ImgDTO> getAllVehicleIMG();
}

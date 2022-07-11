package lk.Spring.service.impl;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.Vehicle_ImgDTO;
import lk.Spring.entity.Customer;
import lk.Spring.entity.Vehicle_IMG;
import lk.Spring.repo.CustomerRepo;
import lk.Spring.repo.VehicleIMGRepo;
import lk.Spring.service.VehicleIMGService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Vehicle_IMGServiceImpl implements VehicleIMGService {
    @Autowired
   private VehicleIMGRepo vehicleIMGRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveVehicleIMG(Vehicle_ImgDTO vehicle_imgDTO) {
        if (!vehicleIMGRepo.existsById(vehicle_imgDTO.getImg_Id())){
           vehicleIMGRepo.save(modelMapper.map(vehicle_imgDTO, Vehicle_IMG.class));
        }else {
            throw new RuntimeException("Vehicle Img  Already Saved");
        }
    }

    @Override
    public void deleteVehicleIMG(String id) {
        if (vehicleIMGRepo.existsById(id)){
            vehicleIMGRepo.deleteById(id);
        }else {
            throw new RuntimeException("Vehicle IMG delete failed");
        }
    }

    @Override
    public void updateVehicleIMG(Vehicle_ImgDTO vehicle_imgDTO) {
        if(vehicleIMGRepo.existsById(vehicle_imgDTO.getImg_Id())){
            vehicleIMGRepo.save(modelMapper.map(vehicle_imgDTO,Vehicle_IMG.class));
        }else{
            throw new RuntimeException("Vehicle Img Update failed");
        }
    }

    @Override
    public Vehicle_ImgDTO searchVehicleIMG(String id) {
        if (vehicleIMGRepo.existsById(id)){
            return  modelMapper.map(vehicleIMGRepo.findById(id).get(), Vehicle_ImgDTO.class);
        }else {
            throw new RuntimeException("Invalid search");
        }
    }

    @Override
    public List<Vehicle_ImgDTO> getAllVehicleIMG() {
        return modelMapper.map(vehicleIMGRepo.findAll(),new TypeToken<List<Vehicle_ImgDTO>>(){}.getType());
    }
}

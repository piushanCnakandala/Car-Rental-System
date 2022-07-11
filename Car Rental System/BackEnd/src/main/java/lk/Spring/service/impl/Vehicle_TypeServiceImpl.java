package lk.Spring.service.impl;

import lk.Spring.dto.RatesDTO;
import lk.Spring.dto.StaffDTO;
import lk.Spring.dto.Vehicle_TypeDTO;
import lk.Spring.entity.Rates;
import lk.Spring.entity.Vehicle_Type;
import lk.Spring.repo.RatesRepo;
import lk.Spring.repo.Vehicle_TypeRepo;
import lk.Spring.service.Vehicle_TypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class Vehicle_TypeServiceImpl implements Vehicle_TypeService {

    @Autowired
    private Vehicle_TypeRepo vehicle_typeRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveVehicleType(Vehicle_TypeDTO vehicle_typeDTO) {
        if (!vehicle_typeRepo.existsById(vehicle_typeDTO.getVehicle_Type_Id())) {
            vehicle_typeRepo.save(modelMapper.map(vehicle_typeDTO, Vehicle_Type.class));
        } else {
            throw new RuntimeException("Vehicle Type  Already Saved");
        }
    }

    @Override
    public void deleteVehicleType(String id) {
        if (vehicle_typeRepo.existsById(id)) {
           vehicle_typeRepo.deleteById(id);
        } else {
            throw new RuntimeException("vehicle type delete failed");
        }
    }

    @Override
    public void updateVehicleType(Vehicle_TypeDTO vehicle_typeDTO) {
        if (vehicle_typeRepo.existsById(vehicle_typeDTO.getVehicle_Type_Id())) {
            vehicle_typeRepo.save(modelMapper.map(vehicle_typeDTO, Vehicle_Type.class));
        } else {
            throw new RuntimeException("Vehicle Type Update failed");
        }
    }

    @Override
    public Vehicle_TypeDTO searchVehicleType(String id) {
        if (vehicle_typeRepo.existsById(id)) {
            return modelMapper.map(vehicle_typeRepo.findById(id).get(), Vehicle_TypeDTO.class);
        } else {
            throw new RuntimeException("Invalid search");
        }
    }

    @Override
    public List<Vehicle_TypeDTO> getAllVehicleType() {
        return modelMapper.map(vehicle_typeRepo.findAll(),new TypeToken<List<Vehicle_TypeDTO>>(){
        }.getType());
    }
}

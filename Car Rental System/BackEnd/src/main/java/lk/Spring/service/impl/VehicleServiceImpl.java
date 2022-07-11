package lk.Spring.service.impl;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lk.Spring.dto.VehicleDTO;
import lk.Spring.dto.Vehicle_TypeDTO;
import lk.Spring.entity.Vehicle;
import lk.Spring.entity.Vehicle_Type;
import lk.Spring.repo.VehicleRepo;
import lk.Spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getRegistration_Number())) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
        } else {
            throw new RuntimeException("Vehicle Already Saved");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
        } else {
            throw new RuntimeException("Vehicle delete failed");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getRegistration_Number())) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
        } else {
            throw new RuntimeException("Rater Update failed");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            return modelMapper.map(vehicleRepo.findById(id).get(), VehicleDTO.class);
        } else {
            throw new RuntimeException("Invalid search");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return modelMapper.map(vehicleRepo.findAll(),new TypeToken<List<VehicleDTO>>(){
        }.getType());
    }
}

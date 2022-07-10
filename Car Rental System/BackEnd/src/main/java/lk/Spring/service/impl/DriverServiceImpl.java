package lk.Spring.service.impl;

import lk.Spring.dto.DriverDTO;
import lk.Spring.dto.RatesDTO;
import lk.Spring.entity.Driver;
import lk.Spring.entity.Rates;
import lk.Spring.repo.DriverRepo;
import lk.Spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getDriver_Id())) {
            driverRepo.save(modelMapper.map(driverDTO, Driver.class));
        } else {
            throw new RuntimeException("Driver Already Saved");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)) {
           driverRepo.deleteById(id);
        } else {
            throw new RuntimeException("Driver delete failed");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriver_Id())) {
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        } else {
            throw new RuntimeException("Driver Update failed");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (driverRepo.existsById(id)) {
            return modelMapper.map(driverRepo.findById(id).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("Invalid search");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return modelMapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){
        }.getType());
    }
}

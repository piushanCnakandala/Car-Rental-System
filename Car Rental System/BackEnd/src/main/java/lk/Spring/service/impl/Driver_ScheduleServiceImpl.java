package lk.Spring.service.impl;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.Driver_ScheduleDTO;
import lk.Spring.entity.Customer;
import lk.Spring.entity.Driver_Schedule;
import lk.Spring.repo.Driver_ScheduleRepo;
import lk.Spring.service.Driver_ScheduleService;
import lk.Spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class Driver_ScheduleServiceImpl implements Driver_ScheduleService {

    @Autowired
    private Driver_ScheduleRepo driver_scheduleRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveDriverSchedule(Driver_ScheduleDTO driver_scheduleDTO) {
        if (!driver_scheduleRepo.existsById(driver_scheduleDTO.getStaff_Id())){
            driver_scheduleRepo.save(modelMapper.map(driver_scheduleDTO, Driver_Schedule.class));
        }else {
            throw new RuntimeException("Driver Schedule Already Saved");
        }
    }

    @Override
    public void deleteDriverSchedule(String id) {
        if ( driver_scheduleRepo.existsById(id)){
            driver_scheduleRepo.deleteById(id);
        }else {
            throw new RuntimeException("Driver Schedule delete failed");
        }
    }

    @Override
    public void updateDriverSchedule(Driver_ScheduleDTO  driver_scheduleDTO) {
        if(driver_scheduleRepo.existsById(driver_scheduleDTO.getStaff_Id())){
            driver_scheduleRepo.save(modelMapper.map(driver_scheduleDTO,Driver_Schedule.class));
        }else{
            throw new RuntimeException("Driver Schedule Update failed");
        }
    }

    @Override
    public Driver_ScheduleDTO searchDriverSchedule(String id) {
        if (driver_scheduleRepo.existsById(id)){
            return  modelMapper.map(driver_scheduleRepo.findById(id).get(), Driver_ScheduleDTO.class);
        }else {
            throw new RuntimeException("Invalid search");
        }

    }

    @Override
    public List<Driver_ScheduleDTO> getAllDriverSchedule() {
        return modelMapper.map(driver_scheduleRepo.findAll(),new TypeToken<List<Driver_ScheduleDTO>>(){}.getType());
    }
}

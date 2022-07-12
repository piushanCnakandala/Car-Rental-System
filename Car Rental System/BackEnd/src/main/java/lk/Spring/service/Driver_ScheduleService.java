package lk.Spring.service;

import lk.Spring.dto.DriverDTO;
import lk.Spring.dto.Driver_ScheduleDTO;

import java.util.List;

public interface Driver_ScheduleService {
    void saveDriverSchedule(Driver_ScheduleDTO driver_scheduleDTO);
    void deleteDriverSchedule(String id);
    void updateDriverSchedule(Driver_ScheduleDTO dto);
    Driver_ScheduleDTO searchDriverSchedule(String id);
    List<Driver_ScheduleDTO> getAllDriverSchedule();
}

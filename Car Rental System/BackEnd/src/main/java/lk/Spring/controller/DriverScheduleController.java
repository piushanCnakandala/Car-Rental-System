package lk.Spring.controller;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.Driver_ScheduleDTO;
import lk.Spring.service.Driver_ScheduleService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driverSchedule")
@CrossOrigin
public class DriverScheduleController {
    @Autowired
    private Driver_ScheduleService driver_scheduleService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriverSchedule(@ModelAttribute Driver_ScheduleDTO driver_scheduleDTO){
       driver_scheduleService.saveDriverSchedule(driver_scheduleDTO);
        return  new ResponseUtil(200,"saved",null);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriverSchedule(@RequestParam String id){
        driver_scheduleService.deleteDriverSchedule(id);
        return  new ResponseUtil(200,"deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverSchedule(@RequestBody Driver_ScheduleDTO driver_scheduleDTO){
        driver_scheduleService.updateDriverSchedule(driver_scheduleDTO);
        return  new ResponseUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriverSchedule(@PathVariable String id){
        return  new ResponseUtil(200,"Ok",driver_scheduleService.searchDriverSchedule(id));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriverSchedule(){
        return  new ResponseUtil(200,"Ok",driver_scheduleService.getAllDriverSchedule());
    }
}

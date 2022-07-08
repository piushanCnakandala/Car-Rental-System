package lk.Spring.controller;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.StaffDTO;
import lk.Spring.service.StaffService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    StaffService staffService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveStaffMember(@ModelAttribute StaffDTO staffDTO){
        staffService.saveStaffMember(staffDTO);
        return  new ResponseUtil(200,"saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteStaffMember(@RequestParam String id){
        staffService.deleteStaffMember(id);
        return  new ResponseUtil(200,"Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateStaffMember(@RequestBody StaffDTO staffDTO){
        staffService.updateStaffMember(staffDTO);
        return  new ResponseUtil(200,"update",null);
    }

}

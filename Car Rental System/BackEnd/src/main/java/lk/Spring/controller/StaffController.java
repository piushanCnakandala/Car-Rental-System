package lk.Spring.controller;

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


}

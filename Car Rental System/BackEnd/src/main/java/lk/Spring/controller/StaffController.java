package lk.Spring.controller;

import lk.Spring.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    StaffService staffService;


}

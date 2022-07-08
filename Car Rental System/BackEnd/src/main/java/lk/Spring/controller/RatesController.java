package lk.Spring.controller;

import lk.Spring.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates")
@CrossOrigin
public class RatesController {
    @Autowired
    RatesService ratesService;
}

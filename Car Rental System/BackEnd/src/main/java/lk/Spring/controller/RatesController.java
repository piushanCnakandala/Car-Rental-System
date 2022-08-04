package lk.Spring.controller;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.RatesDTO;
import lk.Spring.service.RatesService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rates")
@CrossOrigin
public class RatesController {
    @Autowired
    RatesService ratesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRates(@ModelAttribute RatesDTO ratesDTO){
        ratesService.saveRates(ratesDTO);
        return  new ResponseUtil(200,"saved",null);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRate(@RequestParam String id){
        ratesService.deleteRates(id);
        return  new ResponseUtil(200,"delete",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody RatesDTO ratesDTO){
       ratesService.updateRates(ratesDTO);
        return  new ResponseUtil(200,"update",null);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRates(@PathVariable String id){
        return  new ResponseUtil(200,"Ok",ratesService.searchRates(id));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRates(){
        return  new ResponseUtil(200,"Ok",ratesService.getAllRates());
    }
}

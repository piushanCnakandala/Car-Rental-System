package lk.Spring.controller;

import lk.Spring.dto.RatesDTO;
import lk.Spring.dto.Vehicle_TypeDTO;
import lk.Spring.service.RatesService;
import lk.Spring.service.Vehicle_TypeService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicleType")
@CrossOrigin
public class VehicleTypeController {
    @Autowired
   Vehicle_TypeService vehicle_typeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicleType(@ModelAttribute Vehicle_TypeDTO vehicle_typeDTO){
        vehicle_typeService.saveVehicleType(vehicle_typeDTO);
        return  new ResponseUtil(200,"saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRate(@RequestParam String id){
        vehicle_typeService.deleteVehicleType( id);
        return  new ResponseUtil(200,"delete",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody  Vehicle_TypeDTO vehicle_typeDTO){
        vehicle_typeService.updateVehicleType(vehicle_typeDTO);
        return  new ResponseUtil(200,"update",null);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRates(@PathVariable String id){
        return  new ResponseUtil(200,"Ok",vehicle_typeService.searchVehicleType(id));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRates(){
        return  new ResponseUtil(200,"Ok",vehicle_typeService.getAllVehicleType());
    }
}

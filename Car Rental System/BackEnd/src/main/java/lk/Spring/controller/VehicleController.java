package lk.Spring.controller;

import lk.Spring.dto.DriverDTO;
import lk.Spring.dto.VehicleDTO;
import lk.Spring.service.VehicleService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseUtil saveVehicle(/*@ModelAttribute */@RequestBody VehicleDTO vehicleDTO){
        System.out.println(vehicleDTO.toString());
       vehicleService.saveVehicle(vehicleDTO);
        return  new ResponseUtil(200,"saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String id){
        vehicleService.deleteVehicle(id);
        return  new ResponseUtil(200,"delete",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO){
       vehicleService.updateVehicle(vehicleDTO);
        return  new ResponseUtil(200,"update",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String id){
        return  new ResponseUtil(200,"Ok",vehicleService.searchVehicle(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle(){
        return  new ResponseUtil(200,"Ok",getAllVehicle());
    }
}

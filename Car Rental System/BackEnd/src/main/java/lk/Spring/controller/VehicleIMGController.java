package lk.Spring.controller;

import lk.Spring.dto.CustomerDTO;
import lk.Spring.dto.Vehicle_ImgDTO;
import lk.Spring.service.VehicleIMGService;
import lk.Spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicleimg")
@CrossOrigin
public class VehicleIMGController {

    @Autowired
    private VehicleIMGService vehicleIMGService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicleImg(@ModelAttribute Vehicle_ImgDTO vehicle_imgDTO){
       vehicleIMGService.saveVehicleIMG(vehicle_imgDTO);
        return  new ResponseUtil(200,"saved",null);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicleImg(@RequestParam String id){
       vehicleIMGService.deleteVehicleIMG(id);
        return  new ResponseUtil(200,"deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicleImg(@RequestBody Vehicle_ImgDTO vehicle_imgDTO){
        vehicleIMGService.updateVehicleIMG(vehicle_imgDTO);
        return  new ResponseUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicleImg(@PathVariable String id){
        return  new ResponseUtil(200,"Ok",vehicleIMGService.searchVehicleIMG(id));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicleImg(){
        return  new ResponseUtil(200,"Ok",vehicleIMGService.getAllVehicleIMG());
    }
}

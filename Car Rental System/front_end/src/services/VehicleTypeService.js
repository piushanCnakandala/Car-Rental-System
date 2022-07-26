import axios from "../axios"

class VehicleTypeService {
    postVehicleType= async (data) => {
        const promise =new Promise((resolve,reject)=>{
          axios.post('vehicleType')
        })
    }
}
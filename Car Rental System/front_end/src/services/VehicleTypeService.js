import axios from "../axios"
import qs from "qs";

class VehicleTypeService {
    postVehicleType= async (data) => {
        const promise =new Promise((resolve,reject)=>{
          axios.post('vehicleType',qs.stringify(data))
              .then((res) =>{
                  return resolve(res)
              }).catch((err) =>{
                  return resolve(err)
          })
        })
        return await promise;
    }
}
export  default new VehicleTypeService();
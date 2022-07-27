import axios from "../axios"
import qs from "qs";

class DriverService {
    postDriver= async (data) => {
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

    fetchPosts = async (data) => {
        const promise = new Promise((resolve, reject) => {
            axios.get('vehicleType')
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        });
        return await promise;
    }
}
export  default new DriverService();
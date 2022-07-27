import axios from "../axios"

class VehicleService {
    postVehicle = async (data) =>{
        const promise = new Promise((resolve, reject) => {
            axios.post('vehicle',data)
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        })
        return await promise;
    }

    fetchVehicles = async () =>{
        const promise = new Promise((resolve, reject) => {
            axios.get('vehicle')
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        })
        return await promise;
    }

    deleteVehicle = async (params) =>{
        console.log("de")
        const promise = new Promise((resolve, reject) => {
            axios.delete('vehicle',{params:params})
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        })
        return await promise;
    }

    countByStatus = async (data) =>{
        const promise = new Promise((resolve, reject) => {
            axios.get('vehicle/count/status',{params:{status:data}})
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        })
        return await promise;
    }
}
export default new VehicleService();
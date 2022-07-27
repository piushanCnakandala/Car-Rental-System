import axios from "../axios"
import qs from "qs";

class RateService{
    postRates= async (data) => {
        const promise =new Promise((resolve,reject)=>{
            axios.post('rates',qs.stringify(data))
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
            axios.get('rates')
                .then((res) => {
                    return resolve(res)
                }).catch((err) => {
                return resolve(err)
            })
        });
        return await promise;
    }
}
export  default new RateService();
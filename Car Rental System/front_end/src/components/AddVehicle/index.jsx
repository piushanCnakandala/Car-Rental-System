import {Grid} from "@mui/material";
import React, {Component} from "react";
import {styleSheet} from "./styles";
import {withStyles} from "@mui/styles";
import {TextValidator, ValidatorForm} from "react-material-ui-form-validator";
import CommonButton from "../common/Button";
import RateService from "../../services/RateService";
import VehicleTypeService from "../../services/VehicleTypeService";
import VehicleService from "../../services/VehicleService";


class AddEmployee extends Component {
    constructor(props) {
        super(props);
        this.state = {
            formData: {
                "registration_Number": '',
                "brand": '',
                "colour": '',
                "status": '',
                "no_Of_Passengers": '',
                "running_Km": '',
                "fuel_Type": '',
                "transmission_Type": '',
                "vehicleType": {
                    "vehicle_Type_Id": '',
                    "loss_Damage_Waiver": '',
                    "type": '',
                },
                "rates": {
                    "rate_Id": '',
                    "monthly_rate": '',
                    "daily_Rate": '',
                    "free_Km_Month": '',
                    "free_Km_Day": '',
                    "extra_Km_Price": '',
                },

            },
            ratesData: [],
            typeData: [],

            alert: false,
            message: '',
            severity: ''
        };
    }

    fetchRatesDataForSelect = async () => {
        const rates = await RateService.fetchRates();
        let ratesData = [];
        if (rates.status === 200) {
            rates.data.data.map((value, index) => {
                ratesData.push(value)
            })
            this.setState({
                ratesData: ratesData,
            })
            // console.log('frd')
        }
    }

    fetchVTypeDataForSelect = async () => {
        const res = await VehicleTypeService.fetchVehicleType();
        let typeData = [];
        if (res.status === 200) {
            res.data.data.map((value, index) => {
                typeData.push(value)
                console.log(value)
            })
            this.setState({
                typeData: typeData,
            })
        }

    }

    async componentDidMount() {
        await this.fetchRatesDataForSelect()
        await this.fetchVTypeDataForSelect()
        console.log('mount v')
    }
    handleSubmit = async () => {
        console.log("hi")
        let formDate = this.state.formData
        if (this.props.isUpdate) {
            console.log("hi1")
        } else {
            console.log("hi2")
            let res = await VehicleService.postVehicle(formDate)
            if (res.status === 201) {
                this.setState({
                    alert: true,
                    message: 'Vehicle Saved!',
                    severity: 'success'
                })
            } else {
                this.setState({
                    alert: true,
                    message: res.data.message,
                    severity: 'error'
                })
            }
        }
    };


    handleChange = (event) => {
        let id = event.target.name;
        switch (id) {
            case "userName":
                const userName = event.target.value;
                this.setState(Object.assign(this.state.formData, {userName: userName}));
                // this.setState({ userId });
                break;

            case "password":
                const password = event.target.value;
                this.setState(Object.assign(this.state.formData, {password: password}));
                break;

            default:
                break;
        }
    };

    render() {
        const {classes} = this.props;
        return (<Grid container direction={'row'} xs={12} className={classes.container}>
            <ValidatorForm
                onSubmit={this.handleSubmit}
                onError={(errors) => console.log(errors)}
                className={classes.validator}
            >
                <Grid item container direction={'row'} xs={12} gap={'15px'} justifyContent={'center'}
                      alignContent={'center'}
                      className={classes.container}>
                    <Grid item container direction={'column'} xs={12} gap={'15px'}>
                        <TextValidator
                            label="Employee ID"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Name"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Address"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Mobile Number"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Email"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Password"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            type={"password"}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <TextValidator
                            label="Type"
                            onChange={this.handleChange}
                            name="password"
                            value={this.state.formData.password}
                            validators={["required"]}
                            errorMessages={["This field is required"]}
                            className="w-full"
                            style={{minWidth: '100%'}}
                        />
                        <CommonButton
                            size="large"
                            variant="contained"
                            label="Add"
                            type="submit"
                            className="text-white bg-blue-500 font-bold tracking-wide"
                            style={{backgroundColor: 'rgba(25, 118, 210, 0.95)', width: '100%'}}
                        />
                    </Grid>
                </Grid>
            </ValidatorForm>

        </Grid>);
    }
}

export default withStyles(styleSheet)(AddEmployee);
import customerService from "../../services/customerService";
import {Grid} from "@mui/material";
import IJSESnackBar from "../common/snackBar";
import GDSEButton from "../common/Button";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import HomeIcon from '@mui/icons-material/Home';
import {Link} from "react-router-dom";
import IconButton from "@mui/material/IconButton";
import {TextValidator, ValidatorForm} from "react-material-ui-form-validator";
import AddPhotoAlternateIcon from "@mui/icons-material/AddPhotoAlternate";
import {withStyles} from "@mui/styles";
import {styleSheet} from "./style";

const {Component} = require("react");

class RegisterCustomer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            formData: {
                cusId: '',
                name: '',
                nic: '',
                address: '',
                mobile: '',
                dln: '',
                email: '',
                password: '',
            }, verification: null,
            alert: false,
            message: '',
            severity: '',
        }
    }
    handleSubmit = async () => {
        if (this.state.verification === null) {
            this.setState({
                alert: true,
                message: "Please Upload NIC Card Or Driving License Card Photo to Verify",
                severity: 'error'
            })
            return;
        }
        let formData = this.state.formData
        let data = new FormData();
        data.append("customer",JSON.stringify(formData));
        data.append("file",this.state.verification)

        let res = await customerService.postCustomer(data)
        if (res.status === 201){
            this.setState({
                alert: true,
                message: "Registration Done",
                severity: 'success'
            })
        }else {
            this.setState({
                alert: true,
                message: res.message,
                severity: 'error'
            })
        }
    }
    handleFile(e) {
        let verification = e.target.files[0]
        this.setState({
            verification: verification
        })
    }
    handleChange = (event) => {
        let id = event.target.name;
        switch (id) {
            case "cusId":
                const cusId = event.target.value;
                this.setState(Object.assign(this.state.formData, {cusId: cusId}));
                // this.setState({ userId });
                break;

            case "name":
                const name = event.target.value;
                this.setState(Object.assign(this.state.formData, {name: name}));
                break;

            case "nic":
                const nic = event.target.value;
                this.setState(Object.assign(this.state.formData, {nic: nic}));
                break;

            case "dln":
                const dln = event.target.value;
                this.setState(Object.assign(this.state.formData, {dln: dln}));
                break;

            case "address":
                const address = event.target.value;
                this.setState(Object.assign(this.state.formData, {address: address}));
                break;

            case "mobile":
                const mobile = event.target.value;
                this.setState(Object.assign(this.state.formData, {mobile: mobile}));
                break;

            case "email":
                const email = event.target.value;
                this.setState(Object.assign(this.state.formData, {email: email}));
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
        return (<>
            <Grid container direction={'row'} justifyContent={'center'} alignContent={'center'}
                  className={'bg-white h-screen'}>
                <Grid container direction={'column'}
                      className={'bg-white w-max rounded-lg shadow-[0px_10px_1px_rgba(221,_221,_221,_1),_0_10px_20px_rgba(204,_204,_204,_1)]'}
                      justifyContent={'center'}>
                    <Grid container direction={"row"} justifyContent={"center"}>
                        <Grid container item xs={12} justifyContent={"center"} className={'pt-20 sm:pt-10'}>
                            <Link to={'/'} className={'pt-20 sm:pt-10'}>
                                <IconButton aria-label="delete" size="large" >
                                    <HomeIcon fontSize="inherit"/>
                                </IconButton>
                            </Link>
                        </Grid>
                        <Grid>
                            <Typography variant={"h5"} textAlign={"center"}>
                                Customer Registration Form
                            </Typography>
                        </Grid>

                    </Grid>
                    <ValidatorForm
                        onSubmit={this.handleSubmit}
                        onError={(errors) => console.log(errors)}
                        className={"flex justify-center p-10"}
                    >
                        <Grid container item gap={2} xs={12} justifyContent={"center"}>
                            <Grid container direction={'column'} item gap={2} xs={12} sm={5} md={5}>
                                <TextValidator
                                    label="User ID"
                                    onChange={this.handleChange}
                                    name="cusId"
                                    value={this.state.formData.cusId}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                                <TextValidator
                                    label="Name"
                                    onChange={this.handleChange}
                                    name="name"
                                    value={this.state.formData.name}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                                <TextValidator
                                    label="NIC"
                                    onChange={this.handleChange}
                                    name="nic"
                                    value={this.state.formData.nic}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                                <TextValidator
                                    label="Driving License No."
                                    onChange={this.handleChange}
                                    name="dln"
                                    value={this.state.formData.dln}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                            </Grid>
                            <Grid container direction={'column'} item gap={2} xs={12} sm={5} md={5}><TextValidator
                                label="Address"
                                onChange={this.handleChange}
                                name="address"
                                value={this.state.formData.address}
                                validators={["required"]}
                                errorMessages={["This field is required"]}
                                className={[classes.textField, "w-full text-red-500"]}
                            />
                                <TextValidator
                                    label="Mobile No."
                                    onChange={this.handleChange}
                                    name="mobile"
                                    value={this.state.formData.mobile}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                                <TextValidator
                                    label="Email"
                                    onChange={this.handleChange}
                                    name="email"
                                    value={this.state.formData.email}
                                    validators={["required", "isEmail"]}
                                    errorMessages={["This field is required", "Email is not valid"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                />
                                <TextValidator
                                    label="Password"
                                    onChange={this.handleChange}
                                    name="password"
                                    type={'password'}
                                    value={this.state.formData.password}
                                    validators={["required"]}
                                    errorMessages={["This field is required"]}
                                    className={[classes.textField, "w-full text-red-500"]}
                                /></Grid>
                            <Grid container direction={'row'} xs={10.5} justifyContent={'center'}>
                                <Button
                                    component="label"
                                    variant="outlined"
                                    startIcon={<AddPhotoAlternateIcon className={classes.icon}/>}
                                    sx={{marginRight: "1rem"}}
                                    className={classes.btnUpload}
                                >
                                    Upload NIC Card or Driving License Card image
                                    <input type="file" accept="image/*" hidden
                                           onChange={(e) => this.handleFile(e)}/>
                                </Button>
                            </Grid>
                            <GDSEButton
                                size="large"
                                variant="contained"
                                label='Create'
                                type="submit"
                                className="text-white bg-blue-500 font-bold tracking-wide"
                                style={{backgroundColor: 'rgba(25, 118, 210, 0.95)', width: '100%'}}
                            />
                        </Grid>
                    </ValidatorForm>
                </Grid>
            </Grid>
            <IJSESnackBar
                open={this.state.alert}
                onClose={() => {
                    this.setState({alert: false})
                }}
                message={this.state.message}
                autoHideDuration={3000}
                severity={this.state.severity}
                variant={'filled'}
            />
        </>);
    }
}
export default withStyles(styleSheet)(RegisterCustomer);
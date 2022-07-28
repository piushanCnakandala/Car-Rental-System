import {
  Dialog,
  DialogContent,
  DialogTitle,
  Grid,
  IconButton, Tooltip,
  Typography,
} from "@mui/material";
import React, { Component } from "react";
import Navbar from "../../../components/common/Navbar/Admin";
import Sidebar from "../../../components/common/Sidebar";
import CommonButton from "../../../components/common/Button";
import CommonDataTable from "../../../components/common/Table";
import AddIcon from "@mui/icons-material/Add";
import { withStyles } from "@mui/styles";
import { styleSheet } from "./styles";
import CloseIcon from "@mui/icons-material/Close";
import AddNewVehicle from "../../../components/AddVehicle";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import VehicleService from "../../../services/VehicleService";
import CustomSnackBar from "../../../components/common/SnakBar";


class VehicleManage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      popup: false,
      alert: false,
      message: "",
      severity: "",

      //  for table
      data: [],
      loaded: false,

      //  for data table
      columns: [
        {
          field: "registration_Number",
          headerName: "Reg Num",
          width: 150,
        },

        {
          field: "brand",
          headerName: "Brand",
          width: 150,
        },

        {
          field: "colour",
          headerName: "color",
          width: 125,
          sortable: false,
        },

        {
          field: "fuel_Type",
          headerName: "Fuel Type",
          width: 150,
        },

        {
          field: "no_Of_Passengers",
          headerName: "Num. Passengers",
          width: 150,
        },

        {
          field: "running_Km",
          headerName: "Running km",
          width: 150,
        },

        {
          field: "transmission_Type",
          headerName: "Transmission Type",
          width: 150,
        },

        {
          field: "rates",
          headerName: "Rates",
          width: 150,
        },

        {
          field: "vehicleType",
          headerName: "Type",
          width: 150,
        },

        {
          field: "status",
          headerName: "Status",
          width: 150,
        },

        {
          field: "action",
          headerName: "Action",
          width: 150,
          renderCell: (params) => {
            return (
                <>
                  <Tooltip title="Edit">
                    <IconButton onClick={async () => {
                      await this.updateVehicle(params.row);
                    }}>
                      <EditIcon className={'text-blue-500'}/>
                    </IconButton>
                  </Tooltip>
                  <Tooltip title="Delete">
                    <IconButton onClick={async () => {
                      await this.deleteVehicle(params.row.registration_Number);
                    }}>
                      <DeleteIcon className={'text-red-500'}/>
                    </IconButton>
                  </Tooltip>
                </>
            )
          }
        },
      ],
    };
  }

  updateVehicle = async (data) => {

  }


  deleteVehicle = async (id) => {
    let params = {
      regNo: id
    }

    let res = await VehicleService.deleteVehicle(params);
    console.log(res)
    if (res.status === 200) {
      this.setState({
        alert: true,
        message: res.data.message,
        severity: 'success'
      });
      this.loadData();
    } else {
      this.setState({
        alert: true,
        message: res.message,
        severity: 'error'
      });
    }
  }
  async loadData() {

    let resp = await VehicleService.fetchVehicles();
    let nData = [];
    if (resp.status === 200) {
      resp.data.data.map((value, index) => {
        value.id = value.registration_Number;
        value.type = value.vehicleType.vehicle_Type_Id
        value.rateId = value.rates.rate_Id
        nData.push(value)
      })

      this.setState({
        loaded: true,
        data: nData,
      });
    }
    console.log(this.state.data)
  }

  componentDidMount() {
    this.loadData();
    console.log("Mounted");
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevState.popup == true) {
      this.loadData()
    }
  }

  render() {
    const { classes } = this.props;
    return (

        <>
      <Grid container direction={"row"} columns="12">
        <Grid item xs={"auto"}>
          <Sidebar />
        </Grid>

        <Grid item xs className="">
          <Navbar />
          <Grid container item xs={"auto"} className="flex p-5 gap-5">
            <Grid
              container
              item
              xs={12}
              gap="5px"
              className="rounded-lg p-5 shadow-[0_3px_10px_rgb(0,0,0,0.2)]"
            >
              <CommonButton
                variant="outlined"
                label="Add Vehicle"
                onClick={() => this.setState({ popup: true })}
                startIcon={<AddIcon />}
              />
             {/* <CommonButton
                variant="outlined"
                label="Add Vehicle Rates"
                startIcon={<AddIcon />}
              />
              <CommonButton
                variant="outlined"
                label="Add Vehicle Types"
                startIcon={<AddIcon />}
              />*/}
            </Grid>
            <Grid
              container
              item
              xs={12}
              gap="5px"
              className="rounded-lg p-5 shadow-[0_3px_10px_rgb(0,0,0,0.2)]"
              style={{ height: "700px" }}
            >
              <CommonDataTable
                columns={this.state.columns}
                rows={this.state.data}
                rowsPerPageOptions={5}
                pageSize={10}
                // checkboxSelection={true}
              />
            </Grid>
          </Grid>
        </Grid>
      </Grid>
        <Dialog
          open={this.state.popup}
          maxWidth="md"
          classes={{ paper: classes.dialogWraper }}
        >
          <DialogTitle style={{ paddingRight: "0px" }}>
            <div style={{ display: "flex" }}>
              <Typography
                variant="h4"
                component="div"
                className="font-bold flex-grow"
                style={{ flexGrow: 1 }}
              >
                Add New Vehicle
              </Typography>

              <IconButton onClick={() => this.setState({ popup: false })}>
                <CloseIcon />
              </IconButton>
            </div>
          </DialogTitle>
          <DialogContent dividers>
            <AddNewVehicle/>
          </DialogContent>
        </Dialog>
        <CustomSnackBar
            open={this.state.alert}
            onClose={() => {
              this.setState({alert: false})
            }}
            message={this.state.message}
            autoHideDuration={3000}
            severity={this.state.severity}
            variant={'filled'}
        />
      </>
    );
  }
}
export default withStyles(styleSheet)(VehicleManage);

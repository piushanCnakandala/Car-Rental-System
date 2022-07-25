import { Container, Grid, Typography } from "@mui/material";
import React, { Component } from "react";
import PremiumCars from '../CarSection/PremiumCars/index';
import LuxuryCars from './../CarSection/LuxuryCars/index';
import GeneralCars from './../CarSection/GeneralCars/index';

class ListVehicle extends Component {
    render() {
        return (
            <Grid
                container
                justifyContent="flex-start"
                alignItems="stretch"
                className=""
            >
                <Grid
                    container
                    justifyContent="flex-start"
                    alignItems="stretch"
                    className=""
                >
                    <Grid
                        item
                        direction="column"
                        container
                        className=""
                    >
                    </Grid>


                    <GeneralCars/>
                    <PremiumCars/>
                    <LuxuryCars/>

                    {/* General Car Section End */}
                </Grid>
            </Grid>
        );
    }
}
export default ListVehicle;
import React, {Component} from 'react';
import {styleSheet} from "./style";
import {withStyles} from "@mui/styles";
import AppBar from '../../components/common/appBar'
import Hero from "../../components/Hero";
import Footer from "../../components/Footer/Footer";
import ListVehicle from "../../components/ListOfVehicles";


class Dashboard extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {classes} = this.props
        return (
            <div>
                <AppBar/>
                <Hero/>
                <ListVehicle/>
                <Footer/>

            </div>
        )
    }

}

export default withStyles(styleSheet)(Dashboard)

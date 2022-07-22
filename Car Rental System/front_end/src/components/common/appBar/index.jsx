import {Component} from "react";
import {styleSheet} from "./style";
import {withStyles} from "@mui/styles";
import {dividerClasses, Typography} from "@mui/material";
import logo from "../../../assets/img/carlogo.png"

class AppBar extends Component{
    constructor(props) {
        super(props);
    }
    render() {
        const {classes}=this.props

        return(

               <nav className={classes.container}>
                   <div className={classes.logo_container}>
                       <div className={classes.img_logo}>
                           <img src={logo} className="logo" alt=""/>
                       </div>
                   </div>
                   <div className={classes.nav_title_container}>
                       <Typography className={'text-white font-bold  mt-1.5  '}   variant="h4">Easy Car Rental</Typography>
                   </div>
                   <div className={classes.logginbutton_container}></div>
               </nav>


        )
    }
}
export default withStyles(styleSheet) (AppBar);
import {Component} from "react";
import {styleSheet} from "./style";
import {withStyles} from "@mui/styles";
import {dividerClasses, IconButton, Typography} from "@mui/material";
import {Dialog, DialogContent, DialogTitle } from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import logo from "../../../assets/img/carlogo.png"
import CommonButton from "../Button";
import LoginUser from "../../../pages/Session/login/user";

class AppBar extends Component{
    constructor(props) {
        super(props);
        this.state ={
            open:false
        }
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
                   <div className={classes.logginbutton_container}>
                       <CommonButton
                           size="large"
                           variant="outlined"
                           label="Login"
                           className="text-white border-white hover:bg-white hover:text-black"
                           onClick={() => this.setState({ open: true })}
                       />
                   </div>


                   <Dialog
                       open={this.state.open}
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
                                   Login
                               </Typography>

                               <IconButton onClick={() => this.setState({ open: false })}>
                                   <CloseIcon />
                               </IconButton>
                           </div>
                       </DialogTitle>
                       <DialogContent dividers>
                           <LoginUser />
                       </DialogContent>
                   </Dialog>
               </nav>


        )
    }
}
export default withStyles(styleSheet) (AppBar);
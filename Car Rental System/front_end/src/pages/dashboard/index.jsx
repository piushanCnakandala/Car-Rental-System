import React, {Component} from 'react';
import {styleSheet} from "./style";
import {withStyles} from "@mui/styles";


class Dashboard extends Component{
    constructor(props) {
        super(props);
    }
    render() {
        const {classes}=this.props
        return(
            <div className={classes.container}>
                <div className={classes.nav_bar_container}></div>
                <div className={classes.form_container}>
                    <div className={classes.img_background}>
                        <img src="" alt=""/>
                    </div>
                </div>

            </div>
        )
    }

}
export default withStyles(styleSheet) (Dashboard)
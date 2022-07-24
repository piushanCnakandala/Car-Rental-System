import React, {Component} from 'react';
import {dividerClasses, Typography} from "@mui/material";

class Hero extends Component {
    render() {
        return (
            <div className={'h-screen bg-black flex flex-col justify-center item-center'}>
                <div className={'bg-carImg w-screen h-4/5 bg-contain bg-origin-border bg-right bg-no-repeat bg-black flex flex-col  justify-center item-center'}>
                    <div className={'flex flex-col pl-7'}>
                        <Typography className={'text-white font-bold  mt-1.5  '}   variant="h3" component={'p'}>Rent your <Typography className={'text-red font-bold  mt-1.5  '}   variant="h2" component={'p'}>DREAM CAR</Typography> </Typography>
                        <Typography className={'text-white font-bold  mt-1.5  '}   variant="h3">at the lowest possible rate</Typography>

                    </div>


                </div>
2

            </div>
        );
    }
}

export default Hero;
import Dashboard from "../pages/dashboard";
import NotFound from "../pages/Session/login/NotFound.jsx";
import {Routes,Route} from "react-router-dom";
import LoginDriver from "../pages/Session/login/driver";
import LoginAdmin from "../pages/Session/login/admin";


function App() {
    return (
        <Routes>
            <Route exact path="/" element={<Dashboard/>}/>
            {/* <Route path="dashboard" element={<AdminManageDashboard/>}/>*/}

             <Route path="admin">
                <Route index element={<LoginAdmin/>}/>
                {/*<Route path="dashboard">
                    <Route index element={<AdminManageDashboard/>}/>
                    <Route path="vehiclemanage" element={<VehicleManage />} />
                    <Route path="vehiclerates" element={<VehicleRates/>}/>
                    <Route path="vehicletype" element={<VehicleType/>}/>
                    <Route path="test" element={<AddNewVehicle />} />
                </Route>*/}
            </Route>
            <Route path="driver">
                <Route index element={<LoginDriver/>}/>
               {/* <Route path="dashboard" element={<AdminManageDashboard/>}/>*/}
            </Route>

            <Route path="*" element={<NotFound/>}/>
        </Routes>

    );
}


export default App;
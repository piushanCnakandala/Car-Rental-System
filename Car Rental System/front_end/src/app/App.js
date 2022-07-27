import AdminDashboard from "../pages/Admin/Dashboard";
import NotFound from "../pages/Session/login/NotFound.jsx";
import {Routes,Route} from "react-router-dom";
import LoginDriver from "../pages/Session/login/driver";
import LoginAdmin from "../pages/Session/login/admin";
import VehicleManage from "../pages/Admin/Vehicle Manage";
import VehicleRates from "../pages/Admin/Vehicle Rates";
import VehicleType from "../pages/Admin/Vehicle Types";
import Dashboard from "../pages/dashboard";
import DriverManage from "../pages/Admin/Driver Manage";
import CustomerManage from "../components/Customer Manage";


function AdminManageDashboard() {
    return null;
}

function AddNewVehicle() {
    return null;
}

function App() {
    return (
        <Routes>
            <Route exact path="/" element={<Dashboard/>}/>

             <Route path="admin">
                <Route index element={<LoginAdmin/>}/>
                {<Route path="dashboard">
                    <Route index element={<AdminDashboard/>}/>
                    <Route path="vehiclemanage" element={<VehicleManage />} />
                    <Route path="vehiclerates" element={<VehicleRates/>}/>
                    <Route path="vehicletype" element={<VehicleType/>}/>
                    <Route path="drivermanage" element={<DriverManage/>}/>
                    <Route path="customermanage" element={<CustomerManage/>}/>
                    <Route path="test" element={<AddNewVehicle />} />
                </Route>}
            </Route>
            <Route path="driver">
                <Route index element={<LoginDriver/>}/>
               { <Route path="dashboard" element={<AdminManageDashboard/>}/>}
            </Route>

            <Route path="*" element={<NotFound/>}/>
        </Routes>

    );
}


export default App;
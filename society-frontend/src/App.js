import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

import HomePage from './Components/HomePart/HomePage';
import Login from './Components/HomePart/Login';
import Register from './Components/HomePart/Register';

import ResidentHome from './Components/Residents/ResidentHome';
import ResidentProfileMain from './Components/Residents/Profile/IndexPage'
import ResidentProfilePassword from './Components/Residents/Profile/Password';
import ResidentProfileUpdate from './Components/Residents/Profile/Update';
import ResidentBillPage from './Components/Residents/Bills/IndexPage';
import ResidentComplainMain from './Components/Residents/Complains/Main';

import ManagerHome from './Components/Managers/ManagerHome';
import ManagerProfileMain from './Components/Managers/Profile/';
import ManagerProfileUpdate from "./Components/Managers/Profile/UpdateProfile";
import ManagerComplainMain from "./Components/Managers/Complains/";
import ManagerBillsMain from "./Components/Managers/Bills/";
import ManagerStaffMain from './Components/Managers/Staffs/';

import SupervisorHome from './Components/Supervisor/SupervisorHome';
import SupervisorManager from "./Components/Supervisor/Managers/";
import SupervisorProfileMain from './Components/Supervisor/Profile/';
import SupervisorUserMain from './Components/Supervisor/Users/'
import SupervisorNoticeMain from './Components/Supervisor/Notice/'
import SupervisorProfileUpdate from './Components/Supervisor/Profile/Update';
import SupervisorProfilePassword from './Components/Supervisor/Profile/Password'; 

function App() {
	return (
		<Router>
			<Routes>
				<Route exact path='/' element={< HomePage />}></Route>
				<Route path='/login' element={<Login />}></Route>
				<Route path='/register' element={<Register />}></Route>

				{/* Residents */}
				<Route path='/residents' element={<ResidentHome />}></Route>
				<Route path='/residents/profile' element={<ResidentProfileMain />}></Route>
				<Route path='/residents/profile/password' element={<ResidentProfilePassword />}></Route>
				<Route path='/residents/profile/update' element={<ResidentProfileUpdate />}></Route>
				<Route path='/residents/bills' element={<ResidentBillPage />}></Route>
				<Route path='/residents/complains' element={<ResidentComplainMain />}></Route>

				{/* Managers */}
				<Route path='/managers' element={<ManagerHome />}></Route>
				<Route path='/managers/profile' element={<ManagerProfileMain />}></Route>
				<Route path='/managers/profile/update' element={<ManagerProfileUpdate />}></Route>
				<Route path='/managers/complains' element={<ManagerComplainMain />}></Route>
				<Route path='/managers/bills' element={<ManagerBillsMain />}></Route>
				<Route path='/managers/staffs' element={<ManagerStaffMain />}></Route>

				{/* Supervisor */}
				<Route path='/supervisors' element={<SupervisorHome />}></Route>
				<Route path='/supervisors/manager' element={<SupervisorManager />}></Route>
				<Route path='/supervisors/profile' element={<SupervisorProfileMain />}></Route>
				<Route path='/supervisors/profile/update' element={<SupervisorProfileUpdate />}></Route>
				<Route path='/supervisors/profile/password' element={<SupervisorProfilePassword />}></Route>
				ute path='/supervisors/users' element={<SupervisorUserMain />}></Route>
				<Route path='/supervisors/notice' element={<SupervisorNoticeMain />} ></Route>

			</Routes>
		</Router>
	);
}

export default App;

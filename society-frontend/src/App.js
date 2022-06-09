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
import ManagerComplainMain from "./Components/Managers/Complains/";
import ManagerBillsMain from "./Components/Managers/Bills/";
import ManagerStaffMain from './Components/Managers/Staffs/'

import SupervisorHome from './Components/Supervisor/SupervisorHome'

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
				<Route path='/managers/complains' element={<ManagerComplainMain />}></Route>
				<Route path='/managers/bills' element={<ManagerBillsMain />}></Route>
				<Route path='/managers/staffs' element={<ManagerStaffMain />}></Route>

				{/* Supervisor */}
				<Route path='/supervisors' element={<SupervisorHome />}></Route>

			</Routes>
		</Router>
	);
}

export default App;

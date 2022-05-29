import React from 'react';
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';

import HomePage from './Components/HomePart/HomePage';
import Login from './Components/HomePart/Login';
import Register from './Components/HomePart/Register';

import ResidentHome from './Components/Residents/ResidentHome';
import ResidentProfileMain from './Components/Residents/Profile/IndexPage'
import ResidentProfilePassword from './Components/Residents/Profile/Password';
import ResidentProfileUpdate from './Components/Residents/Profile/Update';
import ResidentBillPage from './Components/Residents/Bills/IndexPage';
import ResidentComplainMain from './Components/Residents/Complains/Main';

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

        </Routes>
    </Router>
  );
}

export default App;

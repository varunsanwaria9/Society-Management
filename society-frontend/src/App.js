import React from 'react';
import { BrowserRouter as Router,Routes, Route, Link } from 'react-router-dom';

import HomePage from './Components/HomePart/HomePage';
import Login from './Components/HomePart/Login';
import Register from './Components/HomePart/Register';

function App() {
  return (
    <Router>
        <Routes>
          <Route exact path='/' element={< HomePage />}></Route>
          <Route path='/login' element={<Login />}></Route>
          <Route path='/register' element={<Register />}></Route>
        </Routes>
    </Router>
  );
}

export default App;

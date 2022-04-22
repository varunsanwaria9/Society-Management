import { useState } from 'react';
import { Link } from 'react-router-dom';

import '../styles/HomePart/Register.css';

export default function Register() {
  
	const [users,setUsers]  = useState({
		name: '',
		phone_no: '',
		email: '',
		password: '',
	})
	const [confPwd,setConfPwd] = useState('');  
	const [showNotification, setShowNotification] = useState({
		show: false,
		msg: "",
	});

	const handleSubmit = (e) => {
		e.preventDefault();
		console.log(users);
	}

	return (
		<div className="regBody">
			<form className="regForm">
				<div className="formHead">
					<h1>Register</h1>
				</div>
				{showNotification.show && <div className="alert alert-danger">{showNotification.msg}</div>}
				<div className="formGroup">
				<label>Name</label>
				<input type="text" 
					value={users.name}
					onChange={(e) => setUsers({...users,name:e.target.value})}
					className="formControl" 
					placeholder='Enter Name' 
					required />
				</div>
				<div className="formGroup">
				<label>Email</label>
				<input type="email" 
					value={users.email}
					onChange={(e) => setUsers({...users,email:e.target.value})}
					className="formControl" 
					placeholder='Enter Email' 
					required />
				</div>
				<div className="formGroup">
				<label>Password</label>
				<input type="text"
					value={users.password}
					onChange={(e) => setUsers({...users,password:e.target.value})} 
					className="formControl" 
					placeholder='Enter Password' 
					required />
				</div>
				<div className="formGroup">
				<label>Confirm Password</label>
				<input type="password"
					value={confPwd}
					onChange={(e) => setConfPwd(e.target.value)}
					className="formControl" 
					placeholder='Enter Password' 
					required />
				</div>
				<div className="formGroup">
					<label>Phone Number</label>
					<input type="text"
						value={users.phone_no}
						onChange={(e) => setUsers({...users,phone_no:e.target.value})}
						className="formControl"
						placeholder='Enter Phone Number' 
						required />
				</div>
				<div className="formGroup">
					<button className="btn btn-primary" onClick={handleSubmit}>Register</button>
				</div>
				<div className="formGroup">
					<p>Already have an account? <Link to="/login">Login</Link></p>
				</div>
			</form>
		</div>
	);
}
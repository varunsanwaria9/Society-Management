import React,{ useState,useEffect } from 'react';
import { Link } from 'react-router-dom';
import AllApi from '../../services/AllApi';

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

	useEffect(() => {
        if(localStorage.getItem('token')){
            let temp = localStorage.getItem('token').split(" ");
            switch(temp[1]) {
                case "RESIDENT":
                    window.location.href = "/residents";
                    break;
                default:
                    alert("Invalid user type");
                    break;
            }
        }
    },[]);

	const handleSubmit = (e) => {
		e.preventDefault();
		if(users.password === confPwd){
			AllApi.Register(users).then(res => {
				if(res.status === 201){
					window.location.href = "/login";
				}
				else{
					setShowNotification({
						show: true,
						msg: "Something went wrong.",
					});
				}
			})
			.catch(err => {
				if(err.response.status === 400){
					setShowNotification({
						show: true,
						msg: "Email already exists.",
					});
				}
				else{
					setShowNotification({
						show: true,
						msg: "Unknown error with status code: " + err.response.status,
					});
				}
			})
		}
		else{
			setShowNotification({
				show: true,
				msg: "Password does not match",
			});
		}
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
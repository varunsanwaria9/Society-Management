import React, {useState, useEffect} from 'react';
import {Link} from 'react-router-dom';
import AllApi from '../../services/AllApi';
import '../styles/HomePart/Login.css';

export default function Login() {

	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [showNotification, setShowNotification] = useState({
		show: false,
		msg: "",
	});

	useEffect(() => {
		if (localStorage.getItem('token')) {
			let temp = localStorage.getItem('token').split(" ");
			switch (temp[1]) {
				case "RESIDENT":
					window.location.href = "/residents";
					break;
				case "MANAGER":
					window.location.href = "/managers";
					break;
				case "SUPERVISOR":
					window.location.href = '/supervisors'
					break;
				default:
					alert("Invalid user type");
					break;
			}
		}
	}, []);

	const handleSubmit = (e) => {
		e.preventDefault();
		if (email.trim() && password.trim()) {
			AllApi.Login({email, password})
				.then(res => {
					// console.log(res);
					if (res.status === 200) {
						let temp = res.data.split(" ");
						localStorage.setItem("token", res.data)
						switch (temp[1]) {
							case "RESIDENT":
								window.location.href = "/residents";
								break;
							case "MANAGER":
								window.location.href = "/managers";
								break;
							case "SUPERVISOR":
								window.location.href = '/supervisors';
								break;
							default:
								alert("Invalid user type");
								break;
						}
					}
				})
				.catch(err => {
					let eResp = err.response;
					console.log(eResp.status);
					if (eResp) {
						if (eResp.status === 400) {
							setShowNotification({
								show: true,
								msg: "Invalid email",
							});
						}
						else if (eResp.status === 403) {
							setShowNotification({
								show: true,
								msg: "Invalid password",
							});
						}
						else {
							setShowNotification({
								show: true,
								msg: "Something went wrong",
							});
						}
					}
					else {
						setShowNotification({
							show: true,
							msg: "Network Error",
						});
					}
				})
		}
		else {
			setShowNotification({
				show: true,
				msg: "Please fill all the fields",
			});
		}
	}

	return (
		<div className="loginBody">
			<form className="loginForm">
				<div className="formHead">
					<h1>Login</h1>
				</div>
				{showNotification.show && <div className="alert alert-danger">{showNotification.msg}</div>}
				<div className="formGroup">
					<label>Email</label>
					<input type="email"
						value={email}
						onChange={(e) => setEmail(e.target.value)}
						className="formControl"
						placeholder='Enter Email' />
				</div>
				<div className="formGroup">
					<label>Password</label>
					<input type="password"
						value={password}
						onChange={(e) => setPassword(e.target.value)}
						className="formControl"
						placeholder='Enter Password' />
				</div>
				<div className="formGroup">
					<button className="btn btn-primary" onClick={handleSubmit}>Login</button>
				</div>
				<div className="formGroup">
					<p>Dont have an account? <Link to="/register">Register</Link></p>
				</div>
			</form>
		</div>
	);
}

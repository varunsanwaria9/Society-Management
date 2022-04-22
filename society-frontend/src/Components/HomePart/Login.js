import { useState } from 'react';
import { Link } from 'react-router-dom';
import '../styles/HomePart/Login.css';

export default function Login() {

   	const [email, setEmail] = useState('');
   	const [password, setPassword] = useState('');
   	const [showNotification, setShowNotification] = useState({
		show: false,
		msg: "",
	});

	const handleSubmit = (e) => {
		e.preventDefault();
		console.log(email, password);
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
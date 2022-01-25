import { useState } from 'react';
import Link from 'next/link';
import Router from 'next/router';
import AllApi from '../services/AllApi'
import styles from '../styles/Login.module.css';

export default function Login() {

   const [email, setEmail] = useState('');
   const [password, setPassword] = useState('');
   const [showNotification, setShowNotification] = useState({
    show: false,
    msg: "",
  });

   const handleSubmit = e => {
		e.preventDefault();	
		setShowNotification({ ...showNotification, show: false });
		if(email && password){
			AllApi.Login({email, password})
				.then(res => {
					if(res.status===200){
						Router.push('/Person');
					}
				})
				.catch(err => {
					if(err.response.status===400){
						setShowNotification({
							show: true,
							msg: 'Incorrect Email',
						})
					}
					else if(err.response.status===403){
						setShowNotification({
							show: true,
							msg: 'Incorrect Password',
						})
					}
					else{
						setShowNotification({
							show: true,
							msg: 'Something went wrong',
						})
					}
				});
   		}else{
			setShowNotification({
				show: true,
				msg: "Enter all details"
			})
		}
	}
	
   return (
    	<div className={styles.loginBody}>
			<form className={styles.loginForm}>
				<div className={styles.formHead}>
					<h1>Login</h1>
				</div>
				{showNotification.show && <div className="alert alert-danger">{showNotification.msg}</div>}
				<div className={styles.formGroup}>
					<label>Email</label>
					<input type="email" 
						value={email}
						onChange={(e) => setEmail(e.target.value)}
						className={styles.formControl} 
						placeholder='Enter Email' />
				</div>
				<div className={styles.formGroup}>
					<label>Password</label>
					<input type="password" 
						value={password} 
						onChange={(e) => setPassword(e.target.value)}
						className={styles.formControl} 
						placeholder='Enter Password' />
				</div>
				<div className={styles.formGroup}>
					<button className="btn btn-primary" onClick={handleSubmit}>Login</button>
				</div>
				<div className={styles.formGroup}>
					<p>Dont have an account? <Link href="/register">Register</Link></p>
				</div>
			</form>
    	</div>
  );
}
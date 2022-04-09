import { useState } from 'react';
import Link from 'next/link';
import Router from 'next/router';
import styles from '../styles/Register.module.css';
import AllApi from '../services/AllApi';

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

	const handleSubmit = e => {
		e.preventDefault();
		setShowNotification({ ...showNotification, show: false });
		if(users.name && users.phone_no && users.email && users.password && confPwd){
			if(users.password === confPwd){
				AllApi.Register(users)
					.then(res => {
						if(res.status === 201){
							Router.push('/login');
						}
					})
					.catch(err => {
						if(err.response){
							if(err.response.status === 400){
								setShowNotification({
									show: true,
									msg: 'Email already exists',
								})
							}
							else{
								setShowNotification({
									show: true,
									msg: 'Something went wrong',
								})
							}
						}
					})
			}
			else{
				setShowNotification({
					show: true,
					msg: "Password doesn't match"
				})
			}
		}
		else{
			setShowNotification({
				show: true,
				msg: "Enter all details"
			})
		}
	}

	return (
		<div className={styles.regBody}>
			<form className={styles.regForm}>
				<div className={styles.formHead}>
					<h1>Register</h1>
				</div>
				{showNotification.show && <div className="alert alert-danger">{showNotification.msg}</div>}
				<div className={styles.formGroup}>
				<label>Name</label>
				<input type="text" 
					value={users.name}
					onChange={(e) => setUsers({...users,name:e.target.value})}
					className={styles.formControl} 
					placeholder='Enter Name' 
					required />
				</div>
				<div className={styles.formGroup}>
				<label>Email</label>
				<input type="email" 
					value={users.email}
					onChange={(e) => setUsers({...users,email:e.target.value})}
					className={styles.formControl} 
					placeholder='Enter Email' 
					required />
				</div>
				<div className={styles.formGroup}>
				<label>Password</label>
				<input type="text"
					value={users.password}
					onChange={(e) => setUsers({...users,password:e.target.value})} 
					className={styles.formControl} 
					placeholder='Enter Password' 
					required />
				</div>
				<div className={styles.formGroup}>
				<label>Confirm Password</label>
				<input type="password"
					value={confPwd}
					onChange={(e) => setConfPwd(e.target.value)}
					className={styles.formControl} 
					placeholder='Enter Password' 
					required />
				</div>
				<div className={styles.formGroup}>
					<label>Phone Number</label>
					<input type="text"
						value={users.phone_no}
						onChange={(e) => setUsers({...users,phone_no:e.target.value})}
						className={styles.formControl}
						placeholder='Enter Phone Number' 
						required />
				</div>
				<div className={styles.formGroup}>
					<button className="btn btn-primary" onClick={handleSubmit}>Register</button>
				</div>
				<div className={styles.formGroup}>
					<p>Already have an account? <Link href="/login">Login</Link></p>
				</div>
			</form>
		</div>
	);
}
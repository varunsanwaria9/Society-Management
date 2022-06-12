import React, {useState, useEffect} from "react";
import ManagerNavbar from '../ManagerNavbar';
import ManagerService from '../../../services/ManagerService'

export default function ManagerProfileUpdate() {

	const [profile, setProfile] = useState({})
	const [auth, setAuth] = useState({})

	const handleSubmit = (e) => {
		ManagerService.profileUpdate(profile)
			.then(res => {
				if (res.status === 201) {
					window.location.href = '/managers/profile'
				}
			})
			.catch(err => {
				console.log(err);
			})
	}

	useEffect(() => {
		ManagerService.detailsById()
			.then(res => {
				if (res.status === 200) {
					console.log(res.data);
					setProfile(res.data)
					setAuth(res.data.auth)
				}
			})
	}, [])

	return (
		<div className='manager-body'>
			<ManagerNavbar />
			<div className="content">
				<form className="regForm">
					<div className="formHead">
						<h1>Update Details</h1>
					</div>
					<div className="formGroup">
						<label>Name</label>
						<input type="text"
							value={profile.name}
							onChange={(e) => setProfile({...profile, name: e.target.value})}
							className="formControl"
							placeholder='Enter Name'
							required />
					</div>
					<div className="formGroup">
						<label>Email</label>
						<input type="email"
							value={auth.email}
							onChange={(e) => setAuth({...auth, email: e.target.value})}
							className="formControl"
							placeholder='Enter Email'
							disabled />
					</div>
					<div className="formGroup">
						<label>Phone Number</label>
						<input type="text"
							value={profile.phone}
							onChange={(e) => setProfile({...profile, phone: e.target.value})}
							className="formControl"
							placeholder='Enter Phone Number'
							required />
					</div>
					<div className="formGroup">
						<label>Address</label>
						<input type='text'
							value={profile.address}
							onChange={(e) => setProfile({...profile, address: e.target.value})}
							className='formControl'
							placeholder='Enter Address'
							required />
					</div>
					<div className="formGroup">
						<button className="btn btn-primary" onClick={handleSubmit}>Update</button>
					</div>
				</form>
			</div>
		</div>
	)
}



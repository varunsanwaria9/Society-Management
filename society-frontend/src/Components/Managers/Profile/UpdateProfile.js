import React, {useState, useEffect} from "react";
import ManagerNavbar from '../ManagerNavbar';

export default function ManagerProfileUpdate() {

	const [profile, setProfile] = useState({})
	const [auth, setAuth] = useState({})

	const handleSubmit = (e) => {
	}

	useEffect(() => {
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
						<button className="btn btn-primary" onClick={handleSubmit}>Update</button>
					</div>
				</form>
			</div>
		</div>
	)
}



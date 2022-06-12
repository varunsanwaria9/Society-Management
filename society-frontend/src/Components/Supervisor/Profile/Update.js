import React, {useEffect, useState} from "react";
import SupervisorService from "../../../services/SupervisorService"; 
import SupervisorNavbar from "../SupervisorNavbar";


export default function SupervisorProfileUpdate() {

	const [profile, setProfile] = useState({})
	const [auth, setAuth] = useState({})

		const handleSubmit = e => {
				SupervisorService.updateSupervisor(profile)
						.then(res => {
								if(res.status === 201){
										window.location.href = '/supervisors/profile'
								}
						})
						.catch(err => {
								console.log(err);
						})
		} 

	useEffect(() => {
		SupervisorService.getDetailsById()
			.then(res => {
				if (res.status === 200) {
					setProfile(res.data)
					setAuth(res.data.auth)
				}
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	return (
		<div className="manager-body">
			<SupervisorNavbar />
				<div className="content">
						<form className="regForm">
								<div className="formHead">
										<h1>Update Details</h1>
								</div>
								<div className="formGroup">
										<label>Name</label>
										<input type="text" 
												value={profile.name}
												onChange={(e) => setProfile({...profile,name:e.target.value})}
												className="formControl" 
												placeholder='Enter Name' 
												required />
								</div>
								<div className="formGroup">
										<label>Email</label>
										<input type="email"
												value={auth.email}
												onChange={(e) => setAuth({...auth,email:e.target.value})}
												className="formControl"
												placeholder='Enter Email'
												disabled />
								</div>
								<div className="formGroup">
										<label>Phone Number</label>
										<input type="text"
												value={profile.phone}
												onChange={(e) => setProfile({...profile,phone:e.target.value})}
												className="formControl"
												placeholder='Enter Phone Number' 
							required />
					</div>
					<div className="formGroup">
						<label>Address</label>
						<input type='text'
							value={profile.address}
							onChange={(e) => setProfile({...profile, address: e.target.value})}
							className="formControl"
							placeholder="Enter Address"
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

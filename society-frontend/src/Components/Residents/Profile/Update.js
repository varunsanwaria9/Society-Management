import React, {useState, useEffect} from 'react';
import ResidentNavbar from '../ResidentNavbar';

import ResidentService from '../../../services/ResidentService';
import '../../styles/Residents/ProfileUpdate.css'

export default function ResidentProfileUpdate() {

	const [resident, setResident] = useState({})
	const [auth, setAuth] = useState({})

	useEffect(() => {
		ResidentService.detailsById()
			.then(response => {
				console.log(response.data);
				setResident(response.data);
				setResident(response.data);
				setAuth(response.data.auth);
			})
			.catch(e => {
				console.log(e);
			})
	}, [])

	const handleSubmit = e => {
		e.preventDefault();
		ResidentService.update(resident)
			.then(response => {
				if (response.status === 201) {
					window.location.href = "/Residents/profile"
				}
				else {
					alert("Some unknown error")
				}
			})
			.catch(e => {
				console.log(e);
			})
	}

	return (
		<div className="body">
			<ResidentNavbar />
			<div className="content">
				<form className="regForm">
					<div className="formHead">
						<h1>Update Details</h1>
					</div>
					<div className="formGroup">
						<label>Name</label>
						<input type="text"
							value={resident.name}
							onChange={(e) => setResident({...resident, name: e.target.value})}
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
							value={resident.phone_no}
							onChange={(e) => setResident({...resident, phone_no: e.target.value})}
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

import React, {useState, useEffect} from "react";
import ManagerNavbar from "../ManagerNavbar";
import ManagerService from "../../../services/ManagerService";
import '../../styles/Managers/profile.css';

export default function ManagerProfileMain() {

	const [details, setDetails] = useState({})
	const [auth, setAuth] = useState({})
	const [tower, setTower] = useState({})

	useEffect(() => {
		ManagerService.detailsById()
			.then(res => {
				if (res.status === 200) {
					setDetails(res.data)
					setAuth(res.data.auth)
					setTower(res.data.tower_ref)
				}
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	return (
		<div className="manager-profile-main-body">
			<ManagerNavbar />
			<div>
				<div>
					<button className="btn btn-primary">Update Profile</button>
					<button className="btn btn-primary">Update Password</button>
					<button className="btn btn-danger">Delete Profile</button>
				</div>
				<div>
					<div>
						<p>Name</p>
						<p>{details.name}</p>
					</div>
					<div>
						<p>Address</p>
						<p>{details.address}</p>
					</div>
					<div>
						<p>Phone Number</p>
						<p>{details.phone}</p>
					</div>
					<div>
						<p>Email</p>
						<p>{auth.email}</p>
					</div>
					<div>
						<p>Tower</p>
						<p>{tower.tower_name}</p>
					</div>
				</div>
			</div>
		</div>
	)
}



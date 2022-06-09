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
			<div className='residentProfileBody'>
				<div className='residentProfileBodyLeft'>
					<button className="btn btn-primary w-25 my-2">Update Profile</button>
					<button className="btn btn-primary w-25 my-2">Update Password</button>
					<button className="btn btn-danger w-25 my-2">Delete Profile</button>
				</div>
				<div className='residentProfileBodyRight'>
						<p className='residentProfileBodyP'>Name <span>:{details.name}</span></p>
						<p className='residentProfileBodyP'>Address <span>:{details.address}</span></p>
						<p className='residentProfileBodyP'>Phone Number <span>:{details.phone}</span></p>
						<p className='residentProfileBodyP'>Email <span>:{auth.email}</span></p>
						<p className='residentProfileBodyP'>Tower <span>:{tower.tower_name}</span></p>
				</div>
			</div>
		</div>
	)
}



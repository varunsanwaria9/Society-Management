import React, {useState, useEffect} from "react";
import ManagerNavbar from "../ManagerNavbar";
import ManagerService from "../../../services/ManagerService";
import '../../styles/Managers/profile.css';

export default function ManagerProfileMain() {

	const [details, setDetails] = useState({})
	const [auth, setAuth] = useState({})
	const [towers, setTowers] = useState({})

	const handleRoute = val => window.location.href = val

	useEffect(() => {
		ManagerService.detailsById()
			.then(res => {
				if (res.status === 200) {
					// console.log(res.data);
					setDetails(res.data)
					setAuth(res.data.auth)
					setTowers(res.data.tower_ref)
				}
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	return (
		<div className="manager-body">
			<ManagerNavbar />
			<div className='residentProfileBody'>
				<div className='residentProfileBodyLeft'>
					<button className="btn btn-primary w-25 my-2" onClick={() => handleRoute('/managers/profile/update')}>Update Profile</button>
					<button className="btn btn-primary w-25 my-2" onClick={() => handleRoute('/managers/profile/password')}>Update Password</button>
					<button className="btn btn-danger w-25 my-2">Delete Profile</button>
				</div>
				<div className='residentProfileBodyRight'>
					<p className='residentProfileBodyP'>Name <span>:{details.name}</span></p>
					<p className='residentProfileBodyP'>Email <span>:{auth.email}</span></p>
					<p className='residentProfileBodyP'>Phone <span>:{details.phone}</span></p>
					<p className="residentProfileBodyP">Address <span>:{details.address}</span></p>
					<p className='residentProfileBodyP'>Tower <span>:{towers.tower_name}</span></p>
				</div>
			</div>
		</div>
	)
}



import React, {useState, useEffect} from 'react';
import ResidentNavbar from '../ResidentNavbar';
import '../../styles/Residents/Profile.css';
import ResidentService from '../../../services/ResidentService';

export default function RegisterProfilePage() {

	const [resident, setResident] = useState({});
	const [auth, setAuth] = useState({});
	const [portfolio, setPortfolio] = useState({});
	const [residence, setResidence] = useState({});

	useEffect(() => {
		ResidentService.detailsById()
			.then(response => {
				setResident(response.data);
				setAuth(response.data.auth);
				setPortfolio(response.data.portfolio);
				setResidence(response.data.residence_ref);
			})
			.catch(e => {
				console.log(e);
			});
	}, []);

	const handleRoute = (route) => {
		window.location.href = route;
	}

	const deleteBtn = () => {
		ResidentService.deleteResident()
			.then(res => {
				if (res.status === 200) {
					localStorage.clear()
					window.location.href = '/'
				}
			})
	}

	return (
		<div>
			<ResidentNavbar />
			<div className="residentProfileBody">
				<div className="residentProfileBodyLeft"> {/* Left Part */}
					<button className='btn btn-primary w-25 my-2' onClick={() => handleRoute("/residents/profile/update")}>Update Profile</button>
					<button className='btn btn-primary w-25 my-2' onClick={() => handleRoute("/residents/profile/password")}>Update Password</button>
					<button className='btn btn-danger w-25 my-2' onClick={deleteBtn}>Delete Profile</button>
				</div>
				<div className="residentProfileBodyRight"> {/* Right Part */}
					<p className="residentProfileBodyP">Name <span>:{resident.name}</span></p>
					<p className="residentProfileBodyP">Email <span>:{auth.email}</span></p>
					<p className="residentProfileBodyP">Phone <span>:{resident.phone_no}</span></p>
					<p className="residentProfileBodyP">Portfolio<span>:{portfolio.post}</span></p>
					<p className="residentProfileBodyP">Flat No <span>:{residence.flat_no}</span></p>
				</div>
			</div>
		</div>
	);
}

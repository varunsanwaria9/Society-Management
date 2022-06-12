import React, {useState, useEffect} from 'react';
import SupervisorNavbar from '../SupervisorNavbar'
import SupervisorService from '../../../services/SupervisorService'

export default function SupervisorProfileMain() {

	const [profile, setProfile] = useState({})
	const [auth, setAuth] = useState({})

	useEffect(() => {
		SupervisorService.getDetailsById()
			.then(res => {
				if (res.status === 200) {
					setProfile(res.data)
					setAuth(res.data.auth)
					// console.log(res.data);
				}
			})
			.catch(err => {
				console.log(err)
			})
	}, [])

	return (
		<div className='manager-body'>
			<SupervisorNavbar />
			<div className='residentProfileBody'>
				<div className='residentProfileBodyLeft'>
					<button className='btn btn-primary w-25 my-2'>Update Profile</button>
					<button className='btn btn-primary w-25 my-2'>Update Password</button>
					<button className='btn btn-danger w-25 my-2'>Delete Profile</button>
				</div>
				<div className='residentProfileBodyRight'>
					<p className='residentProfileBodyP'>Name<span>:{profile.name}</span></p>
					<p className='residentProfileBodyP'>Email<span>:{auth.email}</span></p>
					<p className='residentProfileBodyP'>Phone<span>:{profile.phone}</span></p>
					<p className='residentProfileBodyP'>Address<span>:{profile.address}</span></p>
				</div>
			</div>
		</div>
	)
}



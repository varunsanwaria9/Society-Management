import React, {useState, useEffect} from 'react';
import ManagerNavbar from "../ManagerNavbar";
import ComplainService from "../../../services/ComplainService";

export default function ManagerComplainMain() {

	const [complains, setComplains] = useState([])


	useEffect(() => {
		ComplainService.getAllRaisedComplains()
			.then(res => {
				if (res.status === 200) {
					setComplains(res.data)
				}
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	return (
		<div>
			<ManagerNavbar />
			<div>
				<p>Search place</p>
			</div>
			{complains.map(complain => {
				return (
					<div key={complain.complain_id}>
						<p>{complain.details}</p>
						<p>{complain.raised_on}</p>
						<p>Residence Details</p>
						{complain.status === 'RAISED' && <button className='btn btn-warning'>RAISED</button>}
						{complain.status === 'CHECKED' && <button className='btn btn-primary'>CHECKED</button>}
						{complain.status === 'SOLVED' && <button className='btn btn-danger' disabled>SOLVED</button>}
					</div>
				)
			})}
		</div>
	)
}


import React, {useState, useEffect} from 'react';
import ManagerNavbar from "../ManagerNavbar";
import ComplainService from "../../../services/ComplainService";
import UpdateModel from './UpdateModel';
import '../../styles/Managers/Complain.css'

export default function ManagerComplainMain() {

	const [complains, setComplains] = useState([])
	const [openModel, setOpenModel] = useState(false)
	const [refValue, setRefValue] = useState(null)

	const displayModel = value => {
		setOpenModel(!openModel)
		setRefValue(value)
	}

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
		<div className='manager-body'>
			<ManagerNavbar />
			<div>
				<p>Search place</p>
			</div>
			<div className='manager-main-box'>
				{complains.map(complain => {
					return (
						<div key={complain.complain_id} className='manager-complain-box'>
							<p className='w-40'>{complain.details}</p>
							<p>{complain.raised_on}</p>
							<p>Residence Details</p>
							{complain.status === 'RAISED' && <button className='btn btn-warning' onClick={() => displayModel(complain)}>RAISED</button>}
							{complain.status === 'CHECKED' && <button className='btn btn-primary' onClick={() => displayModel(complain)}>CHECKED</button>}
							{complain.status === 'SOLVED' && <button className='btn btn-danger' disabled>SOLVED</button>}
						</div>
					)
				})}
			</div>
			{openModel && <UpdateModel refValue={refValue} displayModel={displayModel} />}
		</div>
	)
}


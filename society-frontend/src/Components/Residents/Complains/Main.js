import React, {useState, useEffect, useRef} from 'react';
import ResidentNavbar from '../ResidentNavbar';
import AddModel from './AddModel';

import '../../styles/Residents/ComplainMain.css'
import ComplainService from '../../../services/ComplainService';

export default function Main() {

	const [complains, setComplains] = useState([]);
	// store current date in to and a week eariler in from
	const dates = {
		from: new Date().getDate() - 7,
		to: new Date()
	}
	const [showModel, setShowModel] = useState(false);

	const resp = useRef(null)

	useEffect(() => {
		ComplainService.getResidentComplainRaised()
			.then(res => {
				setComplains(res.data);
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	const searchBtn = () => {

	}

	const switchShowModel = () => setShowModel(!showModel);

	return (
		<div className='resident-complain-main-body'>
			<ResidentNavbar />
			<div className='d-flex flex-column'>

				<div className='form-group px-2 my-4 d-flex flex-row w-100 '>
					<div className='d-flex flex-row mx-4'>
						<label>From:</label>
						<input type="date" className='resident-complain-main-input'></input>
					</div>
					<div className='d-flex flex-row mx-4'>
						<label>To:</label>
						<input type="date" className='resident-complain-main-input'></input>
					</div>
					<div className='mx-2'>
						<button className='btn btn-primary' onClick={searchBtn}>Search</button>
					</div>
					<div className='mx-5'></div>
					<div className='mx-5'></div>
					<div className='mx-5'>
						<button className='btn btn-danger' onClick={switchShowModel}>Add Complaints</button>
					</div>
				</div>
				<div className='d-flex flex-row'>
					{/* Display value of complains */}
					{complains.map(complain => {
						return (
							<div className="resident-bill-index-card" key={complain.complain_id}>
								<p>{complain.details}</p>
								<div className="d-flex">
									<p>Generated On: </p>
									<p>{complain.raised_on}</p>
								</div>
								<div className="d-flex">
									<p>Status: </p>
									<p>{complain.status}</p>
								</div>
							</div>
						)
					})}
				</div>
			</div>
			{showModel && <AddModel setShowModel={switchShowModel} resp={resp} />}
		</div>
	)
}

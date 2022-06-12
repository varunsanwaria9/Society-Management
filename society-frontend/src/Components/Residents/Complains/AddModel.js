import React from 'react'
import ComplainService from '../../../services/ComplainService'
import '../../styles/Residents/AddComplain.css';

export default function complainAddModel(props) {


	const onSubmit = () => {
		ComplainService.addComplain({
			value: props.resp.current.value,
			ref: localStorage.getItem('token').split(' ')[0]
		})
			.then(res => {
				if (res.status == 201) {
					props.setShowModel()
				}
			})
			.catch(err => {
				console.log(err);
			})
	}

	return (
		<div className='resident-complain-add-body'>
			<div className='w-50'>
				<div className='d-flex justify-content-end'>
					<button className='btn btn-danger' onClick={props.setShowModel}>x</button>
				</div>
				<hr />
				<div className='d-flex justify-content-center'>
					<textarea className='form-control' placeholder='Enter Complain' ref={props.resp}></textarea>
				</div>
				<br />
				<div className='d-flex justify-content-center'>
					<button className='btn btn-danger' onClick={onSubmit}>Submit</button>
				</div>
			</div>
		</div>
	)
}


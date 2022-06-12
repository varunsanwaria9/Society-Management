import React from 'react';
export default function NoticeAddModel(props) {

	return (
		<div className='resident-complain-add-body d-flex flex-direction-column'>
			<div className='w-50'>
				<button className='btn btn-danger' onClick={props.displayModel}>X</button>
			</div>
			<hr />
			<div className='d-flex justify-content-center flex-direction'>
				<textarea className='form-control' placeholder='Enter notice'></textarea>
				<br />
				<div className='d-flex justify-content-center'>
					<button className='btn btn-primary'>Submit</button>
				</div>
			</div>
		</div>
	)
}



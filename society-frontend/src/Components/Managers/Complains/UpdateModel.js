import React from "react";
import ComplainService from '../../../services/ComplainService'

export default function ComplainUpdateModel(props) {

	const handleClick = value => {
		ComplainService.updateComplains({...props.refValue, status: value})
			.then(res => {
				if (res.status === 200) {
					props.displayModel();
				}
			})
			.catch(err => {
				console.log(err);
			})
	}
	return (
		<div className="manager-complain-update-body">
			<div className="manager-complain-update-box">
				<div className="d-flex justify-content-end">
					<button className="btn btn-danger" onClick={props.displayModel}>X</button>
				</div>
				<div className="d-flex justify-content-center">
					<p>Change Status to</p>
				</div>
				<div className="d-flex justify-content-around">
					<button className="btn btn-danger" onClick={() => handleClick("RAISED")}>RAISED</button>
					<button className="btn btn-warning" onClick={() => handleClick("CHECKED")}>CHECKED</button>
					<button className="btn btn-success" onClick={() => handleClick("SOLVED")}>SOLVED</button>
				</div>
			</div>
		</div >
	)
}



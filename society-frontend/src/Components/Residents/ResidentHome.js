import React, {useState, useEffect} from 'react';
import ResidentNavbar from './ResidentNavbar';
import {Canvas} from '@react-three/fiber';
import {Html} from '@react-three/drei';
import Parent from "../3dModels/Parent";
import ResidentService from '../../services/ResidentService';
import '../styles/Residents/HomePage.css'

export default function ResidentHome() {

	const [notices, setNotices] = useState([])

	useEffect(() => {
		ResidentService.getAllNotices()
			.then(res => {
				if (res.status === 200) {
					console.log(res.data);
					setNotices(res.data)
				}
			})
			.catch(err => {
				console.log(err);
			})
	}, [])

	return (
		<div className='resident-home-main'>
			<ResidentNavbar />
			<div className='resident-home-canvas'>
				<div className='resident-home-notice'>
					{notices.map(notice => {
						return (
							<div key={notice.notice_id}>
								<p>{notice.created_on}</p>
								<p>{notice.details}</p>
								<hr />
							</div>
						)
					})}
				</div>
			</div>
		</div>
	)
}

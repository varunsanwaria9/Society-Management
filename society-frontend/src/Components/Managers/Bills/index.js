import React, {useState, useEffect} from 'react';
import ManagerNavbar from "../ManagerNavbar";
import AddModel from './AddModel';
import BillsService from '../../../services/BillsService';

export default function ManagerBillsMain() {

	const [bills, setBills] = useState([])
    const [showModel,setShowModel] = useState(false)

	useEffect(() => {
		BillsService.allGeneratedBills()
			.then(res => {
				if(res.status === 200){
					setBills(res.data)
				}
			})
			.catch(err => {
				console.log(err)
			})
	}, [])

	const displayModel = () => setShowModel(!showModel)

	return (
		<div>
			<ManagerNavbar />
			<div className='d-flex flex-direction-row'>
				<p>Search Value</p>
				<button className='btn btn-danger' onClick={displayModel}>+ Create Bills</button>
			</div>
			<div className='d-flex flex-direction-row'>
				{bills.map(bill => {
					return (
						<div key={bill.bill_id} className='px-2'>
							<p>{bill.details}</p>
							<p>{bill.amount}</p>
							<p>{bill.residence_ref.flat_no}</p>
							<p>{bill.generated_on}</p>
							<p>{bill.status}</p>
						</div>
					)
				})}
			</div>
			{showModel && <AddModel displayModel={displayModel} />}
		</div>
	)
}

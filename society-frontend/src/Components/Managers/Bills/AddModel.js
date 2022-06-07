import React, {useState} from 'react';
import BillService from '../../../services/BillsService'
import '../../styles/Managers/billModel.css'

export default function ManagerBillsModel(props) {

	const [billModel, setBillModel] = useState({
		details: '',
		amount: 0,
		flat_no: ''
	})

	const handleSubmit = () => {
		BillService.addBill(billModel)
			.then(res => {
				console.log(res);
			})
			.catch(err => {
				console.log(err);
			})
	}

	return (
		<div className='managers-bill-model-body'>
			<div className='d-flex justify-content-end w-25'>
				<button className='btn btn-danger' onClick={props.displayModel}>X</button>
			</div>
			<div className='w-25'>
				<form>
					<div className='form-group py-2'>
						<label>Reason</label>
						<input type='text'
							value={billModel.details}
							onChange={(e) => setBillModel({...billModel, details: e.target.value})}
							ame='form-control'
							placeholder='Enter Reason' />
					</div>
					<div className='form-group py-2'>
						<label>Amount</label>
						<input type='number'
							value={billModel.amount}
							onChange={(e) => setBillModel({...billModel, amount: e.target.value})}
							className='form-control'
							placeholder='Enter Amount' />
					</div>
					<div className='form-group py-2'>
						<label>Flat No</label>
						<input type='text'
							value={billModel.flat_no}
							onChange={(e) => setBillModel({...billModel, flat_no: e.target.value})}
							className='form-control'
							placeholder='Enter Flat No' />
					</div>
					<div className='form-group py-2 d-flex justify-content-center'>
						<button className='btn btn-primary' onClick={handleSubmit}>Submit</button>
					</div>
				</form>		
			</div>
		</div>
	)
}

import React, {useState, useEffect} from 'react';
import ResidentNavbar from '../ResidentNavbar';
import { useParams } from 'react-router-dom';
import BillsService from '../../../services/BillsService'
import '../../styles/Residents/Payment.css'

export default function ResidentBillPayment() {

	const [bills, setBills] = useState({})
		const {id} = useParams()
		const [cardDetails,setCardDetails] = useState({
				cardNumber:'',
				expiryDate:'',
				cvv:''
		})
		
		const handleSubmit = (e) => {
				BillsService.makeBillsPaid(id)
						.then(res => {
								if(res.status === 201){
										console.log(res.data);
										window.location.href = '/residents/bills'
								}
						})
						.catch(err => {
								console.log(err);
						})
		}

	useEffect(() => {
			BillsService.getBillsById(id)
				.then(res => {
						if(res.status === 200){
								setBills(res.data)
						}
				})
				.catch(err => {
					console.log(err)
				})
				
	}, [])

	return (
		<div className='manager-body'>
			<ResidentNavbar />
			<div className='d-flex justify-content-evenly align-items-center'>
				<div className='payment-card'>
					<div className='formGroup'>
						<label>Card Number</label>
						<input type='text'
							value={cardDetails.cardNumber}
							onChange={(e) => setCardDetails({...cardDetails, cardNumber: e.target.value})}
							className='formControl'
							placeholder='Enter Card Number'
							required />
					</div>
					<div className='formGroup'>
						<label>Expiry Date</label>
						<input type='text'
							value={cardDetails.expiryDate}
							onChange={(e) => setCardDetails({...cardDetails, expiryDate: e.target.value})}
							className='formControl'
							placeholder='MM/YY'
							required />
					</div>
					<div className='formGroup'>
						<label>CVV</label>
						<input type='text'
							value={cardDetails.cvv}
							className='formControl'
							onChange={(e) => setCardDetails({...cardDetails, cvv: e.target.value})}
							placeholder='CVV'
							required />
					</div>
				</div>
				<div className='payment-sidebox'>
					<p className='bold'>Amount</p>
					<p>{bills.amount}</p>
					<button className='btn btn-primary' onClick={handleSubmit}>Pay Now</button>
				</div>
			</div>
		</div>
	)
}



import axios from 'axios';

const baseUrl = 'http://localhost:8080/bills';

const addBill = (bill) => {
	return axios.post(`${baseUrl}/add`, bill);
}

const getBillsById = (id) => {
	return axios.get(`${baseUrl}/get/${id}`);
}

const getBillsByGenerated = (id) => {
	return axios.get(`${baseUrl}/generated/${id}`);
}

const getBillsBetnDates = (billDateModel) => {
	return axios.post(`${baseUrl}/dates`, billDateModel);
}

const allGeneratedBills = () => {
	return axios.get(`${baseUrl}/generated`)
}

const makeBillsPaid = (id) => {
	return axios.put(`${baseUrl}/paid/${id}`)
}

export default {
	addBill,
	getBillsById,
	getBillsByGenerated,
	getBillsBetnDates,
	allGeneratedBills,
	makeBillsPaid
}

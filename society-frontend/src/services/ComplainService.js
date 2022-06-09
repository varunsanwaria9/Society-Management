import axios from "axios";

const url = "http://localhost:8080/complain";

const addComplain = (complain) => {
	return axios.post(`${url}/add`, complain);
}

const getComplainById = () => {
	let id = localStorage.getItem("token").split(" ")[0];
	return axios.get(`${url}/get/${id}`);
}

const getResidentComplainRaised = () => {
	let id = localStorage.getItem("token").split(" ")[0];
	return axios.get(`${url}/raised/${id}`);
}

const getAllRaisedComplains = () => {
	return axios.get(`${url}/allRaised/`)
}

const updateComplains = value => {
	return axios.put(`${url}/update`, value)
}

export default {
	addComplain,
	getComplainById,
	getResidentComplainRaised,
	getAllRaisedComplains,
	updateComplains
}

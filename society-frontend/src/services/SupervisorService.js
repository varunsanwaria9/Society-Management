import axios from "axios";

const url = "http://localhost:8080/supervisor";

const getDetailsByEmail = () => {
	let email = localStorage.getItem("details").split(" ")[0]
	return axios.get(`${url}/profile/email/${email}`);
}

const getDetailsById = () => {
	let id = localStorage.getItem('token').split(' ')[0]
	return axios.get(`${url}/profile/get/${id}`);
}

const updateSupervisor = (supervisor) => {
	return axios.put(`${url}/profile/update/supervisor`, supervisor);
}

const getAllManagers = () => {
	return axios.get(`${url}/managers/all`)
}

const searchResidents = value => {
	return axios.get(`${url}/resident/search/${value}`)
}

const addNotice = notice => {
	return axios.post(`${url}/notice/add`, notice)
}

const getAllNotices = () => {
	return axios.get(`${url}/notice/all`)
}

const deleteNotice = id => {
	return axios.delete(`${url}/notice/delete/${id}`)
}

export default {
	getDetailsByEmail,
	getDetailsById,
	updateSupervisor,
	getAllManagers,
	searchResidents,
	addNotice,
	getAllNotices,
	deleteNotice
} 

import axios from "axios";

const url = "http://localhost:8080/residents";

const detailsByEmail = () => {
	let email = localStorage.getItem("token").split(" ")[0]
	return axios.get(`${url}/findByEmail/${email}`)
}

const detailsById = () => {
	let id = localStorage.getItem("token").split(" ")[0]
	return axios.get(`${url}/get/id/${id}`)
}

const update = (resident) => {
	// console.log(resident);
	return axios.put(`${url}/updateProfile`, resident)
}

const deleteResident = () => {
	let id = localStorage.getItem("token").split(" ")[0]
	return axios.delete(`${url}/delete/${id}`)
}


export default {
	detailsByEmail,
	detailsById,
	update,
	deleteResident
}

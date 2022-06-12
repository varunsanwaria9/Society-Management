import axios from "axios";

const url = "http://localhost:8080/manager";

const detailsById = () => {
	let id = localStorage.getItem("token").split(" ")[0]
	axios.get(`${url}/profile/get/${id}`)
}

const profileUpdate = val => {
	return axios.put(`${url}/profile/update`, val)
}

export default {
	detailsById,
	profileUpdate
}

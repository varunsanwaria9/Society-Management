import axios from "axios";

const url = "http://localhost:8080/manager";

const detailsById = () => {
	let id = localStorage.getItem("token").split(" ")[0]
	return axios.get(`${url}/profile/get/${id}`)
}

export default {
	detailsById
}

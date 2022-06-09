import axios from 'axios';

const watchmenUrl = 'http://localhost:8080/watchmen'
const workerUrl = 'http://localhost:8080/worker'

const getAllWatchmen = () => {
	return axios.get(`${watchmenUrl}/all`)
}

const getAllWorker = () => {
	return axios.get(`${workerUrl}/all`)
}

const getWatchmenByTower = () => {
	const id = localStorage.getItem("token").split(" ")[0]
	return axios.get(`${watchmenUrl}/tower/${id}`)
}

const getWorkersByTower = () => {
	const id = localStorage.getItem("token").split(" ")[0]
	return axios.get(`${workerUrl}/tower/${id}`)
}

export default {
	getAllWatchmen,
	getAllWorker,
	getWatchmenByTower,
	getWorkersByTower
}

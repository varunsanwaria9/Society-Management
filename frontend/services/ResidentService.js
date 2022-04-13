import axios  from "axios";

const url = "http://localhost:8080/residents/";

const detailsByEmail = () => {
    let email = localStorage.getItem("details").split(" ")[0]
    return axios.get(url + `findByEmail/${email}`)
}

export default {
    detailsByEmail
}
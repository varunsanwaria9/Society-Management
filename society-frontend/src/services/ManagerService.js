import axios from "axios";

const url = "http://localhost:8080/manager/";

const detailsByEmail = () => {
    let email = localStorage.getItem("details").split(" ")[0]
    return axios.get(url + `profile/email/${email}`)
}

export default {
    detailsByEmail,
}
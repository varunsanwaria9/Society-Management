import axios from "axios";

const url = "http://localhost:8080/manager/";

const detailsByEmail = (email) => {
    email = "manager1@mail.com"
    return axios.get(url + `profile/email/${email}`)
}

export default {
    detailsByEmail,
}
import axios  from "axios";

const url = "http://localhost:8080/residents/";

const detailsByEmail = () => {
    let email = "john@mail.com"
    return axios.get(url + `findByEmail/${email}`)
}

export default {
    detailsByEmail
}
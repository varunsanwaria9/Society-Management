import axios  from "axios";

const url = "http://localhost:8080/residents";

const detailsByEmail = () => {
    let email = localStorage.getItem("details").split(" ")[0]
    return axios.get(`${url}/findByEmail/${email}`)
}

const update = (resident) => {
    // console.log(resident);
    return axios.put(`${url}/updateProfile`, resident)
}

export default {
    detailsByEmail,
    update
}
import axios from "axios";

const personUrl = "http://localhost:8080/persons/";
const apiUrl = "http://localhost:8080/api/";

const login = details => {
    console.log(details);
    const form = new URLSearchParams();
    form.append("email", details.email);
    form.append("password", details.password);
    return axios.post(apiUrl + `login`, form, {
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
    })
}

const register = details => {
    console.log(details);
    return axios.post(apiUrl, details);
}
export default {
    login,
    register
};
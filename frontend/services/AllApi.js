import axios from 'axios';

const url = "http://localhost:8080/api/"

const Login = details => {
    console.log(details);
    return axios.post(url + 'login', details)
}

const Register = user => {
    console.log(user);    
    return axios.post(url + 'register', user)
}

export default {
    Login,
    Register
}
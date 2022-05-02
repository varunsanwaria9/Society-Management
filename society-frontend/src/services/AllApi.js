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

const updatePassword = model => {
    console.log(model);
    return axios.put(url + 'updatePassword',{email:"john@mail.com",oldPwd:model.oldPwd,newPwd:model.newPwd})
}

export default {
    Login,
    Register,
    updatePassword
}
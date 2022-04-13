import React,{useState} from 'react';
import AllApi from '../../../services/AllApi';

export default function SupervisorProfilePaassword(){

    const [pwd,setPwd] = useState({
        oldPwd:"",
        newPwd:"",
        repwd:""
    })
    
    const onSubmit = e => {
        e.preventDefault()
        AllApi.updatePassword(pwd)
            .then(res => {
                console.log(res);
            })
            .catch(e => {
                console.log(e);
            })
    }

    return(
        <div>
            
        </div>
)}
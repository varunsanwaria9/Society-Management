import React,{ useEffect,useState } from 'react';

export default function ManagersProfilePassword(){
    
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
    
    return (
        <div>
        </div>
)}
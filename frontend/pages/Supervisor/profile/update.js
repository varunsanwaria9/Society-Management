import React,{useEffect,useState} from 'react';
import SupervisorService from '../../../services/SupervisorService';

export default function SupervisorProfileUpdate(){

    const [supervisor, setSupervisor] = useState({});
    
    useEffect(() => {
        SupervisorService.getDetailsByEmail("")
        .then(response => {
            setSupervisor(response.data);
        })
        .catch(e => {
            console.log(e);
        })

    },[])

    return(
        <div>
            <h1>Supervisor Profile Update</h1>
        </div>
)
}
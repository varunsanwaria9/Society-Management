import React,{useEffect,useState} from 'react';
import SupervisorService from '../../../services/SupervisorService';


export default function SupervisorProfilePage() {
    
    const [supervisor, setSupervisor] = useState({});
    const [auth, setAuth] = useState({});

    useEffect(() => {
        SupervisorService.getDetailsByEmail()
        .then(response => {
            console.log(response.data);
            setSupervisor(response.data);
            setAuth(response.data.auth);
        })
        .catch(e => {
            console.log(e);
        })
    
    },[])
    
    return (
        <div>
            <h1>SupervisorProfilePage</h1>
        </div>
)}
import React,{ useEffect,useState } from 'react';
import ManagerService from '../../../services/ManagerService';

export default function ManagersProfilePage(){

    const [manager, setManager] = useState({})
    const [auth,setAuth] = useState({})
    const [supervisor,setSupervisor] = useState({})
    const [tower,setTower] = useState({})

    useEffect(() => {
        ManagerService.detailsByEmail()
        .then(response => {
            // console.log(response.data)
            setManager(response.data)
            setAuth(response.data.auth)
            setSupervisor(response.data.supervisor_ref)
            setTower(response.data.tower_ref)
        })
        .catch(e => {
            console.log(e);
        })
    },[])

    return(
        <div>
            Profile Page
        </div>
)}
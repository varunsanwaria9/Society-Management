import React, { useEffect, useState } from 'react';
import ManagerService from '../../../services/ManagerService';

export default function ManagersProfilePage() {
    
    const [manager,setManager] = useState({});

    useEffect(() => {
        ManagerService.detailsByEmail("")
        .then(response => {
            // console.log(response.data)
            setManager(response.data)
        })
        .catch(e => {
            console.log(e);
        })
    },[]);        

    return(
        <div>
        </div>
)}
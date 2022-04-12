import React,{useEffect,useState} from 'react';
import ResidentService from '../../../services/ResidentService';

export default function ResidentProfileUpdate(){
    
    const [resident, setResident] = useState({});

    useEffect(() => {
        ResidentService.detailsByEmail("")
        .then(response => {
            // console.log(response.data);
            setResident(response.data);
        })
        .catch(e => {
            console.log(e);
        });
    },[]);        

    return(
        <div>
            <p>Update Residents Details Page</p>
            <p>{JSON.stringify(resident)}</p>
        </div>
)}
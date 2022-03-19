import React,{useState,useEffect} from 'react';
import ResidentService from '../../../services/ResidentService';

export default function ResidentCommPage() {

    const [resident, setResident] = useState({});

    useEffect(() => {
        ResidentService.detailsByEmail()
        .then(response => {
            setResident(response.data);
        })
        .catch(e => {
            console.log(e);
        });
    },[]);

    return(
        <div>
            <p>Resident Community Page</p>
            <p>{JSON.stringify(resident)}</p>
        </div>
)}

import React,{useEffect,useState} from 'react';
import ResidentService from '../../../services/ResidentService';

export default function ResidentProfilePage() {
    
    const [resident, setResident] = useState({});

    useEffect(() => {
        ResidentService.detailsByEmail()
        .then(response => {
            console.log(response.data);
        })
        .catch(e => {
            console.log(e);
        });
    },[]);        
    
    return(
        <div>
            <p>Resident Profile Page</p>
        </div>
)}
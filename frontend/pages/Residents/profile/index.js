import React,{useEffect,useState} from 'react';
import ResidentService from '../../../services/ResidentService';

export default function ResidentProfilePage() {
    
    const [resident, setResident] = useState({});

    // Show Resident Details
    //  4 buttons: Update Profile, Update Password, Delete Profile, Show Committes (if  any with resident details & if not then show create new committee)
    useEffect(() => {
        ResidentService.detailsByEmail()
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
            <p>Resident Profile Page</p>
            <p>{JSON.stringify(resident)}</p>
        </div>
)}
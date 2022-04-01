import React,{useEffect,useState} from 'react';
import ResidentNavbar from '../../../components/ResidentNavbar';
import ResidentService from '../../../services/ResidentService';

export default function ResidentProfilePage() {
    
    const [resident, setResident] = useState({});
    const [auth, setAuth] = useState({});
    const [portfolio,setPortfolio] = useState({});
    const [residence,setResidence] = useState({});
    const [committee,setCommittee] = useState([]);

    // Show Resident Details
    //  4 buttons: Update Profile, Update Password, Delete Profile, Show Committes (if  any with resident details & if not then show create new committee)
    useEffect(() => {
        ResidentService.detailsByEmail()
        .then(response => {
            // console.log(response.data);
            setResident(response.data);
            setAuth(response.data.auth);
            setPortfolio(response.data.portfolio);
            setResidence(response.data.residence_ref);
            setCommittee(response.data.committee);
        })
        .catch(e => {
            console.log(e);
        });
    },[]);        
    
    return(
        <div>
            <ResidentNavbar />
            <div className='residentProfileBody'>
                <div className='residentProfileBodyLeft'> {/* Left Part */} 
                    <button className='btn btn-primary'>Update Profile</button>
                    <button className='btn btn-primary'>Update Password</button>
                    <button className='btn btn-danger'>Delete Profile</button>
                </div>
                <div className='residentProfileBodyRight'> {/* Right Part */}
                    <p>Name: <span>{resident.name}</span></p>
                    <p>Email: <span>{auth.email}</span></p> 
                    <p>Phone: <span>{resident.phone_no}</span></p> 
                    <p>Portfolio:<span>{portfolio.post}</span></p>
                    <p>Flat No: <span>{residence.flat_no}</span></p>
                    <p>Committes: <span>
                        {
                            committee.length == 0 ? 
                            "Not Yet In Any" : 
                            <button className='btn btn-info'>Show Committes</button>
                        }
                    </span></p>
                </div>
            </div>
        </div>
)}
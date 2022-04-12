import React,{useEffect,useState} from 'react';
import Router from 'next/router';

import ResidentNavbar from '../../../components/ResidentNavbar';
import ResidentService from '../../../services/ResidentService';
import styles from '../../../styles/Residents/Profile.module.css'

export default function ResidentProfilePage() {
    
    const [resident, setResident] = useState({});
    const [auth, setAuth] = useState({});
    const [portfolio,setPortfolio] = useState({});
    const [residence,setResidence] = useState({});
    const [committee,setCommittee] = useState([]);

    // Show Resident Details
    //  4 buttons: Update Profile, Update Password, Delete Profile, Show Committes (if  any with resident details & if not then show create new committee)
    useEffect(() => {
        ResidentService.detailsByEmail("")
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
            <div className={styles.residentProfileBody}>
                <div className={styles.residentProfileBodyLeft}> {/* Left Part */} 
                    <button className='btn btn-primary w-25 my-2' onClick={() => Router.push('/Residents/profile/update')}>Update Profile</button>
                    <button className='btn btn-primary w-25 my-2' onClick={() => Router.push('/Residents/profile/password')}>Update Password</button>
                    <button className='btn btn-danger w-25 my-2'>Delete Profile</button>
                </div>
                <div className={styles.residentProfileBodyRight}> {/* Right Part */}
                    <p className={styles.residentProfileBodyP}>Name <span>:{resident.name}</span></p>
                    <p className={styles.residentProfileBodyP}>Email <span>:{auth.email}</span></p> 
                    <p className={styles.residentProfileBodyP}>Phone <span>:{resident.phone_no}</span></p> 
                    <p className={styles.residentProfileBodyP}>Portfolio<span>:{portfolio.post}</span></p>
                    <p className={styles.residentProfileBodyP}>Flat No <span>:{residence.flat_no}</span></p>
                    <p className={styles.residentProfileBodyP}>Committes <span>
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
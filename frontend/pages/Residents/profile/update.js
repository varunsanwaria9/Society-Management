import React,{useEffect,useState} from 'react';
import Router from 'next/router';

import styles from '../../../styles/Residents/ProfileUpdate.module.css';
import ResidentService from '../../../services/ResidentService';
import ResidentNavbar from '../../../components/ResidentNavbar';

export default function ResidentProfileUpdate(){
    
    const [resident, setResident] = useState({});
    const [auth, setAuth] = useState({});
    const [portfolio,setPortfolio] = useState({});
    const [residence,setResidence] = useState({});
    const [committee,setCommittee] = useState([]);

    useEffect(() => {
        ResidentService.detailsByEmail("")
        .then(response => {
            console.log(response.data);
            setResident(response.data);
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

    const handleSubmit = e => {
        e.preventDefault();
        ResidentService.update(resident)
        .then(response => {
            if(response.status === 201){
                Router.push("/Residents/profile");
            }
            else{
                alert("Some unknown error")
            }
        })
        .catch(e => {
            console.log(e);
        })
    }

    return(
        <div className={styles.body}>
            <ResidentNavbar />
            <div className={styles.content}>
                <form className={styles.regForm}>
                    <div className={styles.formHead}>
                        <h1>Update Details</h1>
                    </div>
                    <div className={styles.formGroup}>
                        <label>Name</label>
                        <input type="text" 
                            value={resident.name}
                            onChange={(e) => setResident({...resident,name:e.target.value})}
                            className={styles.formControl} 
                            placeholder='Enter Name' 
                            required />
                    </div>
                    <div className={styles.formGroup}>
                        <label>Email</label>
                        <input type="email"
                            value={auth.email}
                            onChange={(e) => setAuth({...auth,email:e.target.value})}
                            className={styles.formControl}
                            placeholder='Enter Email'
                            disabled />
                    </div>
                    <div className={styles.formGroup}>
                        <label>Phone Number</label>
                        <input type="text"
                            value={resident.phone_no}
                            onChange={(e) => setResident({...resident,phone_no:e.target.value})}
                            className={styles.formControl}
                            placeholder='Enter Phone Number' 
                            required />
                    </div>
                    <div className={styles.formGroup}>
                        <button className="btn btn-primary" onClick={handleSubmit}>Update</button>
                    </div>
                </form>
            </div>
        </div>
)}
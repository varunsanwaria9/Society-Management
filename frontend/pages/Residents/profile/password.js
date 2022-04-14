import React,{useState} from 'react';
import Router from 'next/router';

import AllApi from '../../../services/AllApi';
import ResidentNavbar from '../../../components/ResidentNavbar';
import styles from '../../../styles/Residents/Password.module.css'

export default function ResidentProfilePassword() {
    
    const [pwd,setPwd] = useState({
        oldPwd:"",
        newPwd:"",
        repwd:""
    })
    
    const onSubmit = e => {
        e.preventDefault()
        AllApi.updatePassword(pwd)
            .then(res => {
                if(res.status === 200){
                    Router.push("/Residents/profile")
                }
                else{
                    alert("Some unknown error occured.")
                }
            })
            .catch(e => {
                console.log(e);
            })
    }

    return (
        <div>
            <ResidentNavbar />
            <div className={styles.residentpasswordbody}>
                <form className='w-50'>
                    <div className='form-group'>
                        <label>Old Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.oldPwd}
                            onChange={e => setPwd({...pwd,oldPwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group'>
                        <label>New Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.newPwd}
                            onChange={e => setPwd({...pwd,newPwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group'>
                        <label>Re-Enter Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.repwd}
                            onChange={e => setPwd({...pwd,repwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group d-flex justify-content-center'>
                        <button className='btn btn-primary' onClick={onSubmit}>Update Password</button>
                    </div>
                </form>
            </div>
        </div>
)}
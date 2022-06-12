import React,{ useState } from "react";
import ResidentNavbar from "../ResidentNavbar";
import '../../styles/Residents/Password.css';
import AllApi from "../../../services/AllApi";

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
                    window.location.href = "/residents/profile";
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
            <div className="residentpasswordbody">
                <form className='w-50'>
                    <div className='form-group py-2'>
                        <label>Old Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.oldPwd}
                            onChange={e => setPwd({...pwd,oldPwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group py-2'>
                        <label>New Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.newPwd}
                            onChange={e => setPwd({...pwd,newPwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group py-2'>
                        <label>Re-Enter Password</label>
                        <input type="password" 
                            className='form-control'
                            value={pwd.repwd}
                            onChange={e => setPwd({...pwd,repwd:e.target.value})}
                            placeholder='Enter old password' />
                    </div>
                    <div className='form-group d-flex justify-content-center py-2'>
                        <button className='btn btn-primary' onClick={onSubmit}>Update Password</button>
                    </div>
                </form>
            </div>
        </div>
)}

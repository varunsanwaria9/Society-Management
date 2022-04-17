import React,{useEffect} from 'react';
import Router from 'next/router';

export default function ResidentLogout(){
    useEffect(() => {
        localStorage.removeItem("details");
        Router.push('/login');
    }, []);
    return(
        <div></div>
)}
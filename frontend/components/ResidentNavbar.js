import React,{useEffect} from 'react';
import Router from 'next/router';
import styles from '../styles/Residents/Navbar.module.css';

export default function ResidentNavbar() {
    //  make a navbar with values of home, profile, complaints, bills and logout
    
    useEffect(() => {
        if(localStorage.getItem("details") === null){
            Router.push('/login');
        }
    }, []);

    const changePage = (page) => {
        Router.push(page);
    }
    
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-dark">
            <a className="navbar-brand w-75 text-light" href="#">Navbar</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <button className={styles.navBtn} onClick={(e) => changePage("/Residents")}>Home</button>
                    </li>
                    <li className="nav-item">
                        <button className={styles.navBtn}>Bills</button>
                    </li>
                    <li className="nav-item">
                        <button className={styles.navBtn}>Complains</button>
                    </li>
                    <li className="nav-item">
                        <button className={styles.navBtn} onClick={(e) => changePage("/Residents/profile")}>Profile</button>
                    </li>
                    <li className="nav-item">
                        <button className={styles.navBtn} onClick={(e) => changePage("/Residents/logout")}>Logout</button>
                    </li>
                </ul>
            </div>
        </nav>
)}
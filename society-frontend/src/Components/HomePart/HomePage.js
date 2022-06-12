import React,{ useEffect } from 'react';
import { Canvas } from '@react-three/fiber';
import { Html } from '@react-three/drei';
import Building3 from '../3dModels/Building03'

import '../styles/HomePart/HomePage.css'

export default function HomePage(){

    useEffect(() => {
        if(localStorage.getItem('token')){
            let temp = localStorage.getItem('token').split(" ");
            switch(temp[1]) {
                case "RESIDENT":
                    window.location.href = "/residents";
                    break;
				case "MANAGER":
						window.location.href = '/managers';
						break;
				case "SUPERVISOR":
						window.location.href = '/supervisors'
				default:
                    alert("Invalid user type");
                    break;
            }
        }
    },[]);

    const routeFn = (route) => {
        window.location.href = route;
    }

    return (
        <div className='App'>
            <Canvas className='canvas'>
                {/* <OrbitControls /> */}
                <ambientLight intensity={0.5} />
                <directionalLight position={[-2, 5, 2]} />
                <Building3 />
                <Html>
                    <div className='home-pos1'>
                        <p className='welcome-msg text-light'>Welcome</p>
                        <p className='text-light text-bold'>To</p>
                        <p className='text-light welcome-msg'>Aashiyana</p>
                        <div className='d-flex justify-content-around w-100'>
                            <button className='btn btn-primary' onClick={() => routeFn("login")}>Login</button>
                            <button className='btn btn-primary' onClick={() => routeFn("register")}>Register</button>
                        </div>
                    </div>
                </Html>
            </Canvas>
        </div>
)}

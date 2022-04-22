import React from 'react';
import { Canvas } from '@react-three/fiber';
import { Html } from '@react-three/drei';
import Building3 from '../3dModels/Building03'

import '../styles/HomePart/HomePage.css'

export default function HomePage(){

    const routeFn = (route) => {
        window.location.href = route;
    }

    return (
        <div className='App'>
            <Canvas className='canvas'>
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
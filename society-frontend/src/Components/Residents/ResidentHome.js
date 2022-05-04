import React from 'react';
import ResidentNavbar from './ResidentNavbar';
import { Canvas } from '@react-three/fiber';
import { Html } from '@react-three/drei';
import Person from '../3dModels/Person1'

import '../styles/Residents/HomePage.css'

export default function ResidentHome() {
  return (
    <div className='resident-home-main'>
        <ResidentNavbar />
        <div className='resident-home-canvas'>
          <Canvas className='resident-home-canvas'>
            <ambientLight intensity={0.5} />
            <directionalLight position={[-2, 5, 2]} />
            <Person />
            <Html>
              <div className='resident-homed-div'>
                <p className='resident-home-msg'>Welcome</p>
                <p className='resident-home-msg'>Resident</p>
              </div>
            </Html>
          </Canvas>
        </div>
    </div>
  );
}
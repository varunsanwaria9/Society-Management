import React from 'react';
import { Canvas } from '@react-three/fiber';
import { Html } from '@react-three/drei';
import SupervisorNavbar from './SupervisorNavbar'
import Admin from '../3dModels/Admin' 

export default function supervisorHome() {
    return (
        <div className='supervisor-home-main'>
        <SupervisorNavbar />
        <div className='supervisor-home-canvas'>
          <Canvas className='supervisor-home-canvas'>
            <ambientLight intensity={0.5} />
            <directionalLight position={[-2, 5, 2]} />
		    <Admin /> 
		    <Html>
              <div className='supervisor-homed-div'>
                <p className='supervisor-home-msg'>Welcome</p>
                <p className='supervisor-home-msg'>supervisor</p>
              </div>
            </Html>
          </Canvas>
        </div>
    </div>
  );
}
    

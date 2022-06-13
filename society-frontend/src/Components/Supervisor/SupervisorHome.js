import React from 'react';
import {Canvas} from '@react-three/fiber';
import {Html} from '@react-three/drei';
import SupervisorNavbar from './SupervisorNavbar'
import Admin from '../3dModels/Admin'

export default function supervisorHome() {
	return (
		<div className='manager-home-main'>
			<SupervisorNavbar />
			<div className='manager-home-canvas'>
				<Canvas className='manager-home-canvas'>
					<ambientLight intensity={0.5} />
					<directionalLight position={[-2, 5, 2]} />
					<Admin />
					<Html>
						<div className='manager-home-msg'>
							<p>Welcome</p>
							<p>supervisor</p>
						</div>
					</Html>
				</Canvas>
			</div>
		</div>
	);
}


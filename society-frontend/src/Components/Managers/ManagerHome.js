import React from "react";
import ManagerNavbar from './ManagerNavbar';
import { Canvas } from '@react-three/fiber';
import { Html } from '@react-three/drei';
import Person from "../3dModels/Person1";

import '../styles/Managers/HomePage.css'

export default function ManagerHome() {
	return (
		<div className="manager-home-main">
			<ManagerNavbar />
				<div className='manager-home-canvas'>
						<Canvas className='manager-home-canvas'>
								<ambientLight intensity={0.5} />
								<directionalLight position={[-2,5,2]} />
								<Person />
								<Html>
										<div className='manager-home-msg'>
												<p>Welcome</p>
												<p>Manager</p>
										</div>
								</Html>
						</Canvas>
				</div>
		</div>
	)
}

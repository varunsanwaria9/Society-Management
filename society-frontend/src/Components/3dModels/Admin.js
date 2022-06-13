/*
Auto-generated by: https://github.com/pmndrs/gltfjsx
author: hendrickkganyago (https://sketchfab.com/hendrickkganyago)
license: CC-BY-4.0 (http://creativecommons.org/licenses/by/4.0/)
source: https://sketchfab.com/3d-models/hendrick-kganyago-business-coaching-ba538062cbb04e469a5aaa1dc2fda200
title: Hendrick Kganyago Business Coaching
*/

import React, {useRef} from 'react'
import {useGLTF} from '@react-three/drei'

export default function Model({...props}) {
	const group = useRef()
	const {nodes, materials} = useGLTF('/admin.gltf')
	return (
		<group ref={group} {...props} dispose={null}>
			<group rotation={[-Math.PI / 2, 0, -0.2]} position={[-71.7, -70.1, -160.2]}>
				<mesh geometry={nodes.Object_2.geometry} material={materials.GTP_BMan_Jack_07_Stg_Lsn_Adl_Ccs_Gry_Mgr_BlendMaterial} />
				<mesh geometry={nodes.Object_3.geometry} material={materials.GTP_BMan_Jack_07_Stg_Lsn_Adl_Ccs_Gry_Mgr_BlendMaterial} />
			</group>
		</group>
	)
}

useGLTF.preload('/admin.gltf')

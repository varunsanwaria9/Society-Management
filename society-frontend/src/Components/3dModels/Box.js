import React from "react";

const BoxFunction = () => {
    return (
        <mesh rotation={[90, 0, 20]}>
            <boxBufferGeometry attach="geometry" args={[3, 3, 3]} />
            <meshNormalMaterial attach="material" />
            {/* <meshStandardMaterial map={colorMap} /> */}
        </mesh>
    )}

export default BoxFunction
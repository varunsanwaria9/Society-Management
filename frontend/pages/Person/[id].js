import React from 'react'
import { useRouter } from 'next/router'

// Path: localhost:3000/Person/(any value)

export default function PatientID() {
    
    const router = useRouter().query
    
    return (
        <div>
            <p>Patient Page with variable :- {router.id}</p>
        </div>
    )
}

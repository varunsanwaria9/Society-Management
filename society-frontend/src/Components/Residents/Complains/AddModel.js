import React from 'react'

export default function complainAddModel(props) {
    return(
        <div>
            <div>
                <div className='d-flex justify-content-end'>
                    <button className='btn btn-danger' onClick={props.setShowModel}>x</button>
                </div>
                <hr />
                <div className='d-flex justify-content-center'>
                    <textarea className='form-control' placeholder='Enter Complain'></textarea>
                </div>
            </div>
        </div>
)}

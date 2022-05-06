import React, { useEffect, useState } from "react";
import ResidentNavbar from "../ResidentNavbar";
import BillsService from '../../../services/BillsService'

import '../../styles/Residents/Bills.css'

export default function BillsIndexPage() {

    const [bills, setBills] = useState([])

    useEffect(() => {
        let id = localStorage.getItem('token').split(" ")[0]
        BillsService.getBillsByGenerated(id)
            .then(res => {
                if (res.status === 200) {
                    console.log(res.data);
                    setBills(res.data)
                }
            })
            .catch(err => {
                console.log(err);
            })
    }, [])

    return (
        <div className="resident-bill-index-main">
            <ResidentNavbar />

            {/* Search By Date */}


            {/* Card Display */}
            <div className="resident-bill-index-body">
                {bills.map(bill => {
                    return (
                        <div className="resident-bill-index-card" key={bill.bill_id}>
                            <p>{bill.details}</p>
                            <div className="d-flex">
                                <p>Generated on: </p>
                                <p>{bill.generated_on}</p>
                            </div>
                            <div className="d-flex">
                                <p>Amount: </p>
                                <p>{bill.amount}</p>
                            </div>
                            <div className="d-flex">
                                <p>Status: </p>
                                <p>{bill.status}</p>
                            </div>
                            <div className="d-flex justify-content-center">
                                <button className="btn">Pay Now</button>
                            </div>
                        </div>
                    )
                })}
            </div>

        </div>
    )
}
import React,{useState,useEffect} from "react";
import ManagerNavbar from '../ManagerNavbar';
import ManagerService from "../../../services/ManagerService";

export default function ManagerProfileUpdate() {
		
		const [profile,setProfile] = useState({})

		useEffect(() => {
				ManagerService.detailsById()
						.then(res => {
								if(res.status === 200){
										setProfile(res.data)
								}
						})
						.catch(err => {
								console.log(err);
						})
		},[])

		return(
				<div className='manager-body'>
						<ManagerNavbar />
						<div className='content'>
						</div>
				</div>
		)
}



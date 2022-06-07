import React,{useEffect} from 'react';

import '../styles/Residents/Navbar.css';

export default function ResidentNavbar() {

    useEffect(() => {
        if(localStorage.getItem("token") !== null) {
				let role = localStorage.getItem('token').split(" ")[1]
				if(role !== "RESIDENT"){
					window.location.href = `/${role.toLowerCase()}s/`
				}
		}
		else {
			window.location.href = '/login'
		}
	}, []);

	const handleRoute = (route) => {
		window.location.href = route;
	}

	const doLogout = () => {
		localStorage.clear();
		window.location.href = "/";
	}

	return (
		<nav className="navbar navbar-expand-sm bg-nav">
			<p className="navbar-brand w-75 text-light d-flex align-items-center">Aashiyana</p>
			<button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span className="navbar-toggler-icon"></span>
			</button>
			<div className="collapse navbar-collapse" id="navbarNav">
				<ul className="navbar-nav">
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/residents/')}>Home</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/residents/bills')}>Bills</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/residents/complains')}>Complains</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/residents/profile')}>Profile</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => doLogout()}>Logout</button>
					</li>
				</ul>
			</div>
		</nav>
	)
}

import React from "react";

export default function ManagerNavbar() {

	const handleRoute = val => {
		window.location.href = val
	}

	const doLogout = () => {
		localStorage.clear()
		window.location.href = "/"
	}
	return (
		<nav className="navbar navbar-expand-lg  bg-nav">
			<a className="navbar-brand w-75 text-light d-flex align-items-center" href="#">Aashiyana</a>
			<button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span className="navbar-toggler-icon"></span>
			</button>

			<div className="collapse navbar-collapse" id="navbarNav">
				<ul className="navbar-nav">
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/managers/')}>Home</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/managers/complains')}>Complains</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/managers/bills')}>Bills</button>
					</li>
					<li>
						<button className="navBtn" onClick={() => handleRoute('/managers/staffs')}>Staffs</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/managers/profile')}>Profile</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => doLogout()}>Logout</button>
					</li>
				</ul>
			</div>

		</nav>
	)
}

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
		<nav className="navbar navbar-expand-lg navbar-light bg-light">
			<a className="navbar-brand" href="#">Navbar</a>
			<button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span className="navbar-toggler-icon"></span>
			</button>

			<div className="collapse navbar-collapse" id="navbarSupportedContent">
				<ul className="navbar-nav mr-auto">
					<li className="nav-item active">
						<button className="nav-link" onClick={() => handleRoute('/managers/')}>Home</button>
					</li>
					<li className="nav-item">
						<button className="nav-link">Complains</button>
					</li>
					<li className="nav-item">
						<button className="nav-link">Bills</button>
					</li>
					<li className="nav-item">
						<button className="nav-link">Staffs</button>
					</li>
					<li className="nav-item">
						<button className="nav-link" onClick={() => handleRoute('/managers/profile')}>Profile</button>
					</li>
					<li className="nav-item">
						<button className="nav-link" onClick={doLogout}>Logout</button>
					</li>
				</ul>
			</div>
		</nav>
	)
}

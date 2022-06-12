import React, {useEffect} from 'react';
export default function SupervisorNavbar() {
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
						<button className="navBtn">Home</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/supervisors/notice')}>Notice</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/supervisors/users')}>Users</button>
					</li>
					<li className='nav-item'>
						<button className='navBtn' onClick={() => handleRoute('/supervisors/manager')}>Managers</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => handleRoute('/supervisors/profile')}>Profile</button>
					</li>
					<li className="nav-item">
						<button className="navBtn" onClick={() => doLogout()}>Logout</button>
					</li>
				</ul>
			</div>
		</nav>
	)
}


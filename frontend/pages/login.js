import React from 'react'
import Link from 'next/link'
// Path: localhost:3000/login


export default function login() {
	return (
		<div>
			<p>Login Page</p>
			<br />
			<Link href="/">
				<p>Home Page</p>
			</Link>
		</div>
	)
}

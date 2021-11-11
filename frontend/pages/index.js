import styles from '../styles/Home.module.css'
import Link from 'next/link'

// Path: localhost:3000/


export default function Home() {
	return (
		<div className={styles.container}>
			<p>Home Page</p>
			<br />
			<Link href="/login">
				<p>Login Page</p>
			</Link>
		</div>
	)
}

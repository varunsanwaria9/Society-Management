import styles from '../styles/Home.module.css'
import Link from 'next/link'
import {useRouter} from 'next/router'

export default function Home() {

	const router = useRouter()

	return (
		<div className={styles.container}>
			<nav className={styles.navbar}>
				<div className={styles.navbarHeader}>
					<span className="navbar-brand mb-0 h1">Housing Society</span>
				</div>
				<div className={styles.navTags}>
					<div className={styles.navbarElement}>
						<button className={styles.navbarBtn} onClick={() => router.push('/')}>HOME</button>
						<div className={styles.navbarBtnUnderline}></div>
					</div>
					<div className={styles.navbarElement}>
						<button className={styles.navbarBtn} onClick={() => router.push('/login')}>LOGIN</button>
						<div className={styles.navbarBtnUnderline}></div>
					</div>
					<div className={styles.navbarElement}>
						<button className={styles.navbarBtn} onClick={() => router.push('/register')}>REGISTER</button>
						<div className={styles.navbarBtnUnderline}></div>
					</div>
				</div>
			</nav>
		</div>
	)
}

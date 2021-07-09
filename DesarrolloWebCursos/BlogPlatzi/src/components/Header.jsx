import { Link } from "react-router-dom";

const Header = () =>
(
	<nav className="nav">
		<Link className="nav__link" to='/'>Usuarios</Link>
		<Link className="nav__link" to='/tareas'>Tareas</Link>
	</nav>
);

export default Header;

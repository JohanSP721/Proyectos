import { BrowserRouter, Route } from 'react-router-dom';

import Header from '../components/Header';
import Users from "../containers/Users";
import Publications from '../components/Publications';

import '../assets/styles/Global.css';
import '../assets/styles/components/Icons.css';

const Tareas = () => ( <h1>Tareas</h1> )

const App = () =>
(
	<BrowserRouter>
		<Header/>
		<div className="margin">
			<Route exact path="/" component={ Users } />
			<Route exact path="/tareas" component={ Tareas } />
			<Route exact path="/publicaciones/:key" component={ Publications } />
		</div>
	</BrowserRouter>
);

export default App;

import { BrowserRouter, Route } from 'react-router-dom';

import Users from "../containers/Users";
import Chores from '../containers/Chores';
import CreateChore from '../components/CreateChore';
import Header from '../components/Header';
import Publications from '../components/Publications';

import '../assets/styles/Global.css';

const App = () =>
(
	<BrowserRouter>
		<Header/>
		<div className="margin">
			<Route exact path="/" component={ Users } />
			<Route exact path="/tareas" component={ Chores } />
			<Route exact path="/publicaciones/:key" component={ Publications } />
			<Route exact path="/tareas/crear" component={ CreateChore } />
		</div>
	</BrowserRouter>
);

export default App;

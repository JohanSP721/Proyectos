import { useEffect } from 'react';

import { Link } from "react-router-dom";

import { useSelector, useDispatch } from 'react-redux';
import { takeAllChores, takeAllUsers, updateChore } from '../actions';

import Spinner from '../components/Spinner';

const Chores = () =>
{
	const { chores, users,	errorUsers, errorChores, loadingChores } = useSelector(state => state);

	const dispatch = useDispatch();

	const handleComplete = (choreId) =>
	{
		dispatch(updateChore(choreId));
	}

	useEffect(() =>
	{
		const takeChores = async () =>
		{
			!chores.length
			&&
				await dispatch(takeAllChores());
		}

		takeChores();
	}, [dispatch, chores]);

	useEffect(() =>
	{
		const takeUsers = async () =>
		{
			!users.length
			&&
				await dispatch(takeAllUsers());
		}

		takeUsers();
	}, [dispatch, users]);

	return (
		<div>
			<Link className="margin" to="/tareas/crear"><button>Crear Nueva Tarea</button></Link>
			{
				errorUsers === null
				?
					users.map(user =>
						(
							<article key={ user.id } className="margin">
								<h1 className="user-chores">Tareas de { user.name }</h1>
								{
									loadingChores
									?
										<Spinner/>
									:
										errorChores === null
										?
											chores.filter(chore => chore.userId === user.id).map(chore =>
											(
												<div className="chore" key={ chore.id }>
													<input type="checkbox" onClick={() => handleComplete(chore.id)} id={ `completed ${ chore.id }` } defaultChecked={chore.completed}/>
													<label htmlFor={ `completed ${ chore.id }` }> { chore.title } </label>
												</div>
											))
										:
											<h1 className="margin">{ errorChores }</h1>
								}
							</article>
						))
				:
					<h1 className="margin">{ errorUsers }</h1>

			}
		</div>
	)
};

export default Chores;

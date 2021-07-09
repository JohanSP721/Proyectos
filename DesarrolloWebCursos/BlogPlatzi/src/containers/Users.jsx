import { useEffect } from "react";

import { Link } from "react-router-dom";

import { useSelector, useDispatch } from 'react-redux';
import { takeAllUsers } from '../actions';

import Spinner from "../components/Spinner";

const Users = () =>
{
	const { users }= useSelector(state => state);

	const { errorUsers: error } = useSelector(state => state);

	const { loadingUsers: loading } = useSelector(state => state);

	const dispatch = useDispatch();

	useEffect(() =>
	{
		!users.length
		&&
		dispatch(takeAllUsers())
	}, [dispatch, users]);

	return (
		loading
			?
			<Spinner />
			:
			<div>
				<table className="table">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Enlace</th>
						</tr>
					</thead>
					<tbody>
						{
							error === null
								?
								users.map((user) =>
								(
									<tr key={user.id}>
										<td>{user.name}</td>
										<td>{user.email}</td>
										<td>{user.website}</td>
										<td>
											<Link to={ `/publicaciones/${user.id}` }>
												<div className="eye-solid icon"></div>
											</Link>
										</td>
									</tr>
								))
								:
								<tr>
									<td>Datos No Encontrados</td>
									<td>Datos No Encontrados</td>
									<td>Datos No Encontrados</td>
								</tr>
						}
					</tbody>
				</table>
			</div>
	);
};

export default Users;

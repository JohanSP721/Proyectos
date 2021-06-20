import { useState, useEffect } from "react";

const App = () =>
{
	const [users, setUsers] = useState([]);

	useEffect( () => {

		const fetchData = async () =>
		{
			try
			{
				const response = await fetch('https://jsonplaceholder.typicode.com/users');
				const users = await response.json();
				setUsers(users);
			}

			catch (error)
			{
				console.error(error);
			}
		};

		fetchData();
	}, []);

	return(
		<div className="margin">
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
						users.map( user =>
						(
							<tr key= { user.id }>
								<td>{ user.name }</td>
								<td>{ user.email }</td>
								<td>{ user.website }</td>
							</tr>
						) )
					}
				</tbody>
			</table>
		</div>
	);
};

export default App;

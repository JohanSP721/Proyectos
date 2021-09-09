import axios from "axios";
import { actions } from "./actions";

export const takeAllUsers = () => async dispatch =>
{
	dispatch(
		{
			type: actions.loadingUsers
		}
	)

	try
	{

		const { data } = await axios.get('https://jsonplaceholder.typicode.com/users');

		dispatch(
			{
				type: actions.takeAllUsers,
				payload: data
			}
		)

	}

	catch (err)
	{

		dispatch(
			{
				type: actions.errorUsers,
				payload: 'Usuarios No Encontrados'
			}
		)

	}
};

export const takeAllChores = () => async dispatch =>
{
	dispatch(
		{
			type: actions.loadingChores
		}
	)

	try
	{

		const { data } = await axios.get('https://jsonplaceholder.typicode.com/todos');

		dispatch(
			{
				type: actions.takeAllChores,
				payload: data
			}
		)

	}

	catch (err)
	{

		dispatch(
			{
				type: actions.errorChores,
				payload: 'Tareas No Encontradas'
			}
		)

	}
};

export const updateChore = (choreId) => (dispatch, getState) =>
{
	const { chores } = getState();

	const selectChore = chores.filter(chore => chore.id === choreId).shift();

	const updateChore = {
		...selectChore,
		completed: !selectChore.completed
	};

	const updateChores = chores.map(chore =>
	{
		if(chore === selectChore)
		{
			chore = updateChore;
		}

		return chore;
	});

	dispatch(
		{
			type: actions.takeAllChores,
			payload: updateChores
		}
	)
};

export const handleInput = e => (dispatch, getState) =>
{
	const { name, value } = e.target;
	const { chore } = getState();

	const newChore = { ...chore, [name]:value };

	dispatch(
		{
			type: actions.createChore,
			payload: newChore
		}
	)
};

export const saveChore = (newChore) => async (dispatch) =>
{
	dispatch(
		{
			type: actions.loadingChores
		}
	)

	try
	{
		const { data } = await axios.post('https://jsonplaceholder.typicode.com/todos', newChore);

		console.log(data);

		dispatch(
			{
				type: actions.saveChore
			}
		)
	}

	catch (error)
	{
		dispatch(
			{
				type: actions.errorChores,
				payload: 'intente mas tarde'
			}
		)
	}
};

export const updatePublications = (key) => async (dispatch, getState) =>
{
	dispatch(
		{
			type: actions.loadingPublications
		}
	)

	try
	{

		const { data } = await axios.get(`https://jsonplaceholder.typicode.com/posts?userId=${key}`);

		let { publications } = getState();
		let { users } = getState();


		const newPublications = data.map(publication =>
		(
			{
				...publication,
				comments: [],
				open: false
			}
		));

		publications =
		[
			...publications,
			newPublications
		]

		const publicationId = publications.length

		const userId = users.findIndex(u => u.id === parseInt(key));

		let user = { ...users[userId] };

		user = {
			...user,
			publicationId
		};

		users[userId] = user;

		dispatch(
			{
				type: actions.takeAllUsers,
				payload: users
			}
		)

		dispatch(
			{
				type: actions.updatePublications,
				payload: publications
			}
		)

	}

	catch (err)
	{
		dispatch(
			{
				type: actions.errorPublications,
				payload: 'No es posible encontrar las publicaciones de '
			}
		)

	}
};

export const openAndClose = (publicationId) => (dispatch, getState) =>
{
	const { publications:publicationsArray } = getState();

	const publicationsUser = publicationsArray.find(publications => publications.find(p => p.id === publicationId));

	const selectPublication = publicationsUser.filter(publication => publication.id === publicationId).shift();

	const updatePublication = {
		...selectPublication,
		open: !selectPublication.open
	};

	const updatePublications = publicationsUser.map(publication =>
	{
		if(publication === selectPublication)
		{
			publication = updatePublication;
		}

		return publication;
	});

	const updatePublicationsArray = publicationsArray.map(publications =>
	{
		if(publications === publicationsUser)
		{
			publications = updatePublications;
		}

		return publications;
	});

	dispatch(
		{
			type: actions.updatePublications,
			payload: updatePublicationsArray
		}
	)
};

export const takeComments = (publicationId) =>  async (dispatch, getState) =>
{
	dispatch(
		{
			type: actions.loadingComments
		}
	)

	const { publications:publicationsArray } = getState();

	const publicationsUser = publicationsArray.find(publications => publications.find(p => p.id === publicationId));

	const selectPublication = publicationsUser.filter(publication => publication.id === publicationId).shift();

	try
	{
		const { data } = await axios.get(`https://jsonplaceholder.typicode.com/comments?postId=${publicationId}`);

		const updatePublication = {
			...selectPublication,
			comments: data
		};

		const updatePublications = publicationsUser.map(publication =>
		{
			if(publication === selectPublication)
			{
				publication = updatePublication;
			}

			return publication;
		});

		const updatePublicationsArray = publicationsArray.map(publications =>
		{
			if(publications === publicationsUser)
			{
				publications = updatePublications;
			}

			return publications;
		});

		dispatch(
			{
				type: actions.updateComments,
				payload: updatePublicationsArray
			}
		)
	}

	catch (err)
	{
		dispatch(
			{
				type: actions.errorComments,
				payload: 'Comentarios No Disponibles'
			}
		)
	}
};

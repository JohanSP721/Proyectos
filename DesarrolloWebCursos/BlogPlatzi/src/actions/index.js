import axios from "axios";

export const actions = {
	takeAllUsers: 'TAKE_ALL_USERS',
	takePublicationsForUser: 'TAKE_PUBLICATIONS_FOR_USER',
	errorUsers: 'ERROR_MESSAGE_USERS',
	loadingUsers: 'LOADING_USERS',
	errorPublications: 'ERROR_MESSAGE_PUBLICATIONS',
	loadingPublications: 'LOADING_PUBLICATIONS'
};

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

	} catch (err)
	{

		dispatch(
			{
				type: actions.errorUsers,
				payload: err.message
			}
		)

	}
};

export const takePublicationsForUser = (key) => async (dispatch, getState) =>
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
				type: actions.takePublicationsForUser,
				payload: publications
			}
		)

	} catch (err)
	{
		dispatch(
			{
				type: actions.errorPublications,
				payload: err.message
			}
		)

	}
};

export const openAndClose = () => dispatch =>
{
	
}

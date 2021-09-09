import { actions } from "../actions/actions";

const reducer = (state, action) =>
{
	switch (action.type)
	{
		case actions.takeAllUsers:
			return (
				{
					...state,
					users: action.payload,
					loadingPublications: false,
					loadingUsers: false
				}
			);

		case actions.updatePublications:
			return(
				{
					...state,
					publications: action.payload,
					loadingUsers: false,
					loadingPublications: false
				}
			)

		case actions.updateComments:
			return(
				{
					...state,
					publications: action.payload,
					loadingComments: false
				}
			)

		case actions.takeAllChores:
			return(
				{
					...state,
					chores: action.payload,
					loadingChores: false
				}
			)

		case actions.createChore:
			return (
				{
					...state,
					chore: action.payload
				}
			)

		case actions.saveChore:
			return(
				{
					...state,
					chores: [],
					loadingChores: false
				}
			)

		case actions.errorUsers:
			return (
				{
					...state,
					errorUsers: action.payload,
					loadingUsers: false
				}
			);

		case actions.loadingUsers:
			return (
				{
					...state,
					loadingUsers: true
				}
			);

		case actions.errorPublications:
			return (
				{
					...state,
					errorPublications: action.payload,
					loadingPublications: false
				}
			);

		case actions.loadingPublications:
			return (
				{
					...state,
					loadingPublications: true
				}
			)

		case actions.errorComments:
			return (
				{
					...state,
					errorComments: action.payload,
					loadingComments: false
				}
			);

		case actions.loadingComments:
			return (
				{
					...state,
					loadingComments: true
				}
			)

		case actions.errorChores:
			return (
				{
					...state,
					errorChores: action.payload,
					loadingChores: false
				}
			);

		case actions.loadingChores:
			return (
				{
					...state,
					loadingChores: true
				}
			)

		default:
			return state;
	}
};

export default reducer;

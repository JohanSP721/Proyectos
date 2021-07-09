import { actions } from "../actions";

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

		case actions.takePublicationsForUser:
			return(
				{
					...state,
					publications: action.payload,
					loadingUsers: false,
					loadingPublications: false
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

		default:
			return state;
	}
};

export default reducer;

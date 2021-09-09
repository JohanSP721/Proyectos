import { useEffect } from "react";

import { useParams } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";

import { updatePublications, takeAllUsers, openAndClose, takeComments } from "../actions";

import Spinner from "./Spinner";
import Comments from "./Comments";

const Publications = () =>
{
	const { key } = useParams();

	const { users, publications: publicationsArray, loadingPublications, errorPublications, errorUsers } = useSelector(state => state);

	const dispatch = useDispatch();

	const user = users.filter(u => u.id === parseInt(key)).shift();
	const publications = publicationsArray.find(publications => publications.find(publicationsForUser => publicationsForUser.userId === parseInt(key)));

	const handleUpdatePublications = (publication) =>
	{
		dispatch(openAndClose(publication.id));
		!publication.open && !publication.comments.length && dispatch(takeComments(publication.id));
	};

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

	useEffect(() =>
	{
		const takePublications = async () =>
		{
			user !== undefined && !user.publicationId
			&&
				await dispatch(updatePublications(key));
		}

		takePublications();
	}, [dispatch, key, user]);

	return (
		errorUsers !== null
		?
			<section>
				<h1>{ errorUsers }</h1>
			</section>
		:
			errorPublications !== null
			?
				<section>
					<h1>Publicaciones de { user.name }</h1>
					<h2 className="margin">{ errorPublications } { user.name }</h2>
				</section>
			:
				loadingPublications
				?
					<Spinner />
				:
					<section>
						<h1>Publicaciones de { user.name }</h1>
						{
							publications !== undefined
							&&
							publications.map((publication) =>
							(
								<article key={publication.id} className="margin">
									<h2 className="publication_title" onClick={() => handleUpdatePublications(publication)}>{publication.title}</h2>
									<p>{publication.body}</p>
									<h3>{publication.open && <Comments comments={publication.comments}/>}</h3>
								</article>
							)
							)
						}
					</section>
	)
};

export default Publications;


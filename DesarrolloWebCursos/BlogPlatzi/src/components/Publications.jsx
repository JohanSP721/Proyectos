import { useEffect } from "react";

import { useParams } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";

import { takePublicationsForUser, takeAllUsers } from "../actions";

import Spinner from "./Spinner";

const Publications = () =>
{
	const { key } = useParams();

	const { users, publications: publicationsArray, loadingPublications, errorPublications, errorUsers } = useSelector(state => state);
	const dispatch = useDispatch();

	const user = users.filter(u => u.id === parseInt(key)).shift();
	const publications = publicationsArray.find(publications => publications.find(publicationsForUser => publicationsForUser.userId === parseInt(key)));

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
				await dispatch(takePublicationsForUser(key));
		}

		takePublications();
	}, [dispatch, key, user]);

	return (
		errorUsers !== null
			?
			<section>
				<h1>Usuarios no encontrados</h1>
			</section>
			:
			errorPublications !== null
				?
				<section>
					<h1>Publicaciones de {user.name}</h1>
					<h2 className="margin">No es posible encontrar las publicaciones de {user.name}</h2>
				</section>
				:
				loadingPublications
					?
					<Spinner />
					:
					<section>
						<h1>Publicaciones de {user.name}</h1>
						{
							!(publications === undefined)
							&&
							publications.map(publication =>
							(
								<article key={publication.id} className="margin" onClick={() => alert(publication.id)}>
									<h2>{publication.title}</h2>
									<p>{publication.body}</p>
								</article>
							)
							)
						}
					</section>
	)
};

export default Publications;


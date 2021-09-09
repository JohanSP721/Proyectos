import { useSelector } from "react-redux";

import Spinner from "./Spinner";

const Comments = (props) =>
{
	const { comments } = props;

	const { errorComments:error, loadingComments:loading } = useSelector(state => state);

	return (
		loading
		?
			<Spinner/>
		:
			<ul>
				{
					error != null
					?
						<h2 className="margin">{ error }</h2>
					:
						comments.map(comment =>
						(
							<li className="margin" key={ comment.id }>
								<b>{ comment.email }</b>
								<br />
								{ comment.body }
							</li>
						))
				}
			</ul>
	)
};

export default Comments;

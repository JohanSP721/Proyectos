import { useSelector, useDispatch } from "react-redux";
import { handleInput, saveChore } from "../actions";

const CreateChore = () =>
{
	const { userId, title } = useSelector(state => state.chore);

	const dispatch = useDispatch();

	const handleChange = e =>
	{
		dispatch(handleInput(e));
	}

	const handleSave = () =>
	{

		const newChore = {
			userId: userId,
			title: title,
			completed: false
		}

		dispatch(saveChore(newChore));
	}

	return (
		<form>
			<h1>Crear Tarea</h1>
			<label htmlFor="userId">Usuario Id:</label>
			<input type="number" onChange={ e => handleChange(e) } name="userId"/>
			<br /><br />
			<label htmlFor="title">Titulo</label>
			<input type="text" onChange={ e => handleChange(e) } name="title"/>
			<button type="button" onClick={ () => handleSave() }>Crear</button>
		</form>
	)
};

export default CreateChore;

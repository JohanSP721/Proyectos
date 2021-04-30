import React from 'react';

class TaskForm extends React.Component
{
	state = {
		title: '',
		description: ''
	};
	
	onSubmit = e =>
	{
		this.props.addTask(this.state.title, this.state.description);
		e.preventDefault();
	};

	onChange = e =>
	{
		console.log(e.target.name, e.target.value);
		
		this.setState({
			[e.target.name]: e.target.value
		});
	};
	
	render()
	{
		return(
			<form onSubmit={this.onSubmit}>
				<input name="title" type="text" placeholder="Write a task" onChange={this.onChange} value={this.state.title}/>
				<br/>
				<textarea name="description" cols="30" rows="2" placeholder="Write a description" onChange={this.onChange} value={this.state.description}></textarea>
				<button type="submit">
					Save a Task
				</button>
			</form>
		);
	}
};

export default TaskForm;
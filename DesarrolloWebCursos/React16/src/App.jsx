import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './App.css';

import tasks from './sample/tasks.json';

import Tasks from './components/Tasks';
import TaskForm from './components/TaskForm';
import Posts from './components/Post'

class App extends React.Component
{

	state = {
		tasks: tasks
	};

	addTask = (title, description) =>
	{
		const newTask = 
		{
			title: title,
			description: description,
			id: this.state.tasks.length
		}

		this.setState({
			tasks: [...this.state.tasks, newTask]
		});
	};

	editDone = id =>
	{
		const newTasks = this.state.tasks.map(task =>
		{
			if(task.id === id)
			{
				task.done = !task.done;
			}

			return task;
		});

		this.setState({task: newTasks});
	};

	deleteTask = id =>
	{
		const newTasks = this.state.tasks.filter(task => task.id !== id);
		this.setState({tasks: newTasks});
	};

	render()
	{

		return(
			<section>
				<Router>
					<Link to="/">Home</Link>
					<br/>
					<Link to="/posts">Posts</Link>
					<Route exact path="/" render={() =>
					{
						return(
							<article>
								<TaskForm addTask={this.addTask}></TaskForm>
								<Tasks tasks={this.state.tasks} deleteTask={this.deleteTask} editDone={this.editDone}></Tasks>
							</article>);
					}}>
					</Route>
					<Route path="/posts" component={Posts}></Route>
				</Router>
			</section>
		);
	}
};

export default App;

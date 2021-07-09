import React from 'react';
import ReactDOM from 'react-dom';

import { createStore, applyMiddleware } from 'redux';
import { Provider } from "react-redux";
import reduxThunk from 'redux-thunk'

import reducer from './reducers';

import App from './routes/App';

const initialState = {
	users: [],
	publications: [],
	errorUsers: null,
	loadingUsers: true,
	errorPublications: null,
	loadingPublications: true
};

const store = createStore(
	reducer,
	initialState,
	applyMiddleware(reduxThunk)
);

ReactDOM.render(
	<Provider store={store}>
		<React.StrictMode>
			<App />
		</React.StrictMode>
	</Provider>,
	document.getElementById('root')
);

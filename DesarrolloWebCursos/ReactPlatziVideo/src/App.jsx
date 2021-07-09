import React from 'react';

import './assets/styles/Global.scss';

import Layout from './components/Layout';
import Search from './components/Search';

const App = () => {
	
	return(
		<Layout>
			<Search/>
		</Layout>
	)
};

export default App;
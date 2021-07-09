import axios from 'axios';

export const getDataFromApi = (url) => 
{
	return axios(url)
		.then(({ data }) =>
		{
			return data;
		});
}
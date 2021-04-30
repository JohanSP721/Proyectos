import { getDataFromApi } from '../promise';
import { babelPolyfill } from 'babel-polyfill';

describe('probando async y await', () =>
{
	test('Realizar una petición a una api', async () =>
	{
		const api = 'https://rickandmortyapi.com/api/character/';

		await getDataFromApi(api).then( data =>
			{
				expect(data.results.length).toBeGreaterThan(0);
			});
	});

	test('Comprobando la respuesta', async () =>
	{
		const getRick = 'https://rickandmortyapi.com/api/character/1';

		await getDataFromApi(getRick).then( data =>
			{
				expect(data.name).toEqual('Rick Sanchez');
			});
	});

	test('Realizando una petición a una api con error', async () =>
	{
		const apiError = 'http://httpstat.us/404';
		const petición = getDataFromApi(apiError);
		
		await expect(petición).rejects.toEqual(Error('Request failed with status code 404'));
	});

	test('Resuelve un hola', async () =>
	{
		await expect(Promise.resolve('Hola')).resolves.toBe('Hola');
	});

	test('Rechaza con un error', async () =>
	{
		await expect(Promise.reject('Error')).rejects.toBe('Error');
	});
});
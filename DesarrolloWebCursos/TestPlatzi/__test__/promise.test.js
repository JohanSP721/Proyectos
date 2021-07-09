import { getDataFromApi } from '../promise';

describe( 'Probando promesas', () => {

	const url = 'https://rickandmortyapi.com/api/character';
	test( 'Realizando una petición a un API', ( done ) =>
	{
		getDataFromApi(url).then( data =>
			{
				expect(data.results.length).toBeGreaterThan(0);
				done();
			});
	});

	test('Resuelve un hola', () =>
	{
		return expect(Promise.resolve('hola')).resolves.toBe('hola');
	});

	test('Rechaza con un error', () =>
	{
		return expect(Promise.reject('Error')).rejects.toBe('Error');
	});
});
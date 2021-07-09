describe('Comprobar cadenas de texto', () =>
{
	const text = 'un bonito texto';

	test('Debe contener un texto', () =>
	{
		expect(text).toMatch(/bonito/);
	});

	test('No contienen un texto', () =>
	{
		expect(text).not.toMatch(/es/);
	});

	test('Comprobar la longitud de un texto', () =>
	{
		expect(text).toHaveLength(15);
	});
});
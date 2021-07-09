//después de cada prueba

afterEach(() => console.log('Después de cada prueba'));

afterAll(() => console.log('Después de todas las pruebas'));

//antes de cada prueba

beforeEach(() => console.log('Antes de cada prueba'));

beforeAll(() => console.log('Antes de todas las pruebas'));


describe('Preparar antes de ejecutar', () =>
{
	test('Es verdadero', () =>
	{
		expect(true).toBeTruthy();
	});

	test('Es falso', () =>
	{
		expect(false).toBeFalsy();
	});
});
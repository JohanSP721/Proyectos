import { arrayFruits, arrayColors } from '../array';

describe('Trabajando pruebas unitarias en arreglos', () =>
{
	test('Contiene a banana', () =>
	{
		expect(arrayFruits()).toContain('banana');
	});

	test('No contiene a plátano', () =>
	{
		expect(arrayFruits()).not.toContain('plátano');
	});

	test('Comprobar el tamaño de un arreglo', () =>
	{
		expect(arrayFruits()).toHaveLength(6);
	});

	test('Comprobar que existe azul', () =>
	{
		expect(arrayColors()).toContain('azul');
	});
});
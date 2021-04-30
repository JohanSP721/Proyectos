import { sumar , multiplicar, restar, dividir } from '../maths';

describe('Cálculos matemáticos', () =>
{
	test('prueba de sumas', () =>
	{
		expect(sumar(1, 1)).toBe(2);
	});

	test('prueba de multiplicaciones', () =>
	{
		expect(multiplicar(2, 2)).toBe(4);
	});

	test('prueba de restas', () =>
	{
		expect(restar(1, 1)).toBe(0);
	});

	test('prueba de divisiones', () =>
	{
		expect(dividir(4, 2)).toBe(2);
	});
});
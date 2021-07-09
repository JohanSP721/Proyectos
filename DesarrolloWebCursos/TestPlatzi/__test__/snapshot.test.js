import { getCharacter } from '../snapshot';
import rick from '../rick.json';

describe('Es hora de las instantáneas', () =>
{
	test('Snapshot', () =>
	{
		expect(getCharacter(rick)).toMatchSnapshot();
	});

	test('Siempre fallara la instantánea', () =>
	{
		const user =
		{
			createAt: new Date(),
			id: Math.floor(Math.random() * 100)
		}

		expect(user).toMatchSnapshot(
		{
			createAt: expect.any(Date),
			id: expect.any(Number)
		});
	});

	test('Tenemos excepciones', () =>
	{
		const user =
		{
			id: Math.floor(Math.random() * 100),
			name: "Oscar Barajas"
		}

		expect(user).toMatchSnapshot(
			{
				id: expect.any(Number)
			});
	});
});
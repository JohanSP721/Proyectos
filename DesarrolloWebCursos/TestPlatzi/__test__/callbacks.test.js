import { callbackHell } from '../callbacks';

describe('probando un callback', () =>
{
	test('Callback', done =>
	{
		function otherCallback(data)
		{
			expect(data).toBe('Hola JavaScripters');
			done();
		}

		callbackHell(otherCallback);
	});
});
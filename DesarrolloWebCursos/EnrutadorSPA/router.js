const router = async () =>
{
	const header = null || document.getElementById('header');
	
	header.innerHTML = await Header();
	
	const content = null || document.getElementById('content');
	
	let hash = getHash();
	let route = await resolveRoutes(hash);
	let render = routes[route] ? routes[route] : Error404;
	
	content.innerHTML = await render();
};

export default router;
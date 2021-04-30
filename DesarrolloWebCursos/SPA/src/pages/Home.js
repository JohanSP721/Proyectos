import getData from '../utils/getData';

const Home = async () => 
{
	const characters = await getData();

	const view = `
	<section class="characters">
		${characters.results.map(character => `
		<article class="characters-item">
			<a href="#/${character.id}/">
			<img src="${character.image}" alt="${character.name}">
			<h2>${character.name}</h2>
			</a>
	</article>`
	).join('')}
	</section>`;

	return view;
};

export default Home;
const carouselItems = document.querySelectorAll('.carousel-item');

for(let carouselItem of carouselItems)
{
	carouselItem.classList.add('carousel-item__back');

	carouselItem.classList.toggle('carousel-item__back');

	carouselItem.addEventListener('mouseover', () =>
	{
		for(let item of carouselItems)
		{
			if(item.parentNode === carouselItem.parentNode)
			{
				item.classList.toggle('carousel-item__back');
			}
			
			carouselItem.classList.remove('carousel-item__back');
		}
	});

	carouselItem.addEventListener('mouseout', () =>
	{
		for(let item of carouselItems)
		{
			if(item.parentNode === carouselItem.parentNode)
			{
				item.classList.toggle('carousel-item__back');
			}

			carouselItem.classList.remove('carousel-item__back');
		}
	});
}
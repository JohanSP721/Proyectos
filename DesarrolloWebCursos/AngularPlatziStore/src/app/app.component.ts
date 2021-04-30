import { Component } from '@angular/core';

import { Product } from './product.model';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'angular-platzi-store';
	items = ['nicolas', 'julian', 'johan'];
	products:Product[] = [
		{
			id: '1',
			image: 'assets/img/camiseta.png',
			title: 'Camiseta',
			price: 80000,
			description: 'bla bla bla bla bla'
		},
		{
			id: '2',
			image: 'assets/img/hoodie.png',
			title: 'Hoodie',
			price: 80000,
			description: 'bla bla bla bla bla'
		},
		{
			id: '3',
			image: 'assets/img/mug.png',
			title: 'Mug',
			price: 80000,
			description: 'bla bla bla bla bla'
		},
		{
			id: '4',
			image: 'assets/img/pin.png',
			title: 'Pin',
			price: 80000,
			description: 'bla bla bla bla bla'
		},
		{
			id: '5',
			image: 'assets/img/stickers1.png',
			title: 'Stickers',
			price: 80000,
			description: 'bla bla bla bla bla'
		},
		{
			id: '6',
			image: 'assets/img/stickers2.png',
			title: 'Stickers',
			price: 80000,
			description: 'bla bla bla bla bla'
		}
	];

	addItem(): void
	{
		this.items.push(this.title);
	}

	deleteItem(index: number): void
	{
		this.items.splice(index, 1);
	}
}

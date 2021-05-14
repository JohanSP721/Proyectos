import { Component, HostListener } from '@angular/core';
import { DataService } from '@shared/services/data.service';

@Component({
	selector: 'app-characters-list',
	templateUrl: './characters-list.component.html',
	styleUrls: ['./characters-list.component.scss']
})
export class CharactersListComponent
{
	characters$ = this.dataSvc.characters$;

	showButton = false;

	private scrollHeight = 500;

	private pageNum:number = 1;
	
	constructor(private dataSvc: DataService)
	{

	}

	@HostListener('window:scroll')
	onWindowScroll():void
	{
		const yOffSet = window.pageYOffset;
		const scrollTop = document.documentElement.scrollTop;

		this.showButton = (yOffSet | scrollTop) > this.scrollHeight;

		const { scrollHeight, clientHeight } = document.documentElement;

		if(scrollTop + clientHeight > scrollHeight - 5)
		{
			this.onScrollDown();
		}
	}

	onScrollTop(): void
	{
		document.documentElement.scrollTop = 0;
	}

	private onScrollDown(): void
	{
		this.pageNum++;
		this.dataSvc.getCharactersByPage(this.pageNum);
	}
}

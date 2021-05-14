import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { Character } from "@shared/interfaces/date.interface";
import { ToastrService } from "ngx-toastr";

const MY_FAVORITES = 'myFavorites'

@Injectable(
	{
		providedIn: 'root'
	}
)

export class LocalStorageService
{
	private charactersFavSubject = new BehaviorSubject<Character[]>(null);
	charactersFav$ = this.charactersFavSubject.asObservable();

	constructor(private toastrSvc: ToastrService)
	{
		this.initialStorage();
	}

	addOrRemoveFavorite(character: Character): void
	{
		const { id } = character;
		
		const currentsFav = this.getFavoritesCharacters();

		const found = !! currentsFav.find(( fav: Character ) => fav.id === id);

		found ?  this.removeFromFavorite(character) : this.addToFavorite(character);
	}
	
	private addToFavorite(character: Character): void
	{
		try
		{
			const currentsFav = this.getFavoritesCharacters();

			localStorage.setItem(MY_FAVORITES, JSON.stringify([ ...currentsFav, character ]));

			this.charactersFavSubject.next([ ...currentsFav, character ]);

			this.toastrSvc.success(`${character.name} added to favorites`, 'RickAndMortyApp');
		}
		
		catch (error)
		{
			console.error('Error saving favorite to localStorage:', error);

			this.toastrSvc.error(`Error saving favorite to localStorage: ${error}`, 'RickAndMortyApp');
			
			alert('Error');
		}
	}

	private removeFromFavorite(character: Character): void
	{
		try
		{
			const currentsFav = this.getFavoritesCharacters();

			const characters = currentsFav.filter(( item: Character ) => item.id !== character.id);

			localStorage.setItem(MY_FAVORITES, JSON.stringify([ ...characters ]));

			this.charactersFavSubject.next([ ...characters ]);

			this.toastrSvc.warning(`The character: ${character.name}, was removed from Favorites`, 'RickAndMortyApp');
		}
		
		catch (error)
		{
			console.error('Error remove favorite to localStorage:', error);

			this.toastrSvc.error(`Error remove favorite to localStorage: ${error}`, 'RickAndMortyApp');

			alert('Error');
		}
	}

	getFavoritesCharacters(): any
	{
		try
		{
			const charactersFav = JSON.parse(localStorage.getItem(MY_FAVORITES));

			this.charactersFavSubject.next(charactersFav);

			return charactersFav;
		}

		catch (error)
		{
			console.error('Error getting favorites from localStorage:', error);
		}
	}

	clearStorage(): void
	{
		try
		{
			localStorage.clear();
		}
		
		catch (error)
		{
			console.error('Error cleaning localStorage', error);
		}
	}

	private initialStorage(): void
	{
		const currents = JSON.parse(localStorage.getItem(MY_FAVORITES));

		if(!currents)
		{
			localStorage.setItem(MY_FAVORITES, JSON.stringify([]));
		}

		this.getFavoritesCharacters();
	}
}
import { ChangeDetectionStrategy, Component, Input} from '@angular/core';
import { LocalStorageService } from '@app/shared/services/localStorage.service';
import { Character } from '@shared/interfaces/date.interface';

@Component({
  selector: 'app-characters-card',
  templateUrl: './characters-card.component.html',
  styleUrls: ['./characters-card.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush 
})
export class CharactersCardComponent
{

  @Input() character: Character;

  constructor(private localStorageSvc: LocalStorageService)
  {

  }

  getIcon(): string
  {
    return this.character.isFavorite ? 'heart-solid.svg' : 'heart.svg';
  }

  toggleFavorite(): void
  {
    const isFavorite = this.character.isFavorite;

    this.getIcon();
    
    this.character.isFavorite = !isFavorite;

    this.localStorageSvc.addOrRemoveFavorite(this.character);
  }
}

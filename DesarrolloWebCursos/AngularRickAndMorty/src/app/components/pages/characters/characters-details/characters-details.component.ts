import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '@app/shared/services/data.service';
import { take, tap } from 'rxjs/operators';
import Observable from 'zen-observable';

@Component({
  selector: 'app-characters-details',
  templateUrl: './characters-details.component.html',
  styleUrls: ['./characters-details.component.scss']
})
export class CharactersDetailsComponent
{
  characterId: string;
  character$: Observable<any>
  constructor(private route: ActivatedRoute, private dataSvc: DataService)
  {
    this.route.params.pipe(
      take(1),
      tap(({ id }) => this.character$ = this.dataSvc.getDetails(id))
    ).subscribe();
  }
}

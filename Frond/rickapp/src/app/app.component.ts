import { Component, OnInit} from '@angular/core';
import { EpisodesServices } from './episodes/episodes.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  episodes:any;

  constructor(public episode:EpisodesServices){}

  ngOnInit() {
    this.episode.getEpisodes().subscribe(
      (res) => { this.episodes = res; console.log(res)},
      (err) => { console.error(err)}
    )
  }

}

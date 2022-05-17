import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-episodes',
  templateUrl: './episodes.page.html',
  styleUrls: ['./episodes.page.scss'],
})
export class EpisodesPage implements OnInit {

  episodes: []

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.http.get<any>('http://localhost:8080/api/episode')
    .subscribe(
      res => {console.log(res)
      this.episodes = res[0].results;
      })
  }

}

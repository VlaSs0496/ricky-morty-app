import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-single-episode',
  templateUrl: './single-episode.page.html',
  styleUrls: ['./single-episode.page.scss'],
})
export class SingleEpisodePage implements OnInit {

  episode;
  profileId: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.profileId = this.activatedRoute.snapshot.paramMap.get('id')

    this.http.get('http://localhost:8080/api/episode/' + this.profileId)
    .subscribe(
      res => {
      this.episode = res;
    })
  }

}

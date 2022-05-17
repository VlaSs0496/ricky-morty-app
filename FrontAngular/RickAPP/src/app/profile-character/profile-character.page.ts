import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-profile-character',
  templateUrl: './profile-character.page.html',
  styleUrls: ['./profile-character.page.scss'],
})
export class ProfileCharacterPage implements OnInit {

  character;
  profileId: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.profileId = this.activatedRoute.snapshot.paramMap.get('id')

    this.http.get('http://localhost:8080/api/character/' + this.profileId)
    .subscribe(
      res => {
      this.character = res;
    })
  }

}

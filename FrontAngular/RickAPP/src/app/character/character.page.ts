import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-character',
  templateUrl: './character.page.html',
  styleUrls: ['./character.page.scss'],
})
export class CharacterPage implements OnInit {

  characters: []
  constructor(
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.http.get<any>('http://localhost:8080/api/character')
    .subscribe(
      res => {console.log(res)
      this.characters = res[0].results;
      })
  }

}

import { Injectable } from "@angular/core"; 
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()

export class EpisodesServices{

    private urlApi = 'http://localhost:8080/test/episode/2';

    constructor(public http: HttpClient){}

    public getEpisodes(): Observable<any>{
        return this.http.get(this.urlApi);
    }

}
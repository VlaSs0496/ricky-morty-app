package demo.springboot.controller;

import demo.springboot.service.RaMService;
import demo.springboot.response.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController //la funcion de esta clase
@AllArgsConstructor
@RequestMapping("/api") //nos dice en que direccion del servidor se va activar esta clase o los metodos de esta clase
public class RaMController {

    RaMService raMClient;

    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/character/{id}") //en esta dicireccion se activa el metodo de personajes por id
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){ //el metodo
        return raMClient.findAndCharacterById(id);
    }
    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id){
        return raMClient.findAnLocationById(id);
    }

    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
        return raMClient.findAEpisodeById(id);
    }

    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/episode")
    public Flux<GetAllEpisodes> getAllEpisodes(){
        return raMClient.getAllEpisodes();
    }

    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/character")
    public Flux<GetAllCharacters> getAllCharacters(){
        return raMClient.getAllCharacters();
    }


    @PostMapping
    public EpisodeResponse saveEpisode(@RequestBody EpisodeResponse episode){
        return this.raMClient.saveEpisode(episode);
    }
}

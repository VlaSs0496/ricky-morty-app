package demo.springboot.controller;

import demo.springboot.client.RaMClient;
import demo.springboot.response.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RaMController {
    @Autowired
    RaMClient raMClient;

    @CrossOrigin(origins = "http://localhost:8100/")
    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
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

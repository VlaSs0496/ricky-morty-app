package demo.springboot.service;

import demo.springboot.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repositorio.EpisodeRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service // clase de tiepo servicio
@Slf4j
public class RaMService {

    private final WebClient webClient;

    EpisodeRepository episodeRepository;
    public RaMService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findAndCharacterById(String id){
        log.info("busqueda de personaje o por id [{}]",id);
        return webClient.get().uri("/character/"+id).accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new RuntimeException("error no se donde"))).bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAnLocationById(String id){
        log.info("busqueda de episodio o por id [{}]",id);
        return webClient.get().uri("/location/"+id).accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new RuntimeException("error no se donde"))).bodyToMono(LocationResponse.class);
    }
    public Mono<EpisodeResponse> findAEpisodeById(String id){
        log.info("busqueda de locacion o por id [{}]",id);
        return webClient.get().uri("/episode/"+id).accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new RuntimeException("error no se donde"))).bodyToMono(EpisodeResponse.class);
    }
    public Flux<GetAllEpisodes> getAllEpisodes(){
        log.info("List of the all episodes");
        return webClient.get().uri("/episode").accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new RuntimeException("error no se donde"))).bodyToFlux(GetAllEpisodes.class);
    }
    public Flux<GetAllCharacters> getAllCharacters(){
        log.info("List of the all episodes");
        return webClient.get().uri("/character").accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new RuntimeException("error no se donde"))).bodyToFlux(GetAllCharacters.class);
    }
    public EpisodeResponse saveEpisode(EpisodeResponse episode){
        return episodeRepository.save(episode);
    }

}

package repositorio;

import demo.springboot.response.EpisodeResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends CrudRepository<EpisodeResponse, Long> {

}

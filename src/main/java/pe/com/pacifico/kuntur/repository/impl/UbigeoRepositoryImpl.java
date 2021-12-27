package pe.com.pacifico.kuntur.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import pe.com.pacifico.kuntur.model.Ubigeo;
import pe.com.pacifico.kuntur.repository.UbigeoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <b>Class</b>: PolicyServiceImpl <br/>
 * <b>Copyright</b>: 2021 Pacifico Seguros - La Chakra <br/>.
 *
 * @author 2021  Pacifico Seguros - La Chakra <br/>
 * <u>Service Provider</u>: Soluciones Digitales <br/>
 * <u>Developed by</u>: La Chakra developer <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     December 13, 2021 Creación de Clase.
 *   </li>
 * </ul>
 */
@Repository
public class UbigeoRepositoryImpl implements UbigeoRepository {

  private static final String KEY = "KEY_UBIGEO_2";

  private final ReactiveRedisOperations<String, Ubigeo> redisOperations;
  private final ReactiveHashOperations<String, String, Ubigeo> hashOperations;

  @Autowired
  public UbigeoRepositoryImpl(ReactiveRedisOperations<String, Ubigeo> redisOperations) {
    this.redisOperations = redisOperations;
    this.hashOperations = redisOperations.opsForHash();
  }

  /**
   * Metodo que recupera una lista de ubigeos.
   * @return retorna una lista.
   */
  @Override
  public Flux<Ubigeo> findAll() {
    return hashOperations.values(KEY);
  }

  /**
   * Método que busca ubigeo por id.
   * @param id de ubigeo.
   * @return retorna un Ubigeo.
   */
  @Override
  public Mono<Ubigeo> findById(String id) {
    return hashOperations.get(KEY, id);
  }

  @Override
  public void save(List<Ubigeo> ubigeos) {
    for (Ubigeo ubigeo: ubigeos){
      hashOperations.put(KEY, ubigeo.getUbigeo().toString(), ubigeo).subscribe();
    }
  }

}

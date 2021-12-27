package pe.com.pacifico.kuntur.business;

import pe.com.pacifico.kuntur.model.Ubigeo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <b>Class</b>: UbigeoService <br/>
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
public interface UbigeoService {

  Flux<Ubigeo> getUbigeoList();

  Mono<Ubigeo> getUbigeo(String id);

  void saveUbigeo(List<Ubigeo> ubigeos);

}

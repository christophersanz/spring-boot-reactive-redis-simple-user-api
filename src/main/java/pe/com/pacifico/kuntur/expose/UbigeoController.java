package pe.com.pacifico.kuntur.expose;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.pacifico.kuntur.business.UbigeoService;
//import pe.com.pacifico.kuntur.expose.response.UbigeoResponse;
import pe.com.pacifico.kuntur.model.Ubigeo;
import pe.com.pacifico.kuntur.model.custom.UbigeoWrapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Random;

/**
 * <b>Class</b>: UbigeoController <br/>
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
@RestController
@RequestMapping("/ubigeos")
@Slf4j
@RequiredArgsConstructor
public class UbigeoController {

  private final UbigeoService ubigeoService;

  /**
   * This method is used to get all ubigeoResponse.
   * @return all ubigeo.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<Ubigeo> getUbigeos() {
    //return ubigeoService.getUbigeoList().flatMap(this::buildResponse);
    return ubigeoService.getUbigeoList();
  }

  /**
   * This method is used to get one ubigeoResponse.
   * @return one ubigeo.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Ubigeo> getUbigeo(@PathVariable String id) {
    //return ubigeoService.getUbigeo(id).flatMap(this::buildResponse);
    return ubigeoService.getUbigeo(id);
  }

/*  private Mono<UbigeoResponse> buildResponse(Ubigeo ubigeo) {
    UbigeoResponse ubigeoResponse = new UbigeoResponse();
    try {
      ubigeoResponse.setUbigeo(ubigeo.getKeyUbigeo());
      ubigeoResponse.setUbigeoCodDpto(ubigeo.getUbigeoCoddpto());
      ubigeoResponse.setUbigeoCodProv(ubigeo.getUbigeoCodprov());
      ubigeoResponse.setUbigeoCodDist(ubigeo.getUbigeoCoddist());
      ubigeoResponse.setUbigeoDesDist(ubigeo.getUbigeoDesdist());
      ubigeoResponse.setUbigeoDesProv(ubigeo.getUbigeoDesprov());
      ubigeoResponse.setUbigeoDesDepa(ubigeo.getUbigeoDesdpto());
    } catch (Exception ex) {
      Mono.error(new Exception());
    }
    return Mono.just(ubigeoResponse);
  }*/

  @PostMapping
  public void saveUser(@RequestBody UbigeoWrapper ubigeos) {
    ubigeoService.saveUbigeo(ubigeos.getUbigeos());
  }

}

package pe.com.pacifico.kuntur.business.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.pacifico.kuntur.business.UbigeoService;
import pe.com.pacifico.kuntur.business.exception.BusinessErrorCodes;
//import pe.com.pacifico.kuntur.business.exception.BusinessException;
import pe.com.pacifico.kuntur.model.Ubigeo;
import pe.com.pacifico.kuntur.repository.UbigeoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <b>Class</b>: UbigeoServiceImpl <br/>
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
@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl implements UbigeoService {

  private final UbigeoRepository ubigeoRepository;

  @Override
  public Flux<Ubigeo> getUbigeoList() {
    return ubigeoRepository.findAll();
  }

  @Override
  public Mono<Ubigeo> getUbigeo(String id) {
    Mono<Ubigeo> ubigeo = ubigeoRepository.findById(id);
    /*if (ubigeo == null) {
      return Mono.error(BusinessException.createException(HttpStatus.NOT_FOUND, BusinessErrorCodes.BUSINESS_ERROR));
    }*/
    return ubigeo;
  }

  @Override
  public void saveUbigeo(List<Ubigeo> ubigeos) {
    ubigeoRepository.save(ubigeos);
  }

}

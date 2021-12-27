package pe.com.pacifico.kuntur.model.custom;

import lombok.*;
import pe.com.pacifico.kuntur.model.Ubigeo;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Class</b>: UbigeoWrapper <br/>
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
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class UbigeoWrapper implements Serializable {

  private static final long serialVersionUID = 36508984795293335L;

  private List<Ubigeo> ubigeos;

}

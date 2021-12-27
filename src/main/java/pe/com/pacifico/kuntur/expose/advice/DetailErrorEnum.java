package pe.com.pacifico.kuntur.expose.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b>Class</b>: DetailErrorEnum <br/>
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
@Getter
@AllArgsConstructor
public enum DetailErrorEnum {
  GENERIC_ERROR("000", "Error Generico: %s"),
  FIELD_ERROR("001", "Error de campo(s): %s");

  private String code;
  private String description;
}

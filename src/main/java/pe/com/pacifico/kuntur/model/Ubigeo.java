package pe.com.pacifico.kuntur.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <b>Class</b>: Ubigeo <br/>
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
@Builder
@Setter
@ToString
//@RedisHash(value = "KEY_TEST", timeToLive = 86400) // 1 days
public class Ubigeo implements Serializable {

  private static final long serialVersionUID = -7691086612009706777L;

  @Id
  private String ubigeo;

  private String departmentCode;

  private String provinceCode;

  private String districtCode;

  private String department;

  private String province;

  private String district;

}

package pe.com.pacifico.kuntur.model.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;
import pe.com.pacifico.kuntur.model.Ubigeo;

import java.io.IOException;

/**
 * <b>Class</b>: CustomUbigeoDeserializer <br/>
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
/*@Slf4j
public class CustomUbigeoDeserializer extends StdDeserializer<Ubigeo> {

  public CustomUbigeoDeserializer() {
    this(null);
  }

  public CustomUbigeoDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Ubigeo deserialize(JsonParser parser, DeserializationContext deserializer) {
    Ubigeo ubigeo = new Ubigeo();
    ObjectCodec codec = parser.getCodec();
    JsonNode node = null;
    try {
      node = codec.readTree(parser);
      ubigeo.setUbigeoCoddpto(node.get("UBIGEO_CODDPTO").asText());
      ubigeo.setUbigeoCodprov(node.get("UBIGEO_CODPROV").asText());
      ubigeo.setUbigeoCoddist(node.get("UBIGEO_CODDIST").asText());
      ubigeo.setUbigeoDesdpto(node.get("UBIGEO_DESDPTO").asText());
      ubigeo.setUbigeoDesprov(node.get("UBIGEO_DESPROV").asText());
      ubigeo.setUbigeoDesdist(node.get("UBIGEO_DESDIST").asText());
      ubigeo.setKeyUbigeo(node.get("KEY_UBIGEO").asText());
    } catch (IOException e) {
      log.error("[error] -> Ubigeo deserialize" + e.getMessage());
    }
    return ubigeo;
  }
}*/

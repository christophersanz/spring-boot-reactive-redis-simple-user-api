package pe.com.pacifico.kuntur.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.*;
import pe.com.pacifico.kuntur.model.Ubigeo;

/**
 * <b>Class</b>: RedisConfig <br/>
 * <b>Copyright</b>: 2021 Pacifico Seguros - La Chakra <br/>.
 *
 * @author 2021  Pacifico Seguros - La Chakra <br/>
 * <u>Service Provider</u>: Soluciones Digitales <br/>
 * <u>Developed by</u>: Steel Pulse <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     August 16, 2021 Creación de Clase.
 *   </li>
 * </ul>
 */
@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String redisHost;

  @Value("${spring.redis.port}")
  private int redisPort;

  @Value("${spring.redis.password}")
  private String redisPassword;

/*
  @Bean
  public LettuceConnectionFactory lettuceConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration();
    redisStandaloneConfig.setHostName(redisHost);
    redisStandaloneConfig.setPort(redisPort);
    redisStandaloneConfig.setPassword(redisPassword);
    return new LettuceConnectionFactory(redisStandaloneConfig);
  }

  @Bean
  public ReactiveRedisOperations<String, Ubigeo> redisOperations(LettuceConnectionFactory connectionFactory) {
    RedisSerializationContext<String, Ubigeo> serializationContext = RedisSerializationContext
            .<String, Ubigeo>newSerializationContext(new StringRedisSerializer())
            .key(new StringRedisSerializer())
            .value(new GenericToStringSerializer<>(Ubigeo.class))
            .hashKey(new StringRedisSerializer())
            .hashValue(new GenericJackson2JsonRedisSerializer())
            .build();
    return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
  }
*/


 //########################################## JEDIS FACTORY
  @Bean
  public ReactiveRedisTemplate<String, Ubigeo> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
     StringRedisSerializer keySerializer = new StringRedisSerializer();
     Jackson2JsonRedisSerializer<Ubigeo> valueSerializer = new Jackson2JsonRedisSerializer<>(Ubigeo.class);
     RedisSerializationContext.RedisSerializationContextBuilder<String, Ubigeo> builder = RedisSerializationContext
             .newSerializationContext(keySerializer);
     RedisSerializationContext<String, Ubigeo> context = builder.value(valueSerializer).build();
     return new ReactiveRedisTemplate<>(factory, context);
  }

  @Bean
  public ReactiveRedisOperations<String, Ubigeo> redisOperations(ReactiveRedisConnectionFactory connectionFactory) {
     RedisSerializationContext<String, Ubigeo> serializationContext = RedisSerializationContext
            .<String, Ubigeo>newSerializationContext(new StringRedisSerializer())
            .key(new StringRedisSerializer())
            .value(new GenericToStringSerializer<>(Ubigeo.class))
            .hashKey(new StringRedisSerializer())
            .hashValue(new GenericJackson2JsonRedisSerializer())
            .build();
    return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
  }

}

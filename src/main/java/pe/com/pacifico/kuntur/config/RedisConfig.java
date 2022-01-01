package pe.com.pacifico.kuntur.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
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

  @Autowired
  private Environment env;

 // ########################################## CONECTION LETUCCE ########################################## //
    /**
     * Creación de Bean tipo LettuceConnectionFactory.
     * @return LettuceConnectionFactory.
     */
    @Bean
    @Primary
    public ReactiveRedisConnectionFactory lettuceConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration();
        redisStandaloneConfig.setHostName(env.getProperty("spring.redis.host"));
        redisStandaloneConfig.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
        redisStandaloneConfig.setPassword(env.getProperty("spring.redis.password"));

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMinIdle(Integer.parseInt(env.getProperty("spring.redis.letucce.pool.min-idle")));
        poolConfig.setMaxIdle(Integer.parseInt(env.getProperty("spring.redis.letucce.pool.max-idle")));

        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();

        return new LettuceConnectionFactory(redisStandaloneConfig, lettuceClientConfiguration);
    }

    @Bean
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate() {
        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), RedisSerializationContext.string());
    }

   @Bean
  public ReactiveRedisOperations<String, Ubigeo> reactiveRedisOperations(LettuceConnectionFactory connectionFactory) {
    RedisSerializationContext<String, Ubigeo> serializationContext = RedisSerializationContext
            .<String, Ubigeo>newSerializationContext(new StringRedisSerializer())
            .key(new StringRedisSerializer())
            .value(new GenericToStringSerializer<>(Ubigeo.class))
            .hashKey(new StringRedisSerializer())
            .hashValue(new GenericJackson2JsonRedisSerializer())
            .build();
    return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
  }

 // ########################################## CONECTION JEDIS ########################################## //
  /*
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
  */

}

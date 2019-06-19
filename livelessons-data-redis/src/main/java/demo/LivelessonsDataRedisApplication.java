package demo;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@SpringBootApplication
@EnableCaching
public class LivelessonsDataRedisApplication {

	
	@Bean
	public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
	    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
	            .disableCachingNullValues()
	            .entryTtl(Duration.ofHours(1))
	            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
	    redisCacheConfiguration.usePrefix();

	   return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
	                    .cacheDefaults(redisCacheConfiguration).build();

	}   
	
	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsDataRedisApplication.class, args);
	}

}

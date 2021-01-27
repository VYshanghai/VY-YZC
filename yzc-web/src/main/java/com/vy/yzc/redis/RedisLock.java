package com.vy.yzc.redis;

import com.vy.basic.redis.util.MutexLocker;
import java.util.Optional;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

/**
 * @Author: Edward
 * @Date: 2020/11/14 14:33
 * @Description:
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RedisLock {

	private RedisTemplate redisTemplate;

	private Long expire = 60 * 3L;

	private String key;

	private static final Integer wait = 5 * 1000;

	private volatile Boolean locked = false;

	private String error;

	public <T> T process(Supplier<T> process) {
		Optional.ofNullable(redisTemplate)
				.orElseThrow(() -> new NullPointerException("redisTemplate is null"));
		Optional.ofNullable(expire)
				.orElseThrow(() -> new NullPointerException("expire is null"));
		Optional.ofNullable(key)
				.orElseThrow(() -> new NullPointerException("expire is null"));
			try (MutexLocker locker = MutexLocker.MutexLockerBuilder.aMutexLocker()
					.withKey(key)
					.withRedisTemplate(redisTemplate).build()) {
				Long start = System.currentTimeMillis();
				while (locked = !locker.acquire()){
					Long end = System.currentTimeMillis();
					if(end - start > wait){
						Assert.isTrue(locked, error);
					}
				}
				return process.get();
			}
	}
}

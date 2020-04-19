package com.yayayahei.hello.spring.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;
@Component
public class RedisHealthIndicator implements HealthIndicator {
    private static final String VERSION = "version";

    private static final String REDIS_VERSION = "redis_version";

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisHealthIndicator(RedisConnectionFactory connectionFactory) {
        Assert.notNull(connectionFactory, "ConnectionFactory must not be null");
        this.redisConnectionFactory = connectionFactory;
    }
    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();
        try {
            doHealthCheck(builder);
        } catch (Exception ex) {
            // use unknown, then health check api would response ok, otherwise response 503
            builder.unknown()
                    .withDetail("connection", "Not Available")
                    .withDetail("error", ex.getClass().getName() + ": " + ex.getMessage());
        }
        return builder.build();
    }
    protected void doHealthCheck(Health.Builder builder) {
        RedisConnection connection = RedisConnectionUtils
                .getConnection(this.redisConnectionFactory);
        try {
            String redisVersion = Optional.ofNullable(connection.info())
                    .map(info -> info.getProperty(REDIS_VERSION)).orElse("unknown");
            builder.up().withDetail("connection", "Available")
                    .withDetail(VERSION, redisVersion);
        } finally {
            RedisConnectionUtils.releaseConnection(connection,
                    this.redisConnectionFactory);
        }
    }
}

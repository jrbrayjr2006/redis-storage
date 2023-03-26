#  Redis Storage Application

## Local Setup

Install a local instance of Redis or run a Docker Redis image.

The easiest way to install Redis is to pull its Docker image and run  a container.

```agsl
docker pull redis

docker run --name some-redis -d redis redis-server --save 60 1 --loglevel warning
```

Connect to Redis via ant command line interface (cli)

```agsl
docker run -it --network some-network --rm redis redis-cli -h some-redis
```

Start the Redis Server.

```cmd
redis-server
```

## Testing

The Mockk framework is used instead of Mockito for this project since it is written in Kotlin.

## References

- [Redis](https://redis.io)
- [Redis Docker Image](https://hub.docker.com/_/redis)
- [Spring Boot Testing with Kotlin](https://www.baeldung.com/kotlin/spring-boot-testing)
- [Lombok compiler plugin](https://kotlinlang.org/docs/lombok.html)
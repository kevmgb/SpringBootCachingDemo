# Cacheable Demo

A spring boot service demonstration caching using the Caffeine library.

## Use case
Consider a service that performs a rest call to acquire a bearer token for querying other services via an API gateway. It would be ideal to cache the token to prevent the need to reacquire a token for every rest call.
The token could then be expired after a certain amount of time.
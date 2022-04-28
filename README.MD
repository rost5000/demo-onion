# Example Onion project

This is an example of onion project based on Spring boot with database access and 

## Prerequisites
1. You need to install jdk 17 or higher
2. You need to intall golang
3. You need to run command `go get github.com/grpc-ecosystem/grpc-gateway/v2`

This project generate from protobuf controllers and clients
This approach called "API First"

This projetc has the onion architecture:
1. [domain](./modules/domain) -- project contains modules
2. [usecase](./modules/usecase) -- project contains buisness logic for microservice
3. [controller-rest](./modules/controller-rest) -- project contains rest controllers and mappings from dto models to domain.
4. [repository-jpa](./modules/repository-jpa) -- project contains jpa repositories and entities
5. [infrastructure](./modules/infrastructure) -- project contains infrastructure layer (configs etc...)
## Build 

```bash
gradle clean build
```


# redis
Redis sandbox

docker-compose spins up redis and demo-app with simple rest-api

POST /sendMessage/{message} to send a message (received prints it to console)

POST /saveValue/{value} to save value to cache (key = value, value = value + currentTimeMillis)
GET /getValue/{value} to get value from cache and print to console
                                                                  

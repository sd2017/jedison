FROM java:7
COPY /src /src
COPY /lib /lib
COPY /target /target
RUN javac   -cp .:target/dependency/jedis-2.1.0.jar:target/jedison-0.2-SNAPSHOT.jar  -d . src/main/java/JedisTest.java
RUN jar cf target/jedison-0.2-SNAPSHOT.jar target/classes/
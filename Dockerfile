FROM "openjdk:16.0.1-jdk-oraclelinux7"

COPY . /opt/speaker-deck-api
WORKDIR /opt/speaker-deck-api

RUN ./gradlew build
ENTRYPOINT ["/opt/speaker-deck-api/fetch-speaker-deck-profile.sh"]
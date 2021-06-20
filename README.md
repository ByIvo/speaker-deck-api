[![Java CI with Gradle](https://github.com/ByIvo/speaker-deck-api/actions/workflows/gradle.yml/badge.svg)](https://github.com/ByIvo/speaker-deck-api/actions/workflows/gradle.yml)
# speaker-deck-api

# What

It provides an API to extract profile data from Speaker Deck

# How does it work

It scraps the speakerdeck website and returns the personal data of a given username

## How to install

### With Java installed

**If you want to run it locally, first install OpenJDK16**

With OpenJDK16 available, execute:

```sh
./fetch-speaker-deck-profile.sh byivo
```

**TIP: Try replacing `byivo` by your own SpeakerDeck username.**

### With Docker

Build your own image running:

```sh
docker build -t byivo/speaker-deck-api .
```

After completing the image build process, just run the container providing the username at the end:
```sh
docker run --rm -it byivo/speaker-deck-api byivo
```

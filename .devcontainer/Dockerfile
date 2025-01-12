FROM eclipse-temurin:21-jdk-alpine AS jdk-alpine

RUN apk --no-cache upgrade
ENV GRADLE_VERSION=8.12
ARG GRADLE_DOWNLOAD_SHA256=7a00d51fb93147819aab76024feece20b6b84e420694101f276be952e08bef03
ENV GRADLE_HOME=/opt/gradle-${GRADLE_VERSION}
RUN set -o errexit -o nounset \
    && echo "Downloading Gradle" \
    && wget --no-verbose "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    \
    && echo "Checksum for file" \
    && echo "${GRADLE_DOWNLOAD_SHA256} *gradle-${GRADLE_VERSION}-bin.zip" | sha256sum -c - \
    \
    && echo "Installing Gradle" \
#    && mkdir ${GRADLE_HOME} \
    && unzip -d /opt gradle-${GRADLE_VERSION}-bin.zip
ENV PATH=${PATH}:$GRADLE_HOME/bin

FROM clojure:openjdk-16-lein-slim-buster

WORKDIR /
RUN apt-get update && apt-get install -y curl zip unzip
RUN curl -s -L https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-4.6.0.2311-linux.zip -o sonarscanner.zip
RUN unzip -qq sonarscanner.zip
RUN rm -rf sonarscanner.zip
RUN mv sonar-scanner-4.6.0.2311-linux sonar-scanner
COPY sonar-scanner.properties sonar-scanner/conf/sonar-scanner.properties
ENV SONAR_RUNNER_HOME=sonar-scanner
ENV PATH $PATH:/sonar-scanner/bin

WORKDIR /app

ENTRYPOINT lein deps && tail -f /dev/null
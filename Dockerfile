FROM bellsoft/liberica-openjre-alpine:17
ARG JAR_FILE=build/libs/people.jar
ENV JAVA_TOOL_OPTIONS='-agentlib:jdwp=transport=dt_socket,address=*:7000,server=y,suspend=n'
COPY ${JAR_FILE} /people.jar
ENTRYPOINT ["java","-jar"]
CMD ["people.jar"]
FROM amazoncorretto:17
MAINTAINER Roman Kotov
WORKDIR /app
COPY target/user-service-runnable.jar /app/user-service-runnable.jar
CMD ["java","-jar","user-service-runnable.jar"]
# also can be used, in that case can fetch additional variables from application-local.yaml,
# but ENVIRONMENT variables will have higher priority
#ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "user-service-runnable.jar"]

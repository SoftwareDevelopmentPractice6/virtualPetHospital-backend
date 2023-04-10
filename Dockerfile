FROM openjdk:17-oracle

WORKDIR /docker/virtualPetHospital/build

COPY /target/eureka-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/eureka.jar
COPY /target/login-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/login.jar
COPY /target/system-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/system.jar
COPY /target/medicalRecordManagement-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/medicalRecordManagement.jar
COPY /target/exam-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/exam.jar
COPY /target/intermediator-?.?.?-SNAPSHOT.jar /docker/virtualPetHospital/build/intermediator.jar

COPY /run_jar.sh /docker/virtualPetHospital/build

RUN chmod 755 run_jar.sh
EXPOSE 8085-8090

ENTRYPOINT ["./run_jar.sh", "start"]
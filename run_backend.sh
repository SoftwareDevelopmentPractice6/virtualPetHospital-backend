#!/bin/sh

startProd(){
    echo "--------------开始启动--------------"
    (./mvnw -pl eureka spring-boot:run -P prod) &
    (./mvnw -pl login spring-boot:run -P prod) &
    (./mvnw -pl system spring-boot:run -P prod) &
    (./mvnw -pl medicalRecordManagement spring-boot:run -P prod) &
    (./mvnw -pl exam spring-boot:run -P prod) &
    (./mvnw -pl intermediator spring-boot:run -P prod)
}

startDev(){
    echo "--------------开始启动--------------"
    (./mvnw -pl eureka spring-boot:run -P dev) &
    (./mvnw -pl login spring-boot:run -P dev) &
    (./mvnw -pl system spring-boot:run -P dev) &
    (./mvnw -pl medicalRecordManagement spring-boot:run -P dev) &
    (./mvnw -pl exam spring-boot:run -P dev) &
    (./mvnw -pl intermediator spring-boot:run -P dev)
}

stopProd() {
    echo "--------------开始停止--------------"
    eureka_pid=`lsof -i:8085|grep "LISTEN"|awk '{print $2}'`;
    login_pid=`lsof -i:8086|grep "LISTEN"|awk '{print $2}'`;
    system_pid=`lsof -i:8087|grep "LISTEN"|awk '{print $2}'`;
    medicalRecordManagement_pid=`lsof -i:8088|grep "LISTEN"|awk '{print $2}'`;
    exam_pid=`lsof -i:8089|grep "LISTEN"|awk '{print $2}'`;
    intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`;
    
    if [ "$eureka_pid" != "" ]
    then
        kill -9 $eureka_pid
        echo "成功停止 eureka"
    else
        echo "eureka 不在运行"
    fi
    
    if [ "$login_pid" != "" ]
    then
        kill -9 $login_pid
        echo "成功停止 login"
    else
        echo "login 不在运行"
    fi
    
    if [ "$system_pid" != "" ]
    then
        kill -9 $system_pid
        echo "成功停止 system"
    else
        echo "system 不在运行"
    fi
    
    if [ "$medicalRecordManagement_pid" != "" ]
    then
        kill -9 $medicalRecordManagement_pid
        echo "成功停止 medicalRecordManagement"
    else
        echo "medicalRecordManagement 不在运行"
    fi
    
    if [ "$exam_pid" != "" ]
    then
        kill -9 $exam_pid
        echo "成功停止 exam"
    else
        echo "exam 不在运行"
    fi
    
    if [ "$intermediator_pid" != "" ]
    then
        kill -9 $intermediator_pid
        echo "成功停止 intermediator"
    else
        echo "intermediator 不在运行"
    fi
    echo "--------------停止结束--------------"
}

stopDev() {
    echo "--------------开始停止--------------"
    eureka_pid=`lsof -i:5272|grep "LISTEN"|awk '{print $2}'`;
    login_pid=`lsof -i:8762|grep "LISTEN"|awk '{print $2}'`;
    system_pid=`lsof -i:5678|grep "LISTEN"|awk '{print $2}'`;
    medicalRecordManagement_pid=`lsof -i:8777|grep "LISTEN"|awk '{print $2}'`;
    exam_pid=`lsof -i:8778|grep "LISTEN"|awk '{print $2}'`;
    intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`;
    
    if [ "$eureka_pid" != "" ]
    then
        kill -9 $eureka_pid
        echo "成功停止 eureka"
    else
        echo "eureka 不在运行"
    fi
    
    if [ "$login_pid" != "" ]
    then
        kill -9 $login_pid
        echo "成功停止 login"
    else
        echo "login 不在运行"
    fi
    
    if [ "$system_pid" != "" ]
    then
        kill -9 $system_pid
        echo "成功停止 system"
    else
        echo "system 不在运行"
    fi
    
    if [ "$medicalRecordManagement_pid" != "" ]
    then
        kill -9 $medicalRecordManagement_pid
        echo "成功停止 medicalRecordManagement"
    else
        echo "medicalRecordManagement 不在运行"
    fi
    
    if [ "$exam_pid" != "" ]
    then
        kill -9 $exam_pid
        echo "成功停止 exam"
    else
        echo "exam 不在运行"
    fi
    
    if [ "$intermediator_pid" != "" ]
    then
        kill -9 $intermediator_pid
        echo "成功停止 intermediator"
    else
        echo "intermediator 不在运行"
    fi
    echo "--------------停止结束--------------"
}

case "$1:$2" in
    start:dev)
        startDev
    ;;
    start:prod)
        startProd
    ;;
    stop:dev)
        stopDev
    ;;
    stop:prod)
        stopProd
    ;;
esac
exit 0

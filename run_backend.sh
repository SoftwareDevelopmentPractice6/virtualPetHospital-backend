#!/bin/sh

export eureka_prod_log=logs/prod/eureka.log
export login_prod_log=logs/prod/login.log
export system_prod_log=logs/prod/system.log
export medicalRecordManagement_prod_log=logs/prod/medicalRecordManagement.log
export exam_prod_log=logs/prod/exam.log
export intermediator_prod_log=logs/prod/intermediator.log

export eureka_dev_log=logs/dev/eureka.log
export login_dev_log=logs/dev/login.log
export system_dev_log=logs/dev/system.log
export medicalRecordManagement_dev_log=logs/dev/medicalRecordManagement.log
export exam_dev_log=logs/dev/exam.log
export intermediator_dev_log=logs/dev/intermediator.log

startProd(){
    echo "--------------Stopping other applications if exists--------------"
    stopDev
    stopProd

    echo "--------------Start running--------------"
    echo "Profile: prod"
    sleep 1
    mkdir -p logs/prod;
    echo "Logs of running each module can be found in:"
    echo "- eureka:                  $eureka_prod_log"
    echo "- login:                   $login_prod_log"
    echo "- system:                  $system_prod_log"
    echo "- medicalRecordManagement: $medicalRecordManagement_prod_log"
    echo "- exam:                    $exam_prod_log"
    echo "- intermediator:           $intermediator_prod_log"
    echo "-----------------------------------"
    (./mvnw -pl eureka spring-boot:run -P prod >> $eureka_prod_log) &
    (./mvnw -pl login spring-boot:run -P prod >> $login_prod_log) &
    (./mvnw -pl system spring-boot:run -P prod >> $system_prod_log) &
    (./mvnw -pl medicalRecordManagement spring-boot:run -P prod >> $medicalRecordManagement_prod_log) &
    (./mvnw -pl exam spring-boot:run -P prod >> $exam_prod_log) &
    (./mvnw -pl intermediator spring-boot:run -P prod >> $intermediator_prod_log) &
    (
        echo "Starting......"
        timer=0
        while(( $timer<=100 ))
        do
            printf "$timer %%\r"
            sleep 1
            timer=`expr $timer + 2`
        done
        echo "Running completed"
        echo "-----------------------------------"
        echo "Running address of each module:"
        echo "- eureka:                  http://localhost:8085"
        echo "- login:                   http://localhost:8086"
        echo "- system:                  http://localhost:8087"
        echo "- medicalRecordManagement: http://localhost:8088"
        echo "- exam:                    http://localhost:8089"
        echo "- intermediator:           http://localhost:8090"
    )
}

startDev(){
    echo "--------------Stopping other applications if exists--------------"
    stopDev
    stopProd

    echo "--------------Start running--------------"
    echo "Profile: dev"
    sleep 1
    mkdir -p logs/dev;
    echo "Logs of running each module can be found in:"
    echo "- eureka:                  $eureka_dev_log"
    echo "- login:                   $login_dev_log"
    echo "- system:                  $system_dev_log"
    echo "- medicalRecordManagement: $medicalRecordManagement_dev_log"
    echo "- exam:                    $exam_dev_log"
    echo "- intermediator:           $intermediator_dev_log"
    echo "-----------------------------------"
    (./mvnw -pl eureka spring-boot:run -P dev >> $eureka_dev_log) &
    (./mvnw -pl login spring-boot:run -P dev >> $login_dev_log) &
    (./mvnw -pl system spring-boot:run -P dev >> $system_dev_log) &
    (./mvnw -pl medicalRecordManagement spring-boot:run -P dev >> $medicalRecordManagement_dev_log) &
    (./mvnw -pl exam spring-boot:run -P dev >> $exam_dev_log) &
    (./mvnw -pl intermediator spring-boot:run -P dev >> $intermediator_dev_log) &
    (
        echo "Starting......"
        timer=0
        while(( $timer<=100 ))
        do
            printf "$timer %%\r"
            sleep 1
            timer=`expr $timer + 2`
        done
        echo "Running completed"
        echo "-----------------------------------"
        echo "Running address of each module:"
        echo "- eureka:                  http://localhost:5272"
        echo "- login:                   http://localhost:8762"
        echo "- system:                  http://localhost:5678"
        echo "- medicalRecordManagement: http://localhost:8777"
        echo "- exam:                    http://localhost:8778"
        echo "- intermediator:           http://localhost:8090"
    )
}

stopProd() {
    echo "--------------Start stopping--------------"
    echo "Profile: prod"
    sleep 1
    eureka_pid=`lsof -i:8085|grep "LISTEN"|awk '{print $2}'`;
    login_pid=`lsof -i:8086|grep "LISTEN"|awk '{print $2}'`;
    system_pid=`lsof -i:8087|grep "LISTEN"|awk '{print $2}'`;
    medicalRecordManagement_pid=`lsof -i:8088|grep "LISTEN"|awk '{print $2}'`;
    exam_pid=`lsof -i:8089|grep "LISTEN"|awk '{print $2}'`;
    intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`;
    
    if [ "$eureka_pid" != "" ]
    then
        kill -9 $eureka_pid
        echo "Successfully stopped eureka"
    else
        echo "eureka is not running"
    fi
    
    if [ "$login_pid" != "" ]
    then
        kill -9 $login_pid
        echo "Successfully stopped login"
    else
        echo "login is not running"
    fi
    
    if [ "$system_pid" != "" ]
    then
        kill -9 $system_pid
        echo "Successfully stopped system"
    else
        echo "system is not running"
    fi
    
    if [ "$medicalRecordManagement_pid" != "" ]
    then
        kill -9 $medicalRecordManagement_pid
        echo "Successfully stopped medicalRecordManagement"
    else
        echo "medicalRecordManagement is not running"
    fi
    
    if [ "$exam_pid" != "" ]
    then
        kill -9 $exam_pid
        echo "Successfully stopped exam"
    else
        echo "exam is not running"
    fi
    
    if [ "$intermediator_pid" != "" ]
    then
        kill -9 $intermediator_pid
        echo "Successfully stopped intermediator"
    else
        echo "intermediator is not running"
    fi
    echo "--------------Stopping completed--------------"
}

stopDev() {
    echo "--------------Start stopping--------------"
    echo "Profile: dev"
    sleep 1
    eureka_pid=`lsof -i:5272|grep "LISTEN"|awk '{print $2}'`;
    login_pid=`lsof -i:8762|grep "LISTEN"|awk '{print $2}'`;
    system_pid=`lsof -i:5678|grep "LISTEN"|awk '{print $2}'`;
    medicalRecordManagement_pid=`lsof -i:8777|grep "LISTEN"|awk '{print $2}'`;
    exam_pid=`lsof -i:8778|grep "LISTEN"|awk '{print $2}'`;
    intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`;
    
    if [ "$eureka_pid" != "" ]
    then
        kill -9 $eureka_pid
        echo "Successfully stopped eureka"
    else
        echo "eureka is not running"
    fi
    
    if [ "$login_pid" != "" ]
    then
        kill -9 $login_pid
        echo "Successfully stopped login"
    else
        echo "login is not running"
    fi
    
    if [ "$system_pid" != "" ]
    then
        kill -9 $system_pid
        echo "Successfully stopped system"
    else
        echo "system is not running"
    fi
    
    if [ "$medicalRecordManagement_pid" != "" ]
    then
        kill -9 $medicalRecordManagement_pid
        echo "Successfully stopped medicalRecordManagement"
    else
        echo "medicalRecordManagement is not running"
    fi
    
    if [ "$exam_pid" != "" ]
    then
        kill -9 $exam_pid
        echo "Successfully stopped exam"
    else
        echo "exam is not running"
    fi
    
    if [ "$intermediator_pid" != "" ]
    then
        kill -9 $intermediator_pid
        echo "Successfully stopped intermediator"
    else
        echo "intermediator is not running"
    fi
    echo "--------------Stopping completed--------------"
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

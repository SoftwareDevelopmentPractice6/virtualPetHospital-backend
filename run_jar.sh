#!/bin/sh

startProd(){
    echo "--------------开始启动--------------"
    (java -jar eureka.jar) &
    (java -jar login.jar) &
    (java -jar system.jar) &
    (java -jar medicalRecordManagement.jar) &
    (java -jar exam.jar) &
    (java -jar intermediator.jar)
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

case "$1" in
    start)
        startProd
    ;;
    stop)
        stopProd
    ;;
esac

trap 'stopProd' SIGTERM

exit 0

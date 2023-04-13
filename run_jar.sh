#!/bin/sh

export eureka_jar_log=logs/jar/eureka.log
export login_jar_log=logs/jar/login.log
export system_jar_log=logs/jar/system.log
export medicalRecordManagement_jar_log=logs/jar/medicalRecordManagement.log
export exam_jar_log=logs/jar/exam.log
export intermediator_jar_log=logs/jar/intermediator.log

export GREEN="\e[32m"
export BLUE="\e[34m"
export ENDCOLOR="\e[0m"

startProd(){
    echo "Start running"
    echo "-----------------------------------"
    sleep 1
    mkdir -p logs/jar
    echo "Logs of running each module can be found in:"
    printf -- "- eureka:                  ${GREEN}$eureka_jar_log${ENDCOLOR}\n"
    printf -- "- login:                   ${GREEN}$login_jar_log${ENDCOLOR}\n"
    printf -- "- system:                  ${GREEN}$system_jar_log${ENDCOLOR}\n"
    printf -- "- medicalRecordManagement: ${GREEN}$medicalRecordManagement_jar_log${ENDCOLOR}\n"
    printf -- "- exam:                    ${GREEN}$exam_jar_log${ENDCOLOR}\n"
    printf -- "- intermediator:           ${GREEN}$intermediator_jar_log${ENDCOLOR}\n"
    echo " "
    echo "-----------------------------------"
    (java -jar eureka.jar >> $eureka_jar_log) &
    (java -jar login.jar >> $login_jar_log) &
    (java -jar system.jar >> $system_jar_log) &
    (java -jar medicalRecordManagement.jar >> $medicalRecordManagement_jar_log) &
    (java -jar exam.jar >> $exam_jar_log) &
    (java -jar intermediator.jar >> $intermediator_jar_log) &
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
        printf -- "- eureka:                  ${BLUE}http://127.0.0.1:8085${ENDCOLOR}\n"
        printf -- "- login:                   ${BLUE}http://127.0.0.1:8086${ENDCOLOR}\n"
        printf -- "- system:                  ${BLUE}http://127.0.0.1:8087${ENDCOLOR}\n"
        printf -- "- medicalRecordManagement: ${BLUE}http://127.0.0.1:8088${ENDCOLOR}\n"
        printf -- "- exam:                    ${BLUE}http://127.0.0.1:8089${ENDCOLOR}\n"
        printf -- "- intermediator:           ${BLUE}http://127.0.0.1:8090${ENDCOLOR}\n"
        echo " "
        echo "Please visit eureka page to check whether all 5 modules are running as expected. "
    ) &
    wait
    echo "Project was terminated"
}

stopProd() {
    echo "Start stopping"
    echo "-----------------------------------"
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
    echo "Stopping completed"
    echo "-----------------------------------"
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

#!/bin/sh

export eureka_prod_log=logs/prod/eureka.log
export login_prod_log=logs/prod/login.log
export system_prod_log=logs/prod/system.log
export medicalRecordManagement_prod_log=logs/prod/medicalRecordManagement.log
export exam_prod_log=logs/prod/exam.log
export intermediator_prod_log=logs/prod/intermediator.log

startProd(){
    echo "--------------开始启动--------------"
    mkdir -p logs/prod;
    echo "各模块运行记录可以在如下文件内查看："
    echo "eureka: $eureka_prod_log"
    echo "login: $login_prod_log"
    echo "system: $system_prod_log"
    echo "medicalRecordManagement: $medicalRecordManagement_prod_log"
    echo "exam: $exam_prod_log"
    echo "intermediator: $intermediator_prod_log"
    echo "-----------------------------------"
    (java -jar eureka.jar >> $eureka_prod_log) &
    (java -jar login.jar >> $login_prod_log) &
    (java -jar system.jar >> $system_prod_log) &
    (java -jar medicalRecordManagement.jar >> $medicalRecordManagement_prod_log) &
    (java -jar exam.jar >> $exam_prod_log) &
    (java -jar intermediator.jar >> $intermediator_prod_log) &
    (
        echo "启动中......"
        timer=0
        while(( $timer<=100 ))
        do
            printf "$timer %%\r"
            sleep 1
            timer=`expr $timer + 2`
        done
        echo "启动完成"
        echo "-----------------------------------"
        echo "各模块运行地址："
        echo "eureka: http://localhost:8085"
        echo "login: http://localhost:8086"
        echo "system: http://localhost:8087"
        echo "medicalRecordManagement: http://localhost:8088"
        echo "exam: http://localhost:8089"
        echo "intermediator: http://localhost:8090"
    ) &
    wait
    echo "项目被停止"
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

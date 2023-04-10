@echo off

IF "%~1:%~2"=="start:dev" (
    CALL :startDev
) ELSE IF "%~1:%~2"=="start:prod" (
    CALL :startProd
) ELSE IF "%~1:%~2"=="stop:dev" (
    CALL :stopDev
) ELSE IF "%~1:%~2"=="stop:prod" (
    CALL :stopProd
)
exit "0run"

EXIT /B %ERRORLEVEL%

:startProd
echo "--------------开始启动--------------"
(mvnw.cmd -pl eureka spring-boot:run -P prod) &
(mvnw.cmd -pl login spring-boot:run -P prod) &
(mvnw.cmd -pl system spring-boot:run -P prod) &
(mvnw.cmd -pl medicalRecordManagement spring-boot:run -P prod) &
(mvnw.cmd -pl exam spring-boot:run -P prod) &
(mvnw.cmd -pl intermediator spring-boot:run -P prod)
EXIT /B 0

:startDev
echo "--------------开始启动--------------"
(mvnw.cmd -pl eureka spring-boot:run -P dev) &
(mvnw.cmd -pl login spring-boot:run -P dev) &
(mvnw.cmd -pl system spring-boot:run -P dev) &
(mvnw.cmd -pl medicalRecordManagement spring-boot:run -P dev) &
(mvnw.cmd -pl exam spring-boot:run -P dev) &
(mvnw.cmd -pl intermediator spring-boot:run -P dev)
EXIT /B 0

:stopProd
echo "--------------开始停止--------------"
SET eureka_pid=`lsof -i:8085|grep "LISTEN"|awk '{print $2}'`
SET login_pid=`lsof -i:8086|grep "LISTEN"|awk '{print $2}'`
SET system_pid=`lsof -i:8087|grep "LISTEN"|awk '{print $2}'`
SET medicalRecordManagement_pid=`lsof -i:8088|grep "LISTEN"|awk '{print $2}'`
SET exam_pid=`lsof -i:8089|grep "LISTEN"|awk '{print $2}'`
SET intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`
IF "%eureka_pid%" != "" (
    kill "-9" "%eureka_pid%"
    echo "成功停止 eureka"
) ELSE (
    echo "eureka 不在运行"
)
IF "%login_pid%" != "" (
    kill "-9" "%login_pid%"
    echo "成功停止 login"
) ELSE (
    echo "login 不在运行"
)
IF "%system_pid%" != "" (
    kill "-9" "%system_pid%"
    echo "成功停止 system"
) ELSE (
    echo "system 不在运行"
)
IF "%medicalRecordManagement_pid%" != "" (
    kill "-9" "%medicalRecordManagement_pid%"
    echo "成功停止 medicalRecordManagement"
) ELSE (
    echo "medicalRecordManagement 不在运行"
)
IF "%exam_pid%" != "" (
    kill "-9" "%exam_pid%"
    echo "成功停止 exam"
) ELSE (
    echo "exam 不在运行"
)
IF "%intermediator_pid%" != "" (
    kill "-9" "%intermediator_pid%"
    echo "成功停止 intermediator"
) ELSE (
    echo "intermediator 不在运行"
)
echo "--------------停止结束--------------"
EXIT /B 0

:stopDev
echo "--------------开始停止--------------"
SET eureka_pid=`lsof -i:5272|grep "LISTEN"|awk '{print $2}'`
SET login_pid=`lsof -i:8762|grep "LISTEN"|awk '{print $2}'`
SET system_pid=`lsof -i:5678|grep "LISTEN"|awk '{print $2}'`
SET medicalRecordManagement_pid=`lsof -i:8777|grep "LISTEN"|awk '{print $2}'`
SET exam_pid=`lsof -i:8778|grep "LISTEN"|awk '{print $2}'`
SET intermediator_pid=`lsof -i:8090|grep "LISTEN"|awk '{print $2}'`
IF "%eureka_pid%" != "" (
    kill "-9" "%eureka_pid%"
    echo "成功停止 eureka"
) ELSE (
    echo "eureka 不在运行"
)
IF "%login_pid%" != "" (
    kill "-9" "%login_pid%"
    echo "成功停止 login"
) ELSE (
    echo "login 不在运行"
)
IF "%system_pid%" != "" (
    kill "-9" "%system_pid%"
    echo "成功停止 system"
) ELSE (
    echo "system 不在运行"
)
IF "%medicalRecordManagement_pid%" != "" (
    kill "-9" "%medicalRecordManagement_pid%"
    echo "成功停止 medicalRecordManagement"
) ELSE (
    echo "medicalRecordManagement 不在运行"
)
IF "%exam_pid%" != "" (
    kill "-9" "%exam_pid%"
    echo "成功停止 exam"
) ELSE (
    echo "exam 不在运行"
)
IF "%intermediator_pid%" != "" (
    kill "-9" "%intermediator_pid%"
    echo "成功停止 intermediator"
) ELSE (
    echo "intermediator 不在运行"
)
echo "--------------停止结束--------------"
EXIT /B 0
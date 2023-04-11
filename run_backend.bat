@echo off

SET eureka_prod_log=logs\prod\eureka.log
SET login_prod_log=logs\prod\login.log
SET system_prod_log=logs\prod\system.log
SET medicalRecordManagement_prod_log=logs\prod\medicalRecordManagement.log
SET exam_prod_log=logs\prod\exam.log
SET intermediator_prod_log=logs\prod\intermediator.log

SET eureka_dev_log=logs\dev\eureka.log
SET login_dev_log=logs\dev\login.log
SET system_dev_log=logs\dev\system.log
SET medicalRecordManagement_dev_log=logs\dev\medicalRecordManagement.log
SET exam_dev_log=logs\dev\exam.log
SET intermediator_dev_log=logs\dev\intermediator.log

IF "%~1:%~2"=="start:dev" (
    CALL :startDev
) ELSE IF "%~1:%~2"=="start:prod" (
    CALL :startProd
) ELSE IF "%~1:%~2"=="stop:dev" (
    CALL :stopDev
) ELSE IF "%~1:%~2"=="stop:prod" (
    CALL :stopProd
)

SET eureka_prod_log=
SET login_prod_log=
SET system_prod_log=
SET medicalRecordManagement_prod_log=
SET exam_prod_log=
SET intermediator_prod_log=

SET eureka_dev_log=
SET login_dev_log=
SET system_dev_log=
SET medicalRecordManagement_dev_log=
SET exam_dev_log=
SET intermediator_dev_log=

EXIT /B 0

:startProd
echo "--------------Start running--------------"
if not exist logs\prod mkdir -p logs\prod;
echo "Logs of running each module can be found in:"
echo "eureka: %eureka_prod_log%"
echo "login: %login_prod_log%"
echo "system: %system_prod_log%"
echo "medicalRecordManagement: %medicalRecordManagement_prod_log%"
echo "exam: %exam_prod_log%"
echo "intermediator: %intermediator_prod_log%"
echo "-----------------------------------"
echo "Starting......"
(
    start /b cmd /c mvnw.cmd -pl eureka spring-boot:run -P prod ^>^> %eureka_prod_log%
    start /b cmd /c mvnw.cmd -pl login spring-boot:run -P prod ^>^> %login_prod_log%
    start /b cmd /c mvnw.cmd -pl system spring-boot:run -P prod ^>^> %system_prod_log%
    start /b cmd /c mvnw.cmd -pl medicalRecordManagement spring-boot:run -P prod ^>^> %medicalRecordManagement_prod_log%
    start /b cmd /c mvnw.cmd -pl exam spring-boot:run -P prod ^>^> %exam_prod_log%
    start /b cmd /c mvnw.cmd -pl intermediator spring-boot:run -P prod ^>^> %intermediator_prod_log%
) | set /P "="

echo "Project was terminated"
EXIT /B 0


:startDev
echo "--------------Start running--------------"
if not exist logs\dev mkdir -p logs\dev;
echo "Logs of running each module can be found in:"
echo "eureka: %eureka_dev_log%"
echo "login: %login_dev_log%"
echo "system: %system_dev_log%"
echo "medicalRecordManagement: %medicalRecordManagement_dev_log%"
echo "exam: %exam_dev_log%"
echo "intermediator: %intermediator_dev_log%"
echo "-----------------------------------"
echo "Starting......"
(
    start /b "+++batch+++" cmd /c mvnw.cmd -pl eureka spring-boot:run -P dev ^>^> %eureka_dev_log%
    start /b "+++batch+++" cmd /c mvnw.cmd -pl login spring-boot:run -P dev ^>^> %login_dev_log%
    start /b "+++batch+++" cmd /c mvnw.cmd -pl system spring-boot:run -P dev ^>^> %system_dev_log%
    start /b "+++batch+++" cmd /c mvnw.cmd -pl medicalRecordManagement spring-boot:run -P dev ^>^> %medicalRecordManagement_dev_log%
    start /b "+++batch+++" cmd /c mvnw.cmd -pl exam spring-boot:run -P dev ^>^> %exam_dev_log%
    start /b "+++batch+++" cmd /c mvnw.cmd -pl intermediator spring-boot:run -P dev ^>^> %intermediator_dev_log%
) | set /P "="

echo "Project was terminated"
EXIT /B 0

:stopProd
echo "--------------Start stopping--------------"
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8085.*LISTENING
') DO SET eureka_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8086.*LISTENING
') DO SET login_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8087.*LISTENING
') DO SET system_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8088.*LISTENING
') DO SET medicalRecordManagement_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8089.*LISTENING
') DO SET exam_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8090.*LISTENING
') DO SET intermediator_pid=%%P

IF NOT "%eureka_pid%" == "" (
    TaskKill.exe /F /PID "%eureka_pid%"
    SET eureka_pid=
    echo "Successfully stopped eureka"
) ELSE (
    echo "eureka is not running"
)
IF NOT "%login_pid%" == "" (
    TaskKill.exe /F /PID "%login_pid%"
    SET login_pid=
    echo "Successfully stopped login"
) ELSE (
    echo "login is not running"
)
IF NOT "%system_pid%" == "" (
    TaskKill.exe /F /PID "%system_pid%"
    SET system_pid=
    echo "Successfully stopped system"
) ELSE (
    echo "system is not running"
)
IF NOT "%medicalRecordManagement_pid%" == "" (
    TaskKill.exe /F /PID "%medicalRecordManagement_pid%"
    SET medicalRecordManagement_pid=
    echo "Successfully stopped medicalRecordManagement"
) ELSE (
    echo "medicalRecordManagement is not running"
)
IF NOT "%exam_pid%" == "" (
    TaskKill.exe /F /PID "%exam_pid%"
    SET exam_pid=
    echo "Successfully stopped exam"
) ELSE (
    echo "exam is not running"
)
IF NOT "%intermediator_pid%" == "" (
    TaskKill.exe /F /PID "%intermediator_pid%"
    SET intermediator_pid=
    echo "Successfully stopped intermediator"
) ELSE (
    echo "intermediator is not running"
)
echo "--------------Stopping completed--------------"
EXIT /B 0

:stopDev
echo "--------------Start stopping--------------"
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:5272.*LISTENING
') DO SET eureka_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8762.*LISTENING
') DO SET login_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:5678.*LISTENING
') DO SET system_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8777.*LISTENING
') DO SET medicalRecordManagement_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8778.*LISTENING
') DO SET exam_pid=%%P
FOR /F "tokens=5 delims= " %%P IN ('
    netstat -a -n -o ^| findstr 0.0.0.0:8090.*LISTENING
') DO SET intermediator_pid=%%P

IF NOT "%eureka_pid%" == "" (
    TaskKill.exe /F /PID "%eureka_pid%"
    SET eureka_pid=
    echo "Successfully stopped eureka"
) ELSE (
    echo "eureka is not running"
)
IF NOT "%login_pid%" == "" (
    TaskKill.exe /F /PID "%login_pid%"
    SET login_pid=
    echo "Successfully stopped login"
) ELSE (
    echo "login is not running"
)
IF NOT "%system_pid%" == "" (
    TaskKill.exe /F /PID "%system_pid%"
    SET system_pid=
    echo "Successfully stopped system"
) ELSE (
    echo "system is not running"
)
IF NOT "%medicalRecordManagement_pid%" == "" (
    TaskKill.exe /F /PID "%medicalRecordManagement_pid%"
    SET medicalRecordManagement_pid=
    echo "Successfully stopped medicalRecordManagement"
) ELSE (
    echo "medicalRecordManagement is not running"
)
IF NOT "%exam_pid%" == "" (
    TaskKill.exe /F /PID "%exam_pid%"
    SET exam_pid=
    echo "Successfully stopped exam"
) ELSE (
    echo "exam is not running"
)
IF NOT "%intermediator_pid%" == "" (
    TaskKill.exe /F /PID "%intermediator_pid%"
    SET intermediator_pid=
    echo "Successfully stopped intermediator"
) ELSE (
    echo "intermediator is not running"
)
echo "--------------Stopping completed--------------"
EXIT /B 0

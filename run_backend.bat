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

for /F %%a in ('echo prompt $E ^| cmd') do set "ESC=%%a"

SET GREEN=[32m
SET BLUE=[34m
SET ENDCOLOR=[0m

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

SET ESC=

SET GREEN=
SET BLUE=
SET ENDCOLOR=

EXIT /B 0

:startProd
echo Stopping other applications if exists
echo -----------------------------------
CALL :stopDev
CALL :stopProd

echo Start running
echo Profile: prod
echo -----------------------------------
timeout 1 /nobreak >nul
if not exist logs\prod mkdir logs\prod;
echo Logs of running each module can be found in:
echo - eureka:                  %ESC%%GREEN%%eureka_prod_log%%ESC%%ENDCOLOR%
echo - login:                   %ESC%%GREEN%%login_prod_log%%ESC%%ENDCOLOR%
echo - system:                  %ESC%%GREEN%%system_prod_log%%ESC%%ENDCOLOR%
echo - medicalRecordManagement: %ESC%%GREEN%%medicalRecordManagement_prod_log%%ESC%%ENDCOLOR%
echo - exam:                    %ESC%%GREEN%%exam_prod_log%%ESC%%ENDCOLOR%
echo - intermediator:           %ESC%%GREEN%%intermediator_prod_log%%ESC%%ENDCOLOR%
echo. 
echo -----------------------------------
start /b cmd /c mvnw.cmd -pl eureka spring-boot:run -P prod ^>^> %eureka_prod_log%
start /b cmd /c mvnw.cmd -pl login spring-boot:run -P prod ^>^> %login_prod_log%
start /b cmd /c mvnw.cmd -pl system spring-boot:run -P prod ^>^> %system_prod_log%
start /b cmd /c mvnw.cmd -pl medicalRecordManagement spring-boot:run -P prod ^>^> %medicalRecordManagement_prod_log%
start /b cmd /c mvnw.cmd -pl exam spring-boot:run -P prod ^>^> %exam_prod_log%
start /b cmd /c mvnw.cmd -pl intermediator spring-boot:run -P prod ^>^> %intermediator_prod_log%
echo Starting......

setlocal EnableDelayedExpansion
for /F %%a in ('copy /Z "%~F0" NUL') do set "CR=%%a"

FOR /L %%i IN (0,2,100) DO ( < NUL set /P "=%%i %%!CR!" & timeout 1 /nobreak >nul)

echo Running completed
echo -----------------------------------
echo Running address of each module:
echo - eureka:                  %ESC%%BLUE%http://localhost:8085%ESC%%ENDCOLOR%
echo - login:                   %ESC%%BLUE%http://localhost:8086%ESC%%ENDCOLOR%
echo - system:                  %ESC%%BLUE%http://localhost:8087%ESC%%ENDCOLOR%
echo - medicalRecordManagement: %ESC%%BLUE%http://localhost:8088%ESC%%ENDCOLOR%
echo - exam:                    %ESC%%BLUE%http://localhost:8089%ESC%%ENDCOLOR%
echo - intermediator:           %ESC%%BLUE%http://localhost:8090%ESC%%ENDCOLOR%
echo. 
echo Please visit eureka page to check whether all 5 modules are running as expected. 

EXIT /B 0


:startDev
echo Stopping other applications if exists
echo -----------------------------------
CALL :stopDev
CALL :stopProd

echo Start running
echo Profile: dev
echo -----------------------------------
timeout 1 /nobreak >nul
if not exist logs\dev mkdir logs\dev;
echo Logs of running each module can be found in:
echo - eureka:                  %ESC%%GREEN%%eureka_dev_log%%ESC%%ENDCOLOR%
echo - login:                   %ESC%%GREEN%%login_dev_log%%ESC%%ENDCOLOR%
echo - system:                  %ESC%%GREEN%%system_dev_log%%ESC%%ENDCOLOR%
echo - medicalRecordManagement: %ESC%%GREEN%%medicalRecordManagement_dev_log%%ESC%%ENDCOLOR%
echo - exam:                    %ESC%%GREEN%%exam_dev_log%%ESC%%ENDCOLOR%
echo - intermediator:           %ESC%%GREEN%%intermediator_dev_log%%ESC%%ENDCOLOR%
echo.
echo -----------------------------------
start /b cmd /c mvnw.cmd -pl eureka spring-boot:run -P dev ^>^> %eureka_dev_log%
start /b cmd /c mvnw.cmd -pl login spring-boot:run -P dev ^>^> %login_dev_log%
start /b cmd /c mvnw.cmd -pl system spring-boot:run -P dev ^>^> %system_dev_log%
start /b cmd /c mvnw.cmd -pl medicalRecordManagement spring-boot:run -P dev ^>^> %medicalRecordManagement_dev_log%
start /b cmd /c mvnw.cmd -pl exam spring-boot:run -P dev ^>^> %exam_dev_log%
start /b cmd /c mvnw.cmd -pl intermediator spring-boot:run -P dev ^>^> %intermediator_dev_log%
echo Starting......

setlocal EnableDelayedExpansion
for /F %%a in ('copy /Z "%~F0" NUL') do set "CR=%%a"

FOR /L %%i IN (0,2,100) DO ( < NUL set /P "=%%i %%!CR!" & timeout 1 /nobreak >nul)

echo Running completed
echo -----------------------------------
echo Running address of each module:
echo - eureka:                  %ESC%%BLUE%http://localhost:5272%ESC%%ENDCOLOR%
echo - login:                   %ESC%%BLUE%http://localhost:8762%ESC%%ENDCOLOR%
echo - system:                  %ESC%%BLUE%http://localhost:5678%ESC%%ENDCOLOR%
echo - medicalRecordManagement: %ESC%%BLUE%http://localhost:8777%ESC%%ENDCOLOR%
echo - exam:                    %ESC%%BLUE%http://localhost:8778%ESC%%ENDCOLOR%
echo - intermediator:           %ESC%%BLUE%http://localhost:8090%ESC%%ENDCOLOR%
echo.
echo Please visit eureka page to check whether all 5 modules are running as expected. 

EXIT /B 0

:stopProd
echo Start stopping
echo Profile: prod
echo -----------------------------------
timeout 1 /nobreak >nul
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
    TaskKill.exe /F /PID "%eureka_pid%" >nul
    SET eureka_pid=
    echo Successfully stopped eureka
) ELSE (
    echo eureka is not running
)
IF NOT "%login_pid%" == "" (
    TaskKill.exe /F /PID "%login_pid%" >nul
    SET login_pid=
    echo Successfully stopped login
) ELSE (
    echo login is not running
)
IF NOT "%system_pid%" == "" (
    TaskKill.exe /F /PID "%system_pid%" >nul
    SET system_pid=
    echo Successfully stopped system
) ELSE (
    echo system is not running
)
IF NOT "%medicalRecordManagement_pid%" == "" (
    TaskKill.exe /F /PID "%medicalRecordManagement_pid%" >nul
    SET medicalRecordManagement_pid=
    echo Successfully stopped medicalRecordManagement
) ELSE (
    echo medicalRecordManagement is not running
)
IF NOT "%exam_pid%" == "" (
    TaskKill.exe /F /PID "%exam_pid%" >nul
    SET exam_pid=
    echo Successfully stopped exam
) ELSE (
    echo exam is not running
)
IF NOT "%intermediator_pid%" == "" (
    TaskKill.exe /F /PID "%intermediator_pid%" >nul
    SET intermediator_pid=
    echo Successfully stopped intermediator
) ELSE (
    echo intermediator is not running
)
echo Stopping completed
echo -----------------------------------
EXIT /B 0

:stopDev
echo Start stopping
echo Profile: dev
echo -----------------------------------
timeout 1 /nobreak >nul
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
    TaskKill.exe /F /PID "%eureka_pid%" >nul
    SET eureka_pid=
    echo Successfully stopped eureka
) ELSE (
    echo eureka is not running
)
IF NOT "%login_pid%" == "" (
    TaskKill.exe /F /PID "%login_pid%" >nul
    SET login_pid=
    echo Successfully stopped login
) ELSE (
    echo login is not running
)
IF NOT "%system_pid%" == "" (
    TaskKill.exe /F /PID "%system_pid%" >nul
    SET system_pid=
    echo Successfully stopped system
) ELSE (
    echo system is not running
)
IF NOT "%medicalRecordManagement_pid%" == "" (
    TaskKill.exe /F /PID "%medicalRecordManagement_pid%" >nul
    SET medicalRecordManagement_pid=
    echo Successfully stopped medicalRecordManagement
) ELSE (
    echo medicalRecordManagement is not running
)
IF NOT "%exam_pid%" == "" (
    TaskKill.exe /F /PID "%exam_pid%" >nul
    SET exam_pid=
    echo Successfully stopped exam
) ELSE (
    echo exam is not running
)
IF NOT "%intermediator_pid%" == "" (
    TaskKill.exe /F /PID "%intermediator_pid%" >nul
    SET intermediator_pid=
    echo Successfully stopped intermediator
) ELSE (
    echo intermediator is not running
)
echo Stopping completed
echo -----------------------------------
EXIT /B 0

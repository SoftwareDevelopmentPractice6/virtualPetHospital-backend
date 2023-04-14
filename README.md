<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-14 23:38:39
 * @FilePath: /virtualPetHospital-backend/README.md
 * @Description: 项目后端部分简介文件
-->
# Virtual Pet Hospital Backend Part

## Contributors

- 李亦杨 10195101467
- 刁泽皓 10195101470
- 陆宣辰 10195101466

## 运行项目

1. 启动MySQL数据库，数据库需要一个满足以下条件的用户

   - 权限：All
   - 端口：`3306`
   - 账号：`virtualPetHospital`
   - 密码：`virtualPetHospital`

    SQL:

    ```sql
    DROP USER if EXISTS `virtualPetHospital`;

    CREATE USER `virtualPetHospital`@`localhost` IDENTIFIED WITH mysql_native_password BY 'virtualPetHospital' PASSWORD EXPIRE NEVER;

    GRANT Alter, Alter Routine, Create, Create Routine, Create Temporary Tables, Create User, Create View, Delete, Drop, Event, Execute, File, Grant Option, Index, Insert, Lock Tables, Process, References, Reload, Replication Client, Replication Slave, Select, Show Databases, Show View, Shutdown, Super, Trigger, Update ON *.* TO `virtualPetHospital`@`localhost`;
    ```

2. 启动eureka模块，随后启动除了common与jacoco-report以外的全部模块
3. 8090端口的swagger界面可以测试项目接口

### 便捷的启动方式

#### MacOS & Linux

1. 根目录下运行：

    ```shell
    chmod 755 run_backend.sh
    ```

2. 根目录下运行：

    ```shell
    ./run_backend.sh start prod
    ```

    其中两个参数分别代表：

    - 参数1：start | stop。start用于启动项目，stop用于停止项目。
    - 参数2：dev | prod。dev表示选择dev环境，prod表示选择prod环境。

#### Windows

根目录下运行：

```batch
.\run_backend.bat start prod
```

可选参数及含义同上。

## Docker 打包

按顺序执行以下命令：

```bash
# 项目打成jar包

# Windows
# .\mvnw.cmd clean install -D skipTests
# MacOS & Linux
./mvnw clean install -D skipTests

# Windows
# .\mvnw.cmd clean package -D skipTests -P docker
# MacOS & Linux
./mvnw clean package -D skipTests -P docker

# docker build
docker build -t virtual-pet-hospital .
```

## 文档

### 后端开发人员用文档

- [项目相关信息](./docs/ProjectInfo.md)
- [规范与开发教程](./docs/StandardInstruction.md)
- [各类问题](./docs/QA.md)
- [TODO](./docs/TODO.md)

### 前端接口文档

1. 首先安装http-server

    ```nodejs
    npm install http-server -g
    ```

2. `cd`到`/docs/api-docs`
3. 命令`http-server`启动本地文件服务器
4. 到8080端口查看API文档

## 说明

1. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr，**不要自己merge**。
2. 本文件只作为整个后端的文档，各个模块的细致说明等文档放在各个子模块的目录下即可。

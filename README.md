<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-23 15:21:13
 * @FilePath: /virtualPetHospital-backend/README.md
 * @Description: 项目后端部分简介文件
-->
# Virtual Pet Hospital Backend Part

## 目录

- [Virtual Pet Hospital Backend Part](#virtual-pet-hospital-backend-part)
  - [目录](#目录)
  - [Contributors](#contributors)
  - [配置数据库](#配置数据库)
  - [运行项目](#运行项目)
    - [便捷的启动方式](#便捷的启动方式)
  - [文档](#文档)
    - [项目信息与常见运行问题](#项目信息与常见运行问题)
    - [后端开发人员用文档](#后端开发人员用文档)
    - [前端接口文档](#前端接口文档)
  - [说明](#说明)

## Contributors

- 李亦杨 10195101467
- 刁泽皓 10195101470
- 陆宣辰 10195101466

## 配置数据库

使用MySQL数据库，数据库需要一个满足以下条件的用户：

- 权限：All
- 端口：`3306`
- 账号：`virtualPetHospital`
- 密码：`virtualPetHospital`

## 运行项目

1. 启动MySQL数据库后，启动eureka模块，随后启动除了common与jacoco-report以外的全部模块
2. dev环境下8090端口的swagger界面可以测试项目接口

### 便捷的启动方式

根目录下运行：

```bash
# Windows
# .\run_backend.bat start prod

# MacOS & Linux
chmod 755 run_backend.sh
./run_backend.sh start prod
```

其中两个参数分别代表：

| 参数1 \ 参数2 | dev                 | prod                 |
| ------------- | ------------------- | -------------------- |
| start         | 启动项目（dev环境） | 启动项目（prod环境） |
| stop          | 停止项目（dev环境） | 停止项目（prod环境） |

## 文档

### 项目信息与常见运行问题

- [项目相关信息](./docs/ProjectInfo.md)
- [项目部署说明文档](./docs/ProjectDeployInstruction.md)
- [各类问题](./docs/QA.md)

### 后端开发人员用文档

- [项目设计文档](./docs/ProjectArchitecture.md)
- [规范与开发教程](./docs/StandardInstruction.md)
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

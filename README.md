<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-21 18:17:49
 * @FilePath: /virtualPetHospital-backend/README.md
 * @Description: 项目后端部分简介文件
-->
# Virtual Pet Hospital Backend Part

## Contributors

- 李亦杨 10195101467：数据管理
- 刁泽皓 10195101470：鉴权、系统管理、导览、职能学习（角色扮演，集成到系统管理部分）
- 陆宣辰 10195101466：病例管理、测试、职能学习（病例学习，集成到病例部分）

## TODO

- [X] 数据库设计
- [X] 数据库配置
- [X] SQL: DDL 3.18 5 PM
  - [X] 鉴权 & 系统
  - [X] 病例 & 测试：病例内`DISEASENAME`表加一个字段`category`，表明基础病例的所属类别（内科、寄生虫···）
- [ ] 开发：一个模块一周，可以先不写单测
  - [X] login
  - [ ] system
  - [ ] 病例
  - [X] exam
- [ ] 需要的功能：
  - [ ] 增：每表一个
  - [ ] 删：根据id删，每表一个
  - [ ] 改：根据id改，每表一个，用于改整条数据除id的全字段。控制器层接受的参数是JSON字符串
  - [ ] 查：视情况而定
- [ ] 中间层
- [ ] 文件上传
  - [X] 单一文件传输功能
  - [X] 图片格式转换
  - [ ] 视频格式转换（老师给的示例项目似乎没做，比较麻烦）
  - [ ] 分块上传（老师给的示例项目似乎没做，需要前端配合）
  - [ ] 批量操作（前端多调几次接口比较合理？）

## 文档

### 后端开发人员用文档

- [项目相关信息](./docs/ProjectInfo.md)
- [规范与开发教程](./docs/StandardInstruction.md)
- [各类问题](./docs/QA.md)

### 前端接口文档

1. 首先安装http-server

    ```nodejs
    npm install http-server -g
    ```

2. `cd`到`/docs/api-docs`
3. 命令`http-server`启动本地文件服务器
4. 到8080端口查看API文档

## 运行demo

1. 启动MySql数据库，数据库需要一个满足以下条件的用户

   - 权限：All
   - 端口：`3306`
   - 账号：`virtualPetHospital`
   - 密码：`virtualPetHospital`

2. 启动eureka模块，随后启动login、intermediator两个模块
3. [8090端口的swagger界面](localhost:8090/swagger-ui/index.html)可以测试demo接口
4. 开发可以完全参考demo，即login模块

## 说明

1. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr，**不要自己merge**。
2. 本文件只作为整个后端的文档，各个模块的细致说明等文档放在各个子模块的目录下即可。

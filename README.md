<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-14 18:34:34
 * @FilePath: /virtualPetHospital-backend/README.md
 * @Description: 项目后端部分简介文件
-->
# Virtual Pet Hospital Backend Part

## Contributors

- 李亦杨 10195101467：职能学习、数据管理
- 刁泽皓 10195101470：鉴权、系统管理、导览
- 陆宣辰 10195101466：病历管理、测试

## TODO

- [X] 数据库设计
- [ ] 数据库配置
- [ ] SQL

## 项目结构

- 系统类：
  - eureka：该文件夹内为Spring cloud所需的Eureka组件，**请勿改动**。其用于项目内各个子模块的注册。
  - jacoco-report: 用于测试报告集成，**请勿改动**。
  - swagger: 用于生成API文档，**请勿改动**。
- 功能模块：
  - login：登陆鉴权模块。
  - system: 系统管理模块、导览模块与职能学习部分。
  - medicalRecordManagement: 病例管理模块。

## 架构设计

``` mermaid
flowchart LR
    subgraph backend
        subgraph modules
            direction TB
            subgraph module 1
                direction LR
                entity1 --> dao1 --> service1 --> controller1
            end
            subgraph module 2
                direction LR
                entity2 --> dao2 --> service2 --> controller2
            end
            subgraph module 3
                direction LR
                entity3 --> dao3 --> service3 --> controller3
            end
            subgraph module 4
                direction LR
                entity4 --> dao4 --> service4 --> controller4
            end
        end
        subgraph intermediator
            direction LR
            servicei --> controlleri
        end

        controller1 --> servicei
        controller2 --> servicei
        controller3 --> servicei
        controller4 --> servicei
    end

    subgraph database
        databse1 --> entity1
        databse2 --> entity2
        databse3 --> entity3
        databse4 --> entity4
    end

    controlleri --> frontend
```

## 数据库设计

- [病例管理与测试模块数据库设计](./medicalRecordManagement/README.md#数据库设计)
- [导览与系统管理、职能学习部分数据库设计](./system/README.md#er图)
- [鉴权模块数据库设计](./login/README.md#数据库设计er图)

## 技术选型

- JAVA 17
- Spring Boot 3.0.3
- Spring Cloud微服务架构
- MySQL

以上均可以随意改动，只作参考

## 规范

### Commit Message

- feat: 新功能、特性
- fix: 修bug
- docs: 文档修改
- test: 测试
- style: 代码格式等修改
- refactor: 重构
- config: 项目配置

### 代码规范

- **命名要能清楚表达变量/函数等作用**，驼峰法，变量类型不用在变量名内提醒
- 复杂函数勤写注释
- 其他函数可以考虑简单写点参数与返回值之类的注释
- 尽量不要过长或过短的函数。能复用的部分尽可能复用

## Tips

### 创建新的子模块

1. 构建子模块的项目结构。
   - 子模块`pom.xml`修改为以下格式：

        ``` xml
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <parent>
                <groupId>pet.hospital.backend</groupId>
                <artifactId>virtualPetHospital-backend</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <relativePath/> <!-- lookup parent from repository -->
            </parent>
            <artifactId></artifactId> <!-- 此处为子模块artifactId -->
            <name></name> <!-- 此处为子模块name -->
            <description>Test report aggression.</description> <!-- 此处为子模块描述，需填写 -->
            <properties>
                <java.version>17</java.version>
            </properties>
            <dependencies>
                <!-- 按需要添加依赖 -->
            </dependencies>

        </project>
        ```

   - 根目录下`pom.xml`内在`<modules>`内添加`<module><module>`，中间填子模块artifactId

2. 为了注册子模块到eureka，请完成以下事项：
    - 在子模块`pom.xml`内添加依赖：Spring Discovery Client与Spring Boot Starter Actuator
    - 在启动类上添加注解`@EnableDiscoveryClient`
    - `resources/application.yml`按如下配置，文件后缀名记得修改为`yml`文件

        ``` yml
        server:
            port: # 端口号自己配新的，不要重复
        spring:
            application:
                name: # 名称自己选新的，需要能说明模块大致内容，不要重复
        
        eureka:
            instance:
                lease-renewal-interval-in-seconds: 30      # 心跳时间，即服务续约间隔时间（缺省为30s）
                lease-expiration-duration-in-seconds: 90  # 发呆时间，即服务续约到期时间（缺省为90s）
            client:
                registry-fetch-interval-seconds: 30 # 拉取服务注册信息间隔（缺省为30s）
                service-url:
                    defaultZone: http://localhost:5272/eureka/
                healthcheck:
                    enabled: true # 开启健康检查（依赖spring-boot-starter-actuator）
        ```

3. 添加子模块到测试集成模块与swagger，用于测试报告生成与API文档生成：
    - `jacoco-report`模块下的`pom.xml`内添加依赖，格式如下：

        ``` xml
        <dependency>
            <groupId>pet.hospital.backend</groupId>
            <artifactId></artifactId> <!-- 子模块artifactId -->
            <version>${project.version}</version>
        </dependency>
        ```

    - controller层内：
      - 类上加注解`@API(value = "")`，值填写模块名称
      - 每个接口的函数上添加以下两个注解：

        ``` java
        @ApiOperation(value="", notes="") 
        // value填写功能，notes写备注（可以是详细的功能）
        @ApiImplicitParams({
            // 填写参数列表
            @ApiImplicitParam(name = "", value = "", required = , dataType = ""),
            // 参数名称、参数含义、是否必须、数据类型、
            @ApiImplicitParam(name = "", value = "", required = , dataType = "")
        })
        ```

4. 子模块内MVC模式，四层的package命名为`entity, dao, service, controller`。

### 其他

1. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr，**不要自己merge**。
2. 本文件只作为整个后端的文档，各个模块的细致说明等文档放在各个子模块的目录下即可。
3. 生成测试报告：根目录下跑`mvn test`
4. 生成API文档：运行子模块`swagger`然后到对应端口看

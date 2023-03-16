<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-16 13:33:10
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
- [ ] SQL: DDL 3.18 5 PM
- [ ] 开发 一个模块一周 包括测试

## 项目结构

- 系统类：
  - eureka：该文件夹内为Spring cloud所需的Eureka组件，**请勿改动**。其用于项目内各个子模块的注册。
  - jacoco-report: 用于测试报告集成，**请勿改动**。
- 功能模块：
  - login：登陆鉴权模块。
  - system: 系统管理模块、导览模块与职能学习部分。
  - medicalRecordManagement: 病例管理模块。
  - intermediator: 中间层模块，后期负责数据转发到前端

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
- Spring Cloud 微服务架构
- MySQL 8.0.32

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
- 增删操作使用`saveAndFlush`等功能，不要用原生sql
- 尽量使用REST风格API，接口统一前缀`/api`
- 单元测试覆盖率要求70%以上

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

            <build>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>

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

    - 启动类上加注解

      ``` java
      @OpenAPIDefinition(
        info = @Info(
            title = "鉴权模块", // 模块名称
            version = "0.0.1-SNAPSHOT",  // 项目版本
            description = "虚拟宠物医院API文档-鉴权模块" // 描述
        )
      )

      ```

    - controller层内（intermediator以外的模块可以不加，建议加一下方便用UI测接口）：
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

    - intermediator模块内部每个控制器都要添加以下内容：
      - 类上加注解`@API(tag="")`，`tag`填写模块名称
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
        @ApiResponses(
        // 返回结果示例
            value = {
                @ApiResponse(
                // 一个ApiResponse是一个example
                    responseCode = "200",
                    // 状态码，不能重复
                    content =
                        @Content(
                            examples = {
                                @ExampleObject(
                                    name = "login",
                                    // 示例名称
                                    description = "Login success message.",
                                    //示例描述
                                    value =
                                    // 示例内容，以JSON字符串形式表示
                                            "{\"code\": 200,\"message\": \"ok\",\"data\": {\"userPassword\": \"admin\",\"userName\": \"admin@admin.com\",\"userAuthority\": 1,\"userId\": 1}}")
                            },
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
                            // 传输格式，通常是application/json
                @ApiResponse(
                    responseCode = "515",
                    description = "Request failed",
                    content =
                        @Content(
                            examples = {
                                @ExampleObject(
                                    name = "login",
                                    description = "Login failure message.",
                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                            },
                            mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
        ```

4. 子模块连接数据库：
   - `yml`文件内增加以下配置：
  
        ``` yml
        spring:
            datasource:
                username: virtualPetHospital 
                # MySql数据库使用统一的用户名与密码
                password: virtualPetHospital 
                # MySql数据库使用统一的用户名与密码
                url: jdbc:mysql://localhost:3306/login?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
                # 子模块使用自己的database，命名为子模块的artifactId
                # url部分?前的login修改成子模块所使用的database名
            sql:
                init:
                    mode: always
                    username: virtualPetHospital
                    password: virtualPetHospital
                    schema-locations:
                        - classpath:database/login_initialize.sql
                        # 初始化表sql文件，文件放在`/resource/database`内
                    data-locations:
                        - classpath:database/login_data.sql
                        # 导入数据sql文件，文件放在`/resource/database`内
        ```

   - 初始化表的sql文件建表时，统一采用`CREATE TABLE IF NOT EXISTS TABLE_NAME`
5. 子模块内MVC模式，四层的package命名为`entity, dao, service, controller`。

### 其他

1. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr，**不要自己merge**。
2. 本文件只作为整个后端的文档，各个模块的细致说明等文档放在各个子模块的目录下即可。
3. 方便起见MySql数据库使用统一的账号密码：
   - 端口：`3306`
   - 账号：`virtualPetHospital`
   - 密码：`virtualPetHospital`
4. 生成测试报告：根目录下跑`mvn test`
5. 生成API文档：运行模块后，然后到对应端口`localhost:${module_port}/swagger-ui/index.html`查看
6. java格式化检查与自动格式化：根目录下`mvn spotless:check`，`mvn spotless:apply`
7. `mvn`命令跑不了，显示`non-resolvable parent pom for ···`，或无法正确识别项目结构的解决方法：
   1. 删除根目录下`pom.xml`内以下内容：

        ``` xml
        <modules>
            <module>eureka</module>
            <module>login</module>
            <module>medicalRecordManagement</module>
            <module>system</module>
            <module>jacoco-report</module>
            <module>intermediator</module>
        </modules>
        ```

   2. 根目录下依次执行命令`mvn clean`，`mvn install`。
   3. 把根目录下`pom.xml`内删除的内容添加回去。
   4. 编译器重新加载项目，之后`mvn`命令可以正常运行，且项目结构也可以被正常识别。

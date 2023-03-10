# Medical Record Management

## Contributors

- 陆宣辰 10195101466

## 分工

- 陆宣辰：开发

## TODO

- [ ] 数据库设计

## 项目结构

- eureka：该文件夹内为Spring cloud所需的Eureka组件，**请勿改动**。其用于项目内各个子模块的注册。最后可以写一个统一运行子模块的功能。
- login：该文件夹内为示例子模块。可以后期当作登陆鉴权模块的基础。目前其添加了MySQL的依赖，可以后期根据技术选型修改。

## 架构设计

``` mermaid
erDiagram
   
    Case {
        string CaseID PK
        string DiseaseNameID FK
        string DiagnosticResultID FK
        string AdmissionID FK
        string CasecheckID FK
        string TreatmentProgramID FK
    }
    Case ||--|{ DiseaseName : contains
    Case ||--|{ Admission : contains
    Case ||--|{ Casecheck : contains
    Case ||--|{ DiagnosticResult : contains
    Case ||--|{ TreatmentProgram : contains
    DiseaseName {
        string DiseaseNameID PK
        string content
        string photo
        string video
    }
    DiagnosticResult {
        string DiagnosticResultID PK
        string content
        string photo
        string video
    }
    Admission {
        string AdmissionID PK
        string content
        string photo
        string video
    }
    Casecheck { 
        string CasecheckID PK
        string content
        string photo
        string video
    }
    TreatmentProgram {
        string TreatmentProgramID PK
        string content
        string photo
        string video
    }
```

## 技术选型

- JAVA 11
- Spring Boot 3.0.3
- Spring Cloud微服务架构
- MySQL

## 需求


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

1. 为了注册子模块到eureka，请完成以下事项：
    - 在`pom.xml`内添加依赖：Spring Discovery Client与Spring Boot Starter Actuator
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

2. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr。
3. 本文件只作为整个后端的文档，各个模块的细致说明（如接口等）等文档放在各个子模块的目录下即可。
4. 先按需求内模块划分数据库数据，提供包含耦合较大的信息族的大接口，后续根据前段需求从大接口细分小接口

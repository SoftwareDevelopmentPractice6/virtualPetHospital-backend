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


``` mermaid
erDiagram
          +--------+              +--------+
          |  Exam  |              |  Paper |
          +--------+              +--------+
              |                      |
              |                      |
              |                      |
              |                      |
              |                      |
+-------------+------------+ +------+------+
|          Question         | | Exam Session |
+-------------+------------+ +------+------+
              |                      |
              |                      |
              |                      |
              |                      |
              |                      |
        +-----+------+        +------+--------+
        |  Category  |        | Student Result |
        +------------+        +---------------+

Exam {
  exam_id PK
  exam_name
}

Paper {
  paper_id PK
  paper_name
  exam_id FK
  duration
  total_score
}

Question {
  question_id PK
  question_content
  question_type
  category_id FK
}

Category {
  category_id PK
  category_name
}

ExamSession {
  session_id PK
  paper_id FK
  start_time
  end_time
}

StudentResult {
  result_id PK
  session_id FK
  student_id
  score
}
```
解释：

Exam 表存储考试信息，包括考试 ID 和考试名称等。
Paper 表存储试卷信息，包括试卷 ID、试卷名称、所属考试 ID、考试时间、每题分数、总分等。
Question 表存储考题信息，包括考题 ID、考题内容、考题类型、所属类别 ID 等。
Category 表存储考题类别信息，包括类别 ID 和类别名称等。
ExamSession 表存储每次考试信息，包括考试 ID、试卷 ID、开始时间、结束时间等。
StudentResult 表存储学生考试成绩信息，包括成绩 ID、考试 ID、学生 ID、考试得分等。
在这个设计中，考试信息、试卷信息、考题信息、考题类别信息、每次考试信息和学生考试成绩信息都被存储在不同的表中，各自独立。这样做的好处是可以方便地进行增删改查操作，同时也可以方便地进行数据分析和统计。




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

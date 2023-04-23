<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-18 21:03:21
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-21 22:54:33
 * @FilePath: /virtualPetHospital-backend/docs/StandardInstruction.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# 虚拟宠物医院后端项目规范与开发教程

## 目录

- [虚拟宠物医院后端项目规范与开发教程](#虚拟宠物医院后端项目规范与开发教程)
  - [目录](#目录)
  - [规范](#规范)
    - [Commit Message](#commit-message)
    - [代码规范](#代码规范)
  - [常用工具使用](#常用工具使用)
  - [常用`mvn`命令](#常用mvn命令)
  - [开发教程](#开发教程)
    - [创建新的子模块](#创建新的子模块)
      - [构建子模块的项目结构](#构建子模块的项目结构)
      - [注册子模块到eureka](#注册子模块到eureka)
      - [添加子模块到测试集成模块，用于测试报告生成](#添加子模块到测试集成模块用于测试报告生成)
      - [添加子模块到父模块`pom.xml`中：](#添加子模块到父模块pomxml中)
      - [子模块连接数据库](#子模块连接数据库)
    - [后端子模块开发](#后端子模块开发)
      - [entity层](#entity层)
      - [dao层](#dao层)
      - [service层](#service层)
      - [controller层](#controller层)
    - [中间层](#中间层)
      - [中间层service](#中间层service)
      - [中间层controller](#中间层controller)
    - [测试](#测试)
    - [子模块swagger使用](#子模块swagger使用)
      - [启动类](#启动类)
      - [controller层内](#controller层内)
  - [学习资料](#学习资料)
    - [Java小技巧](#java小技巧)
    - [Spring-boot子模块架构相关](#spring-boot子模块架构相关)
    - [Spring-boot数据库相关](#spring-boot数据库相关)
    - [Spring-boot文件传输](#spring-boot文件传输)
    - [Spring-boot测试相关](#spring-boot测试相关)
    - [Spring-cloud微服务框架相关](#spring-cloud微服务框架相关)
    - [接口相关](#接口相关)

## 规范

### Commit Message

- feat: 新功能、特性
- fix: 修bug
- docs: 文档修改
- test: 测试
- style: 代码格式等修改
- refactor: 重构
- config: 项目配置
- perf: 性能优化
- version: 版本更新

### 代码规范

1. **命名要能清楚表达变量/函数等作用**，驼峰法，变量类型不用在变量名内提醒
2. 复杂函数勤写注释
3. 其他函数可以考虑简单写点参数与返回值之类的注释
4. 尽量不要过长或过短的函数。能复用的部分尽可能复用

## 常用工具使用

1. 生成测试报告：根目录下跑`mvn test`
2. 生成API文档：运行模块后，然后到对应端口`localhost:${module_port}/swagger-ui/index.html`查看
3. java格式化检查与自动格式化：根目录下`mvn spotless:check`，`mvn spotless:apply`

## 常用`mvn`命令

- `mvn test`: 跑测试、生成测试报告
- `mvn clean install`: 重新加载项目、下载依赖等
- `mvn spotless:check`：检查Java格式
- `mvn spotless:apply`：Java格式化
- `mvn versions:set -D newVersion=版本号`: 更新项目版本
- `mvn versions:revert`: 项目版本回滚
- `mvn versions:commit`: 项目版本提交
- `mvn package`: 项目打包
- `mvn 指令 -D skipTests`: 跳过测试
- `mvn 指令 -P 环境定义ID`: 指定环境运行

## 开发教程

### 创建新的子模块

#### 构建子模块的项目结构

1. 子模块`pom.xml`修改为以下格式：

    ``` xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <parent>
            <groupId>pet.hospital.backend</groupId>
            <artifactId>virtualPetHospital-backend</artifactId>
            <version>0.0.1-SNAPSHOT</version> <!-- 此处为父模块版本号 -->
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

2. 根目录下`pom.xml`内在`<modules>`内添加`<module><module>`，中间填子模块artifactId

#### 注册子模块到eureka

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

#### 添加子模块到测试集成模块，用于测试报告生成

`jacoco-report`模块下的`pom.xml`内添加依赖，格式如下：

``` xml
<dependency>
    <groupId>pet.hospital.backend</groupId>
    <artifactId></artifactId> <!-- 子模块artifactId -->
    <version>${project.version}</version>
</dependency>
```

#### 添加子模块到父模块`pom.xml`中：

```xml
<modules>
    <module>eureka</module>
    <module>common</module>
    <module>jacoco-report</module>
    <module>login</module>
    <module>medicalRecordManagement</module>
    <module>system</module>
    <module>exam</module>
    <module>intermediator</module>
</modules>
```

#### 子模块连接数据库

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

### 后端子模块开发

子模块内MVC模式，四层的package命名为`entity, dao, service, controller`。

#### entity层

1. 若有外键，那么从表需要在外键标记注解，如下：

    ```sql
    CREATE TABLE IF NOT EXISTS CATEGORY (
        category_id INT PRIMARY KEY AUTO_INCREMENT,
        category_name VARCHAR(255)
    );

    CREATE TABLE IF NOT EXISTS QUESTION (
        question_id INT PRIMARY KEY AUTO_INCREMENT,
        question_content TEXT,
        question_type VARCHAR(255),
        category_id INT,
        FOREIGN KEY (category_id) REFERENCES CATEGORY(category_id) ON DELETE CASCADE
    );
    ```

    ```java
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "category_id", nullable = false)
        int categoryId;

        @Column(name = "category_name")
        String categoryName;
    }


    public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "question_id", nullable = false)
        int questionId;

        @Column(name = "question_content")
        String questionContent;

        @Column(name = "question_type")
        String questionType;

        @ManyToOne
        @JoinColumn(name = "category_id", referencedColumnName = "category_id")
        Category questionCategory;
    }
    ```

2. 任何表的主键字段都不允许改动

#### dao层

1. 增改操作使用`saveAndFlush`，不要用原生sql
2. 删除操作使用`deleteById`，不要用原生sql
3. 查操作不用写sql，使用内建方法`findAll`或`findById`，可以使用java的stream流进行filter，例如：

    ```java
    List<User> targetUserList = userRepository.findAll().stream()
                .filter(user -> Objects.equals(user.getUserName(), userName))
                .collect(Collectors.toList());
    ```

    同时查操作尽量精简为一个函数。通过传递参数或null值，在filter进行判断以筛选。查操作不需要实现根据数字id查询，具体如：

    ```java
        public JSONObject getQuestions(String questionKeyword, String questionType, Integer categoryId) {
            JSONObject res = new JSONObject();
            res.put(
                    Constants.questionList,
                    JSONObject.parseArray(JSON.toJSONString(questionRepository.findAll().stream()
                            .filter(question -> !Objects.equals(
                                            question.getQuestionContent().indexOf(questionKeyword), -1)
                                    && (Objects.equals(questionType, "")
                                            ? true
                                            : Objects.equals(question.getQuestionType(), questionType))
                                    && (Objects.equals(categoryId, null)
                                            ? true
                                            : Objects.equals(
                                                    question.getQuestionCategory().getCategoryId(), categoryId)))
                            .collect(Collectors.toList()))));
            return ResponseHelper.constructSuccessResponse(res);
        }
    ```

#### service层

1. 不变量统一存在common模块下的`Constants.java`内，使用时用`Constants.xxx`的方式
2. 可复用方法、工具类写在common模块
3. 返回数据格式，请求状态可以参考[intermediator模块内helper文件夹下的EnumCode.java文件](../intermediator/src/main/java/pet/hospital/backend/intermediator/helper/EnumCode.java)：

    ```json
    {
        "code": 200, // 表明请求状态
        "data": {
            // 内部存储需要的数据，JSONObject格式或JSONArray格式
        }
    }
    ```

#### controller层

1. 尽量不要使用使用REST风格API
2. 接口统一前缀`/api`
3. 接口：

- 增：POST
- 删：DELETE
- 改：PUT
- 查：GET/POST
参数为一个时用GET方法，参数用`@PathVariable`修饰，使参数在请求路径中；参数多个时用POST方法

4.建议接入swagger方便测试与查看接口，使用可以参考[这里](#子模块swagger使用)

### 中间层

#### 中间层service

1. 不变量统一存在中间层自己的`Constants.java`内，使用时用`Constants.xxx`的方式
2. 可复用方法、工具类写在helper包内
3. 返回数据统一用`helper`包中的`ResponseData`类

#### 中间层controller

1. 尽量使用REST风格API
2. 接口统一前缀`/api`
3. 接口：

   - 增：POST
   - 删：DELETE
   - 改：PUT
   - 查：GET/POST。参数为一个时用GET方法；参数多个时用POST方法

4. 参数为一个时尽量用`@PathVariable`修饰，使参数在请求路径中；参数多个时用query string或者request body

### 测试

1. 测试只需要写service层与controller层
2. 单元测试覆盖率要求70%以上
3. 类上注解`@Transactional`，表明测试需要回滚
4. 控制器层测试不要调方法，需要用Mockito模拟发请求

### 子模块swagger使用

#### 启动类

启动类上加注解

``` java
@OpenAPIDefinition(
    info = @Info(
        title = "鉴权模块", // 模块名称
        description = "虚拟宠物医院API文档-鉴权模块" // 描述
    )
)
```

#### controller层内

1. 类上加注解`@Tag(name = "")`，值填写模块名称
2. 每个接口的函数上添加`@Operation(summary = "")`，填写接口功能
3. 每个参数前添加`@Parameter(description = "") @RequestParam(required = true)`，description写参数描述，required为是否必须。`@RequestParam`注解根据情况需要替换成其他注解，主要有：

   - `@RequestParam`表明以query string方式发送参数请求接口
   - `@RequestBody`表明请求参数写在请求体中
   - `@PathVariable`表明请求参数写在路径中
  
4. 中间层模块还需要在每个接口的函数上额外添加以下注解：

    ``` java
    @ApiResponses(
    // 返回结果示例
        value = {
            @ApiResponse(
            // 一个ApiResponse包含一个example
                responseCode = "200",
                // 状态码，不能重复
                content =
                    @Content(
                        examples = {
                            @ExampleObject(
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
                                description = "Login failure message.",
                                value = "{\"code\": 515,\"message\": \"Request failed\"}")
                        },
                        mediaType = MediaType.APPLICATION_JSON_VALUE))
        })
    ```

## 学习资料

### Java小技巧

- [Java8提供的stream流操作](https://blog.csdn.net/MinggeQingchun/article/details/123184273)
- [Java正则表达式](https://blog.csdn.net/qq_41154902/article/details/124948491?spm=1001.2101.3001.6650.15&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-15-124948491-blog-114474391.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-15-124948491-blog-114474391.pc_relevant_default&utm_relevant_index=16)

### Spring-boot子模块架构相关

- [Spring-boot四层MVC框架](https://blog.csdn.net/weixin_44532671/article/details/117914161?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-117914161-blog-125536691.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-117914161-blog-125536691.pc_relevant_multi_platform_whitelistv3)
- [常用注解](https://zhuanlan.zhihu.com/p/489217499)

### Spring-boot数据库相关

- [Spring-boot连数据库](https://www.w3cschool.cn/article/69469419.html)
- [外键写法概要](https://www.cnblogs.com/luo630/p/15428367.html)
- [一对一、一对多、多对多等外键写法](https://blog.csdn.net/sinianliushui/article/details/101452018?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-101452018-blog-127540339.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-101452018-blog-127540339.pc_relevant_default&utm_relevant_index=6)
- [JPA级连操作](https://www.jianshu.com/p/ae07c9f147bc)
- [JPA deleteById](https://blog.csdn.net/qq_34465338/article/details/121336199)
- [JPA saveAndFlush](https://blog.csdn.net/chusen/article/details/112913759)
- [用JPA来减少撰写sql](https://blog.csdn.net/weixin_45815335/article/details/125203399)

### Spring-boot文件传输

- [Spring接收、发送文件](https://blog.csdn.net/qq_57390446/article/details/127797971)
- [MultipartFile多服务间中转文件](https://blog.csdn.net/weixin_43202160/article/details/129025774?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EYuanLiJiHua%7EPosition-2-129025774-blog-123480628.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EYuanLiJiHua%7EPosition-2-129025774-blog-123480628.pc_relevant_default&utm_relevant_index=5)
- [文件中转](https://blog.csdn.net/qq_38066290/article/details/111253699)
- [大文件转发](https://stackoverflow.com/questions/15781885/how-to-forward-large-files-with-resttemplate/36226006#36226006)
- [中转小/大型文件](https://blog.csdn.net/eleanoryss/article/details/123480628)
- [文件分块上传](https://blog.csdn.net/u011974797/article/details/127614183)

### Spring-boot测试相关

- [Spring-boot测试回滚](https://blog.csdn.net/weixin_60719453/article/details/127423660)
- [Spring-boot测试](https://blog.csdn.net/m0_52601969/article/details/125954919)
- [Spring-boot Mock测试](https://blog.csdn.net/oschina_41790905/article/details/111501402)

### Spring-cloud微服务框架相关

- [Spring-cloud模块间调用](https://www.cnblogs.com/moonandstar08/p/7565524.html)

### 接口相关

- [REST风格API](https://zhuanlan.zhihu.com/p/536437382)
- [Swagger接口文档导出](https://stackoverflow.com/questions/54259816/how-to-generate-a-pdf-or-markup-from-openapi-3-0)

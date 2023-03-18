<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-17 02:08:53
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-18 21:16:57
 * @FilePath: /virtualPetHospital-backend/docs/QA.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# 虚拟宠物医院后端项目常见问题

## 常见报错

### `non-resolvable parent pom for ···`

``` text
non-resolvable parent parent POM for ···
Could not find artifact ··· and 'parent.relativePath' points at no local POM
```

`mvn`命令跑不了，显示`non-resolvable parent pom for ···`，或无法正确识别项目结构的解决方法：

1. 删除根目录下`pom.xml`内以下内容：

    ``` xml
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

2. 根目录下依次执行命令`mvn clean`，`mvn install`。
3. 把根目录下`pom.xml`内删除的内容添加回去。
4. 编译器重新加载项目，之后`mvn`命令可以正常运行，且项目结构也可以被正常识别。

### `package/repackage fail`

``` text
package/repackage fail ··· 
has been compiled by a more recent version of the Java Runtime
Java Runtime (class file version 61.0), this version of the Java Runtime only recognizes class file version ...
```

电脑默认Java版本太低，改成Java 17

### 无法识别`mvn`命令

- MacOs/Linux: `mvn`改成`./mvnw`
- Windows: `mvn`改成`mvnw.cmd`

### `java.lang.IllegalStateException`

```test
java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
```

Spring-boot 3.0.3内部问题，保证项目路径没有空格或中文即可

### 项目正常运行且接口映射正确，但接口404

Spring-boot 3.0.3内部问题，保证项目路径没有空格或中文即可

## 创建新的子模块

### 构建子模块的项目结构

1. 子模块`pom.xml`修改为以下格式：

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

2. 根目录下`pom.xml`内在`<modules>`内添加`<module><module>`，中间填子模块artifactId

### 注册子模块到eureka

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

### 添加子模块到测试集成模块，用于测试报告生成

`jacoco-report`模块下的`pom.xml`内添加依赖，格式如下：

``` xml
<dependency>
    <groupId>pet.hospital.backend</groupId>
    <artifactId></artifactId> <!-- 子模块artifactId -->
    <version>${project.version}</version>
</dependency>
```

### 子模块连接数据库

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

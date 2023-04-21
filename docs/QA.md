<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-17 02:08:53
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-21 22:52:34
 * @FilePath: /virtualPetHospital-backend/docs/QA.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# 虚拟宠物医院后端项目常见问题

## 目录

- [虚拟宠物医院后端项目常见问题](#虚拟宠物医院后端项目常见问题)
  - [目录](#目录)
  - [常见报错](#常见报错)
    - [`non-resolvable parent pom for ···`](#non-resolvable-parent-pom-for-)
    - [`Failed to execute goal on project ...: Could not find artifact ...`](#failed-to-execute-goal-on-project--could-not-find-artifact-)
    - [`package/repackage fail`](#packagerepackage-fail)
    - [无法识别`mvn`命令](#无法识别mvn命令)
    - [`java.lang.IllegalStateException`](#javalangillegalstateexception)
    - [项目正常运行且接口映射正确，但接口404](#项目正常运行且接口映射正确但接口404)

## 常见报错

### `non-resolvable parent pom for ···`

``` text
non-resolvable parent parent POM for ···
Could not find artifact ··· and 'parent.relativePath' points at no local POM
```

`mvn`命令跑不了，显示`non-resolvable parent pom for ···`，或无法正确识别项目结构的解决方法：

- 手动更改`pom.xml`后install：

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

- 或者可以根目录下依次执行：

    ```bash
    # Windows
    # .\mvnw.cmd clean install -D skipTests -N
    # .\mvnw.cmd clean install -D skipTests

    # MacOS & Linux
    ./mvnw clean install -D skipTests -N
    ./mvnw clean install -D skipTests
    ```

### `Failed to execute goal on project ...: Could not find artifact ...`

``` text
Failed to execute goal on project ...: 
Could not resolve dependencies for project ...: 
Could not find artifact ...
```

项目缺少依赖包，解决方案同[上](#non-resolvable-parent-pom-for-)

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

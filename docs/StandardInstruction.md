<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-18 21:03:21
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-19 15:02:21
 * @FilePath: /virtualPetHospital-backend/docs/StandardInstruction.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# 虚拟宠物医院后端项目规范与开发教程

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

### 后端子模块开发

子模块内MVC模式，四层的package命名为`entity, dao, service, controller`。

### entity层

1. 若有外键，那么从表和主表都需要有属性，如下：

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

        @OneToMany(cascade = CascadeType.ALL)
        @JSONField(serialize = false) // 忽略此属性，序列化为json时不需要此属性
        List<Question> categoryQuestion;
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

2. 通常主表字段中需要加`cascade = CascadeType.ALL`，从表不需要。具体情况看业务
3. 主表的实体类指向从表的属性上需要添加`@JSONField(serialize = false)`，表明序列化为`json`时需要忽略该字段，防止出现无限循环问题
4. 任何表的主键字段都不允许改动

#### dao层

1. 增改操作使用`saveAndFlush`，不要用原生sql
2. 删除操作使用`deleteById`，不要用原生sql
3. 查操作不用写sql，使用内建方法`findAll`或`findById`，可以使用java的stream流进行filter，例如：

    ```java
    List<User> targetUserList = userRepository.findAll().stream()
                .filter(user -> Objects.equals(user.getUserName(), userName))
                .collect(Collectors.toList());
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
- 查：GET/POST
参数为一个时用GET方法，参数用`@PathVariable`修饰，使参数在请求路径中；参数多个时用POST方法

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
        version = "0.0.1-SNAPSHOT",  // 项目版本
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

### Spring-boot封装的易用工具相关

- [Spring接收、发送文件](https://blog.csdn.net/qq_57390446/article/details/127797971)

### Spring-boot测试相关

- [Spring-boot测试回滚](https://blog.csdn.net/weixin_60719453/article/details/127423660)
- [Spring-boot测试](https://blog.csdn.net/m0_52601969/article/details/125954919)
- [Spring-boot Mock测试](https://blog.csdn.net/oschina_41790905/article/details/111501402)

### Spring-cloud微服务框架相关

- [Spring-cloud模块间调用](https://www.cnblogs.com/moonandstar08/p/7565524.html)

### 接口相关

- [REST风格API](https://zhuanlan.zhihu.com/p/536437382)
- [Swagger接口文档导出](https://stackoverflow.com/questions/54259816/how-to-generate-a-pdf-or-markup-from-openapi-3-0)

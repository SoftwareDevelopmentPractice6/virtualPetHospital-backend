<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 21:25:54
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
- [ ] 开发：一个模块一周 包括测试
- [ ] 需要的sql：
  - [ ] 增：每表一个，POST请求
  - [ ] 删；根据id删，每表一个，DELETE请求
  - [ ] 改：根据id改，每表一个，用于改整条数据除id的全字段，PUT请求
  - [ ] 查：视情况而定，参数少可以用GET请求，参数多时用POST请求。GET请求参数用`@PathVariable`修饰，使参数在请求路径中
- [ ] 中间层
- [ ] 文件上传

## 文档

- [项目相关信息](./docs/ProjectInfo.md)
- [各类问题](./docs/QA.md)

## 运行demo

1. 启动MySql数据库，数据库需要一个满足以下条件的用户

   - 权限：All
   - 端口：`3306`
   - 账号：`virtualPetHospital`
   - 密码：`virtualPetHospital`

2. 启动eureka模块，随后启动login、intermediator两个模块
3. [8090端口的swagger界面](ocalhost:8090/swagger-ui/index.html)可以测试demo接口

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

- 总体开发规范：
  
  - **命名要能清楚表达变量/函数等作用**，驼峰法，变量类型不用在变量名内提醒
  - 复杂函数勤写注释
  - 其他函数可以考虑简单写点参数与返回值之类的注释
  - 尽量不要过长或过短的函数。能复用的部分尽可能复用

- dao层：
  
  - 增改操作使用`saveAndFlush`，不要用原生sql
  - 删除操作使用`deleteById`，不要用原生sql
  - 只有查数据要写SQL

- service层：
  
  - 不变量统一存在`Constants.java`内，每个模块一个，使用时用`Constants.xxx`的方式
  - 返回数据格式：

    ```json
    {
      "code": 1 // 表明请求是否成功，成功为1，失败为-1
      "message": "xxx" // 与code相关联
      "data": {
        // 内部存储需要的数据，JSONObject格式或JSONArray格式
      }
    }
    ```

- controller层：
  
  - 尽量使用REST风格API，接口统一前缀`/api`
  - 接口：

    - 增：POST
    - 删：DELETE
    - 改：PUT
    - 查：GET/POST
      参数为一个时用GET方法，参数用`@PathVariable`修饰，使参数在请求路径中；参数多个时用POST方法
  - 建议接入swagger方便测试与查看接口，使用可以参考[这里](docs/QA.md#添加子模块到swagger用于api文档生成)

- 测试：

  - 测试只需要写service层与controller层
  - 单元测试覆盖率要求70%以上
  - 类上注解`@Transactional`，表明测试需要回滚
  - 控制器层测试不要调方法，需要用Mockito模拟发请求

## 其他

1. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr，**不要自己merge**。
2. 本文件只作为整个后端的文档，各个模块的细致说明等文档放在各个子模块的目录下即可。

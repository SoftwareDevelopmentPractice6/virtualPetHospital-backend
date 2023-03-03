<!--
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-01 22:42:27
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-01 23:28:49
 * @FilePath: /virtualPetHospital-backend/README.md
 * @Description: 项目后端部分简介文件
-->
# Virtual Pet Hospital Backend Part

## Contributors

- 李亦杨 10195101467
- 刁泽皓 10195101470
- 陆宣辰 10195101466

## 项目结构

- eureka：该文件夹内为Spring cloud所需的Eureka组件，**请勿改动**。其用于项目内各个子模块的注册。最后可以写一个统一运行子模块的功能。
- login：该文件夹内为示例子模块。可以后期当作登陆鉴权模块的基础。目前其添加了MySQL的依赖，可以后期根据技术选型修改。

## 技术选型

- JAVA 11
- Spring Boot 3.0.3
- Spring Cloud微服务架构
- MySQL

以上均可以随意改动，只作参考

## Tips

1. 为了注册子模块到eureka，请完成以下事项：
    - 在`pom.xml`内添加依赖：Spring Discovery Client与Spring Boot Starter Actuator
    - 在启动类上添加注解`@EnableDiscoveryClient`
2. 以`master`分支为主分支。如果要进行开发等改动，请创建新分支进行修改，完成后提交pr。
3. 本文件只作为整个后端的文档，各个模块的细致说明（如接口等）等文档放在各个子模块的目录下即可。

## 需求

1. 鉴权模块
    - 用户类型：实习生、老师、管理员
    - 登录、注册
    - 权限请求
2. 数据处理模块
    - 存储、上传、下载图片
    - 支持分块上传技术
3. 导览模块
    - 需要每个科室与角色相关的权限信息
4. 职能学习模块
    - 三类角色（兽医师、前台、医助）只限定在模块内部，不参与鉴权

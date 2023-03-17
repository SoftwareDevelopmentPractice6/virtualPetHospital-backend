<!--
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-10 09:00:09
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-16 18:27:47
 * @FilePath: /virtualPetHospital-backend/system/README.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# 系统管理模块 & 导览模块

本模块作为系统管理模块（除鉴权部分）、导览模块与职能学习等部分的功能设计。

## 需求

- 药品和疫苗在一个表中，需要标注区别
- 科室、人员管理不做
- 其他与3d导览的科室一致
- 导览模块需要每个科室与角色相关的权限信息

## 系统管理 & 导览对应

- 药品：药房
- 档案：档案室
- 收费：前台
- 化验项目：化验室
- 住院：住院部

## ER图

``` mermaid
erDiagram
    ROOM ||--|{ FUNCTION : includes
    ROOM ||--|{ MEDICINE : includes
    ROOM ||--|{ ARCHIVE : includes
    ROOM ||--|{ CHARGE : includes
    ROOM ||--|{ CHEMICAL_EXAMINE : includes
    ROOM ||--|{ HOSPITAL_ADMISSION : includes
    ROOM {
        string r_name PK
        string role
    }
    FUNCTION {
        int f_id PK
        string f_name
        string f_description
        string f_flow
        string f_video
        string r_name FK
        string role
    }
    MEDICINE {
        int m_id PK
        string m_name
        string m_kind "for vaccinum distinguish"
        string store_requirement
        string instruction
        string check_flow
        string provide_flow
    }
    ARCHIVE {
        int archive_id PK
        date store_time
        string disease_type
        string pet_type
        string pet_name
        char pet_sex
        string owner_tel
    }
    CHARGE {
        int charge_id PK
        string item_name
        float charge_price
    }
    CHEMICAL_EXAMINE {
        int examine_id PK
        string examine_name
        float examine_price
    }
    HOSPITAL_ADMISSION {
        int admission_id PK
        string room_standard
        string care_level
        string remark
        float care_price
    }
```

- ROOM: 对应科室的表
- FUNCTION: 每个科室对应的功能流程
- MEDICINE: 只在药房使用
- ARCHIVE: 只在档案室使用
- CHARGE: 前台收费用
- CHEMICAL_EXAMINE: 化验室使用
- HOSPITAL_ADMISSION: 入院部使用

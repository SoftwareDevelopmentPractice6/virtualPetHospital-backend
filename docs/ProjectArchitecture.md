# 虚拟宠物医院后端项目设计文档

## 目录

- [虚拟宠物医院后端项目设计文档](#虚拟宠物医院后端项目设计文档)
  - [目录](#目录)
  - [架构设计](#架构设计)
    - [系统架构图](#系统架构图)
    - [系统调用顺序图](#系统调用顺序图)
  - [数据库设计](#数据库设计)

## 架构设计

### 系统架构图

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

### 系统调用顺序图

```mermaid
sequenceDiagram
    Frontend->>+Intermediator: Request
    Intermediator->>+Module: Processed Request
    Module-->>-Intermediator: Response
    Intermediator-->>-Frontend: Processed Response
```

```mermaid
sequenceDiagram
    Intermediator->>+Controller: Request
    Controller->>+Service: Processed Request
    Service->>+Dao: Call with SQL Operations
    Dao->>+Db: Data Request
    Db-->>-Dao: Data Response
    Dao-->>-Service: Data Response
    Service-->>-Controller: Processed Data Response
    Controller-->>-Intermediator: Response
```

## 数据库设计

- [病例管理与测试模块数据库设计](../medicalRecordManagement/README.md#数据库设计)
- [导览与系统管理、职能学习部分数据库设计](../system/README.md#er图)
- [鉴权模块数据库设计](../login/README.md#数据库设计er图)

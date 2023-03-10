# 系统管理模块

## 数据库设计ER图
```mermaid
erDiagram
    USER
    USER {
        int user_id PK
        string user_name
        string password
        int authority
    }
```
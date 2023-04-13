# Medical Record Management

## 数据库设计

``` mermaid
erDiagram

    Case {
        int CaseID PK
        int DiseaseNameID FK
        int DiagnosticResultID FK
        int AdmissionID FK
        int CasecheckID FK
        int TreatmentProgramID FK
    }
    DiseaseName ||--|{ Case : contains
    Case ||--|{ Admission : contains
    Case ||--|{ Casecheck : contains
    Case ||--|{ DiagnosticResult : contains
    Case ||--|{ TreatmentProgram : contains
    DiseaseName {
        int DiseaseNameID PK
        string content
        string photo
        string video
        string category
    }
    DiagnosticResult {
        int DiagnosticResultID PK
        string content
        string photo
        string video
    }
    Admission {
        int AdmissionID PK
        string content
        string photo
        string video
    }
    Casecheck {
        int CasecheckID PK
        string content
        string photo
        string video
    }
    TreatmentProgram {
        int TreatmentProgramID PK
        string content
        string photo
        string video
    }
```

``` mermaid
erDiagram
Exam {
int exam_id PK
string exam_name
}

Paper {
int paper_id PK
string paper_name
int exam_id FK
string duration
string total_score
}

Question {
int question_id PK
string question_content
string question_type
int category_id FK
}

Category {
int category_id PK
string category_name
}

ExamSession {
int session_id PK
int paper_id FK
time start_time
time end_time
}

StudentResult {
int result_id PK
int session_id FK
int student_id
int score
}
Exam ||--|| Paper : relate
Paper ||--|| ExamSession : relate
Question }o--|| Category : contains
ExamSession ||--o{ StudentResult : relate
```

解释：

Exam 表存储考试信息，包括考试 ID 和考试名称等。
Paper 表存储试卷信息，包括试卷 ID、试卷名称、所属考试 ID、考试时间、每题分数、总分等。
Question 表存储考题信息，包括考题 ID、考题内容、考题类型、所属类别 ID 等。
Category 表存储考题类别信息，包括类别 ID 和类别名称等。
ExamSession 表存储每次考试信息，包括考试 ID、试卷 ID、开始时间、结束时间等。
StudentResult 表存储学生考试成绩信息，包括成绩 ID、考试 ID、学生 ID、考试得分等。
在这个设计中，考试信息、试卷信息、考题信息、考题类别信息、每次考试信息和学生考试成绩信息都被存储在不同的表中，各自独立。这样做的好处是可以方便地进行增删改查操作，同时也可以方便地进行数据分析和统计。

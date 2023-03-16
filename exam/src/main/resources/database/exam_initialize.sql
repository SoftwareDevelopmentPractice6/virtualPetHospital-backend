CREATE TABLE IF NOT EXISTS Exam (
exam_id VARCHAR(255) PRIMARY KEY,
exam_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Paper (
paper_id VARCHAR(255) PRIMARY KEY,
paper_name VARCHAR(255),
exam_id VARCHAR(255),
duration VARCHAR(255),
total_score VARCHAR(255),
FOREIGN KEY (exam_id) REFERENCES Exam(exam_id)
);

CREATE TABLE IF NOT EXISTS Category (
category_id VARCHAR(255) PRIMARY KEY,
category_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Question (
question_id VARCHAR(255) PRIMARY KEY,
question_content VARCHAR(255),
question_type VARCHAR(255),
category_id VARCHAR(255),
FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE IF NOT EXISTS ExamSession (
session_id VARCHAR(255) PRIMARY KEY,
paper_id VARCHAR(255),
start_time VARCHAR(255),
end_time VARCHAR(255),
FOREIGN KEY (paper_id) REFERENCES Paper(paper_id)
);

CREATE TABLE IF NOT EXISTS StudentResult (
result_id VARCHAR(255) PRIMARY KEY,
session_id VARCHAR(255),
student_id VARCHAR(255),
score INT,
FOREIGN KEY (session_id) REFERENCES ExamSession(session_id)
);
CREATE
    TABLE
        IF NOT EXISTS EXAM(
            exam_id INT PRIMARY KEY AUTO_INCREMENT,
            exam_name VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS PAPER(
            paper_id INT PRIMARY KEY AUTO_INCREMENT,
            paper_name VARCHAR(255),
            exam_id INT,
            duration VARCHAR(255),
            total_score VARCHAR(255),
            FOREIGN KEY(exam_id) REFERENCES EXAM(exam_id) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS CATEGORY(
            category_id INT PRIMARY KEY AUTO_INCREMENT,
            category_name VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS QUESTION(
            question_id INT PRIMARY KEY AUTO_INCREMENT,
            question_content TEXT,
            question_answer TEXT,
            question_type VARCHAR(255),
            category_id INT,
            FOREIGN KEY(category_id) REFERENCES CATEGORY(category_id) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS EXAMSESSION(
            session_id INT PRIMARY KEY AUTO_INCREMENT,
            paper_id INT,
            start_time DATETIME,
            end_time DATETIME,
            FOREIGN KEY(paper_id) REFERENCES PAPER(paper_id) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS STUDENTRESULT(
            result_id INT PRIMARY KEY AUTO_INCREMENT,
            session_id INT,
            student_id INT,
            score INT,
            FOREIGN KEY(session_id) REFERENCES EXAMSESSION(session_id) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS QUESTIONSINPAPER(
            question_in_paper_id INT PRIMARY KEY AUTO_INCREMENT,
            points INT,
            paper_id INT,
            question_id INT,
            FOREIGN KEY(paper_id) REFERENCES PAPER(paper_id) ON
            DELETE
                CASCADE,
                FOREIGN KEY(question_id) REFERENCES QUESTION(question_id) ON
                DELETE
                    CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS STUDENTANSWER(
            student_answer_id INT PRIMARY KEY AUTO_INCREMENT,
            student_answer_content VARCHAR(255),
            student_answer_point INT,
            question_in_paper_id INT,
            result_id INT,
            FOREIGN KEY(question_in_paper_id) REFERENCES QUESTIONSINPAPER(question_in_paper_id) ON
            DELETE
                CASCADE,
                FOREIGN KEY(result_id) REFERENCES STUDENTRESULT(result_id) ON
                DELETE
                    CASCADE
        );

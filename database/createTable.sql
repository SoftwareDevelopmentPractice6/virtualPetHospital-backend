CREATE
    DATABASE IF NOT EXISTS login DEFAULT CHARACTER
SET
    utf8mb4;

CREATE
    DATABASE IF NOT EXISTS setup DEFAULT CHARACTER
SET
    utf8mb4;

CREATE
    DATABASE IF NOT EXISTS disease DEFAULT CHARACTER
SET
    utf8mb4;

CREATE
    DATABASE IF NOT EXISTS exam DEFAULT CHARACTER
SET
    utf8mb4;

USE login;

DROP
    TABLE
        IF EXISTS USER;

CREATE
    TABLE
        IF NOT EXISTS USER(
            user_id INT PRIMARY KEY AUTO_INCREMENT,
            user_name VARCHAR(255),
            password VARCHAR(255),
            authority INT
        );

USE setup;

DROP
    TABLE
        IF EXISTS FEATURE;

DROP
    TABLE
        IF EXISTS MEDICINE;

DROP
    TABLE
        IF EXISTS ARCHIVE;

DROP
    TABLE
        IF EXISTS CHARGE;

DROP
    TABLE
        IF EXISTS EXAMINE;

DROP
    TABLE
        IF EXISTS ADMISSION;

DROP
    TABLE
        IF EXISTS ROOM;

CREATE
    TABLE
        IF NOT EXISTS ROOM(
            room_name VARCHAR(255) PRIMARY KEY,
            room_role TEXT
        );

CREATE
    TABLE
        IF NOT EXISTS FEATURE(
            func_id INT PRIMARY KEY AUTO_INCREMENT,
            func_name VARCHAR(255),
            func_description VARCHAR(255),
            func_flow VARCHAR(255),
            func_video VARCHAR(255),
            room_name VARCHAR(255),
            func_role VARCHAR(255),
            func_tool VARCHAR(255),
            FOREIGN KEY(room_name) REFERENCES ROOM(room_name) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS MEDICINE(
            medicine_id INT PRIMARY KEY AUTO_INCREMENT,
            medicine_name VARCHAR(255),
            medicine_price FLOAT,
            manufacturer VARCHAR(255),
            class VARCHAR(255),
            specification VARCHAR(255),
            is_vaccine INT
        );

CREATE
    TABLE
        IF NOT EXISTS ARCHIVE(
            archive_id INT PRIMARY KEY AUTO_INCREMENT,
            store_time DATETIME,
            disease_type VARCHAR(255),
            pet_type VARCHAR(255),
            pet_name VARCHAR(255),
            pet_sex CHAR(1),
            owner_tel VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS CHARGE(
            charge_id INT PRIMARY KEY AUTO_INCREMENT,
            item_name VARCHAR(255),
            charge_price FLOAT
        );

CREATE
    TABLE
        IF NOT EXISTS EXAMINE(
            examine_id INT PRIMARY KEY AUTO_INCREMENT,
            examine_name VARCHAR(255),
            examine_price FLOAT,
            room_name VARCHAR(255),
            FOREIGN KEY(room_name) REFERENCES ROOM(room_name) ON
            DELETE
                CASCADE
        );

CREATE
    TABLE
        IF NOT EXISTS ADMISSION(
            admission_id INT PRIMARY KEY AUTO_INCREMENT,
            room_standard VARCHAR(255),
            care_level VARCHAR(255),
            remark TEXT,
            care_price FLOAT,
            room_name VARCHAR(255),
            FOREIGN KEY(room_name) REFERENCES ROOM(room_name) ON
            DELETE
                CASCADE
        );

USE disease;

DROP
    TABLE
        IF EXISTS MEDICALCASE;

DROP
    TABLE
        IF EXISTS DISEASENAME;

DROP
    TABLE
        IF EXISTS DIAGNOSTICRESULT;

DROP
    TABLE
        IF EXISTS ADMISSION;

DROP
    TABLE
        IF EXISTS CASECHECK;

DROP
    TABLE
        IF EXISTS TREATMENTPROGRAM;

CREATE
    TABLE
        IF NOT EXISTS DISEASENAME(
            disease_name_id INT PRIMARY KEY AUTO_INCREMENT,
            content TEXT,
            photo VARCHAR(255),
            video VARCHAR(255),
            category VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS DIAGNOSTICRESULT(
            diagnostic_result_id INT PRIMARY KEY AUTO_INCREMENT,
            content TEXT,
            photo VARCHAR(255),
            video VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS ADMISSION(
            admission_id INT PRIMARY KEY AUTO_INCREMENT,
            content TEXT,
            photo VARCHAR(255),
            video VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS CASECHECK(
            casecheck_id INT PRIMARY KEY AUTO_INCREMENT,
            content TEXT,
            photo VARCHAR(255),
            video VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS TREATMENTPROGRAM(
            treatment_program_id INT PRIMARY KEY AUTO_INCREMENT,
            content TEXT,
            photo VARCHAR(255),
            video VARCHAR(255)
        );

CREATE
    TABLE
        IF NOT EXISTS MEDICALCASE(
            case_id INT PRIMARY KEY AUTO_INCREMENT,
            disease_name_id INT,
            diagnostic_result_id INT,
            admission_id INT,
            casecheck_id INT,
            treatment_program_id INT,
            FOREIGN KEY(disease_name_id) REFERENCES DISEASENAME(disease_name_id) ON
            DELETE
                CASCADE,
                FOREIGN KEY(diagnostic_result_id) REFERENCES DIAGNOSTICRESULT(diagnostic_result_id) ON
                DELETE
                    CASCADE,
                    FOREIGN KEY(admission_id) REFERENCES ADMISSION(admission_id) ON
                    DELETE
                        CASCADE,
                        FOREIGN KEY(casecheck_id) REFERENCES CASECHECK(casecheck_id) ON
                        DELETE
                            CASCADE,
                            FOREIGN KEY(treatment_program_id) REFERENCES TREATMENTPROGRAM(treatment_program_id) ON
                            DELETE
                                CASCADE
        );

USE exam;

DROP
    TABLE
        IF EXISTS STUDENTANSWER;

DROP
    TABLE
        IF EXISTS QUESTIONSINPAPER;

DROP
    TABLE
        IF EXISTS STUDENTRESULT;

DROP
    TABLE
        IF EXISTS EXAMSESSION;

DROP
    TABLE
        IF EXISTS PAPER;

DROP
    TABLE
        IF EXISTS EXAM;

DROP
    TABLE
        IF EXISTS QUESTION;

DROP
    TABLE
        IF EXISTS CATEGORY;

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
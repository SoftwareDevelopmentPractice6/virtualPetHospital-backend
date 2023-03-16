DELETE FROM STUDENTRESULT WHERE result_id = 'RESULT001';
DELETE FROM EXAMSESSION WHERE session_id = 'SESSION001';
DELETE FROM QUESTION WHERE question_id = 'Q001';
DELETE FROM CATEGORY WHERE category_id = 'CAT001';
DELETE FROM PAPER WHERE paper_id = 'PAPER001';
DELETE FROM EXAM WHERE exam_id = 'EXAM001';

INSERT INTO EXAM (exam_id, exam_name) VALUES ('EXAM001', 'Math Exam');
INSERT INTO PAPER (paper_id, paper_name, exam_id, duration, total_score) VALUES ('PAPER001', 'Math Paper', 'EXAM001', '2 hours', '100');
INSERT INTO CATEGORY (category_id, category_name) VALUES ('CAT001', 'Algebra');
INSERT INTO QUESTION (question_id, question_content, question_type, category_id) VALUES ('Q001', 'What is the value of x in the equation x + 5 = 10?', 'Multiple Choice', 'CAT001');
INSERT INTO EXAMSESSION (session_id, paper_id, start_time, end_time) VALUES ('SESSION001', 'PAPER001', '2023-03-16 10:00:00', '2023-03-16 12:00:00');
INSERT INTO STUDENTRESULT (result_id, session_id, student_id, score) VALUES ('RESULT001', 'SESSION001', 'STUDENT001', '90');
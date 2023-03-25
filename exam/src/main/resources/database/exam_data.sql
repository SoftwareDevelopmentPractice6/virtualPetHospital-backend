DELETE FROM STUDENTRESULT WHERE result_id = 1;
DELETE FROM EXAMSESSION WHERE session_id = 1;
DELETE FROM QUESTION WHERE question_id = 1;
DELETE FROM CATEGORY WHERE category_id = 1;
DELETE FROM PAPER WHERE paper_id = 1;
DELETE FROM EXAM WHERE exam_id = 1;
DELETE FROM QUESTIONSINPAPER WHERE question_in_paper_id = 1;

INSERT INTO EXAM (exam_id, exam_name) VALUES (1, 'Math Exam');
INSERT INTO PAPER (paper_id, paper_name, exam_id, duration, total_score) VALUES (1, 'Math Paper', 1, '2 hours', '100');
INSERT INTO CATEGORY (category_id, category_name) VALUES (1, 'Algebra');
INSERT INTO QUESTION (question_id, question_content, question_type, category_id) VALUES (1, 'What is the value of x in the equation x + 5 = 10?', 'Multiple Choice', 1);
INSERT INTO EXAMSESSION (session_id, paper_id, start_time, end_time) VALUES (1, 1, '2023-03-16 10:00:00', '2023-03-16 12:00:00');
INSERT INTO STUDENTRESULT (result_id, session_id, student_id, score) VALUES (1, 1, 1, '90');
INSERT INTO QUESTIONSINPAPER (question_in_paper_id, points, paper_id, question_id) VALUES (1, 2, 1, 1);

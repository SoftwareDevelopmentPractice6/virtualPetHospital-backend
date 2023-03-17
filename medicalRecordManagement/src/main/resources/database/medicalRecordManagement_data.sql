DELETE FROM CASE WHERE case_id = 1;
INSERT INTO CASE (case_id, disease_name_id, diagnostic_result_id, admission_id, casecheck_id, treatment_program_id)
VALUES (1, 1, 1, 1, 1, 1);

DELETE FROM DISEASENAME WHERE disease_name_id = 1;
INSERT INTO DISEASENAME (disease_name_id, content, photo, video, category)
VALUES (1, '高血压', 'https://example.com/hypertension.jpg', 'https://example.com/hypertension.mp4','内科');

DELETE FROM DIAGNOSTICRESULT WHERE diagnostic_result_id = 1;
INSERT INTO DIAGNOSTICRESULT (diagnostic_result_id, content, photo, video)
VALUES (1, '检测结果1', 'https://example.com/result1.jpg', 'https://example.com/result1.mp4');

DELETE FROM ADMISSION WHERE admission_id = 1;
INSERT INTO ADMISSION (admission_id, content, photo, video)
VALUES (1, '入院记录1', 'https://example.com/admission1.jpg', 'https://example.com/admission1.mp4');

DELETE FROM CASECHECK WHERE casecheck_id = 1;
INSERT INTO CASECHECK (casecheck_id, content, photo, video)
VALUES (1, '病例检查1', 'https://example.com/casecheck1.jpg', 'https://example.com/casecheck1.mp4');

DELETE FROM TREATMENTPROGRAM WHERE treatment_program_id = 1;
INSERT INTO TREATMENTPROGRAM (treatment_program_id, content, photo, video)
VALUES (1, '治疗方案1', 'https://example.com/treatment1.jpg', 'https://example.com/treatment1.mp4');

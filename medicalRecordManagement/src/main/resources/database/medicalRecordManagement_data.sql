DELETE FROM CASE WHERE case_id = 'C001';
INSERT INTO CASE (case_id, disease_name_id, diagnostic_result_id, admission_id, casecheck_id, treatment_program_id)
VALUES ('C001', 'DN001', 'DR001', 'A001', 'CC001', 'TP001');

DELETE FROM DISEASENAME WHERE disease_name_id = 'DN001';
INSERT INTO DISEASENAME (disease_name_id, content, photo, video, category)
VALUES ('DN001', '高血压', 'https://example.com/hypertension.jpg', 'https://example.com/hypertension.mp4','内科');

DELETE FROM DIAGNOSTICRESULT WHERE diagnostic_result_id = 'DR001';
INSERT INTO DIAGNOSTICRESULT (diagnostic_result_id, content, photo, video)
VALUES ('DR001', '检测结果1', 'https://example.com/result1.jpg', 'https://example.com/result1.mp4');

DELETE FROM ADMISSION WHERE admission_id = 'A001';
INSERT INTO ADMISSION (admission_id, content, photo, video)
VALUES ('A001', '入院记录1', 'https://example.com/admission1.jpg', 'https://example.com/admission1.mp4');

DELETE FROM CASECHECK WHERE casecheck_id = 'CC001';
INSERT INTO CASECHECK (casecheck_id, content, photo, video)
VALUES ('CC001', '病例检查1', 'https://example.com/casecheck1.jpg', 'https://example.com/casecheck1.mp4');

DELETE FROM TREATMENTPROGRAM WHERE treatment_program_id = 'TP001';
INSERT INTO TREATMENTPROGRAM (treatment_program_id, content, photo, video)
VALUES ('TP001', '治疗方案1', 'https://example.com/treatment1.jpg', 'https://example.com/treatment1.mp4');


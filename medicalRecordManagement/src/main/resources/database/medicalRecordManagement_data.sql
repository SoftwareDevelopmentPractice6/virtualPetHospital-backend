DELETE FROM Case WHERE CaseID = 'C001';
INSERT INTO Case (CaseID, DiseaseNameID, DiagnosticResultID, AdmissionID, CasecheckID, TreatmentProgramID)
VALUES ('C001', 'DN001', 'DR001', 'A001', 'CC001', 'TP001');

DELETE FROM DiseaseName WHERE DiseaseNameID = 'DN001';
INSERT INTO DiseaseName (DiseaseNameID, content, photo, video)
VALUES ('DN001', '高血压', 'https://example.com/hypertension.jpg', 'https://example.com/hypertension.mp4');

DELETE FROM DiagnosticResult WHERE DiagnosticResultID = 'DR001';
INSERT INTO DiagnosticResult (DiagnosticResultID, content, photo, video)
VALUES ('DR001', '检测结果1', 'https://example.com/result1.jpg', 'https://example.com/result1.mp4');

DELETE FROM Admission WHERE AdmissionID = 'A001';
INSERT INTO Admission (AdmissionID, content, photo, video)
VALUES ('A001', '入院记录1', 'https://example.com/admission1.jpg', 'https://example.com/admission1.mp4');

DELETE FROM Casecheck WHERE CasecheckID = 'CC001';
INSERT INTO Casecheck (CasecheckID, content, photo, video)
VALUES ('CC001', '病例检查1', 'https://example.com/casecheck1.jpg', 'https://example.com/casecheck1.mp4');

DELETE FROM TreatmentProgram WHERE TreatmentProgramID = 'TP001';
INSERT INTO TreatmentProgram (TreatmentProgramID, content, photo, video)
VALUES ('TP001', '治疗方案1', 'https://example.com/treatment1.jpg', 'https://example.com/treatment1.mp4');


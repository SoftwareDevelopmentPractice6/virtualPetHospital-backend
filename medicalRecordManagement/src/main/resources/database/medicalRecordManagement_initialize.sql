CREATE TABLE IF NOT EXISTS CASE (
    CaseID VARCHAR(255) PRIMARY KEY,
    DiseaseNameID VARCHAR(255),
    DiagnosticResultID VARCHAR(255),
    AdmissionID VARCHAR(255),
    CasecheckID VARCHAR(255),
    TreatmentProgramID VARCHAR(255),
    FOREIGN KEY (DiseaseNameID) REFERENCES DISEASENAME(DiseaseNameID),
    FOREIGN KEY (DiagnosticResultID) REFERENCES DIAGNOSTICRESULT(DiagnosticResultID),
    FOREIGN KEY (AdmissionID) REFERENCES ADMISSION(AdmissionID),
    FOREIGN KEY (CasecheckID) REFERENCES CASECHECK(CasecheckID),
    FOREIGN KEY (TreatmentProgramID) REFERENCES TREATMENTPROGRAM(TreatmentProgramID)
    );

CREATE TABLE IF NOT EXISTS DISEASENAME (
    DiseaseNameID VARCHAR(255) PRIMARY KEY,
    content TEXT,
    photo VARCHAR(255),
    video VARCHAR(255),
    category VARCHAR (255)
    );

CREATE TABLE IF NOT EXISTS DIAGNOSTICRESULT (
    DiagnosticResultID VARCHAR(255) PRIMARY KEY,
    content TEXT,
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS ADMISSION (
    AdmissionID VARCHAR(255) PRIMARY KEY,
    content TEXT,
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS CASECHECK (
    CasecheckID VARCHAR(255) PRIMARY KEY,
    content TEXT,
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS TREATMENTPROGRAM (
    TreatmentProgramID VARCHAR(255) PRIMARY KEY,
    content TEXT,
    photo VARCHAR(255),
    video VARCHAR(255)
    );

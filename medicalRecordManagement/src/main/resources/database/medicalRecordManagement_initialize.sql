CREATE TABLE IF NOT EXISTS Case (
    CaseID VARCHAR(255) PRIMARY KEY,
    DiseaseNameID VARCHAR(255),
    DiagnosticResultID VARCHAR(255),
    AdmissionID VARCHAR(255),
    CasecheckID VARCHAR(255),
    TreatmentProgramID VARCHAR(255),
    FOREIGN KEY (DiseaseNameID) REFERENCES DiseaseName(DiseaseNameID),
    FOREIGN KEY (DiagnosticResultID) REFERENCES DiagnosticResult(DiagnosticResultID),
    FOREIGN KEY (AdmissionID) REFERENCES Admission(AdmissionID),
    FOREIGN KEY (CasecheckID) REFERENCES Casecheck(CasecheckID),
    FOREIGN KEY (TreatmentProgramID) REFERENCES TreatmentProgram(TreatmentProgramID)
    );

CREATE TABLE IF NOT EXISTS DiseaseName (
    DiseaseNameID VARCHAR(255) PRIMARY KEY,
    content VARCHAR(255),
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS DiagnosticResult (
    DiagnosticResultID VARCHAR(255) PRIMARY KEY,
    content VARCHAR(255),
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS Admission (
    AdmissionID VARCHAR(255) PRIMARY KEY,
    content VARCHAR(255),
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS Casecheck (
    CasecheckID VARCHAR(255) PRIMARY KEY,
    content VARCHAR(255),
    photo VARCHAR(255),
    video VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS TreatmentProgram (
    TreatmentProgramID VARCHAR(255) PRIMARY KEY,
    content VARCHAR(255),
    photo VARCHAR(255),
    video VARCHAR(255)
    );

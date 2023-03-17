
CREATE TABLE IF NOT EXISTS DISEASENAME (
	disease_name_id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	photo VARCHAR(255),
	video VARCHAR(255),
	category VARCHAR (255)
	);

CREATE TABLE IF NOT EXISTS DIAGNOSTICRESULT (
	diagnostic_result_id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	photo VARCHAR(255),
	video VARCHAR(255)
	);

CREATE TABLE IF NOT EXISTS ADMISSION (
	admission_id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	photo VARCHAR(255),
	video VARCHAR(255)
	);

CREATE TABLE IF NOT EXISTS CASECHECK (
	casecheck_id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	photo VARCHAR(255),
	video VARCHAR(255)
	);

CREATE TABLE IF NOT EXISTS TREATMENTPROGRAM (
	treatment_program_id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	photo VARCHAR(255),
	video VARCHAR(255)
	);

CREATE TABLE IF NOT EXISTS MEDICALCASE (
    case_id INT PRIMARY KEY AUTO_INCREMENT ,
    disease_name_id INT,
    diagnostic_result_id INT,
    admission_id INT,
    casecheck_id INT,
    treatment_program_id INT,
    FOREIGN KEY (disease_name_id) REFERENCES DISEASENAME(disease_name_id),
    FOREIGN KEY (diagnostic_result_id) REFERENCES DIAGNOSTICRESULT(diagnostic_result_id),
    FOREIGN KEY (admission_id) REFERENCES ADMISSION(admission_id),
    FOREIGN KEY (casecheck_id) REFERENCES CASECHECK(casecheck_id),
    FOREIGN KEY (treatment_program_id) REFERENCES TREATMENTPROGRAM(treatment_program_id)
    );
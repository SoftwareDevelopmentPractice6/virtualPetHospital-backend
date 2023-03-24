CREATE TABLE IF NOT EXISTS ROOM(
	room_name VARCHAR(255) PRIMARY KEY,
	room_role TEXT
);

CREATE TABLE IF NOT EXISTS FEATURE(
	func_id INT PRIMARY KEY AUTO_INCREMENT,
	func_name VARCHAR(255),
	func_description VARCHAR(255),
	func_flow VARCHAR(255),
	func_video VARCHAR(255),
	room_name VARCHAR(255),
	func_role VARCHAR(255),
	func_tool VARCHAR(255),
	FOREIGN KEY (room_name) REFERENCES ROOM(room_name) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS MEDICINE(
	medicine_id INT PRIMARY KEY AUTO_INCREMENT,
	medicine_name VARCHAR(255),
	medicine_price FLOAT,
	manufacturer VARCHAR(255),
	class VARCHAR(255),
	specification VARCHAR(255),
	is_vaccine INT
);

CREATE TABLE IF NOT EXISTS ARCHIVE(
	archive_id INT PRIMARY KEY AUTO_INCREMENT,
	store_time DATE,
	disease_type VARCHAR(255),
	pet_type VARCHAR(255),
	pet_name VARCHAR(255),
	pet_sex CHAR(1),
	owner_tel VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS CHARGE(
	charge_id INT PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(255),
	charge_price FLOAT
);

CREATE TABLE IF NOT EXISTS EXAMINE(
	examine_id INT PRIMARY KEY AUTO_INCREMENT,
	examine_name VARCHAR(255),
	examine_price FLOAT
);

CREATE TABLE IF NOT EXISTS ADMISSION(
	admission_id INT PRIMARY KEY AUTO_INCREMENT,
	room_standard VARCHAR(255),
	care_level VARCHAR(255),
	remark TEXT,
	care_price FLOAT
);

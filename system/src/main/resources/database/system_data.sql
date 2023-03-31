DELETE FROM `ROOM` WHERE room_name = 'testroom';

INSERT INTO `ROOM` VALUES ('testroom', 'this is a test');

DELETE FROM `FEATURE` WHERE func_id = 1;

INSERT INTO `FEATURE`
VALUES (
		1,
		'a',
		'b',
		'z',
		'a',
		'testroom',
		'w',
		'uuu'
	);

DELETE FROM `MEDICINE` WHERE medicine_id = 1;

INSERT INTO `MEDICINE`
VALUES (
		1,
		'testmed',
		3.1,
		'aa',
		'wdff',
		'fhiqhi',
		0
	);

DELETE FROM `ARCHIVE` WHERE archive_id = 1;

INSERT INTO `ARCHIVE`
VALUES (
		1,
		'9999-12-31 12:12:12',
		'aa',
		'sws',
		'q',
		'm',
		'1234'
	);

DELETE FROM `CHARGE` WHERE charge_id = 1;

INSERT INTO `CHARGE` VALUES (1,'testroom', 7.3);

DELETE FROM `EXAMINE` WHERE examine_id = 2;

INSERT INTO `EXAMINE` VALUES (2,'testroom', 1.2, 'testroom');

DELETE FROM `ADMISSION` WHERE admission_id = 1;

INSERT INTO `ADMISSION`
VALUES (
		1,
		'testroom',
		'this is a test',
		'oxjoq',
		1,
		'testroom'
	);

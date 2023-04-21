USE login;

DELETE FROM USER;

INSERT INTO USER
VALUES
(1, 'admin', '123', 2);

INSERT INTO USER
VALUES
(2, 'student', '123', 1);

INSERT INTO USER
VALUES
(3, 'teacher', '123', 3);

USE setup;

DELETE FROM ROOM;

DELETE FROM ADMISSION;

DELETE FROM FEATURE;

DELETE FROM MEDICINE;

DELETE FROM ARCHIVE;

DELETE FROM CHARGE;

DELETE FROM EXAMINE;

INSERT INTO ROOM
VALUES('诊疗室', '医师，医助');

INSERT INTO ROOM
VALUES('处置室', '医师，医助');

INSERT INTO ROOM
VALUES('手术室', '医师，医助');

INSERT INTO ROOM
VALUES('护理室', '医助');

INSERT INTO ROOM
VALUES('1号病房', '医助');

INSERT INTO ROOM
VALUES('2号病房', '医助');

INSERT INTO ROOM
VALUES('3号病房', '医助');

INSERT INTO ROOM
VALUES('4号病房', '医助');

INSERT INTO ROOM
VALUES('5号病房', '医助');

INSERT INTO ROOM
VALUES('6号病房', '医助');

INSERT INTO ROOM
VALUES('7号病房', '医助');

INSERT INTO ROOM
VALUES('化验室', '医师，医助');

INSERT INTO ROOM
VALUES('X光室', '医师，医助');

INSERT INTO ROOM
VALUES('口腔护理室', '医师，医助');

INSERT INTO ROOM
VALUES('耳科', '医师，医助');

INSERT INTO ROOM
VALUES('内科', '医师，医助');

INSERT INTO ROOM
VALUES('皮肤科', '医师，医助');

INSERT INTO ROOM
VALUES('麻醉科', '医师，医助');

INSERT INTO ROOM
VALUES('疫苗接种室', '医师，医助');

INSERT INTO ROOM
VALUES('采血室', '医师，医助');

INSERT INTO ROOM
VALUES('B超室', '医师，医助');

INSERT INTO ROOM
VALUES('针灸室', '医师，医助');

INSERT INTO ROOM
VALUES('洗澡间', '医助');

INSERT INTO ROOM
VALUES('消毒供应室', '医师，医助');

INSERT INTO ROOM
VALUES('前台', '前台');

INSERT INTO ROOM
VALUES('诊疗室1', '医助');

INSERT INTO ROOM
VALUES('诊疗室2', '医助');

INSERT INTO ADMISSION
VALUES
(
        2,
        '普通病房',
        '一级护理',
        '评价1',
        100.0,
        '1号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        3,
        '普通病房',
        '二级护理',
        '评价2',
        200.0,
        '1号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        4,
        '普通病房',
        '三级护理',
        '评价3',
        300.0,
        '1号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        5,
        '贵宾病房',
        '一级护理',
        '评价4',
        150.0,
        '2号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        6,
        '贵宾病房',
        '二级护理',
        '评价5',
        300.0,
        '2号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        7,
        '贵宾病房',
        '三级护理',
        '评价6',
        450.0,
        '2号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        8,
        '普通病房',
        '一级护理',
        '评价8',
        100.0,
        '3号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        9,
        '普通病房',
        '二级护理',
        '评价7',
        200.0,
        '3号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        10,
        '普通病房',
        '三级护理',
        '评价9',
        300.0,
        '3号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        11,
        '贵宾病房',
        '一级护理',
        '评价10',
        150.0,
        '4号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        12,
        '贵宾病房',
        '二级护理',
        '评价12',
        300.0,
        '4号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        13,
        '贵宾病房',
        '三级护理',
        '评价13',
        450.0,
        '4号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        14,
        '普通病房',
        '一级护理',
        '评价14',
        100.0,
        '5号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        15,
        '普通病房',
        '二级护理',
        '评价15',
        200.0,
        '5号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        16,
        '普通病房',
        '三级护理',
        '评价16',
        300.0,
        '5号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        17,
        '贵宾病房',
        '一级护理',
        '评价17',
        150.0,
        '6号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        18,
        '贵宾病房',
        '二级护理',
        '评价18',
        300.0,
        '6号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        19,
        '紧急病房',
        '三级护理',
        '评价19',
        400.0,
        '7号病房'
    );

INSERT INTO ADMISSION
VALUES
(
        20,
        '紧急病房',
        '三级护理',
        '评价20',
        400.0,
        '7号病房'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '打针',
        '对宠物进行注射药物',
        '1.取药 2.准备注射器 3.选择注射部位 4.注射',
        'system/feature/395d899b-9336-425e-9487-fa7f4eb2f8a8/video',
        '诊疗室1',
        '医师',
        '注射器、药物'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '给药',
        '将药物给予宠物',
        '1.准备药品 2.选择给药途径 3.给药',
        'system/feature/2cb8ff27-3890-3ce3-68da-2fdab2fa4b0e/video',
        '诊疗室2',
        '医师',
        '药品、给药器'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '洗澡',
        '为宠物清洁毛发',
        '1.准备洗浴用具 2.将宠物放入浴盆中 3.用水淋湿毛发 4.涂抹洗发水 5.冲洗干净 6.吹干毛发',
        'system/feature/28db1d5b-0050-bc20-8d56-2eea7ef5b1a9/video',
        '洗澡间',
        '医助',
        '洗发水、毛巾、吹风机'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '手术',
        '为宠物进行外科手术',
        '1.准备手术器械 2.对宠物进行全身麻醉 3.进行手术 4.对伤口进行缝合 5.观察恢复情况',
        'system/feature/3177a9d0-1272-cdcb-7061-05ba17eb28ed/video',
        '手术室',
        '医师',
        '手术器械、麻醉药品'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '牙齿护理',
        '为宠物进行口腔清洁和护理',
        '1.准备口腔清洁用具 2.清洁宠物口腔 3.给予口腔护理药物',
        'system/feature/d778ec6b-2e51-6fd3-ae58-55f24fbcb09b/video',
        '口腔护理室',
        '医助',
        '口腔清洁用具、口腔护理药物'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '驱虫',
        '为宠物进行驱除寄生虫的治疗',
        '1.准备驱虫药品 2.给予宠物驱虫药物',
        'system/feature/16278748-8d11-8645-dca5-74a38a64d322/video',
        '诊疗室1',
        '医师',
        '驱虫药品'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '护理',
        '为宠物提供生活护理服务，如喂食、喂水等',
        '1.准备喂食用具和食物 2.为宠物喂食和喂水',
        'system/feature/b910097e-51b8-50e1-7eaf-d750f4a80429/video',
        '护理室',
        '医助',
        '喂食器具、食物、水'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '拍片',
        '对宠物进行X光或CT检查',
        '1.准备拍片器械 2.给予宠物全身麻醉 3.拍摄X光或CT照片 4.观察结果',
        'system/feature/2f9f1d0a-11d2-47bf-0cf2-d87cb1aae441/video',
        'B超室',
        '医师',
        '拍片器械、麻醉药品'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '针灸',
        '对宠物进行针灸治疗',
        '1.准备针灸器械和药品 2.选择合适的针灸穴位 3.进行针灸治疗',
        'system/feature/a43e8be1-96fb-9116-c84f-5f6e676489ab/video',
        '针灸室',
        '医师',
        '针灸器械、药品'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '抽血',
        '对宠物进行血液检查',
        '1.准备采血器械和药品 2.选择采血部位 3.采血',
        'system/feature/d0727ac3-87cb-e85f-3153-1171c3454dbd/video',
        '采血室',
        '医师',
        '采血器械、药品'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '疫苗接种',
        '为宠物接种疫苗以预防疾病',
        '1.选择疫苗种类 2.将疫苗接种给宠物 3.记录接种时间和疫苗类型',
        'system/feature/006d6164-b002-50b7-8240-12e7b9972c77/video',
        '疫苗接种室',
        '医师',
        '疫苗、注射器、消毒剂'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '牙齿洗刷',
        '为宠物清洁牙齿以预防口腔疾病',
        '1.准备牙刷和牙膏 2.将宠物放置在牙齿清洁台上 3.进行牙齿清洁 4.记录牙齿清洁情况',
        'system/feature/35fbb061-b543-c12e-9a93-5e8dfb03b33c/video',
        '口腔护理室',
        '医师',
        '牙刷、牙膏、口腔消毒剂'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '伤口清洁',
        '为宠物清洁伤口以预防感染',
        '1.准备清洁工具和药品 2.清洁伤口并消毒 3.进行敷料和包扎 4.记录伤口清洁情况',
        'system/feature/71543ef2-7ec7-4caa-383d-d35cb4ad77c1/video',
        '处置室',
        '医师',
        '清洁剂、消毒剂、敷料、包扎器具'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '耳道清理',
        '为宠物清理耳道以预防耳部感染',
        '1.准备清洁工具和药品 2.检查耳道情况 3.清理耳道和外耳 4.记录耳道清理情况',
        'system/feature/c5d333e1-3b14-9aa0-8a72-e2cbd530d998/video',
        '耳科',
        '医师',
        '耳道清洁器具、清洁液、棉签'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '皮肤护理',
        '为宠物清洁皮肤以预防皮肤疾病',
        '1.准备清洁工具和药品 2.检查皮肤情况 3.清洁皮肤并涂抹药品 4.记录皮肤护理情况',
        'system/feature/07ef3a82-d2bf-1085-87c7-b78d9aeed2c1/video',
        '皮肤科',
        '医师',
        '清洁剂、药膏、护理液'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '输液',
        '为宠物进行输液以滋养身体和治疗疾病',
        '1.准备输液设备和药品 2.检查宠物情况 3.选择适当的输液方式和剂量 4.进行输液并监测宠物情况 5.记录输液情况',
        'system/feature/d5d69505-1254-27df-37bd-7dda716ca439/video',
        '内科',
        '医师',
        '输液器具、输液液体、输液针头、止痛药等'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '使用镇静剂',
        '为宠物在手术前进行镇静以减少手术压力和危险',
        '1.准备镇静剂和注射器具 2.计算剂量并注射 3.观察宠物反应并进行必要的调整 4.记录使用情况',
        'system/feature/af64c47f-761f-b017-e324-93f256fccc26/video',
        '麻醉科',
        '医师',
        '镇静剂、注射器、针头等'
    );

INSERT INTO
    FEATURE(
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES
(
        '测量血压',
        '为宠物测量血压以了解其健康状况和监测病情',
        '1.准备血压计和袖带 2.选择合适的袖带大小和位置 3.进行血压测量 4.记录血压值和宠物情况',
        'system/feature/9349f945-c37c-6010-b9b0-b2ba049132f2/video',
        '内科',
        '医师',
        '血压计、袖带等'
    );

INSERT INTO
    MEDICINE(
        medicine_name,
        medicine_price,
        manufacturer,
        class,
        specification,
        is_vaccine
    )
VALUES
(
        '阿莫西林',
        12.5,
        '上海默沙东制药有限公司',
        '抗生素',
        '250mg*24片/盒',
        0
    ), (
        '头孢克洛',
        15.2,
        '江苏欧意药业有限公司',
        '抗生素',
        '0.5g*24片/盒',
        0
    ), (
        '复方甘草口腔溶液',
        28.5,
        '太极集团医药有限公司',
        '口腔用药',
        '10ml*6支/盒',
        0
    ), (
        '吲达帕胺肠溶片',
        108.0,
        '上海安徽制药有限公司',
        '抗菌药物',
        '0.1g*28片/盒',
        0
    ), (
        '乳酸菌素片',
        25.0,
        '山东三九医药股份有限公司',
        '益生菌制剂',
        '0.1g*48片/盒',
        0
    ), (
        '万通筋骨贴',
        2.5,
        '河南豫东医药有限公司',
        '跌打损伤',
        '10cm*14cm/贴',
        0
    ), (
        '益母草颗粒',
        42.5,
        '云南白药集团股份有限公司',
        '妇科用药',
        '5g*15袋/盒',
        0
    ), (
        '人免疫球蛋白注射液',
        1280.0,
        '北京市协和制药有限责任公司',
        '免疫调节剂',
        '5g*1支/盒',
        1
    ), (
        '甲钴胺片',
        32.8,
        '华润三九药业有限公司',
        '维生素类',
        '1mg*30片/盒',
        0
    ), (
        '氧氟沙星胶囊',
        35.0,
        '广东倍特生物制药股份有限公司',
        '抗生素',
        '0.1g*10粒/盒',
        0
    ), (
        '硫酸氢氯吡格雷片',
        320.0,
        '拜耳医药保健有限公司',
        '心血管系统药物',
        '75mg*7片/盒',
        0
    ), (
        '甘草酸二铵缓释片',
        58.6,
        '山西金叶集团药业股份有限公司',
        '解热镇痛',
        '0.15g*12片/盒',
        0
    ), (
        '尿素软膏',
        28.9,
        '北京和利时有限公司',
        '皮肤科用药',
        '30g/支',
        0
    ), (
        '头孢克肟片',
        28.5,
        '云南白药集团股份有限公司',
        '抗菌药物',
        '0.25g×20片/盒',
        0
    ), (
        '多潘立酮片',
        23.8,
        '上海市第一制药有限公司',
        '消化系统药物',
        '10mg×14片/盒',
        0
    ), (
        '青霉素钠',
        8.9,
        '南京金陵药业股份有限公司',
        '抗生素',
        '0.5g×10支/盒',
        0
    ), (
        '布洛芬缓释胶囊',
        18.0,
        '哈药集团有限公司',
        '解热镇痛药',
        '0.2g×24粒/盒',
        0
    ), (
        '氢氧化铝',
        6.8,
        '北京同仁堂科技发展股份有限公司',
        '消化系统药物',
        '10g×60袋/盒',
        0
    ), (
        '丙戊酸钠注射液',
        16.8,
        '江苏恒瑞医药股份有限公司',
        '神经系统药物',
        '1g×20支/盒',
        0
    ), (
        '氯化钠注射液',
        3.5,
        '山西太原制药厂',
        '生理盐水',
        '250ml/瓶',
        0
    );

INSERT INTO
    ARCHIVE(
        store_time,
        disease_type,
        pet_type,
        pet_name,
        pet_sex,
        owner_tel
    )
VALUES
(
        '2022-01-01 08:30:00',
        '感冒',
        '猫',
        '小黑',
        'M',
        '13512345678'
    ), (
        '2022-02-02 14:00:00',
        '拉肚子',
        '狗',
        '大黄',
        'F',
        '13987654321'
    ), (
        '2022-02-15 10:20:00',
        '结膜炎',
        '猫',
        '小白',
        'M',
        '13666666666'
    ), (
        '2022-03-03 16:50:00',
        '发烧',
        '狗',
        '旺财',
        'F',
        '13811112222'
    ), (
        '2022-04-10 11:30:00',
        '打虫',
        '猫',
        '小花',
        'M',
        '13900001111'
    ), (
        '2022-05-01 09:00:00',
        '感冒',
        '狗',
        '咖啡',
        'M',
        '13543215678'
    ), (
        '2022-05-12 15:20:00',
        '瘤子',
        '狗',
        '豆豆',
        'F',
        '13876543210'
    ), (
        '2022-06-05 10:10:00',
        '驱蚤',
        '猫',
        '芝士',
        'M',
        '13998765432'
    ), (
        '2022-07-01 13:30:00',
        '抽血',
        '狗',
        '美美',
        'M',
        '13654327890'
    ), (
        '2022-07-15 16:00:00',
        '发烧',
        '狗',
        '小蓝',
        'F',
        '13501234567'
    ), (
        '2022-08-02 09:40:00',
        '结石',
        '猫',
        '小兔',
        'F',
        '13887654321'
    ), (
        '2022-08-22 11:50:00',
        '疫苗',
        '狗',
        '小莉',
        'M',
        '13944445555'
    ), (
        '2022-09-03 14:30:00',
        '感冒',
        '猫',
        '小妞',
        'M',
        '13666668888'
    ), (
        '2022-10-05 10:10:00',
        '驱虫',
        '狗',
        '旺旺',
        'F',
        '13999990000'
    ), (
        '2022-11-11 08:20:00',
        '瘤子',
        '狗',
        '小可',
        'M',
        '13599998888'
    ), (
        '2022-11-22 15:30:00',
        '抽血',
        '猫',
        '小丸子',
        'F',
        '13876543211'
    ), (
        '2022-12-12 16:00:00',
        '感冒',
        '狗',
        '小小',
        'M',
        '13612345678'
    ), (
        '2023-01-01 14:40:00',
        '疫苗',
        '猫',
        '小王',
        'F',
        '13543219876'
    ), (
        '2022-03-14 09:22:00',
        '感冒',
        '狗',
        '旺财',
        'M',
        '13888888888'
    ), (
        '2022-06-28 15:10:00',
        '牙痛',
        '猫',
        '小花',
        'F',
        '13999999999'
    );

INSERT INTO
    CHARGE(item_name, charge_price)
VALUES
('挂号费', 10.0), ('输液费', 50.0), ('手术费', 500.0), ('体检费', 30.0), ('治疗费', 100.0), ('手术用材料费', 200.0), ('护理费', 80.0), ('诊断费', 50.0), ('药品费', 80.0), ('镇痛费', 30.0), ('检查费', 80.0), ('补液费', 50.0), ('床位费', 100.0), ('止血费', 50.0), ('抢救费', 1000.0), ('疫苗接种费', 200.0), ('驱虫费', 50.0), ('手术器械消毒费', 50.0), ('止痛费', 30.0), ('处置费', 20.0);

INSERT INTO
    EXAMINE(
        examine_name,
        examine_price,
        room_name
    )
VALUES
('疫苗注射', 100.00, '疫苗接种室'), ('驱虫药物', 50.00, '诊疗室'), ('皮肤病检查', 200.00, '皮肤科'), ('内科检查', 250.00, '内科'), ('血液检查', 300.00, '化验室'), ('X光检查', 400.00, 'X光室'), ('细菌培养', 150.00, '化验室'), ('牙齿洁治', 180.00, '诊疗室'), ('肠胃病检查', 280.00, '内科'), ('外伤检查', 200.00, '诊疗室'), ('狗瘟热检查', 150.00, '诊疗室'), ('猫瘟热检查', 150.00, '诊疗室'), ('猫鼻炎检查', 200.00, '诊疗室'), ('兔子传染性腹泻检查', 250.00, '诊疗室'), ('宠物绝育手术', 500.00, '手术室'), ('宠物抽血', 150.00, '化验室'), ('宠物输液', 180.00, '诊疗室'), ('宠物手术缝合', 300.00, '手术室'), ('宠物拆线', 150.00, '手术室'), ('宠物换药', 100.00, '诊疗室'), ('宠物身体理疗', 200.00, '诊疗室');

USE disease;

DELETE FROM DISEASENAME;

DELETE FROM DIAGNOSTICRESULT;

DELETE FROM ADMISSION;

DELETE FROM CASECHECK;

DELETE FROM TREATMENTPROGRAM;

DELETE FROM MEDICALCASE;

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        2,
        '冠心病',
        'disease/diseaseName/5491c078-b9fa-1f47-f7f2-1d5ebf29bf26/photo',
        'disease/diseaseName/5491c078-b9fa-1f47-f7f2-1d5ebf29bf26/video',
        '心血管病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        2,
        '心电图显示冠心病病变',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        2,
        '患者自述胸痛持续数天',
        'disease/admission/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/admission/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        2,
        '体格检查发现心率不齐',
        'disease/caseCheck/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/caseCheck/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        2,
        '药物治疗和改变生活方式，建议行冠状动脉造影',
        'disease/treatmentProgram/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/treatmentProgram/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(2, 2, 2, 2, 2, 2);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        3,
        '糖尿病',
        'disease/diseaseName/7f3685f8-4130-2cb0-bc8c-04f82028f276/photo',
        'disease/diseaseName/7f3685f8-4130-2cb0-bc8c-04f82028f276/video',
        '内分泌疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        3,
        '血糖检测结果过高',
        'disease/diagnosticResult/2f20ae97-1ef6-b66b-e041-774bb9b185ca/photo',
        'disease/diagnosticResult/2f20ae97-1ef6-b66b-e041-774bb9b185ca/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        3,
        '患者自述口渴、多尿等症状',
        'disease/admission/2f20ae97-1ef6-b66b-e041-774bb9b185ca/photo',
        'disease/admission/2f20ae97-1ef6-b66b-e041-774bb9b185ca/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        3,
        '体格检查发现病人双腿轻微麻木',
        'disease/caseCheck/2f20ae97-1ef6-b66b-e041-774bb9b185ca/photo',
        'disease/caseCheck/2f20ae97-1ef6-b66b-e041-774bb9b185ca/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        3,
        '药物治疗，建议改变饮食和生活方式',
        'disease/treatmentProgram/2f20ae97-1ef6-b66b-e041-774bb9b185ca/photo',
        'disease/treatmentProgram/2f20ae97-1ef6-b66b-e041-774bb9b185ca/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(3, 3, 3, 3, 3, 3);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        4,
        '双腿骨折',
        'disease/diseaseName/4f73c0c9-513f-89bd-1c3f-21f539341b74/photo',
        'disease/diseaseName/4f73c0c9-513f-89bd-1c3f-21f539341b74/video',
        '骨科疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        4,
        'X光检查显示双腿骨折',
        'disease/diagnosticResult/feddd676-dd52-03ce-01c1-4a860bc79134/photo',
        'disease/diagnosticResult/feddd676-dd52-03ce-01c1-4a860bc79134/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        4,
        '患者因意外事故导致双腿骨折，需要进行手术治疗',
        'disease/admission/feddd676-dd52-03ce-01c1-4a860bc79134/photo',
        'disease/admission/feddd676-dd52-03ce-01c1-4a860bc79134/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        4,
        '体格检查发现病人双腿无法正常活动',
        'disease/caseCheck/feddd676-dd52-03ce-01c1-4a860bc79134/photo',
        'disease/caseCheck/feddd676-dd52-03ce-01c1-4a860bc79134/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        4,
        '手术治疗，术后进行康复治疗',
        'disease/treatmentProgram/feddd676-dd52-03ce-01c1-4a860bc79134/photo',
        'disease/treatmentProgram/feddd676-dd52-03ce-01c1-4a860bc79134/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(4, 4, 4, 4, 4, 4);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        5,
        '哮喘',
        'disease/diseaseName/f072f77f-7c2a-af31-de22-87fa88caa296/photo',
        'disease/diseaseName/f072f77f-7c2a-af31-de22-87fa88caa296/video',
        '呼吸道疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        5,
        '肺功能检查显示患者呼气流速降低',
        'disease/diagnosticResult/32cd1102-3670-8405-17ad-b4171acb2b09/photo',
        'disease/diagnosticResult/32cd1102-3670-8405-17ad-b4171acb2b09/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        5,
        '患者感到胸闷、呼吸困难等症状',
        'disease/admission/32cd1102-3670-8405-17ad-b4171acb2b09/photo',
        'disease/admission/32cd1102-3670-8405-17ad-b4171acb2b09/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        5,
        '体格检查发现病人胸部呼吸音减弱',
        'disease/caseCheck/32cd1102-3670-8405-17ad-b4171acb2b09/photo',
        'disease/caseCheck/32cd1102-3670-8405-17ad-b4171acb2b09/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        5,
        '药物治疗和呼吸训练',
        'disease/treatmentProgram/32cd1102-3670-8405-17ad-b4171acb2b09/photo',
        'disease/treatmentProgram/32cd1102-3670-8405-17ad-b4171acb2b09/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(5, 5, 5, 5, 5, 5);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        6,
        '胃癌',
        'disease/diseaseName/1464d8a1-13c8-8b2a-faea-aa6be19ea369/photo',
        'disease/diseaseName/1464d8a1-13c8-8b2a-faea-aa6be19ea369/video',
        '肿瘤疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        6,
        '胃镜检查显示患者胃部出现病变',
        'disease/diagnosticResult/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/photo',
        'disease/diagnosticResult/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        6,
        '患者因食欲下降、体重下降等症状前往医院就诊',
        'disease/admission/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/photo',
        'disease/admission/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        6,
        '体格检查发现病人腹部明显肿块',
        'disease/caseCheck/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/photo',
        'disease/caseCheck/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        6,
        '手术切除肿瘤和辅助化疗',
        'disease/treatmentProgram/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/photo',
        'disease/treatmentProgram/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(6, 6, 6, 6, 6, 6);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        7,
        '抑郁症',
        'disease/diseaseName/776e4a59-3c67-1b6a-87ed-ac794f6fa2c3/photo',
        'disease/diseaseName/776e4a59-3c67-1b6a-87ed-ac794f6fa2c3/video',
        '心理疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        7,
        '患者自述情绪低落、失眠等症状，符合抑郁症诊断标准',
        'disease/diagnosticResult/6b896d58-0280-af57-73d2-07d15a8d1224/photo',
        'disease/diagnosticResult/6b896d58-0280-af57-73d2-07d15a8d1224/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        7,
        '患者因情绪低落、社交回避等症状寻求心理咨询',
        'disease/admission/6b896d58-0280-af57-73d2-07d15a8d1224/photo',
        'disease/admission/6b896d58-0280-af57-73d2-07d15a8d1224/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        7,
        '临床心理评估发现患者存在明显的抑郁情绪和焦虑症状',
        'disease/caseCheck/6b896d58-0280-af57-73d2-07d15a8d1224/photo',
        'disease/caseCheck/6b896d58-0280-af57-73d2-07d15a8d1224/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        7,
        '药物治疗和心理治疗',
        'disease/treatmentProgram/6b896d58-0280-af57-73d2-07d15a8d1224/photo',
        'disease/treatmentProgram/6b896d58-0280-af57-73d2-07d15a8d1224/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(7, 7, 7, 7, 7, 7);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        8,
        '肺功能测试显示患者呼吸功能明显受损，支气管收缩试验阳性，符合哮喘诊断标准',
        'disease/diagnosticResult/00f1d104-f23b-542d-13c4-01d7662450d8/photo',
        'disease/diagnosticResult/00f1d104-f23b-542d-13c4-01d7662450d8/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        8,
        '患者因反复咳嗽、气急、胸闷等症状就诊',
        'disease/admission/00f1d104-f23b-542d-13c4-01d7662450d8/photo',
        'disease/admission/00f1d104-f23b-542d-13c4-01d7662450d8/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        8,
        '临床检查发现患者存在喘息、呼吸困难等症状，听诊肺部呼吸音减弱，提示肺功能受损',
        'disease/caseCheck/00f1d104-f23b-542d-13c4-01d7662450d8/photo',
        'disease/caseCheck/00f1d104-f23b-542d-13c4-01d7662450d8/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        8,
        '吸入性类固醇和β2受体激动剂的联合治疗',
        'disease/treatmentProgram/00f1d104-f23b-542d-13c4-01d7662450d8/photo',
        'disease/treatmentProgram/00f1d104-f23b-542d-13c4-01d7662450d8/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(8, 5, 8, 8, 8, 8);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        9,
        '重症糖尿病',
        'disease/diseaseName/bcacf9f8-aefb-ca21-e561-ecbe7670cfe5/photo',
        'disease/diseaseName/bcacf9f8-aefb-ca21-e561-ecbe7670cfe5/video',
        '内分泌代谢疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        9,
        '血糖测定结果超过正常范围，糖化血红蛋白浓度升高，提示糖尿病',
        'disease/diagnosticResult/aeab8123-229a-f994-5c5b-42f28c77f2c8/photo',
        'disease/diagnosticResult/aeab8123-229a-f994-5c5b-42f28c77f2c8/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        9,
        '患者因口渴、多尿、体重下降等症状就诊',
        'disease/admission/aeab8123-229a-f994-5c5b-42f28c77f2c8/photo',
        'disease/admission/aeab8123-229a-f994-5c5b-42f28c77f2c8/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        9,
        '患者体检发现身高165cm，体重52kg，BMI为19.1，血压140/90mmHg，尿常规检查：尿糖阳性，血糖测定：空腹血糖8.5mmol/L，餐后2小时血糖10.5mmol/L，提示糖尿病',
        'disease/caseCheck/aeab8123-229a-f994-5c5b-42f28c77f2c8/photo',
        'disease/caseCheck/aeab8123-229a-f994-5c5b-42f28c77f2c8/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        9,
        '控制饮食、运动和药物治疗，控制血糖水平',
        'disease/treatmentProgram/aeab8123-229a-f994-5c5b-42f28c77f2c8/photo',
        'disease/treatmentProgram/aeab8123-229a-f994-5c5b-42f28c77f2c8/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(9, 9, 9, 9, 9, 9);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        10,
        '肺功能检查显示FEV1/FVC比值减低，提示气流受限，支气管激发试验阳性，提示哮喘',
        'disease/diagnosticResult/689f8f23-9e02-4de2-6e72-467d63472c6e/photo',
        'disease/diagnosticResult/689f8f23-9e02-4de2-6e72-467d63472c6e/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        10,
        '患者因反复咳嗽、气喘、胸闷等症状就诊',
        'disease/admission/689f8f23-9e02-4de2-6e72-467d63472c6e/photo',
        'disease/admission/689f8f23-9e02-4de2-6e72-467d63472c6e/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        10,
        '患者体检发现身高168cm，体重65kg，体温37.3℃，呼吸音粗，胸廓对称，肺底闻及干湿啰音，肺功能检查显示FEV1/FVC比值减低，提示气流受限',
        'disease/caseCheck/689f8f23-9e02-4de2-6e72-467d63472c6e/photo',
        'disease/caseCheck/689f8f23-9e02-4de2-6e72-467d63472c6e/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        10,
        '根据患者哮喘的类型、程度等情况，选择合适的药物治疗，同时加强预防和控制',
        'disease/treatmentProgram/689f8f23-9e02-4de2-6e72-467d63472c6e/photo',
        'disease/treatmentProgram/689f8f23-9e02-4de2-6e72-467d63472c6e/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(10, 5, 10, 10, 10, 10);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        12,
        '胃炎',
        'disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/photo',
        'disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/video',
        '消化系统疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        12,
        '胃部压痛明显，胃镜检查显示胃体部位存在浅表性胃炎病变',
        'disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/photo',
        'disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        12,
        '患者反复出现腹痛、恶心、呕吐等症状，就诊',
        'disease/admission/1a8af183-172f-e834-94f8-6be6ab62589f/photo',
        'disease/admission/1a8af183-172f-e834-94f8-6be6ab62589f/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        12,
        '患者血常规、肝功能、肾功能、电解质等检查均正常，胃镜检查显示胃体部位存在浅表性胃炎病变',
        'disease/caseCheck/1a8af183-172f-e834-94f8-6be6ab62589f/photo',
        'disease/caseCheck/1a8af183-172f-e834-94f8-6be6ab62589f/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        12,
        '通过规律饮食、注意休息、避免吸烟饮酒等方式调理胃肠功能，同时根据病情选择口服药物或其他治疗方式',
        'disease/treatmentProgram/1a8af183-172f-e834-94f8-6be6ab62589f/photo',
        'disease/treatmentProgram/1a8af183-172f-e834-94f8-6be6ab62589f/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(12, 12, 12, 12, 12, 12);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        13,
        '糖尿病',
        'disease/diseaseName/98e2d0f6-70c7-4b1c-9a55-6783bf3e1c20/photo',
        'disease/diseaseName/98e2d0f6-70c7-4b1c-9a55-6783bf3e1c20/video',
        '内分泌疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        13,
        '血糖高于正常范围',
        'disease/diagnosticResult/118944a3-4732-4757-81a1-74c2af27f07f/photo',
        'disease/diagnosticResult/118944a3-4732-4757-81a1-74c2af27f07f/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        13,
        '患者自述口渴、尿频、乏力等症状',
        'disease/admission/118944a3-4732-4757-81a1-74c2af27f07f/photo',
        'disease/admission/118944a3-4732-4757-81a1-74c2af27f07f/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        13,
        '血糖、血压等检查',
        'disease/caseCheck/118944a3-4732-4757-81a1-74c2af27f07f/photo',
        'disease/caseCheck/118944a3-4732-4757-81a1-74c2af27f07f/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        13,
        '控制饮食、运动，药物治疗',
        'disease/treatmentProgram/118944a3-4732-4757-81a1-74c2af27f07f/photo',
        'disease/treatmentProgram/118944a3-4732-4757-81a1-74c2af27f07f/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(13, 13, 13, 13, 13, 13);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        14,
        '糖化血红蛋白(HbA1c) > 6.5%',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        14,
        '患者自述口渴、多尿',
        'disease/admission/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/admission/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        14,
        '体格检查发现足背动脉搏动减弱',
        'disease/caseCheck/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/caseCheck/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        14,
        '控制饮食、运动、口服药物治疗',
        'disease/treatmentProgram/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/treatmentProgram/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(14, 13, 14, 14, 14, 14);

INSERT INTO
    DISEASENAME(
        disease_name_id,
        content,
        photo,
        video,
        category
    )
VALUES
(
        14,
        '感冒',
        'disease/diseaseName/9ed9b55e-35aa-4f3c-b42d-c832d70c930c/photo',
        'disease/diseaseName/9ed9b55e-35aa-4f3c-b42d-c832d70c930c/video',
        '呼吸系统疾病'
    ), (
        15,
        '咳嗽',
        'disease/diseaseName/768e73b7-17d9-4859-9bde-6e8d87b40f23/photo',
        'disease/diseaseName/768e73b7-17d9-4859-9bde-6e8d87b40f23/video',
        '呼吸系统疾病'
    ), (
        16,
        '肺炎',
        'disease/diseaseName/2b3cf3e9-52f5-4b5d-9e8b-7126180b5e50/photo',
        'disease/diseaseName/2b3cf3e9-52f5-4b5d-9e8b-7126180b5e50/video',
        '呼吸系统疾病'
    ), (
        17,
        '腹泻',
        'disease/diseaseName/8b9abf28-b1d3-4cd5-816e-78914bfbbd5c/photo',
        'disease/diseaseName/8b9abf28-b1d3-4cd5-816e-78914bfbbd5c/video',
        '消化系统疾病'
    ), (
        18,
        '便秘',
        'disease/diseaseName/1b0a6b48-2d2d-40e6-aa13-18e8388f94b1/photo',
        'disease/diseaseName/1b0a6b48-2d2d-40e6-aa13-18e8388f94b1/video',
        '消化系统疾病'
    ), (
        20,
        '痔疮',
        'disease/diseaseName/165f95b6-72a6-47d9-9ea1-15a49a01286c/photo',
        'disease/diseaseName/165f95b6-72a6-47d9-9ea1-15a49a01286c/video',
        '消化系统疾病'
    ), (
        21,
        '高血压',
        'disease/diseaseName/8f62004c-bd15-4db4-a3e3-1f994ad2ee0a/photo',
        'disease/diseaseName/8f62004c-bd15-4db4-a3e3-1f994ad2ee0a/video',
        '心血管疾病'
    ), (
        22,
        '真菌感染',
        'disease/diseaseName/f2c8a15d-f7aa-47a9-ae6d-8af067f46527/photo',
        'disease/diseaseName/f2c8a15d-f7aa-47a9-ae6d-8af067f46527/video',
        '皮肤疾病'
    ), (
        23,
        '心房颤动',
        'disease/diseaseName/ba14d8f8-7a0e-4c38-9341-b65a8cc63b63/photo',
        'disease/diseaseName/ba14d8f8-7a0e-4c38-9341-b65a8cc63b63/video',
        '心血管疾病'
    ), (
        24,
        '心肌炎',
        'disease/diseaseName/890017f2-2ab9-46da-bd33-e8a93b49f3af/photo',
        'disease/diseaseName/890017f2-2ab9-46da-bd33-e8a93b49f3af/video',
        '心血管疾病'
    ), (
        25,
        '脑卒中',
        'disease/diseaseName/1e36f41b-60f7-41b8-8a0a-200f17aa6949/photo',
        'disease/diseaseName/1e36f41b-60f7-41b8-8a0a-200f17aa6949/video',
        '神经系统疾病'
    ), (
        26,
        '帕金森病',
        'disease/diseaseName/39fb3ccf-40d8-4f2f-946a-dc6b9f2974c4/photo',
        'disease/diseaseName/39fb3ccf-40d8-4f2f-946a-dc6b9f2974c4/video',
        '神经系统疾病'
    ), (
        27,
        '多发性硬化',
        'disease/diseaseName/2d1a8f53-d27c-4f98-baf9-34f4eae4db4b/photo',
        'disease/diseaseName/2d1a8f53-d27c-4f98-baf9-34f4eae4db4b/video',
        '神经系统疾病'
    ), (
        28,
        '风湿病',
        'disease/diseaseName/10be071e-ec10-4e16-bf9c-778cd99fbb2c/photo',
        'disease/diseaseName/10be071e-ec10-4e16-bf9c-778cd99fbb2c/video',
        '风湿免疫疾病'
    ), (
        29,
        '酒精中毒',
        'disease/diseaseName/10be221e-ec10-4g16-bf9c-778wq99fbb2c/photo',
        'disease/diseaseName/10be221e-ec10-4g16-bf9c-778wq99fbb2c/video',
        '神经系统疾病'
    ), (
        30,
        '慢性胃炎',
        'disease/diseaseName/10be221e-ec10-4g16-bf9c-778wq289fhe2/photo',
        'disease/diseaseName/10be221e-ec10-4g16-bf9c-778wq289fhe2/video',
        '消化系统疾病'
    );

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        15,
        '高血压，收缩压>140mmHg和/或舒张压>90mmHg',
        'disease/diagnosticResult/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/photo',
        'disease/diagnosticResult/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        15,
        '患者自述头疼、头晕、视物模糊等症状',
        'disease/admission/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/photo',
        'disease/admission/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        15,
        '心电图、血脂、肝肾功能等检查',
        'disease/caseCheck/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/photo',
        'disease/caseCheck/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        15,
        '控制饮食、适量运动、口服药物治疗、监测血压',
        'disease/treatmentProgram/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/photo',
        'disease/treatmentProgram/92b6c4f6-4fc6-4f85-9fc6-79989d37c5a2/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(15, 21, 15, 15, 15, 15);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        1,
        '冠状动脉造影显示冠心病病变',
        'disease/diagnosticResult/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/photo',
        'disease/diagnosticResult/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        1,
        '患者自述胸痛、气短、乏力等症状',
        'disease/admission/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/photo',
        'disease/admission/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        1,
        '体格检查发现心率不齐、心律失常等',
        'disease/caseCheck/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/photo',
        'disease/caseCheck/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        1,
        '药物治疗、改变生活方式、行冠状动脉搭桥手术等治疗方案',
        'disease/treatmentProgram/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/photo',
        'disease/treatmentProgram/abcdefgh-ijkl-mnop-qrst-uvwxyz123456/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES(1, 2, 1, 1, 1, 1);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        16,
        '空腹血糖≥7.0mmol/L',
        'disease/diagnosticResult/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/photo',
        'disease/diagnosticResult/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        16,
        '患者自述口渴、多尿等症状',
        'disease/admission/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/photo',
        'disease/admission/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        16,
        '血糖测定：餐后2小时血糖≥11.1mmol/L',
        'disease/caseCheck/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/photo',
        'disease/caseCheck/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        16,
        '控制饮食、运动、药物治疗，注射胰岛素',
        'disease/treatmentProgram/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/photo',
        'disease/treatmentProgram/1ddce6a3-c6ec-4e63-9f7b-9d43e5473202/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(16, 3, 16, 16, 16, 16);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        17,
        '上消化道内窥镜检查显示胃黏膜充血、水肿、糜烂等病变',
        'disease/diagnosticResult/abcd1234-5678-efgh-ijkl-9012mnopqrst/photo',
        'disease/diagnosticResult/abcd1234-5678-efgh-ijkl-9012mnopqrst/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        17,
        '患者自述胃痛、恶心、呕吐等症状',
        'disease/admission/abcd1234-5678-efgh-ijkl-9012mnopqrst/photo',
        'disease/admission/abcd1234-5678-efgh-ijkl-9012mnopqrst/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        17,
        '胃镜检查，病理组织学检查',
        'disease/caseCheck/abcd1234-5678-efgh-ijkl-9012mnopqrst/photo',
        'disease/caseCheck/abcd1234-5678-efgh-ijkl-9012mnopqrst/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        17,
        '抑制幽门螺杆菌、饮食调整、口服药物治疗、支持治疗',
        'disease/treatmentProgram/abcd1234-5678-efgh-ijkl-9012mnopqrst/photo',
        'disease/treatmentProgram/abcd1234-5678-efgh-ijkl-9012mnopqrst/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(17, 12, 17, 17, 17, 17);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        18,
        '体温38℃以上，咳嗽、流涕、喉咙疼痛等症状',
        'disease/diagnosticResult/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/diagnosticResult/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        18,
        '患者自述有发热、咳嗽、流涕等症状',
        'disease/admission/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/admission/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        18,
        '体温测定、喉咙拭子培养',
        'disease/caseCheck/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/caseCheck/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        18,
        '休息，多喝水，吃清淡易消化的食物，适当使用退热镇痛药、抗生素等',
        'disease/treatmentProgram/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/treatmentProgram/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(18, 14, 18, 18, 18, 18);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        19,
        '发热、咳嗽、流鼻涕、喉咙疼痛',
        'disease/diagnosticResult/f7de931e-54d3-4083-8561-b9195b5f1b5f/photo',
        'disease/diagnosticResult/f7de931e-54d3-4083-8561-b9195b5f1b5f/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        19,
        '患者自述发热、咳嗽、流鼻涕、喉咙疼痛等症状',
        'disease/admission/f7de931e-54d3-4083-8561-b9195b5f1b5f/photo',
        'disease/admission/f7de931e-54d3-4083-8561-b9195b5f1b5f/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        19,
        '临床症状和体征',
        'disease/caseCheck/f7de931e-54d3-4083-8561-b9195b5f1b5f/photo',
        'disease/caseCheck/f7de931e-54d3-4083-8561-b9195b5f1b5f/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        19,
        '对症治疗、休息、适当补充水分、药物缓解症状',
        'disease/treatmentProgram/f7de931e-54d3-4083-8561-b9195b5f1b5f/photo',
        'disease/treatmentProgram/f7de931e-54d3-4083-8561-b9195b5f1b5f/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(19, 14, 19, 19, 19, 19);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        20,
        '干咳、咳痰、胸闷、气促等症状',
        'disease/diagnosticResult/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/photo',
        'disease/diagnosticResult/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        20,
        '患者自述有咳嗽、咳痰、胸闷等症状',
        'disease/admission/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/photo',
        'disease/admission/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        20,
        '听诊、胸部X光检查、痰液检查等',
        'disease/caseCheck/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/photo',
        'disease/caseCheck/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        20,
        '治疗原因不同，可以选用抗生素、祛痰药、止咳药、支气管扩张剂等不同药物进行治疗',
        'disease/treatmentProgram/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/photo',
        'disease/treatmentProgram/3a320c3a-9c10-4f8f-b1a2-2b7d267f3461/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(20, 15, 20, 20, 20, 20);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        21,
        '持续性咳嗽，咳嗽时有痰',
        'disease/diagnosticResult/024b63c5-b0cc-413d-a0f5-17e00c06b381/photo',
        'disease/diagnosticResult/024b63c5-b0cc-413d-a0f5-17e00c06b381/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        21,
        '患者自述持续咳嗽不退',
        'disease/admission/024b63c5-b0cc-413d-a0f5-17e00c06b381/photo',
        'disease/admission/024b63c5-b0cc-413d-a0f5-17e00c06b381/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        21,
        '听诊、胸部X光片、喉咙拭子培养',
        'disease/caseCheck/024b63c5-b0cc-413d-a0f5-17e00c06b381/photo',
        'disease/caseCheck/024b63c5-b0cc-413d-a0f5-17e00c06b381/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        21,
        '治疗病因，使用止咳药、祛痰药、抗生素等',
        'disease/treatmentProgram/024b63c5-b0cc-413d-a0f5-17e00c06b381/photo',
        'disease/treatmentProgram/024b63c5-b0cc-413d-a0f5-17e00c06b381/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(21, 15, 21, 21, 21, 21);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        22,
        '发热、咳嗽、胸痛、呼吸急促等症状',
        'disease/diagnosticResult/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/photo',
        'disease/diagnosticResult/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        22,
        '患者自述有发热、咳嗽、胸痛、呼吸急促等症状',
        'disease/admission/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/photo',
        'disease/admission/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        22,
        '胸部X光、CT、血气分析等检查',
        'disease/caseCheck/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/photo',
        'disease/caseCheck/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        22,
        '使用抗生素、呼吸机等治疗，保持休息，维持水电解质平衡',
        'disease/treatmentProgram/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/photo',
        'disease/treatmentProgram/5b28a94b-2be2-4225-a5a5-5d9627d1c9f1/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(22, 16, 22, 22, 22, 22);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        23,
        '发热、咳嗽、胸痛、气急等症状',
        'disease/diagnosticResult/7e26b5aa-97d7-4630-a9d5-973831e21c3d/photo',
        'disease/diagnosticResult/7e26b5aa-97d7-4630-a9d5-973831e21c3d/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        23,
        '患者出现发热、咳嗽等症状，并持续加重',
        'disease/admission/7e26b5aa-97d7-4630-a9d5-973831e21c3d/photo',
        'disease/admission/7e26b5aa-97d7-4630-a9d5-973831e21c3d/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        23,
        '体温测定、血常规检查、胸部CT等',
        'disease/caseCheck/7e26b5aa-97d7-4630-a9d5-973831e21c3d/photo',
        'disease/caseCheck/7e26b5aa-97d7-4630-a9d5-973831e21c3d/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        23,
        '以病毒性肺炎为主要病原体的患者，通常采取支持性治疗，以及适当使用糖皮质激素、抗病毒药物等',
        'disease/treatmentProgram/7e26b5aa-97d7-4630-a9d5-973831e21c3d/photo',
        'disease/treatmentProgram/7e26b5aa-97d7-4630-a9d5-973831e21c3d/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(23, 16, 23, 23, 23, 23);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        24,
        '大便次数增多，排便困难，便质稀薄或呈水样，伴有腹胀、腹痛、恶心、呕吐等症状',
        'disease/diagnosticResult/0428a68e-59b2-4df2-9f4f-4a4b4a032634/photo',
        'disease/diagnosticResult/0428a68e-59b2-4df2-9f4f-4a4b4a032634/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        24,
        '患者自述腹泻已有三天，大便次数增多，排便困难，便质稀薄或呈水样，伴有腹胀、腹痛、恶心、呕吐等症状',
        'disease/admission/0428a68e-59b2-4df2-9f4f-4a4b4a032634/photo',
        'disease/admission/0428a68e-59b2-4df2-9f4f-4a4b4a032634/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        24,
        '查体，抽血、大便常规、肠道病原微生物检测等',
        'disease/caseCheck/0428a68e-59b2-4df2-9f4f-4a4b4a032634/photo',
        'disease/caseCheck/0428a68e-59b2-4df2-9f4f-4a4b4a032634/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        24,
        '休息，多喝水，忌食辛辣、油腻、刺激性食物，口服复方妇科制剂、口服肠道微生态调节剂等',
        'disease/treatmentProgram/0428a68e-59b2-4df2-9f4f-4a4b4a032634/photo',
        'disease/treatmentProgram/0428a68e-59b2-4df2-9f4f-4a4b4a032634/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(24, 17, 24, 24, 24, 24);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        25,
        '每天排便次数增多，排便量明显增加，大便量多呈水样，伴有恶心、呕吐等症状',
        'disease/diagnosticResult/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/photo',
        'disease/diagnosticResult/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        25,
        '患者自述出现腹泻、腹痛、恶心、呕吐等症状',
        'disease/admission/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/photo',
        'disease/admission/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        25,
        '粪便常规检查、病原学检查等',
        'disease/caseCheck/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/photo',
        'disease/caseCheck/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        25,
        '积极补充水分，避免进食辛辣刺激性食物，必要时使用抗生素、腹泻止泻剂等药物',
        'disease/treatmentProgram/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/photo',
        'disease/treatmentProgram/2a4c4ef4-ba08-4a94-8baf-fcdd1a5802d1/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(25, 17, 25, 25, 25, 25);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        26,
        '排便不畅，大便干燥、硬结，伴随腹胀、腹痛等症状',
        'disease/diagnosticResult/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/photo',
        'disease/diagnosticResult/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        26,
        '排便不畅、干燥、难解、大便习惯改变等症状',
        'disease/admission/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/photo',
        'disease/admission/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        26,
        '肛门指检，血常规、大便常规等检查',
        'disease/caseCheck/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/photo',
        'disease/caseCheck/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        26,
        '饮食调理，适量运动，建立良好排便习惯，口服通便药等',
        'disease/treatmentProgram/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/photo',
        'disease/treatmentProgram/80d2d7c5-1cb5-4418-a57f-b5d1f5aa4136/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(26, 18, 26, 26, 26, 26);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        27,
        '肛门周围疼痛、肛门坠胀感、便血',
        'disease/diagnosticResult/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/photo',
        'disease/diagnosticResult/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        27,
        '患者自述肛门疼痛、肛门坠胀感等症状',
        'disease/admission/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/photo',
        'disease/admission/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        27,
        '肛门检查、直肠指诊、肛门括约肌电图等',
        'disease/caseCheck/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/photo',
        'disease/caseCheck/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        27,
        '改善饮食习惯，口服药物、栓剂、外用药、手术等治疗',
        'disease/treatmentProgram/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/photo',
        'disease/treatmentProgram/c4bfe4a6-7f9b-4f3c-9e84-d1d7c6a00772/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(27, 20, 27, 27, 27, 27);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        28,
        '排便困难，排便时间间隔过长，排便次数减少',
        'disease/diagnosticResult/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/photo',
        'disease/diagnosticResult/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        28,
        '患者自述排便困难、排便次数减少等症状',
        'disease/admission/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/photo',
        'disease/admission/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        28,
        '腹部触诊、肛门指诊',
        'disease/caseCheck/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/photo',
        'disease/caseCheck/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        28,
        '改善饮食结构、增加膳食纤维摄入量、适当运动、饮水量充足、口服轻泻剂等',
        'disease/treatmentProgram/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/photo',
        'disease/treatmentProgram/4e04a4f4-9f91-48dc-9fa3-aaaf53a8c310/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(28, 18, 28, 28, 28, 28);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        29,
        '肛门周围疼痛、瘙痒、出血，肛门坠胀等症状',
        'disease/diagnosticResult/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/diagnosticResult/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        29,
        '患者自述肛门部疼痛、肛门出血等症状',
        'disease/admission/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/admission/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        29,
        '肛门检查、直肠指诊等',
        'disease/caseCheck/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/caseCheck/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        29,
        '多喝水，多吃蔬菜水果，避免久坐，外用药物或手术治疗',
        'disease/treatmentProgram/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/photo',
        'disease/treatmentProgram/8f19a90f-d95e-4dc6-b12a-54207adcc9d4/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(29, 20, 29, 29, 29, 29);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        30,
        '血压持续升高，头痛、眩晕、心悸等症状',
        'disease/diagnosticResult/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/photo',
        'disease/diagnosticResult/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        30,
        '患者自述有头痛、眩晕、心悸等症状',
        'disease/admission/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/photo',
        'disease/admission/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        30,
        '测量血压、心电图等检查',
        'disease/caseCheck/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/photo',
        'disease/caseCheck/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        30,
        '调整饮食，适量运动，控制体重，药物治疗等',
        'disease/treatmentProgram/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/photo',
        'disease/treatmentProgram/9d9c23f6-89b8-4b0e-872d-c71b2e48c8e1/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(30, 21, 30, 30, 30, 30);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        31,
        '收缩压≥140mmHg和/或舒张压≥90mmHg',
        'disease/diagnosticResult/61f2f947-5098-476d-9c5f-f3cf77c8f91b/photo',
        'disease/diagnosticResult/61f2f947-5098-476d-9c5f-f3cf77c8f91b/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        31,
        '患者自述头痛、头晕、心悸、气短等症状，或在体检中被发现血压升高',
        'disease/admission/61f2f947-5098-476d-9c5f-f3cf77c8f91b/photo',
        'disease/admission/61f2f947-5098-476d-9c5f-f3cf77c8f91b/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        31,
        '测量血压、查体、心电图、24小时动态血压监测等',
        'disease/caseCheck/61f2f947-5098-476d-9c5f-f3cf77c8f91b/photo',
        'disease/caseCheck/61f2f947-5098-476d-9c5f-f3cf77c8f91b/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        31,
        '生活方式改变，药物治疗，如利尿剂、钙通道阻滞剂、ACEI/ARB等',
        'disease/treatmentProgram/61f2f947-5098-476d-9c5f-f3cf77c8f91b/photo',
        'disease/treatmentProgram/61f2f947-5098-476d-9c5f-f3cf77c8f91b/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(31, 21, 31, 31, 31, 31);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        32,
        '心绞痛、胸闷、气短、心悸等症状',
        'disease/diagnosticResult/69544e6b-6a1e-4264-a031-14d4a94c6b45/photo',
        'disease/diagnosticResult/69544e6b-6a1e-4264-a031-14d4a94c6b45/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        32,
        '患者自述出现心绞痛、胸闷等症状',
        'disease/admission/69544e6b-6a1e-4264-a031-14d4a94c6b45/photo',
        'disease/admission/69544e6b-6a1e-4264-a031-14d4a94c6b45/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        32,
        '心电图、血脂、血压等检查',
        'disease/caseCheck/69544e6b-6a1e-4264-a031-14d4a94c6b45/photo',
        'disease/caseCheck/69544e6b-6a1e-4264-a031-14d4a94c6b45/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        32,
        '改变不良的生活方式，如戒烟、控制体重、适当运动等。药物治疗包括硝酸酯类、钙拮抗剂、β受体阻滞剂等',
        'disease/treatmentProgram/69544e6b-6a1e-4264-a031-14d4a94c6b45/photo',
        'disease/treatmentProgram/69544e6b-6a1e-4264-a031-14d4a94c6b45/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(32, 2, 32, 32, 32, 32);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        33,
        '皮肤上的紅疹、鳞屑、瘙痒等症状',
        'disease/diagnosticResult/c3ba9a3a-6f92-11ec-9621-0242ac130002/photo',
        'disease/diagnosticResult/c3ba9a3a-6f92-11ec-9621-0242ac130002/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        33,
        '患者自述出现皮肤瘙痒等症状',
        'disease/admission/c3ba9a3a-6f92-11ec-9621-0242ac130002/photo',
        'disease/admission/c3ba9a3a-6f92-11ec-9621-0242ac130002/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        33,
        '皮肤检查、血液检查',
        'disease/caseCheck/c3ba9a3a-6f92-11ec-9621-0242ac130002/photo',
        'disease/caseCheck/c3ba9a3a-6f92-11ec-9621-0242ac130002/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        33,
        '抗真菌药物、局部治疗等',
        'disease/treatmentProgram/c3ba9a3a-6f92-11ec-9621-0242ac130002/photo',
        'disease/treatmentProgram/c3ba9a3a-6f92-11ec-9621-0242ac130002/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(33, 22, 33, 33, 33, 33);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        34,
        '病灶部位红肿、疼痛，发热、畏寒、乏力等症状',
        'disease/diagnosticResult/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/photo',
        'disease/diagnosticResult/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        34,
        '患者自述有局部瘙痒、疼痛等症状',
        'disease/admission/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/photo',
        'disease/admission/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        34,
        '病灶刮片、真菌培养',
        'disease/caseCheck/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/photo',
        'disease/caseCheck/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        34,
        '口服或局部使用抗真菌药物，对症处理症状',
        'disease/treatmentProgram/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/photo',
        'disease/treatmentProgram/39711b5f-7bb7-4132-9f5c-1d2c7eae76a8/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(34, 22, 34, 34, 34, 34);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        35,
        '心电图检查、Holter 监测等',
        'disease/diagnosticResult/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/photo',
        'disease/diagnosticResult/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        35,
        '患者自述心悸、气促等症状',
        'disease/admission/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/photo',
        'disease/admission/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        35,
        '心电图检查、超声心动图、血常规等',
        'disease/caseCheck/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/photo',
        'disease/caseCheck/5e7657d1-6af3-4a75-99c5-8e0d1ee9a2d9/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        35,
        '药物治疗、电复律、心脏射频消融术等',
        'disease/treatmentProgram/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/photo',
        'disease/treatmentProgram/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(35, 23, 35, 35, 35, 35);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        36,
        '心率不规律、心悸、气短、乏力等症状',
        'disease/diagnosticResult/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/photo',
        'disease/diagnosticResult/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        36,
        '患者自述有心悸、气短等症状，有高血压、冠心病等心血管疾病病史',
        'disease/admission/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/photo',
        'disease/admission/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        36,
        '心电图、Holter 监测等',
        'disease/caseCheck/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/photo',
        'disease/caseCheck/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        36,
        '药物治疗、电复律、心脏射频消融术等',
        'disease/treatmentProgram/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/photo',
        'disease/treatmentProgram/67d97f39-0736-4f6b-af6b-4a4e4adef4d6/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(36, 23, 36, 36, 36, 36);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        37,
        '胸痛、心悸、心动过速、呼吸急促、乏力、出汗、发热等症状',
        'disease/diagnosticResult/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/photo',
        'disease/diagnosticResult/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        37,
        '患者自述有胸痛、呼吸急促、乏力等症状',
        'disease/admission/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/photo',
        'disease/admission/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        37,
        '心电图、心肌酶谱、心脏彩超',
        'disease/caseCheck/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/photo',
        'disease/caseCheck/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        37,
        '休息，控制症状，使用抗生素、免疫抑制剂等',
        'disease/treatmentProgram/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/photo',
        'disease/treatmentProgram/3ba7d8e8-9326-4f6b-b039-7c64cc88bb1d/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(37, 24, 37, 37, 37, 37);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        38,
        '症状轻重不同，轻症表现为轻微的心悸、乏力、倦怠和气促等，重症表现为胸痛、心悸、晕厥、呼吸困难和心力衰竭等',
        'disease/diagnosticResult/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/photo',
        'disease/diagnosticResult/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        38,
        '患者自述有胸痛、心悸、气促等症状，体格检查发现心脏有杂音',
        'disease/admission/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/photo',
        'disease/admission/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        38,
        '心电图、心肌酶谱、抗心肌抗体检测',
        'disease/caseCheck/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/photo',
        'disease/caseCheck/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        38,
        '静息、卧床、补液，心血管药物治疗等',
        'disease/treatmentProgram/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/photo',
        'disease/treatmentProgram/c2f2d24a-1055-4f28-b93a-9f17ebdc5a5d/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(38, 24, 38, 38, 38, 38);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        39,
        '面部、手臂或腿部一侧的无力或麻木，突然丧失视力、言语不清、严重头痛、眩晕',
        'disease/diagnosticResult/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/photo',
        'disease/diagnosticResult/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        39,
        '患者突然出现上述症状，须立即送往医院治疗',
        'disease/admission/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/photo',
        'disease/admission/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        39,
        'CT、MRI 等检查',
        'disease/caseCheck/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/photo',
        'disease/caseCheck/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        39,
        '根据具体病情采用药物治疗、手术治疗或介入治疗等方法',
        'disease/treatmentProgram/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/photo',
        'disease/treatmentProgram/25a9dfe1-dc8b-4e34-9441-7bb6c97b8f7b/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(39, 25, 39, 39, 39, 39);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        40,
        '头痛、眩晕、恶心、呕吐，失语、面部或身体一侧麻木或无力，突然失明或视力障碍等症状',
        'disease/diagnosticResult/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/photo',
        'disease/diagnosticResult/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        40,
        '患者突发头痛、眩晕，左侧面部和肢体无力',
        'disease/admission/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/photo',
        'disease/admission/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        40,
        '神经系统检查、颅内血管造影等检查',
        'disease/caseCheck/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/photo',
        'disease/caseCheck/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        40,
        '根据病情轻重采用不同的治疗方法，如溶栓治疗、手术治疗等，对卒中后的康复进行支持性治疗',
        'disease/treatmentProgram/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/photo',
        'disease/treatmentProgram/1a2b3c4d-5e6f-7g8h-9i0j-a1b2c3d4e5f6/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(40, 25, 40, 40, 40, 40);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        41,
        '肌肉僵硬、震颤、运动迟缓、姿势不稳等症状',
        'disease/diagnosticResult/129ed70e-fb2c-4b10-9a02-448f68a10c8e/photo',
        'disease/diagnosticResult/129ed70e-fb2c-4b10-9a02-448f68a10c8e/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        41,
        '患者自述肌肉僵硬、震颤、运动迟缓、姿势不稳等症状',
        'disease/admission/129ed70e-fb2c-4b10-9a02-448f68a10c8e/photo',
        'disease/admission/129ed70e-fb2c-4b10-9a02-448f68a10c8e/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        41,
        '神经学检查、脑电图、CT/MRI等',
        'disease/caseCheck/129ed70e-fb2c-4b10-9a02-448f68a10c8e/photo',
        'disease/caseCheck/129ed70e-fb2c-4b10-9a02-448f68a10c8e/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        41,
        '药物治疗、物理治疗、手术治疗等',
        'disease/treatmentProgram/129ed70e-fb2c-4b10-9a02-448f68a10c8e/photo',
        'disease/treatmentProgram/129ed70e-fb2c-4b10-9a02-448f68a10c8e/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(41, 26, 41, 41, 41, 41);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        42,
        '手脚发抖、肌肉僵硬、运动迟缓、平衡失调等症状',
        'disease/diagnosticResult/51ed7562-8473-4853-8b18-9600d0c7b1a1/photo',
        'disease/diagnosticResult/51ed7562-8473-4853-8b18-9600d0c7b1a1/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        42,
        '患者自述手脚不听使唤，身体僵硬、行动迟缓',
        'disease/admission/51ed7562-8473-4853-8b18-9600d0c7b1a1/photo',
        'disease/admission/51ed7562-8473-4853-8b18-9600d0c7b1a1/video'
    );

INSERT INTO
    CASECHECK(
        casecheck_id,
        content,
        photo,
        video
    )
VALUES
(
        42,
        '神经系统检查、头部MRI、脑波图等',
        'disease/caseCheck/51ed7562-8473-4853-8b18-9600d0c7b1a1/photo',
        'disease/caseCheck/51ed7562-8473-4853-8b18-9600d0c7b1a1/video'
    );

INSERT INTO
    TREATMENTPROGRAM(
        treatment_program_id,
        content,
        photo,
        video
    )
VALUES
(
        42,
        '药物治疗，物理治疗，手术治疗等',
        'disease/treatmentProgram/51ed7562-8473-4853-8b18-9600d0c7b1a1/photo',
        'disease/treatmentProgram/51ed7562-8473-4853-8b18-9600d0c7b1a1/video'
    );

INSERT INTO
    MEDICALCASE(
        case_id,
        disease_name_id,
        diagnostic_result_id,
        admission_id,
        casecheck_id,
        treatment_program_id
    )
VALUES
(42, 26, 42, 42, 42, 42);

INSERT INTO
    DIAGNOSTICRESULT(
        diagnostic_result_id,
        content,
        photo,
        video
    )
VALUES
(
        43,
        '神经系统检查发现多发性病灶，脑脊液检查有寡克隆带',
        'disease/diagnosticResult/ade128d7-7ea8-4388-9bdf-211a5a96a719/photo',
        'disease/diagnosticResult/ade128d7-7ea8-4388-9bdf-211a5a96a719/video'
    );

INSERT INTO
    ADMISSION(
        admission_id,
        content,
        photo,
        video
    )
VALUES
(
        43,
        '患者自述出现视力模糊、肢体乏力等症状',
        'disease/admission/ade128d7-7ea8-4388-9bdf-211a5a96a719/photo',
        'disease/admission/ade128d7-7ea8-4388-9bdf-211a5a96a719/video'
    );
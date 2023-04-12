USE login;

DELETE
FROM
    USER;

INSERT
    INTO
        USER
    VALUES(
        1,
        'admin',
        '123',
        2
    );

INSERT
    INTO
        USER
    VALUES(
        2,
        'student',
        '123',
        1
    );

INSERT
    INTO
        USER
    VALUES(
        3,
        'teacher',
        '123',
        3
    );

USE setup;

DELETE
FROM
    ROOM;

DELETE
FROM
    ADMISSION;

DELETE
FROM
    FEATURE;

DELETE
FROM
    MEDICINE;

DELETE
FROM
    ARCHIVE;

DELETE
FROM
    CHARGE;

DELETE
FROM
    EXAMINE;

INSERT
    INTO
        ROOM
    VALUES(
        '诊疗室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '处置室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '手术室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '护理室',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '1号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '2号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '3号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '4号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '5号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '6号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '7号病房',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '化验室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        'X光室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '口腔护理室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '耳科',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '内科',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '皮肤科',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '麻醉科',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '疫苗接种室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '采血室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        'B超室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '针灸室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '洗澡间',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '消毒供应室',
        '医师，医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '前台',
        '前台'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '诊疗室1',
        '医助'
    );

INSERT
    INTO
        ROOM
    VALUES(
        '诊疗室2',
        '医助'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        2,
        '普通病房',
        '一级护理',
        '评价1',
        100.0,
        '1号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        3,
        '普通病房',
        '二级护理',
        '评价2',
        200.0,
        '1号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        4,
        '普通病房',
        '三级护理',
        '评价3',
        300.0,
        '1号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        5,
        '贵宾病房',
        '一级护理',
        '评价4',
        150.0,
        '2号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        6,
        '贵宾病房',
        '二级护理',
        '评价5',
        300.0,
        '2号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        7,
        '贵宾病房',
        '三级护理',
        '评价6',
        450.0,
        '2号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        8,
        '普通病房',
        '一级护理',
        '评价8',
        100.0,
        '3号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        9,
        '普通病房',
        '二级护理',
        '评价7',
        200.0,
        '3号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        10,
        '普通病房',
        '三级护理',
        '评价9',
        300.0,
        '3号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        11,
        '贵宾病房',
        '一级护理',
        '评价10',
        150.0,
        '4号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        12,
        '贵宾病房',
        '二级护理',
        '评价12',
        300.0,
        '4号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        13,
        '贵宾病房',
        '三级护理',
        '评价13',
        450.0,
        '4号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        14,
        '普通病房',
        '一级护理',
        '评价14',
        100.0,
        '5号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        15,
        '普通病房',
        '二级护理',
        '评价15',
        200.0,
        '5号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        16,
        '普通病房',
        '三级护理',
        '评价16',
        300.0,
        '5号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        17,
        '贵宾病房',
        '一级护理',
        '评价17',
        150.0,
        '6号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        18,
        '贵宾病房',
        '二级护理',
        '评价18',
        300.0,
        '6号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        19,
        '紧急病房',
        '三级护理',
        '评价19',
        400.0,
        '7号病房'
    );

INSERT
    INTO
        ADMISSION
    VALUES(
        20,
        '紧急病房',
        '三级护理',
        '评价20',
        400.0,
        '7号病房'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '打针',
        '对宠物进行注射药物',
        '1.取药 2.准备注射器 3.选择注射部位 4.注射',
        'system/feature/395d899b-9336-425e-9487-fa7f4eb2f8a8/video',
        '诊疗室1',
        '医师',
        '注射器、药物'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '给药',
        '将药物给予宠物',
        '1.准备药品 2.选择给药途径 3.给药',
        'system/feature/2cb8ff27-3890-3ce3-68da-2fdab2fa4b0e/video',
        '诊疗室2',
        '医师',
        '药品、给药器'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '洗澡',
        '为宠物清洁毛发',
        '1.准备洗浴用具 2.将宠物放入浴盆中 3.用水淋湿毛发 4.涂抹洗发水 5.冲洗干净 6.吹干毛发',
        'system/feature/28db1d5b-0050-bc20-8d56-2eea7ef5b1a9/video',
        '洗澡间',
        '医助',
        '洗发水、毛巾、吹风机'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '手术',
        '为宠物进行外科手术',
        '1.准备手术器械 2.对宠物进行全身麻醉 3.进行手术 4.对伤口进行缝合 5.观察恢复情况',
        'system/feature/3177a9d0-1272-cdcb-7061-05ba17eb28ed/video',
        '手术室',
        '医师',
        '手术器械、麻醉药品'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '牙齿护理',
        '为宠物进行口腔清洁和护理',
        '1.准备口腔清洁用具 2.清洁宠物口腔 3.给予口腔护理药物',
        'system/feature/d778ec6b-2e51-6fd3-ae58-55f24fbcb09b/video',
        '口腔护理室',
        '医助',
        '口腔清洁用具、口腔护理药物'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '驱虫',
        '为宠物进行驱除寄生虫的治疗',
        '1.准备驱虫药品 2.给予宠物驱虫药物',
        'system/feature/16278748-8d11-8645-dca5-74a38a64d322/video',
        '诊疗室1',
        '医师',
        '驱虫药品'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '护理',
        '为宠物提供生活护理服务，如喂食、喂水等',
        '1.准备喂食用具和食物 2.为宠物喂食和喂水',
        'system/feature/b910097e-51b8-50e1-7eaf-d750f4a80429/video',
        '护理室',
        '医助',
        '喂食器具、食物、水'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '拍片',
        '对宠物进行X光或CT检查',
        '1.准备拍片器械 2.给予宠物全身麻醉 3.拍摄X光或CT照片 4.观察结果',
        'system/feature/2f9f1d0a-11d2-47bf-0cf2-d87cb1aae441/video',
        'B超室',
        '医师',
        '拍片器械、麻醉药品'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '针灸',
        '对宠物进行针灸治疗',
        '1.准备针灸器械和药品 2.选择合适的针灸穴位 3.进行针灸治疗',
        'system/feature/a43e8be1-96fb-9116-c84f-5f6e676489ab/video',
        '针灸室',
        '医师',
        '针灸器械、药品'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '抽血',
        '对宠物进行血液检查',
        '1.准备采血器械和药品 2.选择采血部位 3.采血',
        'system/feature/d0727ac3-87cb-e85f-3153-1171c3454dbd/video',
        '采血室',
        '医师',
        '采血器械、药品'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '疫苗接种',
        '为宠物接种疫苗以预防疾病',
        '1.选择疫苗种类 2.将疫苗接种给宠物 3.记录接种时间和疫苗类型',
        'system/feature/006d6164-b002-50b7-8240-12e7b9972c77/video',
        '疫苗接种室',
        '医师',
        '疫苗、注射器、消毒剂'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '牙齿洗刷',
        '为宠物清洁牙齿以预防口腔疾病',
        '1.准备牙刷和牙膏 2.将宠物放置在牙齿清洁台上 3.进行牙齿清洁 4.记录牙齿清洁情况',
        'system/feature/35fbb061-b543-c12e-9a93-5e8dfb03b33c/video',
        '口腔护理室',
        '医师',
        '牙刷、牙膏、口腔消毒剂'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '伤口清洁',
        '为宠物清洁伤口以预防感染',
        '1.准备清洁工具和药品 2.清洁伤口并消毒 3.进行敷料和包扎 4.记录伤口清洁情况',
        'system/feature/71543ef2-7ec7-4caa-383d-d35cb4ad77c1/video',
        '处置室',
        '医师',
        '清洁剂、消毒剂、敷料、包扎器具'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '耳道清理',
        '为宠物清理耳道以预防耳部感染',
        '1.准备清洁工具和药品 2.检查耳道情况 3.清理耳道和外耳 4.记录耳道清理情况',
        'system/feature/c5d333e1-3b14-9aa0-8a72-e2cbd530d998/video',
        '耳科',
        '医师',
        '耳道清洁器具、清洁液、棉签'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '皮肤护理',
        '为宠物清洁皮肤以预防皮肤疾病',
        '1.准备清洁工具和药品 2.检查皮肤情况 3.清洁皮肤并涂抹药品 4.记录皮肤护理情况',
        'system/feature/07ef3a82-d2bf-1085-87c7-b78d9aeed2c1/video',
        '皮肤科',
        '医师',
        '清洁剂、药膏、护理液'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '输液',
        '为宠物进行输液以滋养身体和治疗疾病',
        '1.准备输液设备和药品 2.检查宠物情况 3.选择适当的输液方式和剂量 4.进行输液并监测宠物情况 5.记录输液情况',
        'system/feature/d5d69505-1254-27df-37bd-7dda716ca439/video',
        '内科',
        '医师',
        '输液器具、输液液体、输液针头、止痛药等'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '使用镇静剂',
        '为宠物在手术前进行镇静以减少手术压力和危险',
        '1.准备镇静剂和注射器具 2.计算剂量并注射 3.观察宠物反应并进行必要的调整 4.记录使用情况',
        'system/feature/af64c47f-761f-b017-e324-93f256fccc26/video',
        '麻醉科',
        '医师',
        '镇静剂、注射器、针头等'
    );

INSERT
    INTO
        FEATURE(
            func_name,
            func_description,
            func_flow,
            func_video,
            room_name,
            func_role,
            func_tool
        )
    VALUES(
        '测量血压',
        '为宠物测量血压以了解其健康状况和监测病情',
        '1.准备血压计和袖带 2.选择合适的袖带大小和位置 3.进行血压测量 4.记录血压值和宠物情况',
        'system/feature/9349f945-c37c-6010-b9b0-b2ba049132f2/video',
        '内科',
        '医师',
        '血压计、袖带等'
    );

INSERT
    INTO
        MEDICINE(
            medicine_name,
            medicine_price,
            manufacturer,
            class,
            specification,
            is_vaccine
        )
    VALUES(
        '阿莫西林',
        12.5,
        '上海默沙东制药有限公司',
        '抗生素',
        '250mg*24片/盒',
        0
    ),
    (
        '头孢克洛',
        15.2,
        '江苏欧意药业有限公司',
        '抗生素',
        '0.5g*24片/盒',
        0
    ),
    (
        '复方甘草口腔溶液',
        28.5,
        '太极集团医药有限公司',
        '口腔用药',
        '10ml*6支/盒',
        0
    ),
    (
        '吲达帕胺肠溶片',
        108.0,
        '上海安徽制药有限公司',
        '抗菌药物',
        '0.1g*28片/盒',
        0
    ),
    (
        '乳酸菌素片',
        25.0,
        '山东三九医药股份有限公司',
        '益生菌制剂',
        '0.1g*48片/盒',
        0
    ),
    (
        '万通筋骨贴',
        2.5,
        '河南豫东医药有限公司',
        '跌打损伤',
        '10cm*14cm/贴',
        0
    ),
    (
        '益母草颗粒',
        42.5,
        '云南白药集团股份有限公司',
        '妇科用药',
        '5g*15袋/盒',
        0
    ),
    (
        '人免疫球蛋白注射液',
        1280.0,
        '北京市协和制药有限责任公司',
        '免疫调节剂',
        '5g*1支/盒',
        1
    ),
    (
        '甲钴胺片',
        32.8,
        '华润三九药业有限公司',
        '维生素类',
        '1mg*30片/盒',
        0
    ),
    (
        '氧氟沙星胶囊',
        35.0,
        '广东倍特生物制药股份有限公司',
        '抗生素',
        '0.1g*10粒/盒',
        0
    ),
    (
        '硫酸氢氯吡格雷片',
        320.0,
        '拜耳医药保健有限公司',
        '心血管系统药物',
        '75mg*7片/盒',
        0
    ),
    (
        '甘草酸二铵缓释片',
        58.6,
        '山西金叶集团药业股份有限公司',
        '解热镇痛',
        '0.15g*12片/盒',
        0
    ),
    (
        '尿素软膏',
        28.9,
        '北京和利时有限公司',
        '皮肤科用药',
        '30g/支',
        0
    ),
    (
        '头孢克肟片',
        28.5,
        '云南白药集团股份有限公司',
        '抗菌药物',
        '0.25g×20片/盒',
        0
    ),
    (
        '多潘立酮片',
        23.8,
        '上海市第一制药有限公司',
        '消化系统药物',
        '10mg×14片/盒',
        0
    ),
    (
        '青霉素钠',
        8.9,
        '南京金陵药业股份有限公司',
        '抗生素',
        '0.5g×10支/盒',
        0
    ),
    (
        '布洛芬缓释胶囊',
        18.0,
        '哈药集团有限公司',
        '解热镇痛药',
        '0.2g×24粒/盒',
        0
    ),
    (
        '氢氧化铝',
        6.8,
        '北京同仁堂科技发展股份有限公司',
        '消化系统药物',
        '10g×60袋/盒',
        0
    ),
    (
        '丙戊酸钠注射液',
        16.8,
        '江苏恒瑞医药股份有限公司',
        '神经系统药物',
        '1g×20支/盒',
        0
    ),
    (
        '氯化钠注射液',
        3.5,
        '山西太原制药厂',
        '生理盐水',
        '250ml/瓶',
        0
    );

INSERT
    INTO
        ARCHIVE(
            store_time,
            disease_type,
            pet_type,
            pet_name,
            pet_sex,
            owner_tel
        )
    VALUES(
        '2022-01-01 08:30:00',
        '感冒',
        '猫',
        '小黑',
        'M',
        '13512345678'
    ),
    (
        '2022-02-02 14:00:00',
        '拉肚子',
        '狗',
        '大黄',
        'F',
        '13987654321'
    ),
    (
        '2022-02-15 10:20:00',
        '结膜炎',
        '猫',
        '小白',
        'M',
        '13666666666'
    ),
    (
        '2022-03-03 16:50:00',
        '发烧',
        '狗',
        '旺财',
        'F',
        '13811112222'
    ),
    (
        '2022-04-10 11:30:00',
        '打虫',
        '猫',
        '小花',
        'M',
        '13900001111'
    ),
    (
        '2022-05-01 09:00:00',
        '感冒',
        '狗',
        '咖啡',
        'M',
        '13543215678'
    ),
    (
        '2022-05-12 15:20:00',
        '瘤子',
        '狗',
        '豆豆',
        'F',
        '13876543210'
    ),
    (
        '2022-06-05 10:10:00',
        '驱蚤',
        '猫',
        '芝士',
        'M',
        '13998765432'
    ),
    (
        '2022-07-01 13:30:00',
        '抽血',
        '狗',
        '美美',
        'M',
        '13654327890'
    ),
    (
        '2022-07-15 16:00:00',
        '发烧',
        '狗',
        '小蓝',
        'F',
        '13501234567'
    ),
    (
        '2022-08-02 09:40:00',
        '结石',
        '猫',
        '小兔',
        'F',
        '13887654321'
    ),
    (
        '2022-08-22 11:50:00',
        '疫苗',
        '狗',
        '小莉',
        'M',
        '13944445555'
    ),
    (
        '2022-09-03 14:30:00',
        '感冒',
        '猫',
        '小妞',
        'M',
        '13666668888'
    ),
    (
        '2022-10-05 10:10:00',
        '驱虫',
        '狗',
        '旺旺',
        'F',
        '13999990000'
    ),
    (
        '2022-11-11 08:20:00',
        '瘤子',
        '狗',
        '小可',
        'M',
        '13599998888'
    ),
    (
        '2022-11-22 15:30:00',
        '抽血',
        '猫',
        '小丸子',
        'F',
        '13876543211'
    ),
    (
        '2022-12-12 16:00:00',
        '感冒',
        '狗',
        '小小',
        'M',
        '13612345678'
    ),
    (
        '2023-01-01 14:40:00',
        '疫苗',
        '猫',
        '小王',
        'F',
        '13543219876'
    ),
    (
        '2022-03-14 09:22:00',
        '感冒',
        '狗',
        '旺财',
        'M',
        '13888888888'
    ),
    (
        '2022-06-28 15:10:00',
        '牙痛',
        '猫',
        '小花',
        'F',
        '13999999999'
    );

INSERT
    INTO
        CHARGE(
            item_name,
            charge_price
        )
    VALUES(
        '挂号费',
        10.0
    ),
    (
        '输液费',
        50.0
    ),
    (
        '手术费',
        500.0
    ),
    (
        '体检费',
        30.0
    ),
    (
        '治疗费',
        100.0
    ),
    (
        '手术用材料费',
        200.0
    ),
    (
        '护理费',
        80.0
    ),
    (
        '诊断费',
        50.0
    ),
    (
        '药品费',
        80.0
    ),
    (
        '镇痛费',
        30.0
    ),
    (
        '检查费',
        80.0
    ),
    (
        '补液费',
        50.0
    ),
    (
        '床位费',
        100.0
    ),
    (
        '止血费',
        50.0
    ),
    (
        '抢救费',
        1000.0
    ),
    (
        '疫苗接种费',
        200.0
    ),
    (
        '驱虫费',
        50.0
    ),
    (
        '手术器械消毒费',
        50.0
    ),
    (
        '止痛费',
        30.0
    ),
    (
        '处置费',
        20.0
    );

INSERT
    INTO
        EXAMINE(
            examine_name,
            examine_price,
            room_name
        )
    VALUES(
        '疫苗注射',
        100.00,
        '疫苗接种室'
    ),
    (
        '驱虫药物',
        50.00,
        '诊疗室'
    ),
    (
        '皮肤病检查',
        200.00,
        '皮肤科'
    ),
    (
        '内科检查',
        250.00,
        '内科'
    ),
    (
        '血液检查',
        300.00,
        '化验室'
    ),
    (
        'X光检查',
        400.00,
        'X光室'
    ),
    (
        '细菌培养',
        150.00,
        '化验室'
    ),
    (
        '牙齿洁治',
        180.00,
        '诊疗室'
    ),
    (
        '肠胃病检查',
        280.00,
        '内科'
    ),
    (
        '外伤检查',
        200.00,
        '诊疗室'
    ),
    (
        '狗瘟热检查',
        150.00,
        '诊疗室'
    ),
    (
        '猫瘟热检查',
        150.00,
        '诊疗室'
    ),
    (
        '猫鼻炎检查',
        200.00,
        '诊疗室'
    ),
    (
        '兔子传染性腹泻检查',
        250.00,
        '诊疗室'
    ),
    (
        '宠物绝育手术',
        500.00,
        '手术室'
    ),
    (
        '宠物抽血',
        150.00,
        '化验室'
    ),
    (
        '宠物输液',
        180.00,
        '诊疗室'
    ),
    (
        '宠物手术缝合',
        300.00,
        '手术室'
    ),
    (
        '宠物拆线',
        150.00,
        '手术室'
    ),
    (
        '宠物换药',
        100.00,
        '诊疗室'
    ),
    (
        '宠物身体理疗',
        200.00,
        '诊疗室'
    );

USE disease;

DELETE
FROM
    DISEASENAME;

DELETE
FROM
    DIAGNOSTICRESULT;

DELETE
FROM
    ADMISSION;

DELETE
FROM
    CASECHECK;

DELETE
FROM
    TREATMENTPROGRAM;

DELETE
FROM
    MEDICALCASE;

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        2,
        '冠心病',
        'disease/diseaseName/5491c078-b9fa-1f47-f7f2-1d5ebf29bf26/photo',
        'disease/diseaseName/5491c078-b9fa-1f47-f7f2-1d5ebf29bf26/video',
        '心血管病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        2,
        '心电图显示冠心病病变',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/photo',
        'disease/diagnosticResult/119980fc-52a3-9075-958d-bb3073be950b/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        2,
        '患者自述胸痛持续数天',
        'disease/admission/f8d426c9-670a-07db-26aa-0a1020e9fc53/photo',
        'disease/admission/f8d426c9-670a-07db-26aa-0a1020e9fc53/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        2,
        '体格检查发现心率不齐',
        'disease/caseCheck/60059edc-1976-9252-4902-c957dd413420/photo',
        'disease/caseCheck/60059edc-1976-9252-4902-c957dd413420/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        2,
        '药物治疗和改变生活方式，建议行冠状动脉造影',
        'disease/treatmentProgram/b2334a94-35c9-d20b-2778-2dee659a1f73/photo',
        'disease/treatmentProgram/b2334a94-35c9-d20b-2778-2dee659a1f73/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        2,
        2,
        2,
        2,
        2,
        2
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        3,
        '糖尿病',
        'disease/diseaseName/7f3685f8-4130-2cb0-bc8c-04f82028f276/photo',
        'disease/diseaseName/7f3685f8-4130-2cb0-bc8c-04f82028f276/video',
        '内分泌疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        3,
        '血糖检测结果过高',
        'disease/diagnosticResult/2f20ae97-1ef6-b66b-e041-774bb9b185ca/photo',
        'disease/diagnosticResult/2f20ae97-1ef6-b66b-e041-774bb9b185ca/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        3,
        '患者自述口渴、多尿等症状',
        'disease/admission/9e4d2b7b-2bca-2f2c-9d26-45e036cf6b01/photo',
        'disease/admission/9e4d2b7b-2bca-2f2c-9d26-45e036cf6b01/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        3,
        '体格检查发现病人双腿轻微麻木',
        'disease/caseCheck/567b8957-c2c3-8247-c10f-5f2e4ea72d9b/photo',
        'disease/caseCheck/567b8957-c2c3-8247-c10f-5f2e4ea72d9b/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        3,
        '药物治疗，建议改变饮食和生活方式',
        'disease/treatmentProgram/f98a3523-9c0d-79f8-732a-e789496b901e/photo',
        'disease/treatmentProgram/f98a3523-9c0d-79f8-732a-e789496b901e/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        3,
        3,
        3,
        3,
        3,
        3
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        4,
        '双腿骨折',
        'disease/diseaseName/4f73c0c9-513f-89bd-1c3f-21f539341b74/photo',
        'disease/diseaseName/4f73c0c9-513f-89bd-1c3f-21f539341b74/video',
        '骨科疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        4,
        'X光检查显示双腿骨折',
        'disease/diagnosticResult/feddd676-dd52-03ce-01c1-4a860bc79134/photo',
        'disease/diagnosticResult/feddd676-dd52-03ce-01c1-4a860bc79134/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        4,
        '患者因意外事故导致双腿骨折，需要进行手术治疗',
        'disease/admission/d2cc81ed-6e6d-60b2-a0e4-e11f97864a57/photo',
        'disease/admission/d2cc81ed-6e6d-60b2-a0e4-e11f97864a57/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        4,
        '体格检查发现病人双腿无法正常活动',
        'disease/caseCheck/722a2f02-8921-aed6-7ea2-8834e5e43cb8/photo',
        'disease/caseCheck/722a2f02-8921-aed6-7ea2-8834e5e43cb8/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        4,
        '手术治疗，术后进行康复治疗',
        'disease/treatmentProgram/fb02bfe4-0971-e514-39b9-c80c2864dc1b/photo',
        'disease/treatmentProgram/fb02bfe4-0971-e514-39b9-c80c2864dc1b/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        4,
        4,
        4,
        4,
        4,
        4
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        5,
        '哮喘',
        'disease/diseaseName/f072f77f-7c2a-af31-de22-87fa88caa296/photo',
        'disease/diseaseName/f072f77f-7c2a-af31-de22-87fa88caa296/video',
        '呼吸道疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        5,
        '肺功能检查显示患者呼气流速降低',
        'disease/diagnosticResult/32cd1102-3670-8405-17ad-b4171acb2b09/photo',
        'disease/diagnosticResult/32cd1102-3670-8405-17ad-b4171acb2b09/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        5,
        '患者感到胸闷、呼吸困难等症状',
        'disease/admission/6c393a3d-65bb-865a-5bfb-e8231a8f07ff/photo',
        'disease/admission/6c393a3d-65bb-865a-5bfb-e8231a8f07ff/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        5,
        '体格检查发现病人胸部呼吸音减弱',
        'disease/caseCheck/dea9f7c4-d5d4-0da9-edc9-bcda0d8ef75c/photo',
        'disease/caseCheck/dea9f7c4-d5d4-0da9-edc9-bcda0d8ef75c/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        5,
        '药物治疗和呼吸训练',
        'disease/treatmentProgram/76f9c082-22a1-6272-ac8b-cd46ba0f7954/photo',
        'disease/treatmentProgram/76f9c082-22a1-6272-ac8b-cd46ba0f7954/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        5,
        5,
        5,
        5,
        5,
        5
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        6,
        '胃癌',
        'disease/diseaseName/1464d8a1-13c8-8b2a-faea-aa6be19ea369/photo',
        'disease/diseaseName/1464d8a1-13c8-8b2a-faea-aa6be19ea369/video',
        '肿瘤疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        6,
        '胃镜检查显示患者胃部出现病变',
        'disease/diagnosticResult/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/photo',
        'disease/diagnosticResult/a53ae0fc-4739-2e65-bc3b-792391dfd2bb/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        6,
        '患者因食欲下降、体重下降等症状前往医院就诊',
        'disease/admission/9054e88d-77f4-4af1-e38f-eedf7b52c213/photo',
        'disease/admission/9054e88d-77f4-4af1-e38f-eedf7b52c213/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        6,
        '体格检查发现病人腹部明显肿块',
        'disease/caseCheck/ff530c08-6dd3-c0f6-194a-dcf54371a1dc/photo',
        'disease/caseCheck/ff530c08-6dd3-c0f6-194a-dcf54371a1dc/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        6,
        '手术切除肿瘤和辅助化疗',
        'disease/treatmentProgram/644d5ffc-875b-ca12-1f4e-bc9675d11e1d/photo',
        'disease/treatmentProgram/644d5ffc-875b-ca12-1f4e-bc9675d11e1d/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        6,
        6,
        6,
        6,
        6,
        6
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        7,
        '抑郁症',
        'disease/diseaseName/776e4a59-3c67-1b6a-87ed-ac794f6fa2c3/photo',
        'disease/diseaseName/776e4a59-3c67-1b6a-87ed-ac794f6fa2c3/video',
        '心理疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        7,
        '患者自述情绪低落、失眠等症状，符合抑郁症诊断标准',
        'disease/diagnosticResult/6b896d58-0280-af57-73d2-07d15a8d1224/photo',
        'disease/diagnosticResult/6b896d58-0280-af57-73d2-07d15a8d1224/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        7,
        '患者因情绪低落、社交回避等症状寻求心理咨询',
        'disease/admission/d4ab18b1-053a-ed59-5873-2b9b3d720446/photo',
        'disease/admission/d4ab18b1-053a-ed59-5873-2b9b3d720446/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        7,
        '临床心理评估发现患者存在明显的抑郁情绪和焦虑症状',
        'disease/caseCheck/d6125f15-dc3a-4bce-8632-275a0356c611/photo',
        'disease/caseCheck/d6125f15-dc3a-4bce-8632-275a0356c611/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        7,
        '药物治疗和心理治疗',
        'disease/treatmentProgram/931a18ae-c492-c36f-5653-c9c2f1b67cf5/photo',
        'disease/treatmentProgram/931a18ae-c492-c36f-5653-c9c2f1b67cf5/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        7,
        7,
        7,
        7,
        7,
        7
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        8,
        '哮喘',
        'disease/diseaseName/0cde3d1f-eb4c-9a5d-b487-0bc2b052fa14/photo',
        'disease/diseaseName/0cde3d1f-eb4c-9a5d-b487-0bc2b052fa14/video',
        '呼吸系统疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        8,
        '肺功能测试显示患者呼吸功能明显受损，支气管收缩试验阳性，符合哮喘诊断标准',
        'disease/diagnosticResult/00f1d104-f23b-542d-13c4-01d7662450d8/photo',
        'disease/diagnosticResult/00f1d104-f23b-542d-13c4-01d7662450d8/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        8,
        '患者因反复咳嗽、气急、胸闷等症状就诊',
        'disease/admission/3ad4765c-ad8b-052b-c4a8-44ff3b7b0771/photo',
        'disease/admission/3ad4765c-ad8b-052b-c4a8-44ff3b7b0771/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        8,
        '临床检查发现患者存在喘息、呼吸困难等症状，听诊肺部呼吸音减弱，提示肺功能受损',
        'disease/caseCheck/d58897a9-810b-6a80-37d7-342183324502/photo',
        'disease/caseCheck/d58897a9-810b-6a80-37d7-342183324502/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        8,
        '吸入性类固醇和β2受体激动剂的联合治疗',
        'disease/treatmentProgram/3fb4b3b9-163c-7d8a-5411-4963a34d8f27/photo',
        'disease/treatmentProgram/3fb4b3b9-163c-7d8a-5411-4963a34d8f27/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        8,
        8,
        8,
        8,
        8,
        8
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        9,
        '重症糖尿病',
        'disease/diseaseName/bcacf9f8-aefb-ca21-e561-ecbe7670cfe5/photo',
        'disease/diseaseName/bcacf9f8-aefb-ca21-e561-ecbe7670cfe5/video',
        '内分泌代谢疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        9,
        '血糖测定结果超过正常范围，糖化血红蛋白浓度升高，提示糖尿病',
        'disease/diagnosticResult/aeab8123-229a-f994-5c5b-42f28c77f2c8/photo',
        'disease/diagnosticResult/aeab8123-229a-f994-5c5b-42f28c77f2c8/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        9,
        '患者因口渴、多尿、体重下降等症状就诊',
        'disease/admission/37fa69bc-33a4-e2c3-64ad-d79ca3967492/photo',
        'disease/admission/37fa69bc-33a4-e2c3-64ad-d79ca3967492/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        9,
        '患者体检发现身高165cm，体重52kg，BMI为19.1，血压140/90mmHg，尿常规检查：尿糖阳性，血糖测定：空腹血糖8.5mmol/L，餐后2小时血糖10.5mmol/L，提示糖尿病',
        'disease/caseCheck/231ed93b-0c6b-b2c5-745e-a4076f4f0561/photo',
        'disease/caseCheck/231ed93b-0c6b-b2c5-745e-a4076f4f0561/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        9,
        '控制饮食、运动和药物治疗，控制血糖水平',
        'disease/treatmentProgram/185fbf3f-4f8d-ed31-321d-b31df768d9bd/photo',
        'disease/treatmentProgram/185fbf3f-4f8d-ed31-321d-b31df768d9bd/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        9,
        9,
        9,
        9,
        9,
        9
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        10,
        '哮喘',
        'disease/diseaseName/6c3d45b2-5077-8b7a-571d-faf60ba38623/photo',
        'disease/diseaseName/6c3d45b2-5077-8b7a-571d-faf60ba38623/video',
        '呼吸系统疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        10,
        '肺功能检查显示FEV1/FVC比值减低，提示气流受限，支气管激发试验阳性，提示哮喘',
        'disease/diagnosticResult/689f8f23-9e02-4de2-6e72-467d63472c6e/photo',
        'disease/diagnosticResult/689f8f23-9e02-4de2-6e72-467d63472c6e/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        10,
        '患者因反复咳嗽、气喘、胸闷等症状就诊',
        'disease/admission/db22e8ac-4dc1-4999-ead6-5bf872449314/photo',
        'disease/admission/db22e8ac-4dc1-4999-ead6-5bf872449314/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        10,
        '患者体检发现身高168cm，体重65kg，体温37.3℃，呼吸音粗，胸廓对称，肺底闻及干湿啰音，肺功能检查显示FEV1/FVC比值减低，提示气流受限',
        'disease/caseCheck/627bed70-10c6-a1a5-1b48-beb4476f23fd/photo',
        'disease/caseCheck/627bed70-10c6-a1a5-1b48-beb4476f23fd/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        10,
        '根据患者哮喘的类型、程度等情况，选择合适的药物治疗，同时加强预防和控制',
        'disease/treatmentProgram/d15de1b7-3a3c-5c17-a818-73a1a3c37565/photo',
        'disease/treatmentProgram/d15de1b7-3a3c-5c17-a818-73a1a3c37565/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        10,
        10,
        10,
        10,
        10,
        10
    );

INSERT
    INTO
        DISEASENAME(
            disease_name_id,
            content,
            photo,
            video,
            category
        )
    VALUES(
        12,
        '胃炎',
        'disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/photo',
        'disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/video',
        '消化系统疾病'
    );

INSERT
    INTO
        DIAGNOSTICRESULT(
            diagnostic_result_id,
            content,
            photo,
            video
        )
    VALUES(
        12,
        '胃部压痛明显，胃镜检查显示胃体部位存在浅表性胃炎病变',
        'disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/photo',
        'disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/video'
    );

INSERT
    INTO
        ADMISSION(
            admission_id,
            content,
            photo,
            video
        )
    VALUES(
        12,
        '患者反复出现腹痛、恶心、呕吐等症状，就诊',
        'disease/admission/20e2b848-1b58-7b7c-4b76-d090670fd155/photo',
        'disease/admission/20e2b848-1b58-7b7c-4b76-d090670fd155/video'
    );

INSERT
    INTO
        CASECHECK(
            casecheck_id,
            content,
            photo,
            video
        )
    VALUES(
        12,
        '患者血常规、肝功能、肾功能、电解质等检查均正常，胃镜检查显示胃体部位存在浅表性胃炎病变',
        'disease/caseCheck/075d64ff-8798-3c44-d085-420767a162df/photo',
        'disease/caseCheck/075d64ff-8798-3c44-d085-420767a162df/video'
    );

INSERT
    INTO
        TREATMENTPROGRAM(
            treatment_program_id,
            content,
            photo,
            video
        )
    VALUES(
        12,
        '通过规律饮食、注意休息、避免吸烟饮酒等方式调理胃肠功能，同时根据病情选择口服药物或其他治疗方式',
        'disease/treatmentProgram/c7fdc351-6d0b-01c5-a652-739df99106f4/photo',
        'disease/treatmentProgram/c7fdc351-6d0b-01c5-a652-739df99106f4/video'
    );

INSERT
    INTO
        MEDICALCASE(
            case_id,
            disease_name_id,
            diagnostic_result_id,
            admission_id,
            casecheck_id,
            treatment_program_id
        )
    VALUES(
        12,
        12,
        12,
        12,
        12,
        12
    );

use exam;

DELETE FROM STUDENTANSWER;
DELETE FROM QUESTIONSINPAPER;
DELETE FROM STUDENTRESULT;
DELETE FROM EXAMSESSION;
DELETE FROM QUESTION;
DELETE FROM CATEGORY;
DELETE FROM PAPER;
DELETE FROM EXAM;



INSERT INTO CATEGORY (category_id, category_name) VALUES
(1,'狗'), (2,'猫'), (3,'鸟'), (4,'其他');

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (1, '你知道什么是犬瘟热吗？ A.狗得的病 B.猫得的病', '单选', 1);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (2, '猫咪为什么会打喷嚏？ A.因为感冒 B.因为过敏 C.因为异物刺激 D.其他', '单选', 2);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (3, '什么是宠物药品的过敏反应？ A.肚子疼 B.呼吸急促 C.皮肤瘙痒 D.其他', '多选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (4, '什么情况下需要紧急送宠物去医院？ A.突然晕倒 B.呼吸急促 C.严重呕吐 D.其他', '多选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (5, '半夜突然听到宠物在呕吐声，应该怎么办？ A.立刻喂水 B.观察一段时间再决定是否送医 C.在网上找解决方案 D.带宠物到宠物医院', '多选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (6, '宠物是否需要接种疫苗？ A.是 B.不是', '单选', 1);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (7, '狗的牙齿保健有哪些方法？ A.刷牙 B.磨牙棒 C.口腔喷雾 D.生骨头', '多选', 1);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (8, '猫的牙齿保健有哪些方法？ A.刷牙 B.磨牙棒 C.口腔喷雾 D.生鱼肉', '多选', 2);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (9, '宠物发烧了应该怎么办？ A.给宠物喝药 B.让宠物多休息 C.打冰敷 D.立刻带宠物去医院', '单选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (10, '宠物是否需要剪指甲？ A.是 B.不是', '单选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (11, '宠物为什么会打呼噜？ A.因为它睡得太香了 B.因为它有呼吸道疾病 C.因为它太胖了 D.因为它心情好', '单选', 4);

INSERT INTO QUESTION (question_id, question_content, question_type, category_id)
VALUES (12, '宠物会得肥胖症吗？ A.会 B.不会', '单选', 4);

INSERT INTO EXAM (exam_id, exam_name) VALUES (1, '宠物医院实习生测试1');
INSERT INTO PAPER (paper_id, paper_name, exam_id, duration, total_score)
VALUES (1, '宠物医院实习生测试卷1', 1, '60分钟', '100分');
INSERT INTO EXAMSESSION (session_id, paper_id, start_time, end_time)
VALUES (1, 1, '2023-04-12 08:00:00', '2023-04-12 09:00:00');

INSERT INTO STUDENTRESULT (result_id, session_id, student_id, score)
VALUES (1, 1, 1, 80);

INSERT INTO QUESTIONSINPAPER (question_in_paper_id,points, paper_id, question_id) VALUES
(1, 5, 1, 1),
(1, 10, 1, 2),
(1, 15, 1, 3),
(1, 20, 1, 4);

INSERT INTO STUDENTANSWER (student_answer_id, student_answer_content, student_answer_point, question_in_paper_id, result_id)
VALUES (1, 'A', 5, 1, 1);

INSERT INTO EXAM (exam_id, exam_name) VALUES (2, '宠物医院实习生测试2');
INSERT INTO PAPER (paper_id, paper_name, exam_id, duration, total_score)
VALUES (2, '宠物医院实习生测试卷2', 2, '60分钟', '100分');
INSERT INTO EXAMSESSION (session_id, paper_id, start_time, end_time)
VALUES (2, 2, '2023-04-13 10:00:00', '2023-04-13 11:00:00');

INSERT INTO STUDENTRESULT (result_id,session_id, student_id, score)
VALUES (2, 2, 2, 95);

INSERT INTO QUESTIONSINPAPER (question_in_paper_id,points, paper_id, question_id) VALUES
(2, 5, 2, 1),
(2, 10, 2, 3),
(2, 15, 2, 5),
(2, 20, 2, 7);

INSERT INTO STUDENTANSWER (student_answer_id, student_answer_content, student_answer_point, question_in_paper_id, result_id)
VALUES (2, 'B', 10, 2, 2);





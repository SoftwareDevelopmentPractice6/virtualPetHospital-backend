USE system;

INSERT INTO `ROOM` VALUES ('诊疗室', '兽医师/医助');

INSERT INTO `ROOM` VALUES ('处置室', '兽医师/医助');

INSERT INTO `ROOM` VALUES ('手术室', '兽医师/医助');

INSERT INTO `ROOM` VALUES ('护理室', '医助');

INSERT INTO `ROOM` VALUES ('1号病房', '医助');

INSERT INTO `ROOM` VALUES ('2号病房', '医助');

INSERT INTO `ROOM` VALUES ('3号病房', '医助');

INSERT INTO `ROOM` VALUES ('4号病房', '医助');

INSERT INTO `ROOM` VALUES ('5号病房', '医助');

INSERT INTO `ROOM` VALUES ('6号病房', '医助');

INSERT INTO `ROOM` VALUES ('7号药房', '医助');

INSERT INTO `ROOM` VALUES ('化验室', '兽医师/医助');

INSERT INTO `ROOM` VALUES ('X光室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('口腔护理室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('耳科', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('内科', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('皮肤科', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('麻醉科', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('疫苗接种室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('采血室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('B超室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('针灸室', '兽医师/ 医助');

INSERT INTO `ROOM` VALUES ('洗澡间', '医助');

洗澡间 INSERT INTO `ROOM` VALUES ('消毒供应室', '兽医师/ 医助');

洗澡间 INSERT INTO `ROOM` VALUES ('前台', '前台');

INSERT INTO `admission` VALUES (2,'普通病房', '一级护理','评价1',100.0,'1号病房');

INSERT INTO `admission` VALUES (3,'普通病房', '二级护理','评价2',200.0,'1号病房');

INSERT INTO `admission` VALUES (4,'普通病房', '三级护理','评价3',300.0,'1号病房');

INSERT INTO `admission` VALUES (5,'贵宾病房', '一级护理','评价4',150.0,'2号病房');

INSERT INTO `admission` VALUES (6,'贵宾病房', '二级护理','评价5',300.0,'2号病房');

INSERT INTO `admission` VALUES (7,'贵宾病房', '三级护理','评价6',450.0,'2号病房');

INSERT INTO `admission` VALUES (8,'普通病房', '一级护理','评价8',100.0,'3号病房');

INSERT INTO `admission` VALUES (9,'普通病房', '二级护理','评价7',200.0,'3号病房');

INSERT INTO `admission`
VALUES (
        10,
        '普通病房',
        '三级护理',
        '评价9',
        300.0,
        '3号病房'
    );

INSERT INTO `admission`
VALUES (
        11,
        '贵宾病房',
        '一级护理',
        '评价10',
        150.0,
        '4号病房'
    );

INSERT INTO `admission`
VALUES (
        12,
        '贵宾病房',
        '二级护理',
        '评价12',
        300.0,
        '4号病房'
    );

INSERT INTO `admission`
VALUES (
        13,
        '贵宾病房',
        '三级护理',
        '评价13',
        450.0,
        '4号病房'
    );

INSERT INTO `admission`
VALUES (
        14,
        '普通病房',
        '一级护理',
        '评价14',
        100.0,
        '5号病房'
    );

INSERT INTO `admission`
VALUES (
        15,
        '普通病房',
        '二级护理',
        '评价15',
        200.0,
        '5号病房'
    );

INSERT INTO `admission`
VALUES (
        16,
        '普通病房',
        '三级护理',
        '评价16',
        300.0,
        '5号病房'
    );

INSERT INTO `admission`
VALUES (
        17,
        '贵宾病房',
        '一级护理',
        '评价17',
        150.0,
        '6号病房'
    );

INSERT INTO `admission`
VALUES (
        18,
        '贵宾病房',
        '二级护理',
        '评价18',
        300.0,
        '6号病房'
    );

INSERT INTO `admission`
VALUES (
        19,
        '紧急病房',
        '三级护理',
        '评价19',
        400.0,
        '7号病房'
    );

INSERT INTO `admission`
VALUES (
        20,
        '紧急病房',
        '三级护理',
        '评价20',
        400.0,
        '7号病房'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '打针',
        '对宠物进行注射药物',
        '1.取药 2.准备注射器 3.选择注射部位 4.注射',
        'http://www.example.com/injection_video.mp4',
        '诊疗室1',
        '兽医',
        '注射器、药物'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '给药',
        '将药物给予宠物',
        '1.准备药品 2.选择给药途径 3.给药',
        'http://www.example.com/medication_video.mp4',
        '诊疗室2',
        '兽医',
        '药品、给药器'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '洗澡',
        '为宠物清洁毛发',
        '1.准备洗浴用具 2.将宠物放入浴盆中 3.用水淋湿毛发 4.涂抹洗发水 5.冲洗干净 6.吹干毛发',
        'http://www.example.com/bathing_video.mp4',
        '洗澡间',
        '助理',
        '洗发水、毛巾、吹风机'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '手术',
        '为宠物进行外科手术',
        '1.准备手术器械 2.对宠物进行全身麻醉 3.进行手术 4.对伤口进行缝合 5.观察恢复情况',
        'http://www.example.com/surgery_video.mp4',
        '手术室',
        '兽医',
        '手术器械、麻醉药品'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '牙齿护理',
        '为宠物进行口腔清洁和护理',
        '1.准备口腔清洁用具 2.清洁宠物口腔 3.给予口腔护理药物',
        'http://www.example.com/dental_video.mp4',
        '口腔护理室',
        '助理',
        '口腔清洁用具、口腔护理药物'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '驱虫',
        '为宠物进行驱除寄生虫的治疗',
        '1.准备驱虫药品 2.给予宠物驱虫药物',
        'http://www.example.com/deworming_video.mp4',
        '诊疗室1',
        '兽医',
        '驱虫药品'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '护理',
        '为宠物提供生活护理服务，如喂食、喂水等',
        '1.准备喂食用具和食物 2.为宠物喂食和喂水',
        'http://www.example.com/nursing_video.mp4',
        '护理室',
        '护理人员',
        '喂食器具、食物、水'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '拍片',
        '对宠物进行X光或CT检查',
        '1.准备拍片器械 2.给予宠物全身麻醉 3.拍摄X光或CT照片 4.观察结果',
        'http://www.example.com/xray_video.mp4',
        'B超室',
        '兽医',
        '拍片器械、麻醉药品'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '针灸',
        '对宠物进行针灸治疗',
        '1.准备针灸器械和药品 2.选择合适的针灸穴位 3.进行针灸治疗',
        'http://www.example.com/acupuncture_video.mp4',
        '针灸室',
        '兽医',
        '针灸器械、药品'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '抽血',
        '对宠物进行血液检查',
        '1.准备采血器械和药品 2.选择采血部位 3.采血',
        'http://www.example.com/blood_collection_video.mp4',
        '采血室',
        '兽医',
        '采血器械、药品'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '疫苗接种',
        '为宠物接种疫苗以预防疾病',
        '1.选择疫苗种类 2.将疫苗接种给宠物 3.记录接种时间和疫苗类型',
        'http://www.example.com/vaccination_video.mp4',
        '疫苗接种室',
        '兽医',
        '疫苗、注射器、消毒剂'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '牙齿洗刷',
        '为宠物清洁牙齿以预防口腔疾病',
        '1.准备牙刷和牙膏 2.将宠物放置在牙齿清洁台上 3.进行牙齿清洁 4.记录牙齿清洁情况',
        'http://www.example.com/dental_video.mp4',
        '口腔护理室',
        '兽医',
        '牙刷、牙膏、口腔消毒剂'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '伤口清洁',
        '为宠物清洁伤口以预防感染',
        '1.准备清洁工具和药品 2.清洁伤口并消毒 3.进行敷料和包扎 4.记录伤口清洁情况',
        'http://www.example.com/wound_cleaning_video.mp4',
        '处置室',
        '兽医',
        '清洁剂、消毒剂、敷料、包扎器具'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '耳道清理',
        '为宠物清理耳道以预防耳部感染',
        '1.准备清洁工具和药品 2.检查耳道情况 3.清理耳道和外耳 4.记录耳道清理情况',
        'http://www.example.com/ear_cleaning_video.mp4',
        '耳科',
        '兽医',
        '耳道清洁器具、清洁液、棉签'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '皮肤护理',
        '为宠物清洁皮肤以预防皮肤疾病',
        '1.准备清洁工具和药品 2.检查皮肤情况 3.清洁皮肤并涂抹药品 4.记录皮肤护理情况',
        'http://www.example.com/skin_care_video.mp4',
        '皮肤科',
        '兽医',
        '清洁剂、药膏、护理液'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '输液',
        '为宠物进行输液以滋养身体和治疗疾病',
        '1.准备输液设备和药品 2.检查宠物情况 3.选择适当的输液方式和剂量 4.进行输液并监测宠物情况 5.记录输液情况',
        'http://www.example.com/iv_therapy_video.mp4',
        '内科',
        '兽医',
        '输液器具、输液液体、输液针头、止痛药等'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '使用镇静剂',
        '为宠物在手术前进行镇静以减少手术压力和危险',
        '1.准备镇静剂和注射器具 2.计算剂量并注射 3.观察宠物反应并进行必要的调整 4.记录使用情况',
        'http://www.example.com/sedation_video.mp4',
        '麻醉科',
        '兽医',
        '镇静剂、注射器、针头等'
    );

INSERT INTO
    FEATURE (
        func_name,
        func_description,
        func_flow,
        func_video,
        room_name,
        func_role,
        func_tool
    )
VALUES (
        '测量血压',
        '为宠物测量血压以了解其健康状况和监测病情',
        '1.准备血压计和袖带 2.选择合适的袖带大小和位置 3.进行血压测量 4.记录血压值和宠物情况',
        'http://www.example.com/blood_pressure_measurement_video.mp4',
        '内科',
        '兽医',
        '血压计、袖带等'
    );

INSERT INTO
    MEDICINE (
        medicine_name,
        medicine_price,
        manufacturer,
        class,
        specification,
        is_vaccine
    )
VALUES (
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
VALUES (
        '2022-01-01 08:30:00',
        '感冒',
        '猫',
        '小黑',
        '母',
        '13512345678'
    ), (
        '2022-02-02 14:00:00',
        '拉肚子',
        '狗',
        '大黄',
        '公',
        '13987654321'
    ), (
        '2022-02-15 10:20:00',
        '结膜炎',
        '猫',
        '小白',
        '母',
        '13666666666'
    ), (
        '2022-03-03 16:50:00',
        '发烧',
        '狗',
        '旺财',
        '公',
        '13811112222'
    ), (
        '2022-04-10 11:30:00',
        '打虫',
        '猫',
        '小花',
        '母',
        '13900001111'
    ), (
        '2022-05-01 09:00:00',
        '感冒',
        '狗',
        '咖啡',
        '母',
        '13543215678'
    ), (
        '2022-05-12 15:20:00',
        '瘤子',
        '狗',
        '豆豆',
        '公',
        '13876543210'
    ), (
        '2022-06-05 10:10:00',
        '驱蚤',
        '猫',
        '芝士',
        '母',
        '13998765432'
    ), (
        '2022-07-01 13:30:00',
        '抽血',
        '狗',
        '美美',
        '母',
        '13654327890'
    ), (
        '2022-07-15 16:00:00',
        '发烧',
        '狗',
        '小蓝',
        '公',
        '13501234567'
    ), (
        '2022-08-02 09:40:00',
        '结石',
        '猫',
        '小兔',
        '公',
        '13887654321'
    ), (
        '2022-08-22 11:50:00',
        '疫苗',
        '狗',
        '小莉',
        '母',
        '13944445555'
    ), (
        '2022-09-03 14:30:00',
        '感冒',
        '猫',
        '小妞',
        '母',
        '13666668888'
    ), (
        '2022-10-05 10:10:00',
        '驱虫',
        '狗',
        '旺旺',
        '公',
        '13999990000'
    ), (
        '2022-11-11 08:20:00',
        '瘤子',
        '狗',
        '小可',
        '母',
        '13599998888'
    ), (
        '2022-11-22 15:30:00',
        '抽血',
        '猫',
        '小丸子',
        '公',
        '13876543211'
    ), (
        '2022-12-12 16:00:00',
        '感冒',
        '狗',
        '小小',
        '母',
        '13612345678'
    ), (
        '2023-01-01 14:40:00',
        '疫苗',
        '猫',
        '小王',
        '公',
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
    )
INSERT INTO
    CHARGE (item_name, charge_price)
VALUES ('挂号费', 10.0), ('输液费', 50.0), ('手术费', 500.0), ('体检费', 30.0), ('治疗费', 100.0), ('手术用材料费', 200.0), ('护理费', 80.0), ('诊断费', 50.0), ('药品费', 80.0), ('镇痛费', 30.0), ('检查费', 80.0), ('补液费', 50.0), ('床位费', 100.0), ('止血费', 50.0), ('抢救费', 1000.0), ('疫苗接种费', 200.0), ('驱虫费', 50.0), ('手术器械消毒费', 50.0), ('止痛费', 30.0), ('处置费', 20.0);

INSERT INTO
    EXAMINE(
        examine_name,
        examine_price,
        room_name
    )
VALUES ('疫苗注射', 100.00, '疫苗接种室'), ('驱虫药物', 50.00, '诊疗室'), ('皮肤病检查', 200.00, '皮肤科'), ('内科检查', 250.00, '内科'), ('血液检查', 300.00, '化验室'), ('X光检查', 400.00, 'X光室'), ('细菌培养', 150.00, '化验室'), ('牙齿洁治', 180.00, '诊疗室'), ('肠胃病检查', 280.00, '内科'), ('外伤检查', 200.00, '诊疗室'), ('狗瘟热检查', 150.00, '诊疗室'), ('猫瘟热检查', 150.00, '诊疗室'), ('猫鼻炎检查', 200.00, '诊疗室'), ('兔子传染性腹泻检查', 250.00, '诊疗室'), ('宠物绝育手术', 500.00, '手术室'), ('宠物抽血', 150.00, '化验室'), ('宠物输液', 180.00, '诊疗室'), ('宠物手术缝合', 300.00, '手术室'), ('宠物拆线', 150.00, '手术室'), ('宠物换药', 100.00, '诊疗室'), ('宠物身体理疗', 200.00, '诊疗室');
/*
Navicat MySQL Data Transfer

Source Server         : mysql5
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : jcx

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-02-21 16:57:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dtproperties`
-- ----------------------------
DROP TABLE IF EXISTS `dtproperties`;
CREATE TABLE `dtproperties` (
  `id` int(100) NOT NULL,
  `objectid` int(100) DEFAULT NULL,
  `property` varchar(100) NOT NULL,
  `value` varchar(600) DEFAULT NULL,
  `lvalue` blob,
  `version` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`property`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dtproperties
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_gysinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gysinfo`;
CREATE TABLE `tb_gysinfo` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL,
  `jc` varchar(100) DEFAULT NULL,
  `dz` varchar(100) DEFAULT NULL,
  `yzbm` varchar(100) DEFAULT NULL,
  `dh` varchar(100) DEFAULT NULL,
  `cz` varchar(100) DEFAULT NULL,
  `lxr` varchar(100) DEFAULT NULL,
  `lxdh` varchar(100) DEFAULT NULL,
  `yh` varchar(100) DEFAULT NULL,
  `yx` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_gysinfo
-- ----------------------------
INSERT INTO `tb_gysinfo` VALUES ('gys1001', '阿里巴巴股份制有限公司', '阿里巴巴', '北京三环', '100000', '15833069306', '3232377', '马云', '13214389438', 'mayunbaba.163.com', '兴业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1002', '京东商城', '京东', '清华大学', '100002', '17754327569', '1123333', '刘强东', '13364872549', 'naichameimei.126.com', '建设银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1003', '美国联合储蓄银行', '美联储', 'USA', '10000', '5613555', '4987', '寇晓宇', '17865198993', '714366968@qq.com', '美国联合储蓄银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1004', '聚美优品', '聚美', '湖南长沙', '25025', '13578057688', '346578', '陈欧', '17745889321', 'wozuimei@163.com', '邯郸银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1005', '迪拜皇室', 'DB', '迪拜', '666666', '88888888', '8888', '郝韵致', '17865193230', '851086023@qq.com', '瑞士银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1006', '成都利尔药业公司', '成都利尔药业', '成都', '235332', '134826355837', '2994', '何奭', '13257443689', '88838848@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1007', '四川合信药厂公司', '四川合信药厂', '四川', '235333', '134826355834', '2995', '梁锋', '13257443690', '88838849@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1008', '四川中方制药公司', '四川中方制药', '四川', '235334', '134826355874', '2996', '曹靖毅', '13257443691', '88838850@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1009', '成都永安制药公司', '成都永安制药', '成都', '235335', '134826355837', '2997', '汪权', '13257443692', '88838851@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1010', '云南永安制药公司', '云南永安制药', '云南', '235336', '134826355834', '2998', '陈睿睿', '13257443693', '88838852@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1011', '云南白药公司', '云南白药', '云南', '235337', '134826355874', '2999', '徐鸿宇', '13257443694', '88838853@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1012', '四川爱丽丝制药公司', '四川爱丽丝制药', '四川', '235338', '134826355837', '3000', '白珺仁', '13257443695', '88838854@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1013', '华能电力厂商公司', '华能电力厂商', '山东', '235339', '134826355834', '3001', '许钦奇', '13257443696', '88838855@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1014', '泉州石化公司', '泉州石化', '泉州', '235340', '134826355874', '3002', '李信融', '17854357890', '88838856@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1015', '广州电力公司', '广州电力', '广州', '235341', '134826355837', '3003', '杨强强', '17854357891', '88838857@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1016', '新华书店总店', '新华书店总店', '中国', '235342', '134826355834', '3004', '王钟灵', '17854357892', '88838858@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1017', '中国联通公司', '中国联通公司', '北京', '235343', '134826355874', '3005', '刘方铮', '17854357893', '88838859@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1018', '北京天石易通公司', '北京天石易通公司', '北京', '235344', '134826355837', '3006', '蔡天成', '17854357894', '88838860@qq.com', '中国银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1019', '北京康大集成软件技术公司', '北京康大集成软件技术', '北京', '235345', '134826355834', '3007', '杨时杰', '17854357895', '88838861@qq.com', '中国银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1020', '中天数据通信有限公司', '中天数据通信有限', '上海', '235346', '134826355874', '3008', '金龙', '17854357896', '88838862@qq.com', '中国银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1021', '上海凯伊科技发展公司', '上海凯伊科技发展', '上海', '235347', '134826355834', '3009', '朱方林', '17854357897', '88838863@qq.com', '中国银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1022', '沈阳瑞成科技公司', '沈阳瑞成科技', '沈阳', '235348', '134826355874', '4432', '卫一宁', '17854357898', '88838864@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1023', '深圳滨网科技公司', '深圳滨网科技', '深圳', '235349', '134826355837', '4433', '吴晓东', '17854357899', '88838865@qq.com', '工商银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1024', '深圳欧阳华斯电源公司', '深圳欧阳华斯电源', '深圳', '235350', '134826355834', '4434', '曹德福', '17854357900', '88838866@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1025', '58同城公司', '58同城', '北京', '235351', '134826355874', '4435', '李康', '17854357901', '88838867@qq.com', '农业银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1026', '阿里巴巴公司', '淘宝网', '天津', '235352', '134826355834', '4436', '沈立凡', '17854357902', '88838868@qq.com', '交通银行');
INSERT INTO `tb_gysinfo` VALUES ('gys1027', '楚楚街公司', '楚楚街', '广州', '235353', '134826355874', '4437', '梅胜寒', '17854357903', '88838869@qq.com', '交通银行');

-- ----------------------------
-- Table structure for `tb_kc`
-- ----------------------------
DROP TABLE IF EXISTS `tb_kc`;
CREATE TABLE `tb_kc` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `spname` varchar(100) DEFAULT NULL,
  `jc` varchar(100) DEFAULT NULL,
  `cd` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `bz` varchar(100) DEFAULT NULL,
  `dw` varchar(100) DEFAULT NULL,
  `dj` varchar(255) NOT NULL,
  `kcsl` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_kc
-- ----------------------------
INSERT INTO `tb_kc` VALUES ('sp1001', '2016LV春夏新款', 'LV女装', '山东滨州', '123', '单件封装', '件', '55.0', '36');
INSERT INTO `tb_kc` VALUES ('sp1002', '2016VANS新款', 'VANS', '芬兰', 'TT123', '单件封装', '双', '33.0', '1074');
INSERT INTO `tb_kc` VALUES ('sp1003', '美国国债', '美国国债', 'USA', 'TT456', '无', '股', '400.0', '138');
INSERT INTO `tb_kc` VALUES ('sp1004', '2016SKII-2神仙水护肤套装', 'SKII-2', '韩国首尔化妆品旗舰店', 'UU88', '超级好的包装', '盒', '11.2', '208');
INSERT INTO `tb_kc` VALUES ('sp1005', '黄金', '黄金', '迪拜地下金矿', 'OO44', '密封', '克', '2222222.0', '129');
INSERT INTO `tb_kc` VALUES ('sp1006', '韩束2016新款面膜', '面膜', '滨州无棣', 'TY88', '5片一盒', '一包', '22.0', '998');
INSERT INTO `tb_kc` VALUES ('sp1008', '阿米卡星药品', '阿米卡星', '成都', 'TT203', '单件封装', '盒', '46.0 ', '43');
INSERT INTO `tb_kc` VALUES ('sp1009', '环丙沙星药品', '环丙沙星', '成都', 'TT204', '单件封装', '盒', '48.0 ', '44');
INSERT INTO `tb_kc` VALUES ('sp1010', '头孢克洛药品', '头孢克洛', '四川', 'TT205', '单件封装', '盒', '50.0 ', '45');
INSERT INTO `tb_kc` VALUES ('sp1011', '吉他霉素药品', '吉他霉素', '成都', 'TT206', '单件封装', '盒', '52.0 ', '46');
INSERT INTO `tb_kc` VALUES ('sp1012', '土霉素药品', '土霉素', '四川', 'TT207', '单件封装', '盒', '54.0 ', '47');
INSERT INTO `tb_kc` VALUES ('sp1013', '多西环素药品', '多西环素', '成都', 'TT208', '单件封装', '盒', '56.0 ', '48');
INSERT INTO `tb_kc` VALUES ('sp1014', '叫沙霉素药品', '叫沙霉素', '四川', 'TT209', '单件封装', '盒', '58.0 ', '49');
INSERT INTO `tb_kc` VALUES ('sp1015', '阿斯林药品', '阿斯林', '成都', 'TT210', '单件封装', '盒', '78.00 ', '50');
INSERT INTO `tb_kc` VALUES ('sp1016', '克林霉素药品', '克林霉素', '成都', 'TT211', '单件封装', '盒', '77.00 ', '51');
INSERT INTO `tb_kc` VALUES ('sp1017', '婴儿健脾散药品', '婴儿健脾散', '四川', 'TT212', '单件封装', '盒', '76.00 ', '52');
INSERT INTO `tb_kc` VALUES ('sp1018', '替硝锉药品', '替硝锉', '四川', 'TT213', '单件封装', '盒', '75.00 ', '53');
INSERT INTO `tb_kc` VALUES ('sp1019', '利巴韦林药品', '利巴韦林', '四川', 'TT214', '单件封装', '盒', '74.00 ', '54');
INSERT INTO `tb_kc` VALUES ('sp1020', '平凡的世界书', '平凡的世界', '山东', 'UU321', '按包封装', '本', '73.00 ', '55');
INSERT INTO `tb_kc` VALUES ('sp1021', '挪威的森林书', '挪威的森林', '河南', 'UU322', '按包封装', '本', '72.00 ', '56');
INSERT INTO `tb_kc` VALUES ('sp1022', '苏菲的世界书', '苏菲的世界', '山东', 'UU323', '按包封装', '本', '71.00 ', '24');
INSERT INTO `tb_kc` VALUES ('sp1023', '十日谈书', '十日谈', '山东', 'UU324', '按包封装', '本', '70.00 ', '25');
INSERT INTO `tb_kc` VALUES ('sp1024', '白鹿原书', '白鹿原', '北京', 'UU325', '按包封装', '本', '69.00 ', '26');
INSERT INTO `tb_kc` VALUES ('sp1025', '活着书', '活着', '山东', 'UU326', '按包封装', '本', '68.00 ', '27');
INSERT INTO `tb_kc` VALUES ('sp1026', '牛虻书', '牛虻', '山东', 'UU327', '按包封装', '本', '67.00 ', '28');
INSERT INTO `tb_kc` VALUES ('sp1027', '麦田的守望者书', '麦田的守望者', '云南', 'UU328', '按包封装', '本', '66.00 ', '29');
INSERT INTO `tb_kc` VALUES ('sp1028', '呼啸山庄书', '呼啸山庄', '山东', 'UU329', '按包封装', '本', '65.00 ', '30');
INSERT INTO `tb_kc` VALUES ('sp1029', '生命从明天开始书', '生命从明天开始', '山东', 'UU330', '按包封装', '本', '64.00 ', '31');
INSERT INTO `tb_kc` VALUES ('sp1030', '钢铁是怎样炼成的书', '钢铁是怎样炼成的', '山东', 'UU331', '按包封装', '本', '63.00 ', '32');
INSERT INTO `tb_kc` VALUES ('sp1031', '婚纱服装', '婚纱', '北京', 'II342', '单件封装', '件', '99.00 ', '33');
INSERT INTO `tb_kc` VALUES ('sp1032', '时尚新款服装', '时尚新款', '天津', 'II343', '单件封装', '件', '890.00 ', '34');
INSERT INTO `tb_kc` VALUES ('sp1033', '2016新款服装', '2016新款', '广州', 'II344', '单件封装', '件', '677.00 ', '35');

-- ----------------------------
-- Table structure for `tb_khinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_khinfo`;
CREATE TABLE `tb_khinfo` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `khname` varchar(100) DEFAULT NULL,
  `jc` varchar(100) DEFAULT NULL,
  `dz` varchar(100) DEFAULT NULL,
  `yzbm` varchar(100) DEFAULT NULL,
  `dh` varchar(100) DEFAULT NULL,
  `cz` varchar(100) DEFAULT NULL,
  `lxr` varchar(100) DEFAULT NULL,
  `lxdh` varchar(100) DEFAULT NULL,
  `yx` varchar(100) DEFAULT NULL,
  `yhname` varchar(100) DEFAULT NULL,
  `yhkh` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_khinfo
-- ----------------------------
INSERT INTO `tb_khinfo` VALUES ('kh1002', '华硕有限公司', '华硕', '厦门', '056001', '13231014689', '8099212', '蔻晓宇', '17865196565', '714366968@qq.com', '建设银行', '621661110000851520');
INSERT INTO `tb_khinfo` VALUES ('kh1003', 'Apple有限公司', 'Apple', 'USA', '1000', '6336998', '6336997', '邱正', '13133035678', '765877677@qq.com', '瑞士银行', '1102387509846601');
INSERT INTO `tb_khinfo` VALUES ('kh1004', 'vivo智能手机有限公司', 'vivo', '上海浦东', '200020', '13731032399', '8505012', '吴晓东', '17865191317', '1233217542qq.com', '上海浦东', '11347774566889');
INSERT INTO `tb_khinfo` VALUES ('kh1005', '微软公司', '微软', 'USA.L.A', '10001', '17865193230', '8432561', '侯中妮', '15969686977', '11347776.163.com', '瑞士银行', '1657483493923919');
INSERT INTO `tb_khinfo` VALUES ('kh1006', '华为手机公司', '华为2', '南京', '345876', '13856763333', '0531', '张帅', '13443256687', '723654383@qq.com', '南京', '343746374');
INSERT INTO `tb_khinfo` VALUES ('kh1008', '杨鑫', '杨鑫', '山东省济南市历下区', '250102', '17865190002', '5315', '郝岳明', '17865198994', '263423492@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1009', '韩楚怡', '韩楚怡', '山东省济南市历下区', '250103', '17865190003', '5316', '郝岳明', '17865198995', '263423493@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1010', '潘云刚', '潘云刚', '山东省济南市历下区', '250104', '17865190004', '5317', '郝岳明', '17865198996', '263423494@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1011', '冯靓静', '冯靓静', '山东省济南市历下区', '250105', '17865190005', '5318', '郝岳明', '17865198997', '263423495@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1012', '曹德福', '曹德福', '山东省济南市历下区', '250106', '17865190006', '5319', '郝岳明', '17865198998', '263423496@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1013', '李康', '李康', '山东省济南市历下区', '250107', '17865190007', '5320', '郝岳明', '17865198999', '263423497@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1014', '沈立凡', '沈立凡', '山东省济南市历下区', '250108', '17865190008', '5321', '郝岳明', '17865199000', '263423498@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1015', '郑强', '郑强', '山东省济南市历下区', '250109', '17865190009', '5322', '郝岳明', '17865199001', '263423499@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1016', '刘梦源', '刘梦源', '山东省济南市历下区', '250110', '17865190010', '5323', '郝岳明', '17865199002', '263423500@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1017', '房元发', '房元发', '山东省济南市历下区', '250111', '17865190011', '5324', '郝岳明', '17865199003', '263423501@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1018', '柏淑涛', '柏淑涛', '山东省济南市历下区', '250112', '17865190012', '5325', '郝岳明', '17865199004', '263423502@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1019', '董业', '董业', '山东省济南市历下区', '250113', '17865190013', '5326', '郝岳明', '17865199005', '263423503@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1020', '薛鹏飞', '薛鹏飞', '山东省济南市历下区', '250114', '17865190014', '5327', '郝岳明', '17865199006', '263423504@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1021', '边荣正', '边荣正', '山东省济南市历下区', '250115', '17865190015', '5328', '郝岳明', '17865199007', '263423505@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1022', '叶涛', '叶涛', '山东省济南市历下区', '250116', '17865190016', '5329', '郝岳明', '17865199008', '263423506@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1023', '刘新宇', '刘新宇', '山东省济南市历下区', '250117', '17865190017', '5330', '郝岳明', '17865199009', '263423507@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1024', '朱方林', '朱方林', '山东省济南市历下区', '250118', '17865190018', '5331', '郝岳明', '17865199010', '263423508@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1025', '卫一宁', '卫一宁', '山东省济南市历下区', '250119', '17865190019', '5332', '郝岳明', '17865199011', '263423509@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1026', '吴晓东', '吴晓东', '山东省济南市历下区', '250120', '17865190020', '5333', '郝岳明', '17865199012', '263423510@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1027', '邱正', '邱正', '山东省济南市历下区', '250121', '17865190021', '5334', '郝岳明', '17865199013', '263423511@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1028', '秦晓宇', '秦晓宇', '山东省济南市历下区', '250122', '17865190022', '5335', '郝岳明', '17865199014', '263423512@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1029', '梅胜寒', '梅胜寒', '山东省济南市历下区', '250123', '17865190023', '5336', '郝岳明', '17865199015', '263423513@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1030', '孙畅畅', '孙畅畅', '山东省济南市历下区', '250124', '17865190024', '5337', '郝岳明', '17865199016', '263423514@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1031', '陈琳锋', '陈琳锋', '山东省济南市历下区', '250125', '17865190025', '5338', '郝岳明', '17865199017', '263423515@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1032', '刁欣蓉', '刁欣蓉', '山东省济南市历下区', '250126', '17865190026', '5339', '郝岳明', '17865199018', '263423516@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1033', '李莹', '李莹', '山东省济南市历下区', '250127', '17865190027', '5340', '郝岳明', '17865199019', '263423517@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1034', '卢丽婧', '卢丽婧', '山东省济南市历下区', '250128', '17865190028', '5341', '郝岳明', '17865199020', '263423518@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1035', '刘云风', '刘云风', '山东省济南市历下区', '250129', '17865190029', '5342', '郝岳明', '17865199021', '263423519@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1036', '郭涵章', '郭涵章', '山东省济南市历下区', '250130', '17865190030', '5343', '郝岳明', '17865199022', '263423520@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1037', '李天阳', '李天阳', '山东省济南市历下区', '250131', '17865190031', '5344', '郝岳明', '17865199023', '263423521@qq.com', '中国银行', '62166111100002853432');
INSERT INTO `tb_khinfo` VALUES ('kh1038', '李传哲', '李传哲', '山东省济南市历下区', '250132', '17865190032', '5345', '郝岳明', '17865199024', '263423522@qq.com', '中国银行', '62166111100002853432');

-- ----------------------------
-- Table structure for `tb_manager`
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_rkth`
-- ----------------------------
DROP TABLE IF EXISTS `tb_rkth`;
CREATE TABLE `tb_rkth` (
  `rkthid` varchar(255) NOT NULL,
  `pzno` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `gysid` varchar(255) DEFAULT NULL,
  `rkthrq` datetime DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rkthid`,`pzno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_rkth
-- ----------------------------
INSERT INTO `tb_rkth` VALUES ('RT20160827001', '0', 'sp1004', '11.0', '11', '121.0', 'gys1004', '2016-08-27 06:30:06', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827002', '0', 'sp1008', '11.0 ', '23', '112.0 ', 'gys1005', '2016-08-28 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827005', '1', 'sp1010', '33', '25', '124', 'gys1007', '2016-08-30 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827006', '1', 'sp1011', '40.7', '26', '678', 'gys1008', '2016-08-31 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827007', '1', 'sp1012', '51.7', '27', '44', 'gys1009', '2016-09-01 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827008', '1', 'sp1013', '62.7', '28', '654', 'gys1010', '2016-09-02 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827009', '1', 'sp1014', '73.7', '29', '56', 'gys1011', '2016-09-03 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827010', '1', 'sp1015', '84.7', '30', '3452', 'gys1012', '2016-09-04 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827011', '1', 'sp1016', '95.7', '31', '34', 'gys1013', '2016-09-05 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827012', '1', 'sp1017', '13', '32', '343', 'gys1014', '2016-09-06 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827013', '1', 'sp1001', '14', '33', '123', 'gys1015', '2016-09-07 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827014', '1', 'sp1003', '15', '12', '231', 'gys1016', '2016-09-08 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827015', '1', 'sp1005', '16', '14', '234', 'gys1017', '2016-09-09 06:30:00', 'qq', '现金');
INSERT INTO `tb_rkth` VALUES ('RT20160827016', '0', 'sp1007', '17', '16', '342', 'gys1018', '2016-09-10 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827017', '0', 'sp1009', '18', '18', '234', 'gys1019', '2016-09-11 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827018', '0', 'sp1011', '19', '20', '235', 'gys1020', '2016-09-12 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827019', '0', 'sp1013', '20', '22', '236', 'gys1021', '2016-09-13 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827020', '0', 'sp1015', '21', '24', '237', 'gys1022', '2016-09-14 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827021', '1', 'sp1017', '22', '26', '238', 'gys1023', '2016-09-15 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827022', '1', 'sp1019', '23', '13', '239', 'gys1024', '2016-09-16 06:30:00', 'qq', '支票');
INSERT INTO `tb_rkth` VALUES ('RT20160827023', '0', 'sp1021', '24', '2', '240', 'gys1025', '2016-09-17 06:30:00', 'qq', '支票');

-- ----------------------------
-- Table structure for `tb_rkth_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_rkth_detail`;
CREATE TABLE `tb_rkth_detail` (
  `rkthid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `dj` decimal(20,2) DEFAULT NULL,
  `sl` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_rkth_detail
-- ----------------------------
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827001', 'sp1004', '11.00', '11');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827001', 'sp1007', '22.00', '22');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827005', 'sp1010', '33.00', '25');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827006', 'sp1011', '40.70', '26');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827007', 'sp1012', '51.70', '27');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827008', 'sp1013', '62.70', '28');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827009', 'sp1014', '73.70', '29');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827010', 'sp1015', '84.70', '30');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827011', 'sp1016', '95.70', '31');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827012', 'sp1017', '13.00', '32');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827013', 'sp1001', '14.00', '33');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827014', 'sp1003', '15.00', '12');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827015', 'sp1005', '16.00', '14');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827016', 'sp1007', '17.00', '16');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827017', 'sp1009', '18.00', '18');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827018', 'sp1011', '19.00', '20');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827019', 'sp1013', '20.00', '22');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827020', 'sp1015', '21.00', '24');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827021', 'sp1017', '22.00', '26');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827022', 'sp1019', '23.00', '13');
INSERT INTO `tb_rkth_detail` VALUES ('RT20160827023', 'sp1021', '24.00', '2');

-- ----------------------------
-- Table structure for `tb_rkth_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_rkth_main`;
CREATE TABLE `tb_rkth_main` (
  `rkthid` varchar(200) NOT NULL DEFAULT '',
  `pzs` varchar(200) DEFAULT NULL,
  `je` varchar(200) DEFAULT NULL,
  `ysjl` varchar(200) DEFAULT NULL,
  `gysname` varchar(200) DEFAULT NULL,
  `rkdate` varchar(200) DEFAULT NULL,
  `czy` varchar(200) DEFAULT NULL,
  `jsr` varchar(200) DEFAULT NULL,
  `jsfs` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`rkthid`),
  KEY `je` (`je`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_rkth_main
-- ----------------------------
INSERT INTO `tb_rkth_main` VALUES ('RT20160827001', '2', '605.0', 'y', '聚美优品', '2016-08-27 06:30:06', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270010', '10', '58', 'e', '成都利尔药业', '2016/9/4 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270011', '11', '59', 's', '成都利尔药业', '2016/9/5 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270012', '12', '60', 'y', '成都利尔药业', '2016/9/6 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270013', '13', '61', 'a', '成都利尔药业', '2016/9/7 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270014', '14', '62', 'b', '成都利尔药业', '2016/9/8 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270015', '15', '63', 'e', '新华书店总店', '2016/9/9 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270016', '16', '64', 's', '新华书店总店', '2016/9/10 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270017', '17', '65', 'y', '新华书店总店', '2016/9/11 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270018', '18', '66', 'a', '新华书店总店', '2016/9/12 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270019', '19', '67', 'b', '新华书店总店', '2016/9/13 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270020', '20', '68', 'e', '新华书店总店', '2016/9/14 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270021', '21', '69', 's', '新华书店总店', '2016/9/15 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270022', '22', '70', 'y', '淘宝网', '2016/9/16 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270023', '23', '71', 'a', '四川爱丽丝制药', '2016/9/17 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270024', '24', '72', 'b', '淘宝网', '2016/9/18 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270025', '25', '73', 'e', '四川爱丽丝制药', '2016/9/19 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270026', '26', '74', 's', '淘宝网', '2016/9/20 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT201608270027', '27', '75', 'y', '四川爱丽丝制药', '2016/9/21 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827003', '3', '43', 'a', '聚美优品', '2016/8/28 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827004', '4', '23', 'b', '聚美优品', '2016/8/29 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827005', '5', '53', 'e', '聚美优品', '2016/8/30 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827006', '6', '54', 's', '聚美优品', '2016/8/31 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827007', '7', '55', 'y', '成都利尔药业', '2016/9/1 6:30', '管理员', 'qq', '支票');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827008', '8', '56', 'a', '成都利尔药业', '2016/9/2 6:30', '管理员', 'qq', '现金');
INSERT INTO `tb_rkth_main` VALUES ('RT20160827009', '9', '57', 'b', '成都利尔药业', '2016/9/3 6:30', '管理员', 'qq', '支票');

-- ----------------------------
-- Table structure for `tb_ruku`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ruku`;
CREATE TABLE `tb_ruku` (
  `rukuid` varchar(255) NOT NULL,
  `pzno` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `gysid` varchar(255) DEFAULT NULL,
  `rukurq` datetime DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rukuid`,`pzno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ruku
-- ----------------------------
INSERT INTO `tb_ruku` VALUES ('RK20160827001', '0', 'sp1004', '111.0', '111', '12321.0', 'gys1004', '2016-08-27 06:44:57', 'ww', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160827002', '1', 'sp1007', '22.0', '222', '4884.0', 'gys1004', '2016-08-27 06:44:57', 'ww', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907001', '0', 'sp1002', '33.0', '2', '66.0', 'gys1002', '2016-09-07 11:06:34', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907005', '2', 'sp1001', '11', '3', '67', 'gys1003', '2016-09-08 11:06:00', 'a', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907006', '3', 'sp1004', '23', '4', '68', 'gys1004', '2016-09-09 11:06:00', 'a', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907007', '1', 'sp1005', '12', '5', '69', 'gys1005', '2016-09-10 11:06:00', 'd', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907008', '3', 'sp1005', '5', '6', '70', 'gys1006', '2016-09-11 11:06:00', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907009', '3', 'sp1005', '3', '7', '71', 'gys1007', '2016-09-12 11:06:00', 'w', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907010', '3', 'sp1005', '234', '8', '72', 'gys1008', '2016-09-13 11:06:00', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907011', '4', 'sp1005', '345', '9', '73', 'gys1009', '2016-09-14 11:06:00', 'a', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907012', '4', 'sp1005', '256.4', '10', '74', 'gys1010', '2016-09-15 11:06:00', 'a', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907013', '5', 'sp1005', '11', '11', '75', 'gys1011', '2016-09-16 11:06:00', 'd', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907014', '5', 'sp1012', '23', '12', '76', 'gys1012', '2016-09-17 11:06:00', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907015', '5', 'sp102', '12', '13', '77', 'gys1013', '2016-09-18 11:06:00', 'w', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907016', '6', 'sp102', '5', '14', '78', 'gys1014', '2016-09-19 11:06:00', 'e', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907017', '6', 'sp102', '448.8', '15', '79', 'gys1015', '2016-09-20 11:06:00', 'a', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907018', '7', 'sp102', '487.3', '16', '80', 'gys1016', '2016-09-21 11:06:00', 'a', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907019', '7', 'sp102', '11', '17', '81', 'gys1017', '2016-09-22 11:06:00', 'd', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907020', '7', 'sp102', '23', '18', '82', 'gys1002', '2016-09-23 11:06:00', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907021', '8', 'sp102', '12', '19', '83', 'gys1003', '2016-09-24 11:06:00', 'w', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907022', '8', 'sp102', '5', '20', '84', 'gys1004', '2016-09-25 11:06:00', 'e', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907023', '9', 'sp106', '679.6', '21', '85', 'gys1005', '2016-09-26 11:06:00', 'a', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907024', '9', 'sp106', '718.1', '22', '86', 'gys1006', '2016-09-27 11:06:00', 'a', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907025', '9', 'sp102', '11', '23', '87', 'gys1007', '2016-09-28 11:06:00', 'd', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907026', '10', 'sp102', '23', '24', '88', 'gys1008', '2016-09-29 11:06:00', 'e', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907027', '10', 'sp106', '12', '25', '89', 'gys1009', '2016-09-30 11:06:00', 'w', '支票');
INSERT INTO `tb_ruku` VALUES ('RK20160907028', '11', 'sp106', '5', '26', '90', 'gys1010', '2016-10-01 11:06:00', 'e', '现金');
INSERT INTO `tb_ruku` VALUES ('RK20160907029', '11', 'sp102', '910.5', '27', '91', 'gys1005', '2016-10-02 11:06:00', 'a', '现金');

-- ----------------------------
-- Table structure for `tb_ruku_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ruku_detail`;
CREATE TABLE `tb_ruku_detail` (
  `rkid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `dj` decimal(20,2) DEFAULT NULL,
  `sl` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_ruku_detail
-- ----------------------------
INSERT INTO `tb_ruku_detail` VALUES ('RK20160827001', 'sp1004', '111.00', '111');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160827002', 'sp1007', '22.00', '222');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907001', 'sp1002', '33.00', '2');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907005', 'sp1001', '11.00', '3');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907006', 'sp1004', '23.00', '4');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907007', 'sp1005', '12.00', '5');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907008', 'sp1005', '5.00', '6');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907009', 'sp1005', '3.00', '7');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907010', 'sp1005', '234.00', '8');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907011', 'sp1005', '345.00', '9');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907012', 'sp1005', '256.40', '10');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907013', 'sp1005', '11.00', '11');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907014', 'sp1012', '23.00', '12');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907015', 'sp102', '12.00', '13');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907016', 'sp102', '5.00', '14');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907017', 'sp102', '448.80', '15');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907018', 'sp102', '487.30', '16');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907019', 'sp102', '11.00', '17');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907020', 'sp102', '23.00', '18');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907021', 'sp102', '12.00', '19');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907022', 'sp102', '5.00', '20');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907023', 'sp106', '679.60', '21');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907024', 'sp106', '718.10', '22');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907025', 'sp102', '11.00', '23');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907026', 'sp102', '23.00', '24');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907027', 'sp106', '12.00', '25');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907028', 'sp106', '5.00', '26');
INSERT INTO `tb_ruku_detail` VALUES ('RK20160907029', 'sp102', '910.50', '27');

-- ----------------------------
-- Table structure for `tb_ruku_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ruku_main`;
CREATE TABLE `tb_ruku_main` (
  `rkid` varchar(100) NOT NULL DEFAULT '',
  `pzs` varchar(100) DEFAULT NULL,
  `je` varchar(100) DEFAULT NULL,
  `ysjl` varchar(100) DEFAULT NULL,
  `gysname` varchar(100) DEFAULT NULL,
  `rtdate` varchar(100) DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ruku_main
-- ----------------------------
INSERT INTO `tb_ruku_main` VALUES ('RK20160827001', '2', '17205.0', 'y', '聚美优品', '2016-08-27 06:44:57', '管理员', 'ww', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907001', '1', '66.0', 'rr', '京东商城', '2016-09-07 11:06:34', '管理员', 'e', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907005', '3', '43.00 ', 'a', '聚美优品', '2016/8/28 6:30', '管理员', 'a', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907006', '4', '23.00 ', 'b', '聚美优品', '2016/8/29 6:30', '管理员', 'b', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907007', '5', '53.00 ', 'e', '聚美优品', '2016/8/30 6:30', '管理员', 'e', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907008', '6', '54.00 ', 's', '聚美优品', '2016/8/31 6:30', '管理员', 's', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907009', '7', '55.00 ', 'y', '成都利尔药业', '2016/9/1 6:30', '管理员', 'y', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907010', '8', '56.00 ', 'a', '成都利尔药业', '2016/9/2 6:30', '管理员', 'a', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907011', '9', '57.00 ', 'b', '成都利尔药业', '2016/9/3 6:30', '管理员', 'b', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907012', '10', '58.00 ', 'e', '成都利尔药业', '2016/9/4 6:30', '管理员', 'e', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907013', '11', '59.00 ', 's', '成都利尔药业', '2016/9/5 6:30', '管理员', 's', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907014', '12', '60.00 ', 'y', '成都利尔药业', '2016/9/6 6:30', '管理员', 'y', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907015', '13', '61.00 ', 'a', '成都利尔药业', '2016/9/7 6:30', '管理员', 'a', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907016', '14', '62.00 ', 'b', '成都利尔药业', '2016/9/8 6:30', '管理员', 'b', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907017', '15', '63.00 ', 'e', '新华书店总店', '2016/9/9 6:30', '管理员', 'e', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907018', '16', '64.00 ', 's', '新华书店总店', '2016/9/10 6:30', '管理员', 's', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907019', '17', '65.00 ', 'y', '新华书店总店', '2016/9/11 6:30', '管理员', 'y', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907020', '18', '66.00 ', 'a', '新华书店总店', '2016/9/12 6:30', '管理员', 'a', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907021', '19', '67.00 ', 'b', '新华书店总店', '2016/9/13 6:30', '管理员', 'b', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907022', '20', '68.00 ', 'e', '新华书店总店', '2016/9/14 6:30', '管理员', 'e', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907023', '21', '69.00 ', 's', '新华书店总店', '2016/9/15 6:30', '管理员', 's', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907024', '22', '70.00 ', 'y', '淘宝网', '2016/9/16 6:30', '管理员', 'y', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907025', '23', '71.00 ', 'a', '四川爱丽丝制药', '2016/9/17 6:30', '管理员', 'a', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907026', '24', '72.00 ', 'b', '淘宝网', '2016/9/18 6:30', '管理员', 'b', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907027', '25', '73.00 ', 'e', '四川爱丽丝制药', '2016/9/19 6:30', '管理员', 'e', '支票');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907028', '26', '74.00 ', 's', '淘宝网', '2016/9/20 6:30', '管理员', 's', '现金');
INSERT INTO `tb_ruku_main` VALUES ('RK20160907029', '27', '75.00 ', 'y', '四川爱丽丝制药', '2016/9/21 6:30', '管理员', 'y', '支票');

-- ----------------------------
-- Table structure for `tb_sell`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell`;
CREATE TABLE `tb_sell` (
  `sellid` varchar(255) NOT NULL,
  `pzno` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `khid` varchar(255) DEFAULT NULL,
  `sellrq` datetime DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sellid`,`pzno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sell
-- ----------------------------
INSERT INTO `tb_sell` VALUES ('XS20160827001', '0', 'sp1004', '22.0', '22', '484.0', 'kh1003', '2016-08-27 06:53:10', 'ee', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827002', '1', 'sp1005', '333.0', '33', '10989.0', 'kh1003', '2016-08-27 06:53:10', 'ee', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827003', '3', 'sp1002', '43.0 ', '24.0 ', '1032.0 ', 'kh1005', '2016-08-28 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827004', '4', 'sp1003', '23.0 ', '25.0 ', '575.0 ', 'kh1006', '2016-08-29 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827005', '5', 'sp1004', '53.0 ', '26.0 ', '1378.0 ', 'kh1007', '2016-08-30 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827006', '6', 'sp1005', '54.0 ', '27.0 ', '1458.0 ', 'kh1008', '2016-08-31 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827007', '7', 'sp1006', '55.0 ', '28.0 ', '1540.0 ', 'kh1009', '2016-09-01 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827008', '8', 'sp1007', '56.0 ', '29.0 ', '1624.0 ', 'kh1010', '2016-09-02 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827009', '9', 'sp1008', '57.0 ', '30.0 ', '1710.0 ', 'kh1011', '2016-09-03 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827010', '10', 'sp1009', '58.0 ', '31.0 ', '1798.0 ', 'kh1012', '2016-09-04 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827011', '11', 'sp1010', '59.0 ', '32.0 ', '1888.0 ', 'kh1013', '2016-09-05 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827012', '12', 'sp1011', '60.0 ', '33.0 ', '1980.0 ', 'kh1014', '2016-09-06 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827013', '13', 'sp1012', '61.0 ', '34.0 ', '2074.0 ', 'kh1015', '2016-09-07 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827014', '14', 'sp1013', '62.0 ', '35.0 ', '2170.0 ', 'kh1016', '2016-09-08 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827015', '15', 'sp1014', '63.0 ', '36.0 ', '2268.0 ', 'kh1017', '2016-09-09 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827016', '16', 'sp1001', '64.0 ', '37.0 ', '2368.0 ', 'kh1018', '2016-09-10 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827017', '17', 'sp1002', '65.0 ', '38.0 ', '2470.0 ', 'kh1019', '2016-09-11 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827018', '18', 'sp1003', '66.0 ', '39.0 ', '2574.0 ', 'kh1020', '2016-09-12 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827019', '19', 'sp1001', '67.0 ', '40.0 ', '2680.0 ', 'kh1021', '2016-09-13 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827020', '20', 'sp1002', '68.0 ', '41.0 ', '2788.0 ', 'kh1022', '2016-09-14 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827021', '2', 'sp1003', '69.0 ', '42.0 ', '2898.0 ', 'kh1023', '2016-09-15 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827022', '3', 'sp1004', '70.0 ', '43.0 ', '3010.0 ', 'kh1024', '2016-09-16 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827023', '4', 'sp1005', '71.0 ', '44.0 ', '3124.0 ', 'kh1025', '2016-09-17 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827024', '5', 'sp1006', '72.0 ', '45.0 ', '3240.0 ', 'kh1026', '2016-09-18 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827025', '6', 'sp1004', '73.0 ', '46.0 ', '3358.0 ', 'kh1027', '2016-09-19 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827026', '7', 'sp1005', '74.0 ', '47.0 ', '3478.0 ', 'kh1028', '2016-09-20 06:30:00', 'qq', '现金');
INSERT INTO `tb_sell` VALUES ('XS20160827027', '8', 'sp1006', '75.0 ', '48.0 ', '3600.0 ', 'kh1029', '2016-09-21 06:30:00', 'qq', '支票');
INSERT INTO `tb_sell` VALUES ('XS20160827028', '2', 'sp1007', '33.0', '33', '1089.0', 'kh1003', '2016-08-27 06:53:10', 'ee', '现金');

-- ----------------------------
-- Table structure for `tb_sell_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_detail`;
CREATE TABLE `tb_sell_detail` (
  `sellid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `dj` decimal(20,2) DEFAULT NULL,
  `sl` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_sell_detail
-- ----------------------------
INSERT INTO `tb_sell_detail` VALUES ('XS20160827001', 'sp1004', '22.00', '22');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827003', 'sp1005', '333.00', '33');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827001', 'sp1007', '33.00', '33');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827006', 'sp1005', '54.00', '27');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827007', 'sp1006', '55.00', '28');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827008', 'sp1007', '56.00', '29');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827009', 'sp1008', '57.00', '30');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827010', 'sp1009', '58.00', '31');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827011', 'sp1010', '59.00', '32');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827012', 'sp1011', '60.00', '33');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827013', 'sp1012', '61.00', '34');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827014', 'sp1013', '62.00', '35');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827015', 'sp1014', '63.00', '36');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827016', 'sp1001', '64.00', '37');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827017', 'sp1002', '65.00', '38');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827018', 'sp1003', '66.00', '39');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827019', 'sp1001', '67.00', '40');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827020', 'sp1002', '68.00', '41');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827021', 'sp1003', '69.00', '42');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827022', 'sp1004', '70.00', '43');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827023', 'sp1005', '71.00', '44');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827024', 'sp1006', '72.00', '45');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827025', 'sp1004', '73.00', '46');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827026', 'sp1005', '74.00', '47');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827027', 'sp1006', '75.00', '48');
INSERT INTO `tb_sell_detail` VALUES ('XS20160827028', 'sp1007', '33.00', '33');

-- ----------------------------
-- Table structure for `tb_sell_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_main`;
CREATE TABLE `tb_sell_main` (
  `sellid` varchar(100) NOT NULL DEFAULT '',
  `pzs` int(100) DEFAULT NULL,
  `je` decimal(20,2) DEFAULT NULL,
  `ysjl` varchar(100) DEFAULT NULL,
  `khname` varchar(100) DEFAULT NULL,
  `xsdate` datetime DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sellid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_sell_main
-- ----------------------------
INSERT INTO `tb_sell_main` VALUES ('XS20160827001', '3', '12562.00', 'y', 'Apple有限公司', '2016-08-27 06:53:10', '管理员', 'ee', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827006', '4', '12563.00', 'a', 'Apple有限公司', '2016-08-28 06:53:00', '管理员', 'aa', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827007', '5', '12564.00', 'd', 'Apple有限公司', '2016-08-29 06:53:00', '管理员', 'dw', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827008', '6', '12565.00', 's', 'Apple有限公司', '2016-08-30 06:53:00', '管理员', 'wqa', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827009', '7', '12566.00', 'w', 'Apple有限公司', '2016-08-31 06:53:00', '管理员', 'we', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827010', '8', '12567.00', 'y', 'Apple有限公司', '2016-09-01 06:53:00', '管理员', 'ee', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827011', '9', '12568.00', 'a', '李康', '2016-09-02 06:53:00', '管理员', 'aa', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827012', '10', '12569.00', 'd', '沈立凡', '2016-09-03 06:53:00', '管理员', 'dw', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827013', '11', '12570.00', 's', '郑强', '2016-09-04 06:53:00', '管理员', 'wqa', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827014', '12', '12571.00', 'w', '刘梦源', '2016-09-05 06:53:00', '管理员', 'we', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827015', '13', '12572.00', 'y', '房元发', '2016-09-06 06:53:00', '管理员', 'ee', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827016', '14', '12573.00', 'a', '柏淑涛', '2016-09-07 06:53:00', '管理员', 'aa', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827017', '15', '12574.00', 'd', '华硕有限公司', '2016-09-08 06:53:00', '管理员', 'dw', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827018', '16', '12575.00', 's', '华硕有限公司', '2016-09-09 06:53:00', '管理员', 'wqa', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827019', '17', '12576.00', 'w', '华硕有限公司', '2016-09-10 06:53:00', '管理员', 'we', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827020', '18', '12577.00', 'y', '华硕有限公司', '2016-09-11 06:53:00', '管理员', 'ee', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827021', '19', '12578.00', 'a', '华硕有限公司', '2016-09-12 06:53:00', '管理员', 'aa', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827022', '20', '12579.00', 'd', 'vivo智能手机有限公司', '2016-09-13 06:53:00', '管理员', 'dw', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827023', '21', '12580.00', 's', 'vivo智能手机有限公司', '2016-09-14 06:53:00', '管理员', 'wqa', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827024', '22', '12581.00', 'w', 'vivo智能手机有限公司', '2016-09-15 06:53:00', '管理员', 'we', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827025', '23', '12582.00', 'y', 'vivo智能手机有限公司', '2016-09-16 06:53:00', '管理员', 'ee', '现金');
INSERT INTO `tb_sell_main` VALUES ('XS20160827026', '24', '12583.00', 'a', '微软公司', '2016-09-17 06:53:00', '管理员', 'aa', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827027', '25', '12584.00', 'd', '微软公司', '2016-09-18 06:53:00', '管理员', 'dw', '支票');
INSERT INTO `tb_sell_main` VALUES ('XS20160827028', '26', '12585.00', 's', '微软公司', '2016-09-19 06:53:00', '管理员', 'wqa', '现金');

-- ----------------------------
-- Table structure for `tb_spinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_spinfo`;
CREATE TABLE `tb_spinfo` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `spname` varchar(100) DEFAULT NULL,
  `jc` varchar(100) DEFAULT NULL,
  `cd` varchar(100) DEFAULT NULL,
  `dw` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `bz` varchar(100) DEFAULT NULL,
  `ph` varchar(100) DEFAULT NULL,
  `pzwh` varchar(100) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  `gysname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gg` (`gg`),
  KEY `spname` (`spname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_spinfo
-- ----------------------------
INSERT INTO `tb_spinfo` VALUES ('sp1001', '2016LV春夏新款', 'LV女装', '山东滨州', '件', '123', '单件封装', '321', 'WERT1242', '贵重物品', '阿里巴巴股份制有限公司');
INSERT INTO `tb_spinfo` VALUES ('sp1002', '2016VANS新款', 'VANS', '芬兰', '双', 'TT123', '单件封装', '12', 'EE321', '无', '京东商城');
INSERT INTO `tb_spinfo` VALUES ('sp1003', '美国国债', '美国国债', 'USA', '股', 'TT456', '无', '5', 'YY654', '贵', '美国联合储蓄银行');
INSERT INTO `tb_spinfo` VALUES ('sp1004', '2016SKII-2神仙水护肤套装', 'SKII-2', '韩国首尔化妆品旗舰店', '盒', 'UU88', '超级好的包装', '77', 'OK', '贵的要死', '聚美优品');
INSERT INTO `tb_spinfo` VALUES ('sp1005', '黄金', '黄金', '迪拜地下金矿', '克', 'OO44', '密封', '9', '444', '这玩意不能乱碰', '迪拜皇室');
INSERT INTO `tb_spinfo` VALUES ('sp1006', '韩束2016新款面膜', '面膜', '滨州无棣', '一包', 'TY88', '5片一盒', '899', 'YYYYY', '挺好用的', '聚美优品');
INSERT INTO `tb_spinfo` VALUES ('sp1008', '阿米卡星药品', '阿米卡星', '成都', '盒', 'TT203', '单件封装', '424', 'DE', '无', '成都利尔药业');
INSERT INTO `tb_spinfo` VALUES ('sp1009', '环丙沙星药品', '环丙沙星', '成都', '盒', 'TT204', '单件封装', '425', 'SDWE', '无', '成都利尔药业');
INSERT INTO `tb_spinfo` VALUES ('sp1010', '头孢克洛药品', '头孢克洛', '四川', '盒', 'TT205', '单件封装', '426', 'SDWE', '无', '四川合信药厂');
INSERT INTO `tb_spinfo` VALUES ('sp1011', '吉他霉素药品', '吉他霉素', '成都', '盒', 'TT206', '单件封装', '152', 'AS', '无', '成都利尔药业');
INSERT INTO `tb_spinfo` VALUES ('sp1012', '土霉素药品', '土霉素', '四川', '盒', 'TT207', '单件封装', '153', 'ACS', '无', '四川合信药厂');
INSERT INTO `tb_spinfo` VALUES ('sp1013', '多西环素药品', '多西环素', '成都', '盒', 'TT208', '单件封装', '154', 'DE', '无', '成都利尔药业');
INSERT INTO `tb_spinfo` VALUES ('sp1014', '叫沙霉素药品', '叫沙霉素', '四川', '盒', 'TT209', '单件封装', '155', 'SDWE', '无', '四川合信药厂');
INSERT INTO `tb_spinfo` VALUES ('sp1015', '阿斯林药品', '阿斯林', '成都', '盒', 'TT210', '单件封装', '156', 'SDWE', '无', '成都永安制药');
INSERT INTO `tb_spinfo` VALUES ('sp1016', '克林霉素药品', '克林霉素', '成都', '盒', 'TT211', '单件封装', '634', 'AS', '无', '成都永安制药');
INSERT INTO `tb_spinfo` VALUES ('sp1017', '婴儿健脾散药品', '婴儿健脾散', '四川', '盒', 'TT212', '单件封装', '635', 'ACS', '无', '四川爱丽丝制药');
INSERT INTO `tb_spinfo` VALUES ('sp1018', '替硝锉药品', '替硝锉', '四川', '盒', 'TT213', '单件封装', '636', 'DE', '无', '四川爱丽丝制药');
INSERT INTO `tb_spinfo` VALUES ('sp1019', '利巴韦林药品', '利巴韦林', '四川', '盒', 'TT214', '单件封装', '637', 'SDWE', '无', '四川爱丽丝制药');
INSERT INTO `tb_spinfo` VALUES ('sp1020', '平凡的世界书', '平凡的世界', '山东', '本', 'UU321', '按包封装', '238', 'DWE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1021', '挪威的森林书', '挪威的森林', '河南', '本', 'UU322', '按包封装', '239', 'AS', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1022', '苏菲的世界书', '苏菲的世界', '山东', '本', 'UU323', '按包封装', '240', 'ACS', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1023', '十日谈书', '十日谈', '山东', '本', 'UU324', '按包封装', '241', 'DE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1024', '白鹿原书', '白鹿原', '北京', '本', 'UU325', '按包封装', '242', 'SDWE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1025', '活着书', '活着', '山东', '本', 'UU326', '按包封装', '243', 'DWE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1026', '牛虻书', '牛虻', '山东', '本', 'UU327', '按包封装', '244', 'AS', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1027', '麦田的守望者书', '麦田的守望者', '云南', '本', 'UU328', '按包封装', '245', 'ACS', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1028', '呼啸山庄书', '呼啸山庄', '山东', '本', 'UU329', '按包封装', '246', 'DE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1029', '生命从明天开始书', '生命从明天开始', '山东', '本', 'UU330', '按包封装', '247', 'SDWE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1030', '钢铁是怎样炼成的书', '钢铁是怎样炼成的', '山东', '本', 'UU331', '按包封装', '248', 'DWE', '无', '新华书店总店');
INSERT INTO `tb_spinfo` VALUES ('sp1031', '婚纱服装', '婚纱', '北京', '件', 'II342', '单件封装', '843', 'WWEF', '无', '58同城公司');
INSERT INTO `tb_spinfo` VALUES ('sp1032', '时尚新款服装', '时尚新款', '天津', '件', 'II343', '单件封装', '844', 'WWEF', '无', '阿里巴巴公司');
INSERT INTO `tb_spinfo` VALUES ('sp1033', '2016新款服装', '2016新款', '广州', '件', 'II344', '单件封装', '845', 'WWEF', '无', '楚楚街公司');

-- ----------------------------
-- Table structure for `tb_sxth_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sxth_detail`;
CREATE TABLE `tb_sxth_detail` (
  `xsthid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `dj` decimal(20,2) DEFAULT NULL,
  `sl` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_sxth_detail
-- ----------------------------
INSERT INTO `tb_sxth_detail` VALUES ('该', '表不使用', '1.00', null);
INSERT INTO `tb_sxth_detail` VALUES ('', null, null, null);

-- ----------------------------
-- Table structure for `tb_xsth`
-- ----------------------------
DROP TABLE IF EXISTS `tb_xsth`;
CREATE TABLE `tb_xsth` (
  `xsthid` varchar(255) NOT NULL,
  `pzno` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `khid` varchar(255) DEFAULT NULL,
  `xsthrq` datetime DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xsthid`,`pzno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_xsth
-- ----------------------------
INSERT INTO `tb_xsth` VALUES ('XK20160907005', '3', 'sp1004', '23.0 ', '11', '253.0 ', 'kh1005', '2016-08-28 07:03:00', 'a', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907006', '4', 'sp1005', '2.0 ', '2', '4.0 ', 'kh1006', '2016-08-29 07:03:00', 'b', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907007', '5', 'sp1006', '45.0 ', '3', '135.0 ', 'kh1007', '2016-08-30 07:03:00', 'e', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907008', '6', 'sp1007', '46.0 ', '4', '184.0 ', 'kh1008', '2016-08-31 07:03:00', 's', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907009', '7', 'sp1008', '47.0 ', '5', '235.0 ', 'kh1009', '2016-09-01 07:03:00', 'y', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907010', '8', 'sp1009', '48.0 ', '6', '288.0 ', 'kh1010', '2016-09-02 07:03:00', 'a', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907011', '9', 'sp1010', '49.0 ', '7', '343.0 ', 'kh1011', '2016-09-03 07:03:00', 'b', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907012', '10', 'sp1011', '50.0 ', '8', '400.0 ', 'kh1012', '2016-09-04 07:03:00', 'e', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907013', '11', 'sp1012', '51.0 ', '9', '459.0 ', 'kh1013', '2016-09-05 07:03:00', 's', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907014', '12', 'sp1013', '52.0 ', '10', '520.0 ', 'kh1014', '2016-09-06 07:03:00', 'y', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907015', '13', 'sp1014', '53.0 ', '11', '583.0 ', 'kh1015', '2016-09-07 07:03:00', 'a', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907016', '14', 'sp1015', '4.0 ', '32', '128.0 ', 'kh1016', '2016-09-08 07:03:00', 'b', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907017', '15', 'sp1016', '5.0 ', '33', '165.0 ', 'kh1017', '2016-09-09 07:03:00', 'e', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907018', '16', 'sp1017', '6.0 ', '34', '204.0 ', 'kh1018', '2016-09-10 07:03:00', 's', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907019', '17', 'sp1018', '7.0 ', '35', '245.0 ', 'kh1019', '2016-09-11 07:03:00', 'y', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907020', '18', 'sp1019', '8.0 ', '36', '288.0 ', 'kh1020', '2016-09-12 07:03:00', 'a', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907021', '19', 'sp1020', '88.0 ', '37', '3256.0 ', 'kh1004', '2016-09-13 07:03:00', 'b', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907022', '20', 'sp1021', '89.0 ', '38', '3382.0 ', 'kh1005', '2016-09-14 07:03:00', 'e', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907023', '21', 'sp1022', '90.0 ', '39', '3510.0 ', 'kh1006', '2016-09-15 07:03:00', 's', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907024', '22', 'sp1023', '91.0 ', '20', '1820.0 ', 'kh1007', '2016-09-16 07:03:00', 'y', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907025', '23', 'sp1024', '92.0 ', '21', '1932.0 ', 'kh1008', '2016-09-17 07:03:00', 'a', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907026', '24', 'sp1025', '93.0 ', '22', '2046.0 ', 'kh1009', '2016-09-18 07:03:00', 'b', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907027', '25', 'sp1026', '94.0 ', '23', '2162.0 ', 'kh1010', '2016-09-19 07:03:00', 'e', '支票');
INSERT INTO `tb_xsth` VALUES ('XK20160907028', '26', 'sp1027', '95.0 ', '24', '2280.0 ', 'kh1011', '2016-09-20 07:03:00', 's', '现金');
INSERT INTO `tb_xsth` VALUES ('XK20160907029', '27', 'sp1028', '96.0 ', '25', '2400.0 ', 'kh1012', '2016-09-21 07:03:00', 'y', '支票');
INSERT INTO `tb_xsth` VALUES ('XT20160827001', '0', 'sp1005', '333.0', '33', '10989.0', 'kh1004', '2016-08-27 07:03:07', 'rr', '现金');
INSERT INTO `tb_xsth` VALUES ('XT20160827001', '1', 'sp1003', '222.0', '22', '4884.0', 'kh1004', '2016-08-27 07:03:07', 'rr', '现金');

-- ----------------------------
-- Table structure for `tb_xsth_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_xsth_detail`;
CREATE TABLE `tb_xsth_detail` (
  `xsthid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `dj` decimal(20,2) DEFAULT NULL,
  `sl` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_xsth_detail
-- ----------------------------
INSERT INTO `tb_xsth_detail` VALUES ('XT20160827001', 'sp1005', '333.00', '33');
INSERT INTO `tb_xsth_detail` VALUES ('XT20160827001', 'sp1003', '222.00', '22');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907005', 'sp1004', '23.00', '11');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907006', 'sp1005', '2.00', '2');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907007', 'sp1006', '45.00', '3');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907008', 'sp1007', '46.00', '4');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907009', 'sp1008', '47.00', '5');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907010', 'sp1009', '48.00', '6');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907011', 'sp1010', '49.00', '7');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907012', 'sp1011', '50.00', '8');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907013', 'sp1012', '51.00', '9');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907014', 'sp1013', '52.00', '10');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907015', 'sp1014', '53.00', '11');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907016', 'sp1015', '4.00', '32');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907017', 'sp1016', '5.00', '33');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907018', 'sp1017', '6.00', '34');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907019', 'sp1018', '7.00', '35');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907020', 'sp1019', '8.00', '36');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907021', 'sp1020', '88.00', '37');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907022', 'sp1021', '89.00', '38');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907023', 'sp1022', '90.00', '39');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907024', 'sp1023', '91.00', '20');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907025', 'sp1024', '92.00', '21');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907026', 'sp1025', '93.00', '22');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907027', 'sp1026', '94.00', '23');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907028', 'sp1027', '95.00', '24');
INSERT INTO `tb_xsth_detail` VALUES ('XK20160907029', 'sp1028', '96.00', '25');

-- ----------------------------
-- Table structure for `tb_xsth_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_xsth_main`;
CREATE TABLE `tb_xsth_main` (
  `xsthid` varchar(100) NOT NULL DEFAULT '',
  `pzs` int(100) DEFAULT NULL,
  `je` decimal(20,2) DEFAULT NULL,
  `ysjl` varchar(100) DEFAULT NULL,
  `khname` varchar(100) DEFAULT NULL,
  `thdate` datetime DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`xsthid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_xsth_main
-- ----------------------------
INSERT INTO `tb_xsth_main` VALUES ('XK20160907005', '3', '253.00', 'a', 'vivo智能手机有限公司', '2016-08-28 07:03:00', '管理员', 'a', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907006', '4', '4.00', 'b', 'vivo智能手机有限公司', '2016-08-29 07:03:00', '管理员', 'dw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907007', '5', '135.00', 'e', 'vivo智能手机有限公司', '2016-08-30 07:03:00', '管理员', 're', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907008', '6', '184.00', 's', '华硕有限公司', '2016-08-31 07:03:00', '管理员', 'w', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907009', '7', '235.00', 'y', 'vivo智能手机有限公司', '2016-09-01 07:03:00', '管理员', 'qw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907010', '8', '288.00', 'a', 'vivo智能手机有限公司', '2016-09-02 07:03:00', '管理员', 'ee', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907011', '9', '343.00', 'b', 'vivo智能手机有限公司', '2016-09-03 07:03:00', '管理员', 'a', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907012', '10', '400.00', 'e', 'vivo智能手机有限公司', '2016-09-04 07:03:00', '管理员', 'dw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907013', '11', '459.00', 's', '华硕有限公司', '2016-09-05 07:03:00', '管理员', 're', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907014', '12', '520.00', 'y', '华硕有限公司', '2016-09-06 07:03:00', '管理员', 'w', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907015', '13', '583.00', 'a', '微软公司', '2016-09-07 07:03:00', '管理员', 'qw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907016', '14', '128.00', 'b', '华硕有限公司', '2016-09-08 07:03:00', '管理员', 'ee', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907017', '15', '165.00', 'e', '华硕有限公司', '2016-09-09 07:03:00', '管理员', 'a', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907018', '16', '204.00', 's', '华硕有限公司', '2016-09-10 07:03:00', '管理员', 'dw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907019', '17', '245.00', 'y', '微软公司', '2016-09-11 07:03:00', '管理员', 're', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907020', '18', '288.00', 'a', '微软公司', '2016-09-12 07:03:00', '管理员', 'w', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907021', '19', '3256.00', 'b', '微软公司', '2016-09-13 07:03:00', '管理员', 'qw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907022', '20', '3382.00', 'e', '微软公司', '2016-09-14 07:03:00', '管理员', 'ee', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907023', '21', '3510.00', 's', '微软公司', '2016-09-15 07:03:00', '管理员', 'a', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907024', '22', '1820.00', 'y', '华为手机公司', '2016-09-16 07:03:00', '管理员', 'dw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907025', '23', '1932.00', 'a', '华为手机公司', '2016-09-17 07:03:00', '管理员', 're', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907026', '24', '2046.00', 'b', '华为手机公司', '2016-09-18 07:03:00', '管理员', 'w', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907027', '25', '2162.00', 'e', '华为手机公司', '2016-09-19 07:03:00', '管理员', 'qw', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907028', '26', '2280.00', 's', '华为手机公司', '2016-09-20 07:03:00', '管理员', 'ee', '支票');
INSERT INTO `tb_xsth_main` VALUES ('XK20160907029', '27', '2400.00', 'y', '华为手机公司', '2016-09-21 07:03:00', '管理员', 'a', '现金');
INSERT INTO `tb_xsth_main` VALUES ('XT20160827001', '2', '15873.00', 'y', 'vivo智能手机有限公司', '2016-08-27 07:03:07', '管理员', 'rr', '现金');

-- ----------------------------
-- Table structure for `tb_yhlist`
-- ----------------------------
DROP TABLE IF EXISTS `tb_yhlist`;
CREATE TABLE `tb_yhlist` (
  `name` varchar(100) DEFAULT '',
  `username` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) DEFAULT NULL,
  `qx` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_yhlist
-- ----------------------------
INSERT INTO `tb_yhlist` VALUES ('管理员', '123', '123', '1');
INSERT INTO `tb_yhlist` VALUES ('管理员', '222', '222', '1');
INSERT INTO `tb_yhlist` VALUES ('系统管理员', '321', '321', '1');
INSERT INTO `tb_yhlist` VALUES ('管理员', '啦', '111', '1');
INSERT INTO `tb_yhlist` VALUES ('管理员', '蔻', '1234', '1');
INSERT INTO `tb_yhlist` VALUES ('管理员', '该亚科技', '123', '1');

-- ----------------------------
-- Table structure for `v_rkthview`
-- ----------------------------
DROP TABLE IF EXISTS `v_rkthview`;
CREATE TABLE `v_rkthview` (
  `rkthid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `spname` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `dj` varchar(100) DEFAULT NULL,
  `je` varchar(100) DEFAULT NULL,
  `gys` varchar(100) DEFAULT NULL,
  `thrq` varchar(100) DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  `sl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rkthid`),
  KEY `spid` (`spid`),
  KEY `spname` (`spname`),
  KEY `gg` (`gg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_rkthview
-- ----------------------------
INSERT INTO `v_rkthview` VALUES ('RT20160425001', 'sp1002', '2016VANS新款', 'TT123', '4.00', '22.0', '京东商城', '2016-04-25 09:02:56', '系统管理员', '22', '现金', '44');
INSERT INTO `v_rkthview` VALUES ('RT20160426002', 'sp1002', '2016VANS新款', 'TT123', '4.00', '22.0', '阿里巴巴股份制有限公司', '2016-04-25 09:02:56', '系统管理员', '22', '现金', '44');
INSERT INTO `v_rkthview` VALUES ('RT20160427001', 'sp1003', '韩束2016新款面膜', 'TT456', '4', '160.0', '聚美优品', '2016-04-26 15:53:20', '系统管理员', '22', '现金', '40');
INSERT INTO `v_rkthview` VALUES ('RT20160907005', 'sp1009', '环丙沙星药品', 'TT458', '425.00 ', '1275.0 ', '聚美优品', '2016/4/28 15:53', '管理员', '24', '支票', '20');
INSERT INTO `v_rkthview` VALUES ('RT20160907006', 'sp1010', '头孢克洛药品', 'TT123', '426.00 ', '1278.0 ', '聚美优品', '2016/4/29 15:53', '管理员', '25', '支票', '10');
INSERT INTO `v_rkthview` VALUES ('RT20160907007', 'sp1011', '吉他霉素药品', 'TT124', '152.00 ', '456.0 ', '聚美优品', '2016/4/30 15:53', '管理员', '26', '现金', '23');
INSERT INTO `v_rkthview` VALUES ('RT20160907008', 'sp1012', '土霉素药品', 'TT125', '153.00 ', '459.0 ', '成都利尔药业', '2016/5/1 15:53', '管理员', '27', '支票', '24');
INSERT INTO `v_rkthview` VALUES ('RT20160907009', 'sp1013', '多西环素药品', 'TT126', '154.00 ', '462.0 ', '成都利尔药业', '2016/5/2 15:53', '管理员', '28', '支票', '25');
INSERT INTO `v_rkthview` VALUES ('RT20160907010', 'sp1014', '叫沙霉素药品', 'TT127', '155.00 ', '465.0 ', '成都利尔药业', '2016/5/3 15:53', '管理员', '29', '现金', '26');
INSERT INTO `v_rkthview` VALUES ('RT20160907011', 'sp1015', '阿斯林药品', 'TT128', '156.00 ', '468.0 ', '成都利尔药业', '2016/5/4 15:53', '管理员', '30', '支票', '27');
INSERT INTO `v_rkthview` VALUES ('RT20160907012', 'sp1016', '克林霉素药品', 'TT129', '634.00 ', '1902.0 ', '成都利尔药业', '2016/5/5 15:53', '管理员', '31', '支票', '28');
INSERT INTO `v_rkthview` VALUES ('RT20160907013', 'sp1017', '婴儿健脾散药品', 'TT466', '635.00 ', '1905.0 ', '成都利尔药业', '2016/5/6 15:53', '管理员', '32', '现金', '29');
INSERT INTO `v_rkthview` VALUES ('RT20160907014', 'sp1018', '替硝锉药品', 'TT467', '636.00 ', '1908.0 ', '成都利尔药业', '2016/5/7 15:53', '管理员', '33', '支票', '30');
INSERT INTO `v_rkthview` VALUES ('RT20160907015', 'sp1019', '利巴韦林药品', 'TT468', '637.00 ', '1911.0 ', '成都利尔药业', '2016/5/8 15:53', '管理员', '34', '支票', '63');
INSERT INTO `v_rkthview` VALUES ('RT20160907016', 'sp1020', '平凡的世界书', 'TT469', '238.00 ', '714.0 ', '新华书店总店', '2016/5/9 15:53', '管理员', '35', '现金', '64');
INSERT INTO `v_rkthview` VALUES ('RT20160907017', 'sp1021', '挪威的森林书', 'TT470', '239.00 ', '717.0 ', '新华书店总店', '2016/5/10 15:53', '管理员', '36', '支票', '65');
INSERT INTO `v_rkthview` VALUES ('RT20160907018', 'sp1022', '苏菲的世界书', 'TT31', '240.00 ', '720.0 ', '新华书店总店', '2016/5/11 15:53', '管理员', '37', '支票', '66');
INSERT INTO `v_rkthview` VALUES ('RT20160907019', 'sp1023', '十日谈书', 'TT32', '241.00 ', '723.0 ', '新华书店总店', '2016/5/12 15:53', '管理员', '38', '现金', '67');
INSERT INTO `v_rkthview` VALUES ('RT20160907020', 'sp1024', '白鹿原书', 'TT33', '242.00 ', '726.0 ', '新华书店总店', '2016/5/13 15:53', '管理员', '39', '支票', '68');
INSERT INTO `v_rkthview` VALUES ('RT20160907021', 'sp1025', '活着书', 'TT34', '243.00 ', '729.0 ', '新华书店总店', '2016/5/14 15:53', '管理员', '40', '支票', '2');
INSERT INTO `v_rkthview` VALUES ('RT20160907022', 'sp1026', '牛虻书', 'TT35', '244.00 ', '732.0 ', '新华书店总店', '2016/5/15 15:53', '管理员', '41', '现金', '3');
INSERT INTO `v_rkthview` VALUES ('RT20160907023', 'sp1027', '麦田的守望者书', 'TT36', '245.00 ', '735.0 ', '淘宝网', '2016/5/16 15:53', '管理员', '42', '支票', '4');
INSERT INTO `v_rkthview` VALUES ('RT20160907024', 'sp1028', '呼啸山庄书', 'TT37', '246.00 ', '738.0 ', '四川爱丽丝制药', '2016/5/17 15:53', '管理员', '43', '支票', '5');
INSERT INTO `v_rkthview` VALUES ('RT20160907025', 'sp1029', '生命从明天开始书', 'TT38', '247.00 ', '741.0 ', '淘宝网', '2016/5/18 15:53', '管理员', '44', '现金', '6');
INSERT INTO `v_rkthview` VALUES ('RT20160907026', 'sp1030', '钢铁是怎样炼成的书', 'TT39', '248.00 ', '744.0 ', '四川爱丽丝制药', '2016/5/19 15:53', '管理员', '45', '支票', '7');
INSERT INTO `v_rkthview` VALUES ('RT20160907027', 'sp1031', '婚纱服装', 'TT40', '843.00 ', '2529.0 ', '淘宝网', '2016/5/20 15:53', '管理员', '46', '支票', '8');
INSERT INTO `v_rkthview` VALUES ('RT20160907028', 'sp1032', '时尚新款服装', 'TT41', '844.00 ', '2532.0 ', '四川爱丽丝制药', '2016/5/21 15:53', '管理员', '47', '现金', '9');
INSERT INTO `v_rkthview` VALUES ('RT20160907029', 'sp1033', '2016新款服装', 'TT42', '845.00 ', '2535.0 ', '聚美优品', '2016/5/22 15:53', '管理员', '48', '支票', '10');

-- ----------------------------
-- Table structure for `v_rukuview`
-- ----------------------------
DROP TABLE IF EXISTS `v_rukuview`;
CREATE TABLE `v_rukuview` (
  `tkid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `spname` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `dj` varchar(100) DEFAULT NULL,
  `sl` varchar(100) DEFAULT NULL,
  `je` varchar(100) DEFAULT NULL,
  `gys` varchar(100) DEFAULT NULL,
  `tkrq` varchar(100) DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_rukuview
-- ----------------------------
INSERT INTO `v_rukuview` VALUES ('', '', '', '', '', '', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('010901', '010901', '新鲜水果', '30', '30', '果', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('020306', '020306', '防蛀防霉品', '12', '12', '消', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('034706', '034706', '盆类', '10', '10', '（150）', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('040107', '', '儿童内衣', null, null, null, null, null, null, null, null, null);
INSERT INTO `v_rukuview` VALUES ('040903', '040903', '学步车', '', '', '', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('060212', '060212', '排插', '25', '25', '金', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('060213', '060213', '墙壁插座', '10', '10', '（130）', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('060216', '060216', '节能灯', '15', '15', '', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('060217', '060217', '小夜灯', '', '', '', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('070101', '070101', '综合小类', '', '', '自', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('070102', '070102', '蔬菜', '30', '30', '营', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('070103', '070103', '水果', '15', '15', '生', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('070104', '070104', '鸡蛋', '5', '5', '鲜', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('080101', '080101', '农副产品小类', '10', '10', '(60)', null, null, null, '', null, null);
INSERT INTO `v_rukuview` VALUES ('11', '11', '11', '11', '1', '11', '11', '11', '111', '11', '11', '11');
INSERT INTO `v_rukuview` VALUES ('2', '2', '22', '22', '22', '22', '22', '2', '22', '222', '2', '22');
INSERT INTO `v_rukuview` VALUES ('小类编号', '小类编号', '商品小类', '计划品项', '计划品项', '商品中类', null, null, null, '实际品项', null, null);

-- ----------------------------
-- Table structure for `v_sellview`
-- ----------------------------
DROP TABLE IF EXISTS `v_sellview`;
CREATE TABLE `v_sellview` (
  `sellid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `spname` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `dj` varchar(100) DEFAULT NULL,
  `sl` varchar(100) DEFAULT NULL,
  `je` varchar(100) DEFAULT NULL,
  `khname` varchar(100) DEFAULT NULL,
  `thrq` varchar(100) DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsr` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sellid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_sellview
-- ----------------------------
INSERT INTO `v_sellview` VALUES ('RT20160907005', 'sp1009', '环丙沙星药品', 'TT458', '23.00 ', '1275', '29325.0 ', '聚美优品', '2016/4/27 3:47', '管理员', '24', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907006', 'sp1010', '头孢克洛药品', 'TT123', '12.00 ', '1278', '15336.0 ', '聚美优品', '2016/4/28 3:47', '管理员', '25', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907007', 'sp1011', '吉他霉素药品', 'TT124', '1.00 ', '456', '456.0 ', '成都利尔药业', '2016/4/29 3:47', '管理员', '26', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907008', 'sp1012', '土霉素药品', 'TT125', '3.00 ', '459', '1377.0 ', '成都利尔药业', '2016/4/30 3:47', '管理员', '27', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907009', 'sp1013', '多西环素药品', 'TT126', '5.00 ', '462', '2310.0 ', '成都利尔药业', '2016/5/1 3:47', '管理员', '28', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907010', 'sp1014', '叫沙霉素药品', 'TT127', '7.00 ', '465', '3255.0 ', '成都利尔药业', '2016/5/2 3:47', '管理员', '29', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907011', 'sp1015', '阿斯林药品', 'TT128', '9.00 ', '468', '4212.0 ', '成都利尔药业', '2016/5/3 3:47', '管理员', '30', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907012', 'sp1016', '克林霉素药品', 'TT129', '11.00 ', '1902', '20922.0 ', '成都利尔药业', '2016/5/4 3:47', '管理员', '31', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907013', 'sp1017', '婴儿健脾散药品', 'TT466', '13.00 ', '1905', '24765.0 ', '成都利尔药业', '2016/5/5 3:47', '管理员', '32', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907014', 'sp1018', '替硝锉药品', 'TT467', '15.00 ', '1908', '28620.0 ', '成都利尔药业', '2016/5/6 3:47', '管理员', '33', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907015', 'sp1019', '利巴韦林药品', 'TT468', '17.00 ', '1911', '32487.0 ', '新华书店总店', '2016/5/7 3:47', '管理员', '34', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907016', 'sp1020', '平凡的世界书', 'TT469', '19.00 ', '714', '13566.0 ', '新华书店总店', '2016/5/8 3:47', '管理员', '35', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907017', 'sp1021', '挪威的森林书', 'TT470', '21.00 ', '717', '15057.0 ', '新华书店总店', '2016/5/9 3:47', '管理员', '36', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907018', 'sp1022', '苏菲的世界书', 'TT31', '23.00 ', '720', '16560.0 ', '新华书店总店', '2016/5/10 3:47', '管理员', '37', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907019', 'sp1023', '十日谈书', 'TT32', '25.00 ', '723', '18075.0 ', '新华书店总店', '2016/5/11 3:47', '管理员', '38', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907020', 'sp1024', '白鹿原书', 'TT33', '27.00 ', '726', '19602.0 ', '新华书店总店', '2016/5/12 3:47', '管理员', '39', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907021', 'sp1025', '活着书', 'TT34', '29.00 ', '729', '21141.0 ', '新华书店总店', '2016/5/13 3:47', '管理员', '40', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907022', 'sp1026', '牛虻书', 'TT35', '31.00 ', '732', '22692.0 ', '淘宝网', '2016/5/14 3:47', '管理员', '41', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907023', 'sp1027', '麦田的守望者书', 'TT36', '33.00 ', '735', '24255.0 ', '四川爱丽丝制药', '2016/5/15 3:47', '管理员', '42', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907024', 'sp1028', '呼啸山庄书', 'TT37', '35.00 ', '738', '25830.0 ', '淘宝网', '2016/5/16 3:47', '管理员', '43', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907025', 'sp1029', '生命从明天开始书', 'TT38', '37.00 ', '741', '27417.0 ', '四川爱丽丝制药', '2016/5/17 3:47', '管理员', '44', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907026', 'sp1030', '钢铁是怎样炼成的书', 'TT39', '39.00 ', '744', '29016.0 ', '淘宝网', '2016/5/18 3:47', '管理员', '45', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907027', 'sp1031', '婚纱服装', 'TT40', '41.00 ', '2529', '103689.0 ', '四川爱丽丝制药', '2016/5/19 3:47', '管理员', '46', '支票');
INSERT INTO `v_sellview` VALUES ('RT20160907028', 'sp1032', '时尚新款服装', 'TT41', '43.00 ', '2532', '108876.0 ', '聚美优品', '2016/5/20 3:47', '管理员', '47', '现金');
INSERT INTO `v_sellview` VALUES ('RT20160907029', 'sp1033', '2016新款服装', 'TT42', '45.00 ', '2535', '114075.0 ', '聚美优品', '2016/5/21 3:47', '管理员', '48', '支票');
INSERT INTO `v_sellview` VALUES ('XS20160426005', 'sp1003', '美国国债', 'TT456', '44.00', '44', '1936.00', '联想股份有限公司', '2016-04-26 02:35:14', '系统管理员', '44', '现金');
INSERT INTO `v_sellview` VALUES ('XS20160426006', 'sp1007', '韩束2016新款面膜', 'TY88', '13.00', '10', '130.00', 'Apple有限公司', '2016-04-26 02:40:33', '系统管理员', 'ss', '现金');
INSERT INTO `v_sellview` VALUES ('XS20160426007', 'sp1007', '韩束2016新款面膜', 'TY88', '50.00', '50', '500.00', 'Apple有限公司', '2016-04-26 02:43:51', '系统管理员', 'ss', '现金');
INSERT INTO `v_sellview` VALUES ('XS20160426008', 'sp1003', '美国国债', 'TT456', '100.0', '10', '1000.00', 'Apple有限公司', '2016-04-26 03:47:34', '系统管理员', 'ss', '支票');

-- ----------------------------
-- Table structure for `v_xsthview`
-- ----------------------------
DROP TABLE IF EXISTS `v_xsthview`;
CREATE TABLE `v_xsthview` (
  `xsthid` varchar(100) NOT NULL DEFAULT '',
  `spid` varchar(100) DEFAULT NULL,
  `spname` varchar(100) DEFAULT NULL,
  `gg` varchar(100) DEFAULT NULL,
  `dj` varchar(100) DEFAULT NULL,
  `sl` varchar(100) DEFAULT NULL,
  `je` varchar(100) DEFAULT NULL,
  `khmc` varchar(100) DEFAULT NULL,
  `thrq` varchar(100) DEFAULT NULL,
  `czy` varchar(100) DEFAULT NULL,
  `jsy` varchar(100) DEFAULT NULL,
  `jsfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`xsthid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_xsthview
-- ----------------------------
INSERT INTO `v_xsthview` VALUES ('XT20160426003', 'sp1007', '韩束2016新款面膜', 'TY88', '10.00', '5', '50', 'Apple有限公司', '2016-04-26 02:42:28', '系统管理员', 'ss', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160426004', 'sp1007', '韩束2016新款面膜', 'TY88', '10.00', '4', '40', 'Apple有限公司', '2016-04-26 03:50:30', '系统管理员', 'ss', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907005', 'sp1009', '环丙沙星药品', 'TT458', '23', '1275', '29325', '聚美优品', '2016/4/27 3:47', '管理员', '24', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907006', 'sp1010', '头孢克洛药品', 'TT123', '12', '1278', '15336', '聚美优品', '2016/4/28 3:47', '管理员', '25', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907007', 'sp1011', '吉他霉素药品', 'TT124', '1', '456', '456', '成都利尔药业', '2016/4/29 3:47', '管理员', '26', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907008', 'sp1012', '土霉素药品', 'TT125', '3', '459', '1377', '成都利尔药业', '2016/4/30 3:47', '管理员', '27', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907009', 'sp1013', '多西环素药品', 'TT126', '5', '462', '2310', '成都利尔药业', '2016/5/1 3:47', '管理员', '28', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907010', 'sp1014', '叫沙霉素药品', 'TT127', '7', '465', '3255', '成都利尔药业', '2016/5/2 3:47', '管理员', '29', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907011', 'sp1015', '阿斯林药品', 'TT128', '9', '468', '4212', '成都利尔药业', '2016/5/3 3:47', '管理员', '30', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907012', 'sp1016', '克林霉素药品', 'TT129', '11', '1902', '20922', '成都利尔药业', '2016/5/4 3:47', '管理员', '31', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907013', 'sp1017', '婴儿健脾散药品', 'TT466', '13', '1905', '24765', '成都利尔药业', '2016/5/5 3:47', '管理员', '32', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907014', 'sp1018', '替硝锉药品', 'TT467', '15', '1908', '28620', '成都利尔药业', '2016/5/6 3:47', '管理员', '33', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907015', 'sp1019', '利巴韦林药品', 'TT468', '17', '1911', '32487', '新华书店总店', '2016/5/7 3:47', '管理员', '34', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907016', 'sp1020', '平凡的世界书', 'TT469', '19', '714', '13566', '新华书店总店', '2016/5/8 3:47', '管理员', '35', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907017', 'sp1021', '挪威的森林书', 'TT470', '21', '717', '15057', '新华书店总店', '2016/5/9 3:47', '管理员', '36', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907018', 'sp1022', '苏菲的世界书', 'TT31', '23', '720', '16560', '新华书店总店', '2016/5/10 3:47', '管理员', '37', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907019', 'sp1023', '十日谈书', 'TT32', '25', '723', '18075', '新华书店总店', '2016/5/11 3:47', '管理员', '38', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907020', 'sp1024', '白鹿原书', 'TT33', '27', '726', '19602', '新华书店总店', '2016/5/12 3:47', '管理员', '39', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907021', 'sp1025', '活着书', 'TT34', '29', '729', '21141', '新华书店总店', '2016/5/13 3:47', '管理员', '40', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907022', 'sp1026', '牛虻书', 'TT35', '31', '732', '22692', '淘宝网', '2016/5/14 3:47', '管理员', '41', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907023', 'sp1027', '麦田的守望者书', 'TT36', '33', '735', '24255', '四川爱丽丝制药', '2016/5/15 3:47', '管理员', '42', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907024', 'sp1028', '呼啸山庄书', 'TT37', '35', '738', '25830', '淘宝网', '2016/5/16 3:47', '管理员', '43', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907025', 'sp1029', '生命从明天开始书', 'TT38', '37', '741', '27417', '四川爱丽丝制药', '2016/5/17 3:47', '管理员', '44', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907026', 'sp1030', '钢铁是怎样炼成的书', 'TT39', '39', '744', '29016', '淘宝网', '2016/5/18 3:47', '管理员', '45', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907027', 'sp1031', '婚纱服装', 'TT40', '41', '2529', '103689', '四川爱丽丝制药', '2016/5/19 3:47', '管理员', '46', '支票');
INSERT INTO `v_xsthview` VALUES ('XT20160907028', 'sp1032', '时尚新款服装', 'TT41', '43', '2532', '108876', '聚美优品', '2016/5/20 3:47', '管理员', '47', '现金');
INSERT INTO `v_xsthview` VALUES ('XT20160907029', 'sp1033', '2016新款服装', 'TT42', '45', '2535', '114075', '聚美优品', '2016/5/21 3:47', '管理员', '48', '支票');

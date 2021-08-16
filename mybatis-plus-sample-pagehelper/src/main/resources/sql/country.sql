/*
 Navicat MySQL Data Transfer

 Source Server         : 00
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : my-plus

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 16/08/2021 11:03:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '美国，加拿大', '1');
INSERT INTO `country` VALUES (2, '哈萨克斯坦，俄罗斯', '7');
INSERT INTO `country` VALUES (3, '埃及', '20');
INSERT INTO `country` VALUES (4, '南非', '27');
INSERT INTO `country` VALUES (5, '希腊', '30');
INSERT INTO `country` VALUES (6, '荷兰', '31');
INSERT INTO `country` VALUES (7, '比利时', '32');
INSERT INTO `country` VALUES (8, '法国', '33');
INSERT INTO `country` VALUES (9, '西班牙', '34');
INSERT INTO `country` VALUES (10, '匈牙利', '36');
INSERT INTO `country` VALUES (11, '意大利', '39');
INSERT INTO `country` VALUES (12, '罗马尼亚', '40');
INSERT INTO `country` VALUES (13, '瑞士', '41');
INSERT INTO `country` VALUES (14, '奥地利', '43');
INSERT INTO `country` VALUES (15, '根西，马恩，泽西，英国', '44');
INSERT INTO `country` VALUES (16, '丹麦', '45');
INSERT INTO `country` VALUES (17, '瑞典', '46');
INSERT INTO `country` VALUES (18, '挪威', '47');
INSERT INTO `country` VALUES (19, '波兰', '48');
INSERT INTO `country` VALUES (20, '德国', '49');
INSERT INTO `country` VALUES (21, '秘鲁', '51');
INSERT INTO `country` VALUES (22, '墨西哥', '52');
INSERT INTO `country` VALUES (23, '古巴', '53');
INSERT INTO `country` VALUES (24, '阿根廷', '54');
INSERT INTO `country` VALUES (25, '巴西', '55');
INSERT INTO `country` VALUES (26, '智利', '56');
INSERT INTO `country` VALUES (27, '哥伦比亚', '57');
INSERT INTO `country` VALUES (28, '委内瑞拉', '58');
INSERT INTO `country` VALUES (29, '马来西亚', '60');
INSERT INTO `country` VALUES (30, '澳大利亚', '61');
INSERT INTO `country` VALUES (31, '印度尼西亚', '62');
INSERT INTO `country` VALUES (32, '菲律宾', '63');
INSERT INTO `country` VALUES (33, '新西兰', '64');
INSERT INTO `country` VALUES (34, '新加坡', '65');
INSERT INTO `country` VALUES (35, '泰国', '66');
INSERT INTO `country` VALUES (36, '日本', '81');
INSERT INTO `country` VALUES (37, '韩国', '82');
INSERT INTO `country` VALUES (38, '越南', '84');
INSERT INTO `country` VALUES (39, '土耳其', '90');
INSERT INTO `country` VALUES (40, '印度', '91');
INSERT INTO `country` VALUES (41, '巴基斯坦', '92');
INSERT INTO `country` VALUES (42, '阿富汗', '93');
INSERT INTO `country` VALUES (43, '斯里兰卡', '94');
INSERT INTO `country` VALUES (44, '缅甸', '95');
INSERT INTO `country` VALUES (45, '伊朗', '98');
INSERT INTO `country` VALUES (46, '南苏丹', '211');
INSERT INTO `country` VALUES (47, '摩洛哥', '212');
INSERT INTO `country` VALUES (48, '阿尔及利亚', '213');
INSERT INTO `country` VALUES (49, '突尼斯', '216');
INSERT INTO `country` VALUES (50, '利比亚', '218');
INSERT INTO `country` VALUES (51, '冈比亚', '220');
INSERT INTO `country` VALUES (52, '塞内加尔', '221');
INSERT INTO `country` VALUES (53, '毛里塔尼亚', '222');
INSERT INTO `country` VALUES (54, '马里', '223');
INSERT INTO `country` VALUES (55, '科特迪瓦', '225');
INSERT INTO `country` VALUES (56, '布基纳法索', '226');
INSERT INTO `country` VALUES (57, '尼日尔', '227');
INSERT INTO `country` VALUES (58, '多哥', '228');
INSERT INTO `country` VALUES (59, '贝宁', '229');
INSERT INTO `country` VALUES (60, '毛里求斯', '230');
INSERT INTO `country` VALUES (61, '利比里亚', '231');
INSERT INTO `country` VALUES (62, '塞拉利昂', '232');
INSERT INTO `country` VALUES (63, '加纳', '233');
INSERT INTO `country` VALUES (64, '尼日利亚', '234');
INSERT INTO `country` VALUES (65, '乍得', '235');
INSERT INTO `country` VALUES (66, '中非共和国', '236');
INSERT INTO `country` VALUES (67, '喀麦隆', '237');
INSERT INTO `country` VALUES (68, '佛得角', '238');
INSERT INTO `country` VALUES (69, '赤道几内亚', '240');
INSERT INTO `country` VALUES (70, '加蓬', '241');
INSERT INTO `country` VALUES (71, '刚果', '242');
INSERT INTO `country` VALUES (72, '刚果民主共和国', '243');
INSERT INTO `country` VALUES (73, '安哥拉', '244');
INSERT INTO `country` VALUES (74, '几内亚比绍共和国', '245');
INSERT INTO `country` VALUES (75, '塞舌尔', '248');
INSERT INTO `country` VALUES (76, '苏丹', '249');
INSERT INTO `country` VALUES (77, '卢旺达', '250');
INSERT INTO `country` VALUES (78, '埃塞俄比亚', '251');
INSERT INTO `country` VALUES (79, '索马里', '252');
INSERT INTO `country` VALUES (80, '吉布提', '253');
INSERT INTO `country` VALUES (81, '肯尼亚', '254');
INSERT INTO `country` VALUES (82, '坦桑尼亚', '255');
INSERT INTO `country` VALUES (83, '乌干达', '256');
INSERT INTO `country` VALUES (84, '布隆迪', '257');
INSERT INTO `country` VALUES (85, '莫桑比克', '258');
INSERT INTO `country` VALUES (86, '赞比亚', '260');
INSERT INTO `country` VALUES (87, '马达加斯加', '261');
INSERT INTO `country` VALUES (88, '留尼旺', '262');
INSERT INTO `country` VALUES (89, '津巴布韦', '263');
INSERT INTO `country` VALUES (90, '纳米比亚', '264');
INSERT INTO `country` VALUES (91, '马拉维', '265');
INSERT INTO `country` VALUES (92, '莱索托', '266');
INSERT INTO `country` VALUES (93, '博茨瓦纳', '267');
INSERT INTO `country` VALUES (94, '斯威士兰', '268');
INSERT INTO `country` VALUES (95, '科摩罗', '269');
INSERT INTO `country` VALUES (96, '厄立特里亚', '291');
INSERT INTO `country` VALUES (97, '阿鲁巴', '297');
INSERT INTO `country` VALUES (98, '法罗群岛', '298');
INSERT INTO `country` VALUES (99, '格陵兰岛', '299');
INSERT INTO `country` VALUES (100, '直布罗陀', '350');
INSERT INTO `country` VALUES (101, '葡萄牙', '351');
INSERT INTO `country` VALUES (102, '卢森堡', '352');
INSERT INTO `country` VALUES (103, '爱尔兰', '353');
INSERT INTO `country` VALUES (104, '冰岛', '354');
INSERT INTO `country` VALUES (105, '阿尔巴尼亚', '355');
INSERT INTO `country` VALUES (106, '马耳他', '356');
INSERT INTO `country` VALUES (107, '塞浦路斯', '357');
INSERT INTO `country` VALUES (108, '芬兰', '358');
INSERT INTO `country` VALUES (109, '保加利亚', '359');
INSERT INTO `country` VALUES (110, '立陶宛', '370');
INSERT INTO `country` VALUES (111, '拉脱维亚', '371');
INSERT INTO `country` VALUES (112, '爱沙尼亚', '372');
INSERT INTO `country` VALUES (113, '摩尔多瓦', '373');
INSERT INTO `country` VALUES (114, '亚美尼亚', '374');
INSERT INTO `country` VALUES (115, '白俄罗斯', '375');
INSERT INTO `country` VALUES (116, '安道尔', '376');
INSERT INTO `country` VALUES (117, '摩纳哥', '377');
INSERT INTO `country` VALUES (118, '圣马力诺', '378');
INSERT INTO `country` VALUES (119, '乌克兰', '380');
INSERT INTO `country` VALUES (120, '科索沃，塞尔维亚', '381');
INSERT INTO `country` VALUES (121, '黑山共和国', '382');
INSERT INTO `country` VALUES (122, '克罗地亚', '385');
INSERT INTO `country` VALUES (123, '斯洛文尼亚', '386');
INSERT INTO `country` VALUES (124, '波黑', '387');
INSERT INTO `country` VALUES (125, '马其顿王国', '389');
INSERT INTO `country` VALUES (126, '捷克共和国', '420');
INSERT INTO `country` VALUES (127, '斯洛伐克', '421');
INSERT INTO `country` VALUES (128, '列支敦斯登', '423');
INSERT INTO `country` VALUES (129, '福克兰群岛', '500');
INSERT INTO `country` VALUES (130, '伯利兹', '501');
INSERT INTO `country` VALUES (131, '危地马拉', '502');
INSERT INTO `country` VALUES (132, '萨尔瓦多', '503');
INSERT INTO `country` VALUES (133, '洪都拉斯', '504');
INSERT INTO `country` VALUES (134, '尼加拉瓜', '505');
INSERT INTO `country` VALUES (135, '哥斯达黎加', '506');
INSERT INTO `country` VALUES (136, '巴拿马', '507');
INSERT INTO `country` VALUES (137, '海地', '509');
INSERT INTO `country` VALUES (138, '瓜德罗普', '590');
INSERT INTO `country` VALUES (139, '玻利维亚', '591');
INSERT INTO `country` VALUES (140, '圭亚那', '592');
INSERT INTO `country` VALUES (141, '厄瓜多尔', '593');
INSERT INTO `country` VALUES (142, '法属圭亚那', '594');
INSERT INTO `country` VALUES (143, '巴拉圭', '595');
INSERT INTO `country` VALUES (144, '马提尼克', '596');
INSERT INTO `country` VALUES (145, '苏里南', '597');
INSERT INTO `country` VALUES (146, '乌拉圭', '598');
INSERT INTO `country` VALUES (147, '荷属安德列斯群岛', '599');
INSERT INTO `country` VALUES (148, '东帝汶', '670');
INSERT INTO `country` VALUES (149, '关岛', '671');
INSERT INTO `country` VALUES (150, '文莱达鲁萨兰国', '673');
INSERT INTO `country` VALUES (151, '几内亚,巴布亚新几内亚', '675');
INSERT INTO `country` VALUES (152, '汤加', '676');
INSERT INTO `country` VALUES (153, '所罗门群岛', '677');
INSERT INTO `country` VALUES (154, '瓦努阿图', '678');
INSERT INTO `country` VALUES (155, '斐济', '679');
INSERT INTO `country` VALUES (156, '帕劳', '680');
INSERT INTO `country` VALUES (157, '库克群岛', '682');
INSERT INTO `country` VALUES (158, '美属萨摩亚,萨摩亚群岛', '684');
INSERT INTO `country` VALUES (159, '新喀里多尼亚', '687');
INSERT INTO `country` VALUES (160, '法属玻利尼西亚', '689');
INSERT INTO `country` VALUES (161, '朝鲜', '850');
INSERT INTO `country` VALUES (162, '中国香港', '852');
INSERT INTO `country` VALUES (163, '中国澳门', '853');
INSERT INTO `country` VALUES (164, '柬埔寨', '855');
INSERT INTO `country` VALUES (165, '老挝', '856');
INSERT INTO `country` VALUES (166, '孟加拉国', '880');
INSERT INTO `country` VALUES (167, '中国台湾', '886');
INSERT INTO `country` VALUES (168, '马尔代夫', '960');
INSERT INTO `country` VALUES (169, '黎巴嫩', '961');
INSERT INTO `country` VALUES (170, '约旦', '962');
INSERT INTO `country` VALUES (171, '阿拉伯叙利亚共和国', '963');
INSERT INTO `country` VALUES (172, '伊拉克', '964');
INSERT INTO `country` VALUES (173, '科威特', '965');
INSERT INTO `country` VALUES (174, '沙特阿拉伯', '966');
INSERT INTO `country` VALUES (175, '也门', '967');
INSERT INTO `country` VALUES (176, '阿曼', '968');
INSERT INTO `country` VALUES (177, '阿拉伯联合酋长国', '971');
INSERT INTO `country` VALUES (178, '以色列', '972');
INSERT INTO `country` VALUES (179, '巴林', '973');
INSERT INTO `country` VALUES (180, '卡塔尔', '974');
INSERT INTO `country` VALUES (181, '不丹', '975');
INSERT INTO `country` VALUES (182, '蒙古', '976');
INSERT INTO `country` VALUES (183, '尼泊尔', '977');
INSERT INTO `country` VALUES (184, '塔吉克斯坦', '992');
INSERT INTO `country` VALUES (185, '土库曼斯坦', '993');
INSERT INTO `country` VALUES (186, '阿塞拜疆', '994');
INSERT INTO `country` VALUES (187, '格鲁吉亚', '995');
INSERT INTO `country` VALUES (188, '吉尔吉斯斯坦', '996');
INSERT INTO `country` VALUES (189, '乌兹别克斯坦', '998');
INSERT INTO `country` VALUES (190, '巴哈马群岛', '1242');
INSERT INTO `country` VALUES (191, '巴巴多斯', '1246');
INSERT INTO `country` VALUES (192, '安圭拉岛', '1264');

SET FOREIGN_KEY_CHECKS = 1;

-- 当前脚本执行数据库的创建。
DROP DATABASE `secret_plat`;
CREATE DATABASE `secret_plat` CHARACTER SET utf8;
USE `secret_plat`;

-- 账户信息表
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`(
    `a_id` INT(5) UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '帐户ID',
    `a_name` VARCHAR(20) NOT NULL COMMENT '账户名称',
    `a_password` VARCHAR(50) NOT NULL COMMENT '账户密码（MD5密文）',
    `a_anonymous` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '所有内容匿名'
) CHARACTER SET utf8 COMMENT '用户信息';

-- 帖子（主题）表
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic`(
    `t_id` INT(5) UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '帖子ID',
    `t_title` VARCHAR(200) NOT NULL COMMENT '帖子标题',
    `t_content` TEXT NOT NULL COMMENT '帖子内容',
    `t_create_time` DATETIME DEFAULT NOW() COMMENT '发布时间',
    `t_account_id` INT(5) NOT NULL COMMENT '关联账户ID'
) CHARACTER SET utf8 COMMENT '帖子';

-- 留言（跟帖、楼）表
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
    `m_id` INT(5) UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '留言ID',
    `m_content` TEXT NOT NULL COMMENT '留言内容',
    `m_create_time` DATETIME DEFAULT NOW() COMMENT '发布时间',
    `m_topic_id` INT(5) NOT NULL COMMENT '关联主题ID',
    `m_account_id` INT(5) NOT NULL COMMENT '关联账户ID'
) CHARACTER SET utf8 COMMENT '留言';

-- 向账户信息表中添加新的数据
INSERT INTO t_account(a_id, a_name, a_password)
VALUES (1, '橘右京', '0000'),
       (2, '安琪拉', '0000'),
       (3, '狄仁杰', '0000'),
       (4, '貂蝉', '0000'),
       (5, '蔡文姬', '0000'),
       (6, '程咬金', '0000');

-- 向帖子表添加新的数据
INSERT INTO t_topic (t_id, t_title, t_content, t_account_id)
VALUES (1, '我们组有个同事好像是个变态？', '我今天上班的时候正在像往常一样写代码，余光中旁边的一个同事（男生）用手掏鼻子，然后，吃了！吃了！吃了！卧槽', 1),
       (2, '发现了领导的秘密怎么办？', '因为有一个文件需要让我们部长签字，我当时没想太多直接部长办公室推门进去了，忘记了敲门，结果看到了。。。。我的天啊，真希望时间能倒流。', 2),
       (3, '公司今天入职了3名新同事，其中一个人竟然是我的前男友，我的妈啊。', '当我看到他的一瞬间，我日，我真的想怼死他，妈蛋。当时劈腿了了的渣男，这辈子我都不想再看到这个人。', 4);

-- 向消息表中添加新数据
INSERT INTO t_message (m_id, m_content, m_topic_id, m_account_id)
VALUES (1, '你问问他饱了没有，没饱的话把你的也给他吃，实在不行在公司里面发起一个募捐鼻屎的活动。', 1, 1),
       (2, '这孩子可能是缺点啥，但是你离着远点，也许他不仅仅吃鼻屎。', 1, 2),
       (3, '让他去淘宝上买一些鼻屎来吃啊，光吃自己的怎么能够，淘宝上连屁都能买到，买点鼻屎肯定能买到的。', 1, 3),
       (4, '你能不能说清楚到底是咋回事，要不你就干脆别说。', 2, 4),
       (5, '难不成你是看到了？？？？？哇，不是吧。。。。。', 2, 5),
       (6, '求细节', 2, 6),
       (7, '那就去怼啊，你一个老同事干不过一个新来的？', 3, 1);
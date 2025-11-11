
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` BIGINT  AUTO_INCREMENT COMMENT '权限id',
  `request_url` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '请求url',
  `permission_name` VARCHAR(50) NOT NULL COMMENT '权限名称',
  `permission_description` VARCHAR(50) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permission_id`),
	UNIQUE(permission_name)
) COMMENT '权限表';

-- 插入权限数据
INSERT INTO `permission` VALUES (1, '/approvalTask/', '审核权限', 'Owner Admin');
INSERT INTO `permission` VALUES (2, '/admin/', '管理员主页面', 'Owner Admin');
INSERT INTO `permission` VALUES (3, '/user/', '用户主页面', 'Owner User');




DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` BIGINT AUTO_INCREMENT COMMENT '角色id' ,
  `role_name` VARCHAR(50) NOT NULL COMMENT '角色名称',
  `role_description` VARCHAR(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) COMMENT '角色表';

-- 插入角色数据
INSERT INTO `role` VALUES (1, 'Admin', 'System Administrator');
INSERT INTO `role` VALUES (2, 'Manager', 'Department Manager');
INSERT INTO `role` VALUES (3, 'Employee', 'Regular Employee');
INSERT INTO `role` VALUES (4, 'Guest', 'Guest User');
INSERT INTO `role` VALUES (5, 'Customer', 'customer');


DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `role_id` BIGINT  COMMENT '角色id',
  `permission_id` BIGINT COMMENT '权限id',
  PRIMARY KEY (`role_id`, `permission_id`),
  INDEX `idx_permission_id` (`permission_id`),
  CONSTRAINT `fk_rolepermission_role` FOREIGN KEY (`role_id`)
      REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_rolepermission_permission` FOREIGN KEY (`permission_id`)
      REFERENCES `permission` (`permission_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) COMMENT '角色权限表';

-- 插入角色权限数据
INSERT INTO `rolepermission` VALUES (1, 1);
INSERT INTO `rolepermission` VALUES (1, 2);
INSERT INTO `rolepermission` VALUES (2, 3);
INSERT INTO `rolepermission` VALUES (3, 3);
INSERT INTO `rolepermission` VALUES (4, 3);
INSERT INTO `rolepermission` VALUES (5, 3);


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    user_id         BIGINT AUTO_INCREMENT COMMENT '用户id' PRIMARY KEY,
    userAccount     VARCHAR(256) NOT NULL COMMENT '账号',
    userPassword    VARCHAR(512) NOT NULL COMMENT '密码',
    avatarUrl       VARCHAR(1024) NULL COMMENT '用户头像',
    gender          TINYINT NULL COMMENT '性别 0女1男',
    username        VARCHAR(256) NULL COMMENT '用户昵称',
    phone           VARCHAR(128) NULL COMMENT '电话',
    email           VARCHAR(512) NULL COMMENT '邮箱',
    userStatus      INT DEFAULT 0 NOT NULL COMMENT '状态 0 - 正常',
    create_by       BIGINT DEFAULT 0 not NULL COMMENT '创建人用户ID',
    createTime      DATETIME DEFAULT CURRENT_TIMESTAMP not NULL COMMENT '创建时间',
    updateTime      DATETIME DEFAULT CURRENT_TIMESTAMP not null  ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    update_by       BIGINT DEFAULT 0 not NULL COMMENT '更新人',
    isDelete        TINYINT DEFAULT 0 not NULL COMMENT '是否删除',
		max_user_type   VARCHAR(15) default 'Guest' not null comment '用户角色类型',
    userCode        VARCHAR(512) NULL COMMENT '用户编号',
    UNIQUE INDEX userAccount (userAccount)
) COMMENT '用户表';

-- 插入用户数据
INSERT INTO `user` VALUES (NULL, 'admin', '123', NULL, 1, 'testAdmin', NULL, NULL, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 0, 'admin', NULL);
INSERT INTO `user` VALUES (NULL, 'user1', '123', NULL, 1, 'user1', NULL, NULL, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 0, 'Manager', NULL);
INSERT INTO `user` VALUES (NULL, 'user2', '123', NULL, 1, 'user2', NULL, NULL, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 0, 'Manager', NULL);
INSERT INTO `user` VALUES (NULL, 'user3', '123', NULL, 1, 'user3', NULL, NULL, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 0, 'Employee', NULL);
INSERT INTO `user` VALUES (NULL, 'user4', '123', NULL, 1, 'user4', NULL, NULL, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 0, 'Guest', NULL);


DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `user_id` BIGINT NOT NULL COMMENT '用户id',
  `role_id` BIGINT NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `idx_role_id` (`role_id`),
  CONSTRAINT `fk_userrole_user` FOREIGN KEY (`user_id`)
      REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_userrole_role` FOREIGN KEY (`role_id`)
      REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) COMMENT '用户角色表';

-- 插入用户角色数据
INSERT INTO `userrole` VALUES (1, 1);
INSERT INTO `userrole` VALUES (2, 2);
INSERT INTO `userrole` VALUES (3, 2);
INSERT INTO `userrole` VALUES (3, 3);
INSERT INTO `userrole` VALUES (3, 4);
INSERT INTO `userrole` VALUES (3, 5);
INSERT INTO `userrole` VALUES (4, 3);
INSERT INTO `userrole` VALUES (5, 4);


DROP TABLE IF EXISTS `refresh_token`;
CREATE TABLE refresh_token (
  token_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  token VARCHAR(1024) NOT NULL,
  `ip_address` VARCHAR(45) DEFAULT NULL,
  device_info VARCHAR(256) DEFAULT NULL,
  expires_at DATETIME NOT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  `kicked_reason` varchar(255) DEFAULT NULL COMMENT '被踢原因',
  `status` TINYINT DEFAULT 1 COMMENT '状态：1=有效，0=无效（被挤/过期）',
  `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：1=已删除，0=未删除',
  INDEX(user_id),
	UNIQUE KEY (`user_id`, `device_info`),
  CONSTRAINT fk_refresh_user FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
) COMMENT '用户Refresh Token表';

DROP TABLE IF EXISTS `oauth_user`;
CREATE TABLE oauth_user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  provider VARCHAR(64) NOT NULL, -- 如 gitee, github, wechat
  provider_user_id VARCHAR(128) NOT NULL, -- open_id 或 union_id 等
  nickname VARCHAR(128),
  avatar VARCHAR(1024),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY (provider, provider_user_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
)comment '三方登录记录表';



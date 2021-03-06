DROP TABLE IF EXISTS sec_user;
CREATE TABLE sec_user (
  id           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username     VARCHAR(50)  NOT NULL
  COMMENT '登录名',
  providername VARCHAR(50)  NOT NULL
  COMMENT '提供者',
  email        VARCHAR(200) COMMENT '邮箱',
  phone        VARCHAR(50) COMMENT '联系电话',
  password     VARCHAR(200) NOT NULL
  COMMENT '密码',
  avatar_url   VARCHAR(255) COMMENT '头像',
  first_name   VARCHAR(10) COMMENT '名字',
  last_name    VARCHAR(10) COMMENT '姓氏',
  full_name    VARCHAR(20) COMMENT '全名'
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8
  COMMENT ='用户';


DROP TABLE IF EXISTS sec_user_info;
CREATE TABLE sec_user_info (
  id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id     BIGINT NOT NULL
  COMMENT '用户id',
  creator_id  BIGINT COMMENT '创建者id',
  gender      INT             DEFAULT 0
  COMMENT '性别0男，1女',
  province_id BIGINT COMMENT '省id',
  city_id     BIGINT COMMENT '市id',
  county_id   BIGINT COMMENT '县id',
  street      VARCHAR(500) COMMENT '街道',
  zip_code    VARCHAR(50) COMMENT '邮编'
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8
  COMMENT ='用户信息';

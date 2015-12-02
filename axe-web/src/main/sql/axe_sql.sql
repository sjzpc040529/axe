drop database if exists axe;
create database if not EXISTS axe  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;;
use axe;
CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_age` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华','31');
INSERT INTO t_user(user_name, user_age) VALUES ('明月','21');
INSERT INTO t_user(user_name, user_age) VALUES ('万树','22');
INSERT INTO t_user(user_name, user_age) VALUES ('张本强','31');
INSERT INTO t_user(user_name, user_age) VALUES ('12为1我','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华1','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华2','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华3','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华4','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华5','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华6','31');
INSERT INTO t_user(user_name, user_age) VALUES ('李赵华7','31');
